import lang.stride.*;
import greenfoot.*;
import greenfoot.GreenfootImage;

/**
 * MAIN CHARACTER
 * MATIAS GAUTHIER
 */
public class Player extends Actor
{
    /* VAR RELATED TO JUMPING & GRAVITY*/
    protected final int gravity = 1;
    protected int speed;
    /* TIMER RELATED TO THE BLOCKING PERIOD*/
    protected SimpleTimer blockTimer =  new  SimpleTimer();
    public static boolean block = false;

    private GreenfootImage Idle1 = new GreenfootImage("Idle1.png");
    private GreenfootImage Idle2 = new GreenfootImage("Idle2.png");
    private GreenfootImage Idle3 = new GreenfootImage("Idle3.png");
    private GreenfootImage Idle4 = new GreenfootImage("Idle4.png");
    private GreenfootImage Idle5 = new GreenfootImage("Idle5.png");
    private GreenfootImage Idle6 = new GreenfootImage("Idle6.png");
    private GreenfootImage Idle7 = new GreenfootImage("Idle7.png");
    private GreenfootImage Idle8 = new GreenfootImage("Idle8.png");
    private GreenfootImage Idle9 = new GreenfootImage("Idle9.png");
    private GreenfootImage Idle10 = new GreenfootImage("Idle10.png");
    
    private GreenfootImage IdleF1 = new GreenfootImage("IdleF1.png");
    private GreenfootImage IdleF2 = new GreenfootImage("IdleF2.png");
    private GreenfootImage IdleF3 = new GreenfootImage("IdleF3.png");
    private GreenfootImage IdleF4 = new GreenfootImage("IdleF4.png");
    private GreenfootImage IdleF5 = new GreenfootImage("IdleF5.png");
    private GreenfootImage IdleF6 = new GreenfootImage("IdleF6.png");
    private GreenfootImage IdleF7 = new GreenfootImage("IdleF7.png");
    private GreenfootImage IdleF8 = new GreenfootImage("IdleF8.png");
    private GreenfootImage IdleF9 = new GreenfootImage("IdleF9.png");
    private GreenfootImage IdleF10 = new GreenfootImage("IdleF10.png");
    private int frameR = 1; 
    private int frameL = 1; 
    
    /**
     * 
     */
    public void act()
    {
        move();
        fallingAction();
        gameOver();
        block();
        contactArrow();
    }

    /* UP, DOWN, LEFT RIGHT*/

    /**
     * 
     */
    public void move()
    {
        if (Greenfoot.isKeyDown("a")) {
            move(-5);        
            leftAnimation();
        }
        if (Greenfoot.isKeyDown("d")) {
            move(5);
            rightAnimation(); 
        }
        if (Greenfoot.isKeyDown("w") && getY() > getWorld().getHeight() - 100) {
            speed = -20;
        }                
    }

    // ANIMATION RIGHT
    public void rightAnimation() {
        if (frameR == 2) {
            setImage(Idle1); 
        }
        else if (frameR == 4) {
            setImage(Idle2);
        }
        else if (frameR == 6) {
            setImage(Idle3);
        }
        else if (frameR == 8) {
            setImage(Idle4);
        }
        else if (frameR == 10) {
            setImage(Idle5);
        }
        else if (frameR == 12) {
            setImage(Idle6);
        }
        else if (frameR == 14) {
            setImage(Idle7);
        }
        else if (frameR == 16) {
            setImage(Idle8);
        }
        else if (frameR == 18) {
            setImage(Idle9);
        }
        else if (frameR == 20) {
            setImage(Idle10);
            frameR = 0; 
        }
        frameR++; 

        }

    // ANIMATION LEFT
    public void leftAnimation() {
        if (frameL == 2) {
            setImage(IdleF1); 
        }
        else if (frameL == 4) {
            setImage(IdleF2);
        }
        else if (frameL == 6) {
            setImage(IdleF3);
        }
        else if (frameL == 8) {
            setImage(IdleF4);
        }
        else if (frameL == 10) {
            setImage(IdleF5);
        }
        else if (frameL == 12) {
            setImage(IdleF6);
        }
        else if (frameL == 14) {
            setImage(IdleF7);
        }
        else if (frameL == 16) {
            setImage(IdleF8);
        }
        else if (frameL == 18) {
            setImage(IdleF9);
        }
        else if (frameL == 20) {
            setImage(IdleF10);
            frameL = 0; 
        }
        frameL++; 
    }

    /* BLOCK ARROWS*/

    /**
     * 
     */
    public void block()
    {
        if (Greenfoot.isKeyDown("space") && blockTimer.millisElapsed() > 200) {
            block = true;
            blockTimer.mark();
        }
        if (blockTimer.millisElapsed() > 100) {
            block = false;
        }
    }

    /* IMPLEMENTATION OF GRAVITY*/

    /**
     * 
     */
    public void fallingAction()
    {
        setLocation(getX(), getY() + speed);
        if (getY() > getWorld().getHeight() - 100) {
            speed = 0;
        }
        else {
            speed = speed + gravity;
        }
    }

    /* INVOKED WHEN AN ARROW TOUCHES THE PLAYER*/

    /**
     * 
     */
    public void contactArrow()
    {
        if (Arrow.boolContactArrow == true && getY() > getWorld().getHeight() - 100) {
            speed = -5;
            Arrow.boolContactArrow = false;
        }
        else if (Arrow.boolBlockArrow == true && getY() > getWorld().getHeight() - 100) {
            speed = -2;
            move(-5);
            Arrow.boolBlockArrow = false;
        }
    }

    /* CONDITION REQUIRED FOR THE PLAYER TO LOOSE*/

    /**
     * 
     */
    public void gameOver()
    {
        if (isTouching(Boss.class) || isTouching(BowArrow.class)) {
            getWorld().removeObject(this);
        }
    }
}
