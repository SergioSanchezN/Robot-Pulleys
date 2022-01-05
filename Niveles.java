import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Niveles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Niveles extends World
{
    Back back;
    BNivel1 nivel1;
    BNivel2 nivel2;
    BNivel3 nivel3;
    GreenfootSound sound;
    public Niveles()
    {    
        super(720, 400, 1);
        back = new Back();
        nivel1 = new BNivel1();
        nivel2 = new BNivel2();
        nivel3 = new BNivel3(); 
        addObject(back,20, 20);
        addObject(nivel1,281, 85);
        addObject(nivel2,277, 200);
        addObject(nivel3,278, 307);
        sound=new GreenfootSound("Menú.mp3");
    }
    public void act(){
    if(Greenfoot.mouseClicked(back)){
            Greenfoot.setWorld(new Menú());
        }
    if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new Menú());
            
        }
    if(Greenfoot.mouseClicked(nivel1)){
            Greenfoot.setWorld(new Nivel1());
        }
    if(Greenfoot.mouseClicked(nivel2)){
            Greenfoot.setWorld(new Nivel2());
        }
    if(Greenfoot.mouseClicked(nivel3)){
            Greenfoot.setWorld(new Nivel3());
        }
    }
}
