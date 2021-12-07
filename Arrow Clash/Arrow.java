import greenfoot.*;  
import greenfoot.GreenfootImage;
/**
 * ARROW
 * 
 * @author MATIAS GAUTHIER 
 * 
 */
public class Arrow extends Actor
{
    private GreenfootImage Arrow1;
    private GreenfootImage Arrow2;
    private GreenfootImage Arrow3;
    private GreenfootImage Arrow4;
    
    public Arrow(){     
        Arrow1 =  new  GreenfootImage("Arrow1.png");
        Arrow2 =  new  GreenfootImage("Arrow2.png");
        Arrow3 =  new  GreenfootImage("Arrow3.png");
        Arrow4 =  new  GreenfootImage("Arrow4.png");
    }
    
    public void act()
    {
        move(-15);        
        deflect();
        animation();
    }
    
    public void animation(){
        if (getImage() == Arrow1) {
            setImage(Arrow2);
        }
        else {
            if (getImage() == Arrow3) {
                setImage(Arrow4);
            }
            else {
                setImage(Arrow1);
            }   
        } 
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
