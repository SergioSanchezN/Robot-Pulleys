import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controles extends World
{
    Back back;
    public Controles()
    {    
        super(720, 400, 1); 
        back = new Back();
        addObject(back,20, 20);
    }
    public void act(){
    if(Greenfoot.mouseClicked(back)){
            Greenfoot.setWorld(new Menú());
        }
    if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new Menú());
        }
    }
}
