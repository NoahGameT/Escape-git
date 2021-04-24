import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gun extends Pickups
{
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int bounceFactor;
    
    public Gun(int _bounceFactor, boolean bounce, GunType _type) {
        super(_bounceFactor,bounce);
        bounceFactor = _bounceFactor;
    }
    
    public void act() 
    {
        int x = getX();
        int y = getY();
        bounce(x, y, bounceFactor, 15);
        
    }    
}
