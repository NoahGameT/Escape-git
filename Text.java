import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Text(String text, int fontsize, Color color, Color bgColor) {
        GreenfootImage image = new GreenfootImage(text, fontsize, color, bgColor);
        setImage(image);
    }   
}
