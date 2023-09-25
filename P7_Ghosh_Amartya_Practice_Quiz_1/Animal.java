import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Animal extends Actor
{
    private int speed = 5;
    private int dir = 1;
    GreenfootImage img = getImage();
    
    public Animal() {
        if (Greenfoot.getRandomNumber(2) > 0) {
            setImage("baby1.png");
        }
    }
    
    public void act()
    {
        if (bounds() != 0) {
            pickDirection(bounds());
        } else{
            if (Math.random() <= 0.05) {
            pickDirection(0);
            }
        }
        movement();
        despawn();
    }
    
    public int pickDirection(int not) {
        if (not == 0) {
            dir = Greenfoot.getRandomNumber(4) + 1;
            return dir;
        } else {
            dir = Greenfoot.getRandomNumber(4) + 1;
            while (dir == not) {
                dir = Greenfoot.getRandomNumber(4) + 1;
            }
            return dir;
        }
    }
    
    public void movement() {
        if (dir == 1) {
            setRotation(0);
            move(speed);
        } else if (dir == 2) {
            setRotation(90);
            move(speed);
        } else if (dir == 3) {
            setRotation(180);
            move(speed);
        } else if (dir == 4) {
            setRotation(270);
            move(speed);
        }
    }
    
    public int bounds() {
        World w = getWorld();
        if (getX() + img.getWidth()/2 >= w.getWidth()) {
            
            return 1;
        } else if (getX() - img.getWidth()/2 <= 0) {
            
            return 3;
        } else if (getY() - img.getHeight()/2 <= 0) {
            
            return 4;
        } else if (getY() + img.getHeight()/2 >= w.getHeight()) {
            
            return 2;
        }
        return 0;
    }
    
    public void despawn() {
        if (getOneIntersectingObject(Laser.class) != null) {
            World w = getWorld();
            Laser a = (Laser)getOneIntersectingObject(Laser.class);
            
            w.removeObject(a);
            w.removeObject(this);
            
        }
    }
}
