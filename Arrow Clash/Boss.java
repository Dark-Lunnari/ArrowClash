import greenfoot.*;  

/**
 * BOSS
 * 
 * @author MATIAS GAUTHIER
 */
public class Boss extends Actor
{
    public void act()
    {
        randomShooting();
        fallingAction();
        contactArrow(); 
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
}
