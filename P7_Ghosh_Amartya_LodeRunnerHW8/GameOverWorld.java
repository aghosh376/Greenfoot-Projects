import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class GameOverWorld extends World
{
    public GameOverWorld()
    {    
        super(720, 480, 1); 
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        bg.setColor(Color.BLACK);
        bg.fillRect(0,0,getWidth(), getHeight());
        setBackground(bg);
        
        Logo logo = new Logo(true);
        addObject(logo, getWidth()/2, getHeight()/2);
        StartButton start = new StartButton(true);
        addObject(start, getWidth()/2, getHeight()/2 + 150);
    }
}
