import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class StartButton extends Actor
{
    GreenfootImage img = getImage();
    int imgW = img.getWidth()/3;
    int imgH = img.getHeight()/3;
    Greenfoot func = new Greenfoot();
    int countToWorld = 0;
    boolean clicked = false;
    
    public StartButton() {
        int w = img.getWidth()/3;
        int h = img. getHeight()/3;
        img.scale(w,h);
    }
    
    public void act()
    {
        if (!clicked) {
            if (func.mousePressed(this)) {
                //func.setWorld(new MyWorld());
                img.scale((int)(imgW*1.05),(int)(imgH*1.05));
            } else if (func.mouseClicked(this)) {
                //func.setWorld(new MyWorld());
                img.scale(imgW, imgH);
                clicked = true;
            }
        } else {
            countToWorld++;
        }
        if (countToWorld == 80) {
            func.setWorld(new MyWorld());
        }
    }
}
