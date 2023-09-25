import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gold here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gold extends Actor
{
    private HUD hud;
    protected void addedToWorld(World world) {
        hud = world.getObjects(HUD.class).get(0);
    }
    
    public void act()
    {
        if(getOneIntersectingObject(Player.class) != null) {
            hud.addScore(250);
            getWorld().removeObject(this);
            /*MyWorld w = (MyWorld)getWorld();
            w.increaseScore(250);
            w.removeObject(this);*/
        }
    }
}
