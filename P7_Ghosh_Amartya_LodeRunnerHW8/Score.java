import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Score extends Actor
{
    static int score = 0;
    Color bloo = new Color(33, 165, 252);
    GreenfootImage scoreImg = new GreenfootImage("SCORE " + score, 35, bloo, null);
    boolean resetting = false;
    
    public Score() {
        setImage(scoreImg);
    }
    
    protected void addedToWorld(World world) {
        resetScore();
        updateImg();         
        resetting = true;
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
    
    public void resetScore() {
        score = 0;
    }
}
