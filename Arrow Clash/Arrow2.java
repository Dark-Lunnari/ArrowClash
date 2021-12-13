import greenfoot.*;  
import greenfoot.GreenfootImage;
/**
 * ARROW
 * 
 * @author MATIAS GAUTHIER 
 * 
 */
public class Arrow2 extends Actor
{

    private GreenfootImage Arrow1 = new GreenfootImage("Arrow1.png");
    private GreenfootImage Arrow2 = new GreenfootImage("Arrow2.png");
    private GreenfootImage Arrow3 = new GreenfootImage("Arrow3.png");
    private GreenfootImage Arrow4 = new GreenfootImage("Arrow4.png");
    private int frame = 1; 
    
    public void act()
    {
        move(-15);        
        deflect();
        animation();
    }

    // ANIMATION
    public void animation() {
        if (frame == 2) {
            setImage(Arrow1); 
        }
        else if (frame == 4) {
            setImage(Arrow2);
        }
        else if (frame == 6) {
            setImage(Arrow3);
        }
        else if (frame == 8) {
            setImage(Arrow4);
            frame = 0; 
        }
        frame++; 
    }
    
    // VAR RELATED TO WHEN THE PLAYER INTERACTS WITH ARROWS
    
    public static boolean boolContactArrow = false;
    public static boolean boolBlockArrow = false; 
    
    // THIS METHOD IS INVOKED WHEN THE CHARACTER BLOCKS 
    // ALSO USED WHEN THE ARROW TOUCHES TH PLAYER 
    private void deflect() {  
        if (isTouching(Player.class) && Player.block == true) {
             getWorld().addObject(new DeflectedArrow(), getX(), getY());
             boolBlockArrow = true; 
             getWorld().removeObject(this);
        }
        else if (isTouching(Player.class)) {
            boolContactArrow = true; 
            //getWorld().removeObject(this);
        }
        
        else if (isAtEdge()) {
            getWorld().removeObject(this);
        }
        if (isTouching(BowArrow2.class)) {
            removeTouching(BowArrow2.class);
            Greenfoot.setWorld(new MyWorldlvl3());
        }
    }
}    

