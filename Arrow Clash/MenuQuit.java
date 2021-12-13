import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuQuit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuQuit extends World
{

    /**
     * Constructor for objects of class MenuQuit.
     * 
     */
    public MenuQuit()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    public void act(){
        if (Greenfoot.isKeyDown("up")){
            Greenfoot.setWorld(new MenuCredits());
        }        

        if (Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new Menu());
        }
    }
    }

