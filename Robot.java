import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends Actor
{
    Random rand=new Random();
    private boolean intersecCuerda;
    private boolean intersecSuelo;
    private boolean intersecPlataforma;
    public void act() 
    {
        Movimiento();
        SubirPlataforma();
        gravedad();
    }
    public boolean getIntersecCuerda(){
        return intersecCuerda;
    }
    public boolean getIntersecPlataforma(){
        return intersecPlataforma;
    }
    public boolean getIntersecSuelo(){
        return intersecSuelo;
    }
    public void Movimiento(){ 
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")){
            move(2); 
            Actor muro = getOneIntersectingObject(Muro.class);
            if(muro != null){
                move(-2);
            }
        }
        else if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")){
            move(-2);
            Actor muro = getOneIntersectingObject(Muro.class);
            if(muro != null){
                move(2);
            }
        }
    }
    public void gravedad(){
        int y = getY();
        Actor suelo = getOneIntersectingObject(Suelo.class);
        Actor plataforma = getOneIntersectingObject(Plataforma.class);
        if(y<357&&suelo == null&&plataforma==null){
            y=y+3;
        }
        if(suelo == null){
            intersecSuelo=false;
        }
        else{
            intersecSuelo=true;
        }
        setLocation(getX(),y);
    }
    public void SubirCuerda(){
        Actor cuerda = getOneIntersectingObject(Cuerda.class);
        if(cuerda == null){
            intersecCuerda=false;
        }
        else{
            intersecCuerda=true;
        }
    }
    public void SubirPlataforma(){
        Actor plataforma = getOneIntersectingObject(Plataforma.class);
        if(plataforma == null){
            intersecPlataforma=false;
        }
        else{
            intersecPlataforma=true;
        }
    }
}