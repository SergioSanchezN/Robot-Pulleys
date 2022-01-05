import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creditos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creditos extends World
{
    Back back;
    public Creditos()
    {    
        super(725, 407, 1); 
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
