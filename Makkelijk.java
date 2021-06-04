import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Makkelijk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Makkelijk extends UI
{
    /**
     * Act - do whatever the Makkelijk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Makkelijk() {
        GreenfootImage image = new GreenfootImage("Makkelijk", 60, Color.WHITE, Color.BLACK);
        setImage(image);
    }
    
    public void act() 
    {
        if (buttonHovered()) {
            if (mouseClicked()) {
                Greenfoot.setWorld(new Level1());
            }
        }
    }   
}
