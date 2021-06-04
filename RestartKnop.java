import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RestarKnop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class RestartKnop extends UI
{
    /**
     * Act - do whatever the RestarKnop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int nextLvlIndex;
    public RestartKnop(int _nextLvlIndex) {
        if (_nextLvlIndex == 0) _nextLvlIndex++;
        nextLvlIndex = _nextLvlIndex;
    }
    
    public void act() 
    {
        if (buttonHovered()) {
            if (mouseClicked()) {
                Greenfoot.setWorld(Omgeving.getLevel(nextLvlIndex-1));
            }
        }
    }    
}
