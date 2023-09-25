import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Treat extends Actor
{
    protected void addedToWorld​(World world) {
        while(getOneIntersectingObject(Wall.class) != null) {
            setLocation(60, 60);
            while (getOneIntersectingObject(Treat.class) != null) {
                setLocation(getX() + 60, getY());
            }
        }
    }
    
    public Treat() {
        GreenfootImage img = new GreenfootImage("pizza_cheese.png");
        int width = img.getWidth();
        int height = img.getHeight();
        img.scale(width/2, height/2);
        setImage(img);
    }
    
    public void act()
    {
        
    }
}
