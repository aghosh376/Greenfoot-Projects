import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bat extends Actor
{
    /**
     * Act - do whatever the Bat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int batImage = 1;
    int speed = 3;
    int frame = 10;
    MouseInfo mouse; 
    public void act()
    {
        if(frame == 0) {
            frame = 10;
            if (batImage == 1) {
                setImage("bat_02.png");
                batImage = 2;
            } else {
                setImage("bat_01.png");
                batImage = 1;
            }
        }
        if (Greenfoot.getMouseInfo() != null) {
            mouse = Greenfoot.getMouseInfo();
            turnTowards(mouse.getX(), mouse.getY());
            move(speed);
            setRotation(0);
        }
        frame--;
    }
}
