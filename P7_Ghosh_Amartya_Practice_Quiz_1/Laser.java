import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Laser extends Actor
{
    private int speed = 3;
    
    protected void addedToWorld(World world) {
        List<Animal> animals = world.getObjects(Animal.class);
        Animal target = animals.get(Greenfoot.getRandomNumber(animals.size()));
        turnTowards(target.getX(), target.getY());
    }
    
    public void act()
    {
        move(speed);
        bounds();
    }
    
    public void bounds() {
        World w = getWorld();
        if (getX() >= w.getWidth()) {
            w.removeObject(this);
            turn(90);
        } else if (getX() <= 0) {
            w.removeObject(this);
            turn(90);
        } else if (getY() >= w.getHeight()) {
            w.removeObject(this);
            turn(90);
        } else if (getY() <= 0) {
            w.removeObject(this);
            turn(90);
        }
    }
    
}
