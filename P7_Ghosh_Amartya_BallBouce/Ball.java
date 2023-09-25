import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends Actor
{
    int dx = 1;
    int dy = 2;
    public int getDy() {
        return dy;
    }
    
    public void act()
    {
        GreenfootImage img = getImage();
        int ballW = img.getWidth();
        int ballH = img.getHeight();
        
        setLocation(getX() + dx, getY() + dy);
        if (getY() + ballH/2 > getWorld().getHeight()) {
            setLocation(getX(), getWorld().getHeight() - ballH/2);
            dy = -dy;
        }
        if (getY() - ballH/2 < 0) {
            setLocation(getX(), 0 + ballH/2);
            dy = -dy;
        }
        if (getX() + ballW/2 > getWorld().getWidth()) {
            setLocation(getWorld().getWidth() - ballW/2, getY());
            dx = -dx;
        }
        if (getX() - ballW/2 < 0) {
            setLocation(0 + ballW/2, getY());
            dx = -dx;
        }
        
        Actor brick = getOneIntersectingObject(Brick.class);
        
        if (brick != null) {
            GreenfootImage brickImg = brick.getImage();
            int brickW = brickImg.getWidth();
            int brickH = brickImg.getHeight();
            if (brick.getX() + brickW/2 < getX()) {
                dx = -dx;
            } 
            if (brick.getX() - brickW/2 > getX()) {
                dx = -dx;
            }  
            if (brick.getY() - brickH/2 < getY()) {
                dy = -dy;
            } 
            if (brick.getY() + brickH/2 > getY()) {
                dy = -dy;
            }
            World world = getWorld();
            world.removeObject(brick);
        }
    }
}
