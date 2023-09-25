import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private final int maxButterfly = 10;
    private int numButterfly;
    private int count = 0;
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        numButterfly = 0;
    }
    
    public void act() {
        if (numButterfly < maxButterfly) {
            if (Math.random() < 0.02) {
                spawnButterfly();
            }
        }   
    }
    
    public void spawnButterfly() {
        Butterfly butter = new Butterfly();
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        addObject(butter, x,y);
        numButterfly++;
    }
}
