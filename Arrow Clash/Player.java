import greenfoot.*;  

/**
 * MAIN CHARACTER
 * 
 * MATIAS GAUTHIER 
 * 
 */
public class Player extends Actor
{
    public void act()
    {
        move();
        fallingAction();
        gameOver(); 
        block();
        contactArrow(); 
    }
    
    // VAR RELATED TO JUMPING & GRAVITY
    final int gravity = 1;
    int speed;
    
    // TIMER RELATED TO THE BLOCKING PERIOD 
    SimpleTimer blockTimer = new SimpleTimer(); 
    public static boolean block = false; 
    
    // UP, DOWN, LEFT RIGHT
    public void move() {
        if(Greenfoot.isKeyDown("a")){
            move(-5);
        }
        if(Greenfoot.isKeyDown("d")) {
            move(5);
        }
        if(Greenfoot.isKeyDown("w") && getY() > getWorld().getHeight() - 100) {
            speed = -20;             
        }
    }
    
    // BLOCK ARROWS
    public void block() {
        if(Greenfoot.isKeyDown("space") && blockTimer.millisElapsed() > 200) {
            block = true; 
            blockTimer.mark();
        }
        if (blockTimer.millisElapsed() > 100) {
            block = false; 
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
    
    // INVOKED WHEN AN ARROW TOUCHES THE PLAYER
    public void contactArrow() {
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
    
    // CONDITION REQUIRED FOR THE PLAYER TO LOOSE 
    public void gameOver() {
        if (isTouching(Boss.class) || isTouching(BowArrow.class)) {
            getWorld().removeObject(this);
        }
    }
    
}