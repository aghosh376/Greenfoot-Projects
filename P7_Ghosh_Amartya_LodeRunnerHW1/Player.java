import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Person
{
    public Player() {
        String stand = "player_stand";
        String climb = "player_climb_ladder";
        String run = "player_run_0";
        String hang = "player_bar_hang_0";
    }
    
    public void act()
    {
           super.act();
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
