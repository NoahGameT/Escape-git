import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ammo here.
 * 
 * @author Dinand 
 * @version (a version number or a date)
 */
public class Ammo extends Pickups
{
    
    private int bounceFactor;
    private int value = 5; 
    
    /**
     * Increase the player's ammo when the player collides with ammo.
     */
    public Ammo(int _bounceFactor, int _speed, boolean bounce) {
        super(_bounceFactor, bounce);
        bounceFactor = _bounceFactor;
        GreenfootImage image = new GreenfootImage("/pickups/ammo.png");
        setImage(image);
    }
    
    public void act() 
    {
        int x = getX();
        int y = getY();
        bounce(x, y, bounceFactor, speed);
    }
    
    /**
     * Return the value of 'value'.
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Set a new value for 'value'.
     */
    public void setValue(int delta) {
        value -= delta;
    }
}
