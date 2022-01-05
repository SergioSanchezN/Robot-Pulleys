import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Nivel2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel2 extends World
{
    Random rand=new Random();
    int i,tap,fuerza,masa;
    Muro m;
    Suelo s1,s2;
    Robot robot;
    Motor motor;
    Engranajes e1,e2;
    Polea polea;
    Cuerda cuerda;
    Plataforma plataforma;
    Back back;
    GreenfootSound sound;
    public Nivel2()
    {    
        super(723, 408, 1);
        fuerza = 0;
        masa=(rand.nextInt(9)+1)*10;
        m = new Muro();
        s1 = new Suelo();
        s2 = new Suelo();
        robot = new Robot();
        motor = new Motor();
        e1 = new Engranaje1();
        e2 = new Engranaje2();
        polea = new Polea();
        cuerda = new Cuerda();
        plataforma = new Plataforma();
        back = new Back();
        sound=new GreenfootSound("soundNivel2.mp3"); 
        //coordenadas
        showText(" Max 1000 N",140,74);
        showText(" = "+(masa*2/5),105,116);
        showText(" = "+(masa*3/5),105,162);
        addObject(m,518, 305);
        addObject(s1,625, 202);
        addObject(s2,650, 202);
        addObject(motor,319, 149);
        addObject(e1,308, 146);
        addObject(e2,336, 136);
        addObject(cuerda,465, 300);
        addObject(plataforma,465, 398);
        addObject(polea,411, 98);
        addObject(robot,93, 359);
        addObject(back,20, 20);
    }
    public void act(){ 
        sonido();
        clickBack();
        clickMotor();
        moverPlataforma();
        siguienteNivel();
    }
    public void sonido(){
        if(sound.isPlaying()==false){
            sound.playLoop();
        }
    }
    public void clickMotor(){               
        if(Greenfoot.mouseClicked(motor)&&fuerza<1050){
            fuerza = fuerza + 50;      
        }
        if(fuerza==1050){
            fuerza = 0;
        }
        if(fuerza==0){
            showText("0"+fuerza+"N",317,173);
        }    
        else{
            showText(fuerza+"N",317,173);
        }
    }
    public void clickBack(){
        if(Greenfoot.mouseClicked(back)){
            Greenfoot.setWorld(new Menú());
            sound.stop();
        }
    }
    public void controlPlataforma(){
        if((Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w"))&&plataforma.getY()>206){
             int a = plataforma.getY();
             int b = cuerda.getY();
             a--; 
             b--;
             plataforma.setLocation( plataforma.getX(),a);
             cuerda.setLocation( cuerda.getX(),b);            
             e1.girar();
             e2.girar();
             if(robot.getIntersecPlataforma()==true&&plataforma.getY()<robot.getY()+38){
                 robot.setLocation(robot.getX(),(robot.getY()-1));
             }
        }
        if((Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s"))&&plataforma.getY()<398){
             int a = plataforma.getY();
             int b = cuerda.getY();
             a++; 
             b++;
             plataforma.setLocation( plataforma.getX(),a);
             cuerda.setLocation( cuerda.getX(),b);
             e1.girar();
             e2.girar();
        }
    }
    public void moverPlataforma(){
        if((fuerza>0&&robot.getIntersecPlataforma()==false)||(fuerza>masa*10&&robot.getIntersecPlataforma()==true)){
            controlPlataforma();
        }
        if(fuerza<masa*10&&robot.getIntersecPlataforma()==true&&plataforma.getY()<398){
            plataforma.setLocation( plataforma.getX(),(plataforma.getY()+3));
            cuerda.setLocation( cuerda.getX(),(cuerda.getY()+3));
            e1.girar();
            e2.girar();
        }
    }
    public void siguienteNivel(){
        if(robot.getX()>660&&robot.getY()<170){
            sound.stop();
            Greenfoot.setWorld(new Nivel3());
        }    
    }
}
