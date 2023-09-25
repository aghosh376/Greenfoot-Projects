import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameWonWorld extends GameOverWorld
{
    Logo win = getObjects(Logo.class).get(0);
    
    public GameWonWorld()
    {
        win.setImage("GameWin.png");
        GreenfootImage img = win.getImage();
        int w = img.getWidth()/2;
        int h = img.getHeight()/2;
        img.scale(w,h);
    }
}
