import greenfoot.*;  

/**
 * ARROW
 * 
 * @author MATIAS GAUTHIER 
 * 
 */
public class Arrow extends Actor
{
    public void act()
    {
        move(-15); 
        deflect();
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
            getWorld().removeObject(this);
        }
        
        else if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }

}
