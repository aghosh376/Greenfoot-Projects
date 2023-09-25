import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Person extends Actor
{
    private int curX;
    private int curY;
    private int curRotation;
    private int speed = 4;
    private boolean facingRight = false;
    public boolean onLadder = false;
    private boolean belowLadder = false;
    private boolean aboveLadder = false;
    public boolean onPlatform = false;
    private boolean onBar = false;
    private int monkeyFrame = 0;
    private int runFrame = 0;
    private int climbFrame = 0;
    private int command;
    public String stand = "player_stand";
    public String climb = "player_climb_ladder";
    public String run = "player_run_0";
    public String hang = "player_bar_hang_0";
    Greenfoot key = new Greenfoot();
    
    
    public void act()
    {
        curState();
        if (isMidAir() && !onLadder && !onBar) {
            gravity();
        } else {
            command = getCommand();
            movement();
            collide();
        }
        
        changeImg();
        if (runFrame > 3) {
            runFrame = 0;
        }
    }
    
    public void collide() {
        GreenfootImage img = getImage();
        if (getOneObjectAtOffset(-img.getWidth()/2, 0,Wall.class) != null) {
            setLocation(curX, curY);
        }
        if (getOneObjectAtOffset(-img.getWidth()/2, img.getHeight()/2 - 2,Wall.class) != null) {
            setLocation(curX, curY);
        }
        if (getOneObjectAtOffset(-img.getWidth()/2, -img.getHeight()/2 + 2,Wall.class) != null) {
            setLocation(curX, curY);
        }
        if (getOneObjectAtOffset(img.getWidth()/2, 0,Wall.class) != null) {
            setLocation(curX, curY);
        }
        if (getOneObjectAtOffset(img.getWidth()/2 , img.getHeight()/2 - 3,Wall.class) != null) {
            setLocation(curX, curY);
        }
        if (getOneObjectAtOffset(img.getWidth()/2, -img.getHeight()/2 + 3,Wall.class) != null) {
            setLocation(curX, curY);
        }
        World world = getWorld();
        if (getX() < img.getWidth()/2 || getX() > world.getWidth() - img.getWidth()/2) {
          setLocation(curX, curY);
        }
        if (getY() < img.getHeight()/2 || getY() > world.getHeight() - img.getHeight()/2) {
            setLocation(curX, curY);
        }
    }
    
    public void curState() {
        curX = getX();
        curY = getY();
        curRotation = getRotation();
        aboveLadder = isAboveLadder();
        belowLadder = isBelowLadder();
        onLadder = isOnLadder();
        onBar = isOnBar();
    }
    
    public void gravity() {
        World world = getWorld();
        turnTowards(getX(), world.getHeight());
        move(3);
        setRotation(curRotation);
    }
    
    public int getCommand() {
        return 0;
    }
    
    public void movement() {
        GreenfootImage img = getImage();
        MyLevelWorld w = (MyLevelWorld)getWorld();
        if (command == 1) {
            move(speed);
            while (getOneObjectAtOffset(-img.getWidth()/2, 0,Wall.class) != null) {
                move(-1);
            }
            facingRight = true;
            monkeyFrame++;
            if (monkeyFrame > 1) {
                monkeyFrame = 0;
            }
        } else if (command == 2) {
            move(-speed);
            while (getOneObjectAtOffset(img.getWidth()/2, 0,Wall.class) != null) {
                move(1);
            }
            facingRight = false;
            monkeyFrame++;
            if (monkeyFrame > 1) {
                monkeyFrame = 0;
            }
        } else if (command == 3) {
            if (aboveLadder || belowLadder || onLadder) {
                setLocation((getX()/w.gW)*w.gW + w.gW/2, getY());
                turn(-90);
                move(speed);
                turn(90);
                climbFrame++;
                if (climbFrame > 1) {
                    climbFrame = 0;
                }
            }
        } else if (command == 4) {
            if (aboveLadder || belowLadder || onLadder) {
                setLocation((getX()/w.gW)*w.gW + w.gW/2, getY());
                turn(90);
                move(speed);
                turn(-90);
                climbFrame++;
                if (climbFrame > 1) {
                    climbFrame = 0;
                }
            } else if (onBar) {
                setLocation(getX(), getY() +1);
            }
        }
        while (getOneObjectAtOffset(0, img.getHeight()/2,Wall.class) != null) {
            turnTowards(getX(), 0);  
            move(1);
            setRotation(curRotation);
            }
    }
    
    public boolean isMidAir() {
        GreenfootImage img = getImage();
        if (getOneObjectAtOffset(0, img.getHeight()/2 + 1,Wall.class) != null) {
            return false;
        }
        if (getOneObjectAtOffset(img.getWidth()/2, img.getHeight()/2 + 1,Wall.class) != null) {
            return false;
        }
        if (getOneObjectAtOffset(-img.getWidth()/2, img.getHeight()/2 + 1,Wall.class) != null) {
            return false;
        }
        if (!onLadder) {
            if (getOneObjectAtOffset(0, img.getHeight()/2 + 1,Ladder.class) != null) {
                return false;
            }
            if (getOneObjectAtOffset(img.getWidth()/2, img.getHeight()/2 + 1,Ladder.class) != null) {
                return false;
            }
            if (getOneObjectAtOffset(-img.getWidth()/2, img.getHeight()/2 + 1,Ladder.class) != null) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isAboveLadder() {
        GreenfootImage img = getImage();
        if (getOneObjectAtOffset(0, img.getHeight()/2 + 1,Ladder.class) != null) {
            return true;
        }
        if (getOneObjectAtOffset(img.getWidth()/2, img.getHeight()/2 + 1,Ladder.class) != null) {
            return true;
        }
        if (getOneObjectAtOffset(-img.getWidth()/2, img.getHeight()/2 + 1,Ladder.class) != null) {
            return true;
        }
        return false;
    }
    
    public boolean isBelowLadder() {
        GreenfootImage img = getImage();
        if (getOneObjectAtOffset(0, -img.getHeight()/2 - 1,Ladder.class) != null) {
            return true;
        }
        if (getOneObjectAtOffset(img.getWidth()/2, -img.getHeight()/2 - 1,Ladder.class) != null) {
            return true;
        }
        if (getOneObjectAtOffset(-img.getWidth()/2, -img.getHeight()/2 - 1,Ladder.class) != null) {
            return true;
        }
        return false;
    }
    
    public boolean isOnLadder() {
        if (getOneIntersectingObject(Ladder.class) != null) {
            return true;
        }
        return false;
    }
    
    public boolean isOnBar() {
        GreenfootImage img = getImage();
        if (getOneObjectAtOffset(0, -img.getHeight()/2 - 1,Bar.class) != null) {
            return true;
        }
        if (getOneObjectAtOffset(img.getWidth()/2, -img.getHeight()/2 - 1,Bar.class) != null) {
            return true;
        }
        if (getOneObjectAtOffset(-img.getWidth()/2, -img.getHeight()/2 - 1,Bar.class) != null) {
            return true;
        }
        return false;
    }
    
    public boolean isRunning() {
        if (getX() != curX) {
            return true;
        }
        return false;
    }
    
    public boolean isClimbing() {
        if (isMidAir() && onLadder) {
            return true;
        }
        return false;
    }
    
    public boolean isMonkey() {
        if (isMidAir() && onBar) {
            return true;
        }
        return false;
    }
    
    public void changeImg() {
        if (isMidAir() && !isClimbing() && !isMonkey()) {
            if (facingRight) {
                setImage(hang + "0.png");
            } else {
                GreenfootImage fall = new GreenfootImage(hang + "0.png");
                fall.mirrorHorizontally();
                setImage(fall);
            }
        } else if (isMonkey()) {
            if (facingRight) {
                setImage(hang + monkeyFrame + ".png");
            } else {
                GreenfootImage monkey = new GreenfootImage(hang + monkeyFrame + ".png");
                monkey.mirrorHorizontally();
                setImage(monkey);
            }
        } else if (isRunning()) {
            if (facingRight) {
                setImage(run + runFrame + ".png");
                runFrame++;
            } else {
                GreenfootImage move = new GreenfootImage(run + runFrame + ".png");
                move.mirrorHorizontally();
                setImage(move);
                runFrame++;
            }
        } else if (isClimbing()) {
            if (climbFrame == 0) {
                setImage(climb + ".png");
            } else if (climbFrame == 1) {
                GreenfootImage lad = new GreenfootImage(climb + ".png");
                lad.mirrorHorizontally();
                setImage(lad);
            }
        } else {
            runFrame = 0;
            setImage(stand + ".png");
        }
    }
}
