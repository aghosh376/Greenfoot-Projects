import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner;

public class MyWorld extends World
{
    Scanner in = new Scanner(System.in);
    public boolean gameOver = false;
    Pedestrian lol = new Pedestrian();
    public MyWorld()
    {    
        super(600, 400, 1); 
        int x = lol.getImage().getWidth()/2;
        int y = lol.getImage().getHeight()/2;
        addObject(lol, x, getHeight() - y);
    }
    
    public void act() {
        if (gameOver) {
            GameOver endMsg = new GameOver();
            /*
            lol.setLocation(getWidth()/2, getHeight()/2);
            lol.setImage(endMsg);*/
            
            addObject(endMsg, getWidth()/2, getHeight()/2);
            Greenfoot.stop();
        } else {   
            if (Math.random() <= 0.007) {
            spawnFruit();
            }
        }
        if (lol.getHealth() == 0) {
            gameOver = true;
        }
    }
    
    public void spawnFruit() {
        Fruit meteor = new Fruit();
        int x = Greenfoot.getRandomNumber(getWidth());
        int y = Greenfoot.getRandomNumber(100);
        if (x < meteor.getImage().getWidth()/2) {
            x = meteor.getImage().getWidth()/2;
        }
        if (y < meteor.getImage().getHeight()/2) {
            y = meteor.getImage().getHeight()/2;
        }
        addObject(meteor, x, y);
    }
    
    public boolean isGameOver() {
        return gameOver;
    }
}
