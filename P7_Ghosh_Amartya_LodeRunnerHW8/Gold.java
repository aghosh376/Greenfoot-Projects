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
    private World world;
    protected void addedToWorld(World world) {
        this.world = world;
    }
    
    public void act()
    {
        if (world.getObjects(HUD.class)!= null) {
            hud = world.getObjects(HUD.class).get(0);
        }
        if(getOneIntersectingObject(Player.class) != null) {
            hud.addScore(250);
            getWorld().removeObject(this);
            /*MyWorld w = (MyWorld)getWorld();
            w.increaseScore(250);
            w.removeObject(this);*/
        }
    }
}
