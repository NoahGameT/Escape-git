import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NepMuur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NepMuur extends Actor
{
    /**
     * Act - do whatever the NepMuur wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public NepMuur(int width, int height, Color color) {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(color);
        image.fill();
        setImage(image);
    }  
}
