import greenfoot.*;


public class HUD extends Actor
{
    Score sCount = new Score();
    Lives liCount = new Lives();
    Level lvCount = new Level();
    
    
    protected void addedToWorld(World world) {
        GreenfootImage img = new GreenfootImage(world.getWidth(), world.getHeight());
        img.setColor(new Color(33, 165, 252));
        img.fillRect(0, world.getHeight()-48, world.getWidth(), 12);
        setImage(img);
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
    
    public int getLevel() {
        return lvCount.getLevel();
    }
}
