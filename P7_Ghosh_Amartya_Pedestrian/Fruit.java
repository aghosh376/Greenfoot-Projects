import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fruit extends Actor
{
    private int type;
    private int speed = 4;
    boolean gameIsOver = false;
    
    GreenfootImage img = getImage();
    
    public Fruit() {
        type = (Greenfoot.getRandomNumber(3) +1);
        setColor(type);
    }

    public void act()
    {
        if (!gameIsOver) {
            if (getY() > getWorld().getHeight() - img.getHeight()/2) {
                setLocation(getX(), getWorld().getHeight() - img.getHeight()/2);
            }
            setLocation(getX(), getY() + speed);
        }
        MyWorld world = (MyWorld)getWorld();
        gameIsOver = world.isGameOver();
    }
    
    public void setColor(int c) {
        if (c == 1) {
            setImage("plum.png");
        } else if (c == 2) {
            setImage("apple2.png");
        } else if (c == 3) {
            setImage("orange.png");
        }
    }
    
    public int getColor() {
        return type;
    }
    
    
}
