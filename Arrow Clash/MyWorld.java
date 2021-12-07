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
        Grass Grass5 =  new  Grass();
        addObject(Grass5, 114, 359);
        Grass Grass6 =  new  Grass();
        addObject(Grass6, 295, 353);
        Grass Grass7 =  new  Grass();
        addObject(Grass7, 480, 358);
        Grass Grass8 =  new  Grass();
        addObject(Grass8, 596, 359);
        Grass Grass9 =  new  Grass();
        addObject(Grass9, 740, 354);
    }
    
    public void act(){       
        if (Greenfoot.getRandomNumber(100) < 1) {
            addObject( new  Grass(), 779, 359);
        }
      }
    }
