import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pickups here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pickups extends Actor
{
    /**
     * Act - do whatever the Pickups wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean bounce = false;
    private boolean bounceComplete = false;
    
    private int beginX;
    private int beginY; 
    private int bounceFactor;
    private int y;
    
    int speed = 4; // Snelheid bouncen
    int timerNumber = 0;
    
    boolean begin = true;
    
    public Pickups(int _bounceFactor, boolean _bounce) {
        bounceFactor = _bounceFactor;
        bounce = _bounce;
    }
    
    public void start() {
        beginX = getX();
        beginY = getY();
        setLocation(1000, 500);
    }
    
    
    public void act() 
    {
        if (begin) {
            start();
            begin = false;
        }
        
        
        
        if (timerNumber == speed) {
            if (bounce) {
                if (!bounceComplete) {
                    
                    int y = getY() - 1;
                    if (y < beginY - bounceFactor) {
                        bounceComplete = true;
                    }
                } else {
                    int y = getY() + 1;
                    if (y > beginY + bounceFactor) {
                        bounceComplete = false;
                    }
                }
            }
            setLocation(getX(), y);
            timerNumber = 0;
        }
        timerNumber++;
    }
    
    public void bounce(int _x, int _y, int bounceFactor, int speed) {
        if (begin) {
            beginY = _y;
            begin = false;
        }
        
        
        if (timerNumber == speed) {
            if (!bounceComplete) {
                
                y = getY() - 1;
                System.out.println(getY() + " "+ y);
                if (y < beginY - bounceFactor) {
                    bounceComplete = true;
                }
            } else {
                y = getY() + 1;
                if (y > beginY + bounceFactor) {
                    bounceComplete = false;
                }
            }
            
            setLocation(getX(), y);
            timerNumber = 0;
        }
        
        timerNumber++;
    }
}
