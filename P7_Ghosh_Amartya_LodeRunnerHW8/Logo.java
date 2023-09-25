import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Logo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Logo extends Actor
{
    public Logo() {
        GreenfootImage img = getImage();
        int w = img.getWidth()/2;
        int h = img.getHeight()/2;
        img.scale(w,h);
    }
    
    public Logo(boolean gameover) {
        if (gameover == true) {
            setImage("GameOver.png");
        }
        GreenfootImage img = getImage();
        int w = img.getWidth()/2;
        int h = img.getHeight()/2;
        img.scale(w,h);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
