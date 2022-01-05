import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Nivel1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel1 extends World
{
    Random rand=new Random();
    int i,tap,masa,masaDelPeso,masaRobot,masaCaja;
    Muro m;
    Suelo s1,s2;
    Cuerda cuerda;
    Robot robot;
    Dispensador dispensador;
    Engranajes e1,e2;
    Polea polea;
    Plataforma plataforma;
    Peso p1;
    BaseCanasta base;
    Canasta canasta;
    Back back;
    GreenfootSound sound;
    public Nivel1()
    {    
        super(720, 405, 1);
        i=0;
        tap=0;
        m = new Muro();
        s1 = new Suelo();
        s2 = new Suelo();
        robot = new Robot();
        cuerda = new Cuerda();
        dispensador = new Dispensador();
        e1 = new Engranaje1();
        e2 = new Engranaje2();
        polea = new Polea();
        plataforma = new Plataforma();
        base = new BaseCanasta();
        canasta = new Canasta();
        back = new Back();
        masa=(rand.nextInt(9)+1)*10;
        masaDelPeso=masa/(rand.nextInt(4)+1);
        masaRobot = masa*3/5;
        masaCaja = masa*2/5;
        sound=new GreenfootSound("SoundNivel1.mp3");

        //coordenadas
        showText(" = "+masaDelPeso+" Kg",560,261);
        showText(" = "+masaRobot+" Kg",560,300);
        showText(" = "+masaCaja+" Kg",560,340);
        addObject(m,362, 305);
        addObject(s1,469, 202);
        addObject(s2,650, 202);
        addObject(dispensador,122, 131);
        addObject(e1,90, 134);
        addObject(e2,117, 126);
        addObject(cuerda,308, 290);
        addObject(plataforma,308, 396);
        addObject(base,203, 192);
        addObject(canasta,203, 69);
        addObject(polea,254, 100);
        addObject(robot,93, 357);
        addObject(back,20, 20);
    }   
    public void act(){
        sonido();
        clickBack();
        displayDispensador();      
        clickDispensador();
        siguienteNivel();
    }
    public void sonido(){
        if(sound.isPlaying()==false){
            sound.playLoop();
        }
    }
    public void displayDispensador(){
        if(i>9){
            showText(""+i,102,160);
        }
        else{
            showText("0"+i,102,160);
        } 
    }
    public void clickBack(){
        if(Greenfoot.mouseClicked(back)){
            sound.stop();
            Greenfoot.setWorld(new Menú());
        }
    }
    public void siguienteNivel(){
        if(robot.getX()>629&&robot.getY()<170){
            sound.stop();
            Greenfoot.setWorld(new Nivel2());
        }    
    }
    public void plataformaSube(){
        if(canasta.getY()<260){
             canasta.setLocation(canasta.getX(),(canasta.getY()+1));
             base.setLocation(base.getX(),(base.getY()+1));
             plataforma.setLocation(plataforma.getX(),(plataforma.getY()-1));
             cuerda.setLocation(cuerda.getX(),(cuerda.getY()-1));
             if(robot.getIntersecPlataforma()==true&&plataforma.getY()==robot.getY()+38){
                 robot.setLocation(robot.getX(),(robot.getY()-1));
             }
        }
    }
    public void clickDispensador(){
        if(Greenfoot.mouseClicked(dispensador)){
            Peso p = new Peso();
            addObject(p,176, 157); 
            i=i+1;
            tap = 30;
        }
        if(tap>0){
            e1.girar();
            e2.girar();
            tap = tap - 1;
        }
        if(i*masaDelPeso>masa&&robot.getIntersecPlataforma()==true){
            plataformaSube();
        }
        else if(i>=1&&robot.getIntersecPlataforma()==false){
            plataformaSube();
        }
        }
}
