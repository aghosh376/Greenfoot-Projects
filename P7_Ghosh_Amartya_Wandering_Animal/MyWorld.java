import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{

    Wall ref = new Wall();
    GreenfootImage wallImg = ref.getImage();
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(650, 384, 1); 
        
        createWalls(27,1,wallImg.getWidth()/2, wallImg.getHeight()/2);
        createWalls(27,1,wallImg.getWidth()/2, getHeight() - wallImg.getHeight()/2);
        createWalls(1,11,wallImg.getWidth()/2, wallImg.getHeight()/2);
        createWalls(1,11,getWidth() - wallImg.getWidth()/2, wallImg.getHeight()/2);
        createWalls(5,5,wallImg.getWidth()*8, getHeight()/2 - wallImg.getHeight()*2);
        
        for(int i = 0; i < 3; i++) {
            Creature mice = new Creature();
            spawnRandom(mice);
        }
        for(int i = 0; i < 3; i++) {
            Treat pizza = new Treat();
            spawnRandom(pizza);
        }
    }
    public void createWalls(int W, int H, int x, int y) {
        
        for(int i = 0; i < W; i++) {
            for(int k = 0; k < H; k++) {
                Wall boundry = new Wall();
                addObject(boundry, x + i*wallImg.getWidth(), y + k*wallImg.getHeight());
            }
        }
    }
    public void spawnRandom(Actor obj) {
        int x = Greenfoot.getRandomNumber(getWidth()- wallImg.getWidth()*2);
        int y = Greenfoot.getRandomNumber(getHeight() - wallImg.getHeight()*2);
        if (x < wallImg.getWidth()*2) {
                x += wallImg.getWidth();
        }
        if (y < wallImg.getHeight()*2) {
                y += wallImg.getHeight();
        }
        addObject(obj,x,y);
    }
}
