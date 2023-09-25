import greenfoot.*;


public class HUD extends Actor
{
    Score sCount = new Score();
    Lives liCount = new Lives();
    Level lvCount = new Level();
    
    public HUD(int worldW, int worldH) {
        GreenfootImage img = new GreenfootImage(worldW, worldH);
        img.setColor(new Color(33, 165, 252));
        img.fillRect(0, worldH-48, worldW, 12);
        setImage(img);
    }
    
    protected void addedToWorld(World world) {
        world.addObject(sCount, 75, world.getHeight()-20);
        world.addObject(liCount, world.getWidth()/2, world.getHeight()-20);
        world.addObject(lvCount, world.getWidth() - 70, world.getHeight()-20);
    }
    
    public void addScore(int add) {
        sCount.updateCount(250);
    }
    
    public void subLives(int sub) {
        liCount.updateCount(1);
    }
    
    public void nextLevel() {
        lvCount.updateCount(1);
    }
    
}
