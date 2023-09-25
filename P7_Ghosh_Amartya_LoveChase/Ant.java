import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
import java.awt.Point;

public class Ant extends Actor
{
    private ArrayList<Point> touched;
    private int speed = 5;
    private Point target = null;
    private int sinceTouch = 0;
    
    private Cherry myCherry;
    
    public void act()
    {
        World myWorld = getWorld();
        List<Cherry> all = myWorld.getObjects(Cherry.class);
        if (all.get(0) != null) {
            myCherry=all.get(0);
            if (!myCherry.getLocation().equals(getPosition())){
                myWorld.removeObjects(getWorld().getObjects(Heart.class));
                if (sinceTouch > 100) {
                    target = myCherry.nextPosition();
                    if (target != null) {
                        turnTowards(target.x, target.y);
                        setLocation(target.x, target.y);
                    } 
                    if (myCherry.getLocation().equals(getPosition())) {
                        myWorld.addObject(new Heart(), getX(), getY());
                    }
                } 
            } else {
                sinceTouch = 0;
            }
        }
        if (getOneIntersectingObject(Trail.class) != null) {
            myWorld.removeObjects(myWorld.getObjectsAt(target.x, target.y, Trail.class));
        }
        if (!all.get(0).getLocation().equals(getPosition())) {
            sinceTouch++;
        }
        
    }
    
    public Point getPosition() {
        Point p = new Point(this.getX(), this.getY());
        return p;
    }
}
