import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Point;
import java.util.ArrayList;

public class Cherry extends Actor
{
    private int speed;
    private Point location;
    private Point lastPosition;
    private ArrayList<Point> positions;
    private Greenfoot key;
    
    public Cherry() {
        key = new Greenfoot();
        speed = 5;
        positions = new ArrayList<Point>();
        location= new Point(0,0);
        lastPosition = new Point(0,0);
    }
    
    protected void addedToWorld(World world) {

        Point pos = new Point(getX(), getY());
        this.location.setLocation(pos);
        positions.add(pos);
    }
    
    public void act() {
        movement();
        if (!lastPosition.equals(location)) {
            positions.add(new Point(location));
            lastPosition.setLocation(location);
            getWorld().addObject(new Trail(), getX(), getY());
        }
    }
    
    public void movement() {
        
        if (key.isKeyDown("right")){
            setLocation(getX() + speed, getY());
        } else if (key.isKeyDown("left")) {
            setLocation(getX() - speed, getY());
        } else if (key.isKeyDown("up")) {
            setLocation(getX(), getY() - speed);
        } else if (key.isKeyDown("down")) {
            setLocation(getX(), getY() + speed);
        }
    }
    
    public Point getLocation() {
        return location;
    }
    
    public void setLocation(int x, int y){
        super.setLocation(x,y);
        this.location.setLocation(x,y);
    }
    public ArrayList<Point> getPositions() {
        return positions;
    }
    
    public Point nextPosition() {
        Point np;
        if (positions.size() > 0) {
            np = positions.get(0);
            positions.remove(0);
        } else {
            np = null;
        }
        return np;
    }
}
