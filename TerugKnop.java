import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TerugKnop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TerugKnop extends UI
{
    /**
     * Act - do whatever the TerugKnop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (buttonHovered()) {
            if (mouseClicked()) {
                Greenfoot.setWorld(new HomeScreen());
            }
        }
    }    
}
