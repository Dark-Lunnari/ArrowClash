import greenfoot.*;  

/**
 * BOSS
 * 
 * @author MATIAS GAUTHIER
 */
public class Boss extends Actor
{
    private GreenfootImage Idle1 = new GreenfootImage("Boss-Idle1.png");
    private GreenfootImage Idle2 = new GreenfootImage("Boss-Idle2.png");
    private GreenfootImage Idle3 = new GreenfootImage("Boss-Idle3.png");
    private GreenfootImage Idle4 = new GreenfootImage("Boss-Idle4.png");
    private GreenfootImage Idle5 = new GreenfootImage("Boss-Idle5.png");
    private GreenfootImage Idle6 = new GreenfootImage("Boss-Idle6.png");
    private GreenfootImage Idle7 = new GreenfootImage("Boss-Idle7.png");
    private GreenfootImage Idle8 = new GreenfootImage("Boss-Idle8.png");
    private GreenfootImage Idle9 = new GreenfootImage("Boss-Idle9.png");
    private GreenfootImage Idle10 = new GreenfootImage("Boss-Idle10.png");
    
    private int frameR = 1;
    public void act()
    {
        randomShooting();
        fallingAction();
        contactArrow(); 
        IdleAnimation();
    }
    
    // VAR RELATED TO SHOOTING 
    int shootingSpeed = 20;
    int randomTime = 250;
    int randomHeight = 90;
    int timeBetweenShots = 500; 
    SimpleTimer arrowTimer = new SimpleTimer(); 
    
    // VAR RELATED TO JUMPING & GRAVITY
    final int gravity = 1;
    int speed;
    
    // DETERMINES WHEN AND WHERE THE ARROW WILL BE SHOT 
    public void randomShooting() {
        if (arrowTimer.millisElapsed() > timeBetweenShots + Greenfoot.getRandomNumber(randomTime)) {
            getWorld().addObject(new Arrow(), getX(), getY() - Greenfoot.getRandomNumber(randomHeight));
            arrowTimer.mark(); 
        }
    }
    
    // IMPLEMENTATION OF GRAVITY 
    public void fallingAction() {
        setLocation(getX(), getY() + speed);
        if (getY() > getWorld().getHeight() - 100) {
            speed = 0;
        }
        else {
            speed += gravity;
        }
    }
    
    // INVOKED WHEN AN ARROW TOUCHES THE BOSS
    public void contactArrow() {
        if (DeflectedArrow.boolContactArrowBoss == true && getY() > getWorld().getHeight() - 100) {
            speed = -5;
            move(3); 
            DeflectedArrow.boolContactArrowBoss = false;
        }
    }
    
    public void IdleAnimation() {
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
}
