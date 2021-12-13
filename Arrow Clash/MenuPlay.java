import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuPlay extends World
{

    /**
     * Constructor for objects of class MenuPlay.
     * 
     */
    public MenuPlay()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    public void act(){
        if (Greenfoot.isKeyDown("down")){
            Greenfoot.setWorld(new MenuCredits());
        }
        
        if (Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new MyWorld());
        }

    }
    }
