import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOver extends Actor
{
    protected void addedToWorld(World world) {
        GreenfootImage endMsg = 
            new GreenfootImage("Game Over", 60, Color.BLACK, Color.WHITE);
        setImage(endMsg);
    }
    
    public void act()
    {
        
    }
}
