import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Make an object that makes a text box appear when the player has collided with the object (information block).
 * 
 * @author Dinand 
 * @version 1
 */
public class InformationBlock extends Actor
{
    private Text textBox;
    private String text;
    
    public InformationBlock(String _text) {
        text = _text;
        // Make the information block look like a question mark.
        GreenfootImage inner = new GreenfootImage("?", 45, Color.ORANGE, new Color(0, 0, 0, 0));
        setImage(inner);
    }
    
    /**
     * Make a text box appear when the player collides with the information block.
     */
    public void act() 
    {
        // Make the text box appear and the information block disappear if the player has collided with the information block.
        if (checkPlayerCollision()) {
            // Only create a new text box if there hasn't been made one already.
            if (textBox == null) {
                makeTextBox();
                getImage().setTransparency(0);
            } else {
                // Make the text box fully visible and hide the information block.
                textBox.getImage().setTransparency(255);
                getImage().setTransparency(0);
            }
        } else {
            // Hide the text box if a text box has already been made and if the player has stopped colliding with the information block.
            if (textBox != null) textBox.getImage().setTransparency(0);
            getImage().setTransparency(255); // Make the information block fully visible.
        }
    }
    
    /**
     * Check if the player has collided with the information block.
     */
    private boolean checkPlayerCollision() {
        Actor player = getOneIntersectingObject(Player.class);
        if (player != null) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Make the text box appear in the middle on the bottom of the screen.
     */
    private void makeTextBox() {
        textBox = new Text(text, 28, Color.WHITE, null);
        int x = getWorld().getWidth() / 2;
        int y = 4*(getWorld().getHeight()/5);
        getWorld().addObject(textBox, x, y);
    }
}
