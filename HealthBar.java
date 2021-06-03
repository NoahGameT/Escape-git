import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HealthBar here.
 * 
 * @author Dinand 
 * @version 1
 */
public class HealthBar extends Actor
{
    private Color healthColor = Color.RED;
    private int health;
    
    /**
     * Create the initial health bar.
     */
    public HealthBar() {
        // Initialize the value for "health".
        health = 380;
        // Draw the health bar in red.
        changeBar();
    }
    
    /**
     * Keep track of the player's health.
     */
    public void act() 
    {
         
    }
    
    /**
     * Return the current value of health.
     */
    public int getHealth() {
        return health;
    }
    
    /**
     * Change the health.
     */
    public void changeHealth(int delta) {
        health += delta;
        if (health <= 0) {
            Omgeving.getPlayer().setGameOver(true);
        }
        else {
            int newX = getX() + delta/2;
            setLocation(newX, getY());
            changeBar();
        }
    }
    
    /**
     * Change the length of the health bar.
     */
    public void changeBar() {
        GreenfootImage healthImg = new GreenfootImage(health, 20);
        healthImg.setColor(healthColor);
        healthImg.fill();
        setImage(healthImg);
    }
}
