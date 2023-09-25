import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Lives extends Actor
{
    static int lives = 5;
    Color bloo = new Color(33, 165, 252);
    GreenfootImage livesImg = new GreenfootImage("LIVES " + lives, 35, bloo, null);
    int count = 5;
    boolean resetting = false;
    
    public Lives() {
        setImage(livesImg);
    }
    
    protected void addedToWorld(World world) {
        if (lives == 0) {
            resetLives();
            updateImg();
            resetting = true;
        }
    }
    
    public void act() {
        if (resetting) {
            if (count == 0) {
                Greenfoot g = new Greenfoot();
                g.setWorld(new GameOverWorld());
            }
            count--;
        }
    }
    
    public void updateCount (int sub) {
        lives-=sub;
        updateImg();
    }
    
    public void updateImg() {
        setImage(new GreenfootImage("LIVES " + lives, 35, bloo, null));
    }
    
    public void resetLives() {
        lives = 5;
        count = 5;
    }
}
