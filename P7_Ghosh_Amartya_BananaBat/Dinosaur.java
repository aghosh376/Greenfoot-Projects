import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Dinosaur extends Actor
{
    private int scaleW = 50;
    
    public Dinosaur() {
        scaleImage();
    }
    
    public void act()
    {
        scaleImage();
    }
    
    public void scaleImage() {
        GreenfootImage img = getImage();
        double oH = img.getHeight();
        double oW = img.getWidth();
        int scaleH = (int)(oH/oW * scaleW);
        img.scale(scaleW, scaleH);
    }
}
