import greenfoot.*;
import greenfoot.GreenfootImage;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BowArrow3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BowArrow3 extends Actor
{
    private GreenfootImage Bowm1 = new GreenfootImage("Bowman 1.png");
    private GreenfootImage Bowm2 = new GreenfootImage("Bowman 2.png");
    private GreenfootImage Bowm3 = new GreenfootImage("Bowman 3.png");
    private GreenfootImage Bowm4 = new GreenfootImage("Bowman 4.png");
    private GreenfootImage Bowm5 = new GreenfootImage("Bowman 5.png");
    private GreenfootImage Bowm6 = new GreenfootImage("Bowman 6.png");
    private GreenfootImage Bowm7 = new GreenfootImage("Bowman 7.png");
    private GreenfootImage Bowm8 = new GreenfootImage("Bowman 8.png");
    private GreenfootImage Bowm9 = new GreenfootImage("Bowman 9.png");
    private GreenfootImage Bowm10 = new GreenfootImage("Bowman 10.png");
    
    private int frameR = 1;
    /**
     * Act - do whatever the BowArrow3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Animation();
        randomShooting();
        fallingAction();
        contactArrow();
    }
    
    
     public void Animation() {
        if (frameR == 2) {
            setImage(Bowm1); 
        }
        else if (frameR == 4) {
            setImage(Bowm2);
        }
        else if (frameR == 6) {
            setImage(Bowm3);
        }
        else if (frameR == 8) {
            setImage(Bowm4);
        }
        else if (frameR == 10) {
            setImage(Bowm5);
        }
        else if (frameR == 12) {
            setImage(Bowm6);
        }
        else if (frameR == 14) {
            setImage(Bowm7);
        }
        else if (frameR == 16) {
            setImage(Bowm8);
        }
        else if (frameR == 18) {
            setImage(Bowm9);
        }
        else if (frameR == 20) {
            setImage(Bowm10);
            frameR = 0; 
        }
        frameR++; 

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
