import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menú here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menú extends World
{
    BJugar jugar;
    BNiveles niveles;
    BControles controles;
    BCreditos creditos;
    BSalir salir;
    GreenfootSound sound;
    public Menú()
    {    
        super(722, 405, 1);
        jugar = new BJugar();
        niveles = new BNiveles();
        controles = new BControles();
        creditos = new BCreditos();
        salir = new BSalir();
        addObject(jugar, 351, 108);
        addObject(niveles, 351, 154);
        addObject(controles, 351, 202);
        addObject(creditos, 351, 250);
        addObject(salir, 351, 298);
        sound=new GreenfootSound("Menú.mp3");        
    }
    public void act(){
        if(sound.isPlaying()==false){
            sound.playLoop();
        }
        if(Greenfoot.mouseClicked(jugar)){
            Greenfoot.setWorld(new Nivel1()); 
            sound.stop(); 
        }
        if(Greenfoot.mouseClicked(niveles)){
            Greenfoot.setWorld(new Niveles());
            sound.stop();
        }
        if(Greenfoot.mouseClicked(controles)){
            Greenfoot.setWorld(new Controles());
            sound.stop();
        }
        if(Greenfoot.mouseClicked(creditos)){
            Greenfoot.setWorld(new Creditos());
            sound.stop();
        }
        if(Greenfoot.mouseClicked(salir)){
            Greenfoot.stop();
        }
    }
}
