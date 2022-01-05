import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Nivel3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel3 extends World
{
    int i,tap,fuerza,masa,masaDelPeso;
    Random rand=new Random(); 
    Muro m1,m2;
    Suelo s1,s2,s3;
    Peso p1,p2,p3;
    Robot robot;
    Motor motor;
    Engranajes e1,e2;
    Polea polea;
    Cuerda cuerda;
    Plataforma plataforma;
    BaseCanasta base;
    Canasta canasta; 
    Back back;
    GreenfootSound sound;
    public Nivel3()
    {    
        super(713, 402, 1); 
        fuerza = 0;
        masa = (rand.nextInt(9)+1)*10;
        masaDelPeso = rand.nextInt(4)+1;
        m1 = new Muro();
        m2 = new Muro();
        s1 = new Suelo();
        s2 = new Suelo();
        s3 = new Suelo();
        p1 = new Peso();
        p2 = new Peso();
        p3 = new Peso();
        base = new BaseCanasta();
        canasta = new Canasta();
        robot = new Robot();
        motor = new Motor();
        e1 = new Engranaje1();
        e2 = new Engranaje2();
        polea = new Polea();
        cuerda = new Cuerda();
        plataforma = new Plataforma();
        back = new Back();
        sound=new GreenfootSound("SoundNivel3.mp3"); 
        //coordenadas
        showText(" =  "+masaDelPeso+" Kg",198,262);
        showText(" =  "+(masa/2)+" Kg",198,305);
        showText(" =  "+(masa/2)+" Kg",198,345);
        addObject(m1,407, 305);
        addObject(m2,510, 305);
        addObject(s1,100, 205);
        addObject(s2,299, 205); 
        addObject(s3,618, 205);
        addObject(cuerda,458, 251);
        addObject(base,458, 396);
        addObject(canasta,458, 273);
        addObject(polea,404, 98);
        addObject(plataforma,458, 336);
        addObject(p1,488, 388);
        addObject(p2,458, 388);
        addObject(p3,428, 388);
        addObject(robot,93, 169);
        addObject(motor,317, 163);
        addObject(e1,309, 162);
        addObject(e2,336, 151);
        addObject(back,20, 20);
    }
    public void act(){
        sonido();
        clickMotor();
        moverPlataforma();
        clickBack();
        siguienteNivel();
    }
    public void sonido(){
        if(sound.isPlaying()==false){
            sound.playLoop();
        }
    }
        public void clickMotor(){               
        if(Greenfoot.mouseClicked(motor)&&fuerza<1600){
            fuerza = fuerza + 100;      
        }
        if(fuerza==1600){
            fuerza = 0;
        }
        if(fuerza==0){
            showText("0"+fuerza+"N",317,185);
        }    
        else{
            showText(fuerza+"N",317,185);
        }
    }
        public void controlPlataforma(){
        int a = 2;
            if((Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))&&plataforma.getY()>209){
             plataforma.setLocation( plataforma.getX(),(plataforma.getY()-a));
             cuerda.setLocation( cuerda.getX(),(cuerda.getY()-a));
             canasta.setLocation( canasta.getX(),(canasta.getY()-a));
             base.setLocation( base.getX(),(base.getY()-a));
             p1.setLocation( p1.getX(),(p1.getY()-a));
             p2.setLocation( p2.getX(),(p2.getY()-a));
             p3.setLocation( p3.getX(),(p3.getY()-a));
             e1.girar();
             e2.girar();
             if(robot.getIntersecPlataforma()==true&&plataforma.getY()<robot.getY()+38){
                 robot.setLocation(robot.getX(),(robot.getY()-a));
             }
        }
        if((Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))&&plataforma.getY()<336){
             plataforma.setLocation( plataforma.getX(),(plataforma.getY()+a));
             cuerda.setLocation( cuerda.getX(),(cuerda.getY()+a));
             canasta.setLocation( canasta.getX(),(canasta.getY()+a));
             base.setLocation( base.getX(),(base.getY()+a));
             p1.setLocation( p1.getX(),(p1.getY()+a));
             p2.setLocation( p2.getX(),(p2.getY()+a));
             p3.setLocation( p3.getX(),(p3.getY()+a));
             e1.girar();
             e2.girar();
        }
    }
    public void caer(){
        int a = 3;         
        plataforma.setLocation( plataforma.getX(),(plataforma.getY()+a));
        cuerda.setLocation( cuerda.getX(),(cuerda.getY()+a));
        canasta.setLocation( canasta.getX(),(canasta.getY()+a));
        base.setLocation( base.getX(),(base.getY()+a));
        p1.setLocation( p1.getX(),(p1.getY()+a));
        p2.setLocation( p2.getX(),(p2.getY()+a));
        p3.setLocation( p3.getX(),(p3.getY()+a));
        e1.girar();
        e2.girar();
    }
    public void moverPlataforma(){
        if((fuerza>(30*masaDelPeso)&&robot.getIntersecPlataforma()==false)||(fuerza>masa*10+(30*masaDelPeso)&&robot.getIntersecPlataforma()==true)){
            controlPlataforma();
        }
        if(fuerza<masa*10+(30*masaDelPeso)&&robot.getIntersecPlataforma()==true&&plataforma.getY()<336){
            caer();
        }
        if(fuerza<(30*masaDelPeso)&&robot.getIntersecPlataforma()==false&&plataforma.getY()<336){
            caer();
        }
    }
    public void clickBack(){
        if(Greenfoot.mouseClicked(back)){
            Greenfoot.setWorld(new Menú());
            sound.stop();
        }
    }
    public void siguienteNivel(){
        if(robot.getX()>653&&robot.getY()<180){
            sound.stop();
            Greenfoot.setWorld(new Menú());
        }    
    }
}
