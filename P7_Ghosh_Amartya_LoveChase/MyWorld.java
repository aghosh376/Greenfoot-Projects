import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public MyWorld()
    {    
        super(600, 400, 1); 
        Cherry c = new Cherry();
        addObject(c, (int)getWidth()/2, (int)getHeight()/2);
        Ant a = new Ant();
        addObject(a, (int)getWidth()/2 - 50, (int)getHeight()/2);
    }
}
