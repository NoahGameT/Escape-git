import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Make text box appear in the middle of the bottom of the screen when the player stands on an 'information block'.
 * 
 * @author Dinand 
 * @version 2
 */
public class Text extends Actor
{
    /**
     * Create a new text box.
     */
    
    private int fontsize;
    private Color color;
    private Color bgColor;
    
    public Text(String text, int _fontsize, Color _color, Color _bgColor) {
        fontsize = _fontsize;
        color = _color;
        bgColor = _bgColor;
        GreenfootImage image = new GreenfootImage(text, _fontsize, _color, _bgColor);
        setImage(image);
    }
    
    public void ChangeText(String nieuweText) {
        GreenfootImage image = new GreenfootImage(nieuweText, fontsize, color, bgColor);
        setImage(image);
    }
}
