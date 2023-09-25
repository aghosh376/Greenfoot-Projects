import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level extends Actor
{
    int level = 1;
    Color bloo = new Color(33, 165, 252);
    GreenfootImage levelImg = new GreenfootImage("LEVEL " + level, 35, bloo, null);
    
    public Level() {
        setImage(levelImg);
    }
    
    public void updateCount (int sub) {
        level-=sub;
        updateImg();
    }
    
    public void act() {
        setLocation(getWorld().getWidth() - getImage().getWidth()/2 - 10, getY());
    }
    
    public void updateImg() {
        setImage(new GreenfootImage("LEVEL " + level, 35, bloo, null));
    }
}
