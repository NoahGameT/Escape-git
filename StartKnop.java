import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartKnop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartKnop extends UI
{
    /**
     * Act - do whatever the StartKnop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    boolean isHovered = false;
    int width = getImage().getWidth();
    int height = getImage().getHeight();
    
    public void act() 
    {
        if (buttonHovered() && !isHovered) {
            isHovered = true;
            getImage().scale(width + 20, height + 20);
        } else {
            getImage().scale(width, height);
            isHovered = false;
        }
    }    
}
