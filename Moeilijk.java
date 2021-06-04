import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Moeilijk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Moeilijk extends UI
{
    /**
     * Act - do whatever the Moeilijk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Moeilijk() {
        GreenfootImage image = new GreenfootImage("Moeilijk", 60, Color.WHITE, Color.BLACK);
        setImage(image);
    }
    
    public void act() 
    {
        if (buttonHovered()) {
            if (mouseClicked()) {
                Omgeving.setDifficulty("moeilijk");
                Greenfoot.setWorld(new Level1());
            }
        }
    }    
}
