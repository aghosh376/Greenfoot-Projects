import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public static final int gW = 24;
    public static final int gH = 24;
    Wall ref = new Wall();
    GreenfootImage refImg = ref.getImage();
    Ladder lad = new Ladder();
    GreenfootImage refLad = lad.getImage();
    GreenfootImage bg = getBackground();     
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(720, 480, 1); 
        GreenfootImage bg = new GreenfootImage(getWidth(), getHeight());
        bg.setColor(Color.BLACK);
        bg.fillRect(0,0,getWidth(), getHeight());
        setBackground(bg);

        //bg.drawImage(s, 10, 435);
        //bg.drawImage(liv, 310, 435);
        //bg.drawImage(lvl, 580, 435);
        //addObject(s, 50, 455);
        //showText("SCORE " + score, 50, 455); 
        //showText("LIVES " + lives, 360, 455);
        //showText("LEVEL " + level, 670, 455);
        
        addObject(new HUD(), getWidth()/2, getHeight()/2);

        makeWalls(1, 2, 1, 1);
        makeLadders(2 , 3, 2);
        makeWalls(3, 2, 8, 1);
        makeWalls(10, 1, 1, 1);
        makeLadders(9 , 11, 6);
        makeBars(10, 6, 10);
        makeWalls(1, 4, 10, 1);
        makeLadders(11 , 4, 3);
        makeWalls(10, 5, 10, 1);
        makeWalls(10, 7, 1, 5);
        makeWalls(1, 12, 10, 1);
        makeWalls(1, 16, 15, 1);
        makeLadders(16 , 17, 2);
        makeBars(17, 16, 3);
        makeLadders(20 , 16, 12);
        makeWalls(1 , 18, 30, 1);
        
        Player p = new Player();
        addObject(p, 48, getHeight()/2);
        MousePlayer mp = new MousePlayer();
        addObject(mp, 48, getHeight()/2 + 60);
        Enemy e = new Enemy();
        addObject(e, 65, getHeight()/2 + 60);
    }
    
    public void act() {
        //updateHUD(score, lives, level);
        //bg.drawImage(s, 10, 435);
    }
    
    public void makeWalls(int x, int y, int row, int col) {
        x = (x*gW) - gW/2;
        y = (y*gH) - gH/2;
        for(int i = 0; i < row; i++) {
            for(int k = 0; k < col; k++) {
                Wall plat = new Wall();
                addObject(plat, x + i*refImg.getWidth(), y + k*refLad.getHeight());
            }
        }
    }
    
    public void makeLadders(int x, int y, int height) {
        x = (x*gW) - gW/2;
        y = (y*gH) - gH/2;
        for(int i = 0; i < height; i++) {
            Ladder lad = new Ladder();
            addObject(lad, x, y - i*refLad.getHeight());
        }
    }
    
    public void makeBars(int x, int y, int width) {
        x = (x*gW) - gW/2;
        y = (y*gH) - gH;
        for(int i = 0; i < width; i++) {
            Bar monk = new Bar();
            addObject(monk, x + i*refImg.getWidth(), y + 1);
        }
    }
}
