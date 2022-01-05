import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Engranajes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Engranajes extends Actor
{
    /**
     * Act - do whatever the Engranajes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
    }  
    public void girar(){
        setRotation(getRotation()+10);
    }
}
