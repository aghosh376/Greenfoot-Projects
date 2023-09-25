import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;


public class Creature extends Actor
{
    private int speed = 2;
    private int curX;
    private int curY;
    private int curRotation;
    private boolean isBlocked = false;
    
    public void act()
    {
        isBlocked();
        
        if (isBlocked) {
            randomTurn();
            move(speed);
            collide();
            collect();
        } else {
            locateTreat();
            currentState();
            move(speed);
            //collide();
            collect();
        }
        
    }
    
    public void collide() {
        if (getOneIntersectingObject(Wall.class) != null) {
            Actor wall = getOneIntersectingObject(Wall.class);
            setLocation(curX, curY);
        }
    }
    
    public void collect() {
        if (getOneIntersectingObject(Treat.class) != null) {
            Actor t = getOneIntersectingObject(Treat.class);
            getWorld().removeObject(getOneIntersectingObject(Treat.class));
        }
    }
    
    public void randomTurn() {
        int angle = (int)((Math.random()*5)+1);
        double dir = Math.random();
        if (dir>0.5) {
            turn(-angle);
        } else {
            turn(angle);
        }
    }
    
    public void locateTreat() {
        List<Treat> treats = getWorld().getObjects(Treat.class);
        double distance;
        double compDistance = 10000000;
        for (int i = 0; i < treats.size(); i++) {
            distance = Math.pow(Math.abs(getX() - treats.get(i).getX()), 2) + Math.pow(Math.abs(getY() - treats.get(i).getY()), 2);
            if (distance < compDistance) {
                compDistance = distance;
                turnTowards(treats.get(i).getX(), treats.get(i).getY());
            } 
        }
    }
    
    public boolean isBlocked() {
        currentState();
        locateTreat();
        while(getOneIntersectingObject(Treat.class) == null) {
            move(1);
            if (getOneIntersectingObject(Wall.class) != null) {
                isBlocked = true;
                setLocation(curX, curY);
                setRotation(curRotation);
                return true;
            }
        }
        setLocation(curX, curY);
        setRotation(curRotation);
        isBlocked = false;
        return false;
    }
    
    public void currentState() {
        curX = getX();
        curY = getY();
        curRotation = getRotation();
    }
}
