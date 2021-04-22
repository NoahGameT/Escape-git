import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class OnzichtbareMuur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OnzichtbareMuur extends Actor
{
    /**
     * Act - do whatever the OnzichtbareMuur wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public OnzichtbareMuur(int width, int height) {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setTransparency(0);
        setImage(image);
    }      
}
