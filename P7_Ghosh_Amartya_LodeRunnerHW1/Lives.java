import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lives extends Actor
{
    int lives = 5;
    Color bloo = new Color(33, 165, 252);
    GreenfootImage livesImg = new GreenfootImage("LIVES " + lives, 35, bloo, null);
    
    public Lives() {
        setImage(livesImg);
    }
    
    public void updateCount (int sub) {
        lives-=sub;
        updateImg();
    }
    
    public void updateImg() {
        setImage(new GreenfootImage("LIVES " + lives, 35, bloo, null));
    }
}
