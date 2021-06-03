import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthPack here.
 * 
 * @author Dinand
 * @version (a version number or a date)
 */
public class HealthPack extends Pickups
{
    /**
     * Increase the player's health if the player collides with a health pack.
     */
    int bounceFactor;
    
    public HealthPack(int _bounceFactor, int _speed, boolean bounce) {
        super(_bounceFactor, bounce);
        bounceFactor = _bounceFactor;
        GreenfootImage image = new GreenfootImage("/pickups/health_pack.png");
        setImage(image);
    }
    
    public void act() 
    {
        int x = getX();
        int y = getY();
        bounce(x, y, bounceFactor, speed);
    }    
}
