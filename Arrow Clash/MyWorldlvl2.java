import greenfoot.*;  

/**
 * FIRST LEVEL 
 * 
 * @author MATIAS GAUTHIER
 * 
 */
public class MyWorldlvl2 extends World
{
    public MyWorldlvl2()
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

        Grass grass = new Grass();
        addObject(grass,365,298);
        grass.setLocation(690,299);
        Grass grass2 = new Grass();
        addObject(grass2,690,299);
        BowArrow bowArrow = new BowArrow();
        addObject(bowArrow,842,190);
        BowArrow bowArrow2 = new BowArrow();
        addObject(bowArrow2,726,201);
    }
    
    public void act(){       
        if (Greenfoot.getRandomNumber(45) < 1) {
            addObject( new  Grass(), 779, 359);
        }
      }
    }
