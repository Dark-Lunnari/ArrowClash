import greenfoot.*;  

/**
 * FIRST LEVEL 
 * 
 * @author MATIAS GAUTHIER
 * 
 */
public class MyWorld extends World
{
    //private GreenfootImage Heart = new GreenfootImage("Heart.png");
    //private GreenfootImage EmptyHeart = new GreenfootImage("Empty Heary.png");
    
    //private int lives = 3;
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

        Grass grass = new Grass();
        addObject(grass,365,298);
        grass.setLocation(690,299);
        Grass grass2 = new Grass();
        addObject(grass2,690,299);
        BowArrow bowArrow = new BowArrow();
        addObject(bowArrow,839,181);
    }
    
    public void act(){       
        if (Greenfoot.getRandomNumber(45) < 1) {
            addObject( new  Grass(), 779, 359);
        }
    }
    
    //public void Lives(){
        //for (int i = 0; i < lives; i++) {
            //setImage(Heart, 300 + i*60, 320);
}
    

