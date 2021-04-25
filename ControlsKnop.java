import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ControlsKnop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ControlsKnop extends UI
{
    /**
     * Act - do whatever the ControlsKnop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    
    public void act() 
    {
        if (buttonHovered()) {
            if (mouseClicked()) {
                Greenfoot.setWorld(new ControlsMenu());
            }
        }
    }     
}
