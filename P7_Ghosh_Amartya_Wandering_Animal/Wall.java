import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Wall extends Actor
{
    
    public Wall() {
        GreenfootImage img = new GreenfootImage("wallTile.png");
        int width = img.getWidth();
        img.scale(width/2, width/2);
        setImage(img);
    }
    public void act()
    {
        // Add your action code here.
    }
}
