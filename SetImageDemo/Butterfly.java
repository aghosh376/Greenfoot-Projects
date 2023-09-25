import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Butterfly extends Actor
{
    private int frame = 1;
    private final int MAX_FRAME = 15;
    private int scaleW = 50;
    
    public Butterfly() {
        scaleImage();
    }
    
    public void act()
    {
        nextFrame();
    }
    
    public void nextFrame() {
        setImage("butterfly blue animation " + frame + " 1200.png");
        frame++;
        if (frame > MAX_FRAME) {
            frame = 1;
        }
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
