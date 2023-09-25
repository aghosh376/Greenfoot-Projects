import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;

public class Creature extends Actor
{
    private int speed = 3;
    private int angle = 0;
    private double dir = 1;
    
    
    public Creature() {
        GreenfootImage img = new GreenfootImage("mouse.png");
        int width = img.getWidth();
        int height = img.getHeight();
        img.scale(width/2, height/2);
        setImage(img);
    }
    protected void addedToWorld​(World world) {
        while(getOneIntersectingObject(Wall.class) != null) {
            setLocation(world.getWidth() - 60, world.getHeight() - 60);
            while (getOneIntersectingObject(Creature.class) != null) {
                setLocation(getX() - 60, getY());
            }
        }
    }
    public void act()
    {
        angle = (int)(Math.random()*10);
        dir = Math.random();
        if (dir>0.5) {
            turn(-angle);
        } else {
            turn(angle);
        }
        bounce();
        move(speed);
        eat();
    }
    public void bounce() {
        if (getOneIntersectingObject(Wall.class) != null) {
            turn(180);
            move(speed);
        }
    }
    public void eat() {
        if (getOneIntersectingObject(Treat.class) != null) {
            getWorld().removeObject(getOneIntersectingObject(Treat.class));
        }
    }
}
