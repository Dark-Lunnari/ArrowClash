import greenfoot.*;  

/**
 * FIRST LEVEL 
 * 
 * @author MATIAS GAUTHIER
 * 
 */
public class MyWorld extends World
{
    public MyWorld()
    {    
        super(900, 300, 1); 
        prepare();
    }
    
    private void prepare()
    {
        Player player = new Player();
        addObject(player,90, getHeight() - 100);
        //Boss boss = new Boss();
        //addObject(boss,800,190);
        DeflectedArrow DeflectedArrow = new DeflectedArrow(); 
    }
}
