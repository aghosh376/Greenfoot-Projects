import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BallWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public BallWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        Ball bouncyBall = new Ball();
        addObject(bouncyBall, getWidth()/2, 300);
        Actor bree = new Brick();
        GreenfootImage img = bree.getImage();
        int num = getWidth()/img.getWidth();
        
        for(int i = 0; i < num; i++) {
            Brick kyle = new Brick();
            addObject(kyle, img.getWidth()/2 + img.getWidth()*i , 200);
        }
        
    }
}
