import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MousePlayer extends Person
{
    Greenfoot mouse = new Greenfoot();
    
    
    public int getCommand() {
        MouseInfo mouseInfo = mouse.getMouseInfo();
        GreenfootImage img = getImage();
        if (mouseInfo != null) {
            if (mouseInfo.getX() > getX() + img.getWidth()/2) {
                return 1;
            } else if (mouseInfo.getX() < getX() - img.getWidth()/2) {
                return 2;
            } else if (mouseInfo.getY() < getY() - img.getHeight()/2) {
                return 3;
            } else if (mouseInfo.getY() > getY() + img.getHeight()/2) {
                return 4;
            }
        }
        return 0;
    }
}
