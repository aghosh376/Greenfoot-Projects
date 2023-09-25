import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;


public class Enemy extends Person
{
    
    
    public Enemy() {
        this.stand = "enemy_stand";
        this.climb = "enemy_climb_ladder";
        this.run = "enemy_run_0";
        this.hang = "enemy_bar_hang_0";
    }
    
    public void act()
    {
        super.act();
        if(getOneIntersectingObject(Player.class) != null) {
            Player p = (Player)getOneIntersectingObject(Player.class);
            HUD h = getWorld().getObjects(HUD.class).get(0);
            h.subLives(1);
            getWorld().removeObject(p);
            Greenfoot g = new Greenfoot();
            g.setWorld(new MyLevelWorld(h.getLevel()));
        }
    }
    
    public int getCommand() {
        World w = getWorld();
        List<Player> pl = w.getObjects(Player.class);
        Player p = pl.get(0);
        GreenfootImage img = getImage();
        if (p != null) {
            if (p.getX() > getX() + img.getWidth()/2 ) {
                return 1;
            } 
            if (p.getX() < getX() - img.getWidth()/2 ) {
                return 2;
            }
            if (p.getY() < getY()) {
                return 3;
            }
            if (p.getY() > getY()) {
                return 4;
            }
        }
        return 0;
    }
}
