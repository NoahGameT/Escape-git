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
    float ratio = height/width;
    
    int actCount = 0;
    
    public void act() 
    {
        if (buttonHovered()) {
            if (mouseClicked()) {
                Greenfoot.setWorld(new Difficulty());
            }
        } else {
            getImage().scale(width, height);
            isHovered = false;
        }
        actCount++;
    }    
}
