import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Make a colored bar.
 * 
 * @author Dinand
 * @version 1
 */
public class Bar extends Actor
{
    private Color color;
    
    /**
     * Initialize the bar object.
     */
    public Bar(int width, int height, Color _color) {
        color = _color;
        GreenfootImage bar = new GreenfootImage(width, height);
        bar.setColor(color);
        bar.fill();
        setImage(bar);
    }   
}
