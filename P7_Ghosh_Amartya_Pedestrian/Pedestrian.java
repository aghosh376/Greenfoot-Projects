import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pedestrian extends Actor
{
    private int color = 2;
    private int speed = 3;
    private int cooldown = 20;
    private int health = 5;
    boolean gameIsOver = false;
    
    GreenfootImage img = getImage();
    Greenfoot key = new Greenfoot();
    int width = img.getWidth();
    int worldWidth;
    
    protected void addedToWorld(World world) {
        updateImage();
    }
    
    public void act()
    {
        if (!gameIsOver) {
            move(speed);
            if (getX() > getWorld().getWidth() - img.getWidth()/2) {
                setLocation(getWorld().getWidth() - img.getWidth()/2, getY());
                speed = -speed;
            }
            if (getX() < img.getWidth()/2) {
                speed = -speed;
            }
            if (cooldown > 0) {
                cooldown--;
            }
            if (key.getKey() != null) {
                if (key.isKeyDown("space") && cooldown == 0) {
                    setColor(color);
                }
            }
            Fruit fruit = (Fruit)getOneIntersectingObject(Fruit.class);
            if (fruit != null) {
                if (fruit.getColor() == color - 1) {
                    World w = getWorld();
                    w.removeObject(fruit);
                } else {
                    speed = -speed;
                    health--;
                    setColor(color-1);
                    color--;
                    World w = getWorld();
                    w.removeObject(fruit);
                }
            }
        }
        MyWorld world = (MyWorld)getWorld();
        gameIsOver = world.isGameOver();
    }
    
    public void setColor(int c) {
        if (c <= 3) {
            setImage("ppl" + c + ".png");
        } else {
            color = 1;
            setImage("ppl1.png");
        }
        color++;
        updateImage();
        cooldown = 20;
    }
    
    public void updateImage() {
        GreenfootImage hp = new GreenfootImage(health + "", 30, Color.WHITE, null);
        GreenfootImage lmao = getImage();
        lmao.drawImage(hp, lmao.getWidth()/4, lmao.getHeight()/4);
        setImage(lmao);
    }
    
    public int getHealth() {
        return health;
    }
}
