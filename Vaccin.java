import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vaccin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vaccin extends Pickups
{
    
    public Vaccin() {
        super(20, true);
    }
    /**
     * Act - do whatever the Vaccin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x = getX();
        int y = getY();
        bounce(x, y, 20, speed);
    }    
}
