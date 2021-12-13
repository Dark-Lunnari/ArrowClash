import greenfoot.*;  

/**
 * FIRST LEVEL 
 * 
 * @author MATIAS GAUTHIER
 * 
 */
public class MyWorldlvl3 extends World
{
    public MyWorldlvl3()
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
        Boss boss = new Boss();
        addObject(boss,815,198);
        BowArrow bowArrow = new BowArrow();
        addObject(bowArrow,610,185);
        boss.setLocation(738,199);
        BowArrow bowArrow2 = new BowArrow();
        addObject(bowArrow2,843,184);
        removeObject(bowArrow);
        removeObject(bowArrow2);
        BowArrow3 bowArrow3 = new BowArrow3();
        addObject(bowArrow3,585,185);
        BowArrow3 bowArrow32 = new BowArrow3();
        addObject(bowArrow32,840,182);
    }
    
    public void act(){       
        if (Greenfoot.getRandomNumber(45) < 1) {
            addObject( new  Grass(), 779, 359);
        }
      }
    }
