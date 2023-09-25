import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Tile extends Actor
{
    boolean selected = false;
    GreenfootImage img = getImage();
    GreenfootImage selImg = new GreenfootImage(getImage());
    
    public Tile() {
        selImg.setColor(Color.RED);
        selImg.fillRect(0,0, img.getWidth(), 4);
        selImg.fillRect(0,0, 4, img.getHeight());
        selImg.fillRect(0, img.getHeight() - 4, img.getWidth(), 4);
        selImg.fillRect(img.getWidth() - 4, 0, 4, img.getHeight());
        setImage(img);
    }
    
    public void act()
    {
        if (Greenfoot.mouseClicked(this)) {
            onClick();
        }
    }
    
    public void onClick() {
        selected = !selected;
        if (selected) {
            setImage(selImg);
        } else {
            setImage(img);
        }
    }
    
    
}
