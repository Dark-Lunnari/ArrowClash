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
    
    private GreenfootImage Idle1;
    private GreenfootImage Idle2;
    private GreenfootImage Idle3;
    private GreenfootImage Idle4;
    private GreenfootImage Idle5;
    private GreenfootImage Idle6;
    private GreenfootImage Idle7;
    private GreenfootImage Idle8;
    private GreenfootImage Idle9;
    private GreenfootImage Idle10;
    private GreenfootImage IdleF1;
    private GreenfootImage IdleF2;
    private GreenfootImage IdleF3;
    private GreenfootImage IdleF4;
    private GreenfootImage IdleF5;
    private GreenfootImage IdleF6;
    private GreenfootImage IdleF7;
    private GreenfootImage IdleF8;
    private GreenfootImage IdleF9;
    private GreenfootImage IdleF10;
    private long time;
    private long pauseTime;
    public Player(){     
        time = System.currentTimeMillis();
        pauseTime = 0;
        
        Idle1 = new GreenfootImage("Idle1.png");
        Idle2 =  new  GreenfootImage("Idle2.png");
        Idle3 =  new  GreenfootImage("Idle3.png");
        Idle4 =  new  GreenfootImage("Idle4.png");
        Idle5 =  new  GreenfootImage("Idle5.png");
        Idle6 =  new  GreenfootImage("Idle6.png");
        Idle7 =  new  GreenfootImage("Idle7.png");
        Idle8 =  new  GreenfootImage("Idle8.png");
        Idle9 =  new  GreenfootImage("Idle9.png");
        Idle10 =  new  GreenfootImage("Idle10.png");
        IdleF1 =  new  GreenfootImage("IdleF1.png");
        IdleF2 =  new  GreenfootImage("IdleF2.png");
        IdleF3 =  new  GreenfootImage("IdleF3.png");
        IdleF4 =  new  GreenfootImage("IdleF4.png");
        IdleF5 =  new  GreenfootImage("IdleF5.png");
        IdleF6 =  new  GreenfootImage("IdleF6.png");
        IdleF7 =  new  GreenfootImage("IdleF7.png");
        IdleF8 =  new  GreenfootImage("IdleF8.png");
        IdleF9 =  new  GreenfootImage("IdleF9.png");
        IdleF10 =  new  GreenfootImage("IdleF10.png");
    }
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
        pause(1000);
        if(running()){
            IdleRight();
        }
    }

    /* UP, DOWN, LEFT RIGHT*/

    /**
     * 
     */
    public void move()
    {
        if (Greenfoot.isKeyDown("a")) {
            move(-5);        
        }
        if (Greenfoot.isKeyDown("d")) {
            move(5);            
        }
        if (Greenfoot.isKeyDown("w") && getY() > getWorld().getHeight() - 100) {
            speed = -20;
        }                
    }

    //Idle Animation
    
    public void IdleRight(){         
        int timeDelay = 5000;
        if (getImage() == Idle1 && (System.currentTimeMillis() > time ) ){            
                setImage(Idle2); 
            }else if (getImage() == Idle2 && (System.currentTimeMillis() > time + timeDelay)) {  
                setImage(Idle3);
            }
            else if (getImage() == Idle3 && (System.currentTimeMillis() > time + 2*timeDelay)) {               
                setImage(Idle4);                
            }
            else if (getImage() == Idle4 && (System.currentTimeMillis() > time + 3*timeDelay)){                    
                setImage(Idle5);                    
            }
            else if (getImage() == Idle5 && (System.currentTimeMillis() > time + 4*timeDelay)){                    
                setImage(Idle6);                    
            }
            
            else if (getImage() == Idle6 && (System.currentTimeMillis() > time + 5*timeDelay)){                    
                setImage(Idle7);                    
            }
            
            else if (getImage() == Idle7 && (System.currentTimeMillis() > time + 6*timeDelay)){                    
                setImage(Idle8);                    
            }
            
            else if (getImage() == Idle8 && (System.currentTimeMillis() > time + 7*timeDelay)){                    
                setImage(Idle9);
            }
            
            else if (getImage() == Idle9 && (System.currentTimeMillis() > time + 8*timeDelay)){                    
                setImage(Idle10);                    
            }
            else{
                setImage(Idle1);
            }
    }
    public boolean running()
    {
         long time1 = System.currentTimeMillis();
         return time > pauseTime;
    }
    
    public void pause(long delay)
    {
         long time1 = System.currentTimeMillis();
         pauseTime = time+delay;
    }


    public void IdleLeft(){
            if (getImage() == Idle1) {
            setImage(IdleF1);
        }
        else {
            if (getImage() == IdleF2) {
                setImage(IdleF3);
            }
            else {
                if (getImage() == IdleF4) {
                    setImage(IdleF5);
                }
                else {
                    if (getImage() == IdleF6){
                    setImage(IdleF7);
                }
                else{
                    if (getImage() == IdleF8){
                        setImage(IdleF9);
                    }
                    else{
                        setImage(Idle1);
                    }
                }
            }
        }        
    }
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
