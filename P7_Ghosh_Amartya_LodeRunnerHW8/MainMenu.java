import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class MainMenu extends World
{

    
    public MainMenu()
    {    
        super(720, 480, 1); 
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        bg.setColor(Color.BLACK);
        bg.fillRect(0,0,getWidth(), getHeight());
        setBackground(bg);
        
        Logo logo = new Logo();
        addObject(logo, getWidth()/2, getHeight()/2 - 100);
        StartButton start = new StartButton();
        addObject(start, getWidth()/2, getHeight()/2 + 100);
    }
}
