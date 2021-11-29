import greenfoot.*;  

/**
 * DEFLECTED ARROW 
 * 
 * @author MATIAS GAUTHIER
 * 
 */
public class DeflectedArrow extends Actor
{
    public void act()
    {
        deflect();
        hit(); 
    }
    // VAR RELATED TO ENNEMY CONTACT WITH THE ARROw
    public static boolean boolContactArrowBoss = false;
    
    // INVOKED AFTER DEFLECT METHOD IN ARROW CLASS
    public void deflect() {
        int arrowSpeed = 15; 
        setLocation(getX() + arrowSpeed, getY());  
    }
    
    // WHEN ARROW HITS AN ENNEMY 
    public void hit() {
        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
        else if (isTouching(Boss.class)) {
            boolContactArrowBoss = true; 
            getWorld().removeObject(this);
        }
    }
}
