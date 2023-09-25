import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Person
{
    int numLevels = LodeRunnerLevelLoader.numLevels();
    
    public Player() {
        String stand = "player_stand";
        String climb = "player_climb_ladder";
        String run = "player_run_0";
        String hang = "player_bar_hang_0";
    }
    
    public void act()
    {
           super.act();
           if (getWorld().getObjects(Gold.class) != null) {
                if (getWorld().getObjects(Gold.class).size() == 0) {
                    Greenfoot g = new Greenfoot();
                    getWorld().getObjects(HUD.class).get(0).nextLevel();
                    int level = getWorld().getObjects(Level.class).get(0).getLevel();
                    if (numLevels < level) {
                        g.setWorld(new GameWonWorld());
                    } else {
                        g.setWorld(new MyLevelWorld(level));
                    }
                }
           }
    }
    
    public int getCommand() {
        if (key.isKeyDown("right")) {
            return 1;
        } else if (key.isKeyDown("left")) {
            return 2;
        } else if (key.isKeyDown("up")) {
            return 3;
        } else if (key.isKeyDown("down")) {
            return 4;
        }
        return 0;
    }
}
