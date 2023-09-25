import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;


public class MyWorld extends World
{
    private int animalFrame = 0;
    private int laserFrame = 0;
    private List<Animal> animals;
    private int refH;
    private int refW;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        Animal a = new Animal();
        refH = a.getImage().getHeight();
        refW = a.getImage().getWidth();
        addObject(a, 
                  refW + Greenfoot.getRandomNumber(getWidth() - refW*2), 
                  refH + Greenfoot.getRandomNumber(getHeight() - refH*2)
                 );
        
        
        Laser l = new Laser();
        addObject(l, getWidth()/2, getHeight());
        
        
    }
    
    public void act() {
        if (animalFrame > 100) {
            animalFrame = 0;
            Animal a = new Animal();
            addObject(a, 
                  refW + Greenfoot.getRandomNumber(getWidth() - refW*2), 
                  refH + Greenfoot.getRandomNumber(getHeight() - refH*2)
                 );
        }
        animalFrame++;
        animals = getObjects(Animal.class);
        if (animals != null) {
            laserFrame++;
        }
        if (laserFrame > 50 && animals.size() != 0) {
            Laser l = new Laser();
            addObject(l, getWidth()/2, getHeight());
            laserFrame = 0;
        }
    }
}
