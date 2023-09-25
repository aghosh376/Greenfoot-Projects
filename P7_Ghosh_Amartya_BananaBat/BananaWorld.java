import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BananaWorld extends World
{
    public BananaWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        Bat bruce = new Bat();
        addObject(bruce, getWidth()/2, getHeight()/2);
        
        Banana nana = new Banana();
        addObject(nana, 500, 100);
        
        Dinosaur arms = new Dinosaur();
        addObject(arms, 400, 300);
    }
    
    public void act() {
        double chance = Math.random();
        if (chance <= 0.01) {
            spawnBanana();
        }
    }
    
    public void spawnBanana() {
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(getHeight());
        Banana nana = new Banana();
        addObject(nana, x, y);
    }
}
