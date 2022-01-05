import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Peso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Peso extends Actor
{
    /**
     * Act - do whatever the Peso wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Gravedad();
    } 
    public void Gravedad(){
        int y = getY();
        Actor base = getOneIntersectingObject(BaseCanasta.class);
        if(base == null){
            y=y+3;
        }
        setLocation(getX(),y);
    }
}
