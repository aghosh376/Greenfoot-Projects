import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Score extends Actor
{
    int score = 0;
    Color bloo = new Color(33, 165, 252);
    GreenfootImage scoreImg = new GreenfootImage("SCORE " + score, 35, bloo, null);
    
    public Score() {
        setImage(scoreImg);
    }
    
    public void updateCount (int add) {
        score+=add;
        updateImg();
    }
    
    public void act() {
        setLocation(10 + getImage().getWidth()/2, getY());
    }
    
    public void updateImg() {
        setImage(new GreenfootImage("SCORE " + score, 35, bloo, null));
    }
}
