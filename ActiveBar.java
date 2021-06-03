import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Make a responsive bar to represent a certain amount of something and use the class 'Bar' as a foundation.
 * 
 * @author Dinand 
 * @version 1
 */
public class ActiveBar extends Bar
{
    private int value;
    private Color color;
    private String type;
    private int width;
    
    /**
     * Initialize the activeBar object.
     */
    public ActiveBar(int _width, int height, Color _color, String _type) {
        super(_width, height, _color);
        width = _width;
        value = _width;
        color = _color;
        type = _type;
        // Hide the bar if its type is 'ammo'.
        if (type == "ammo") changeValue(-value);
    }
    
    /**
     * Change the value.
     * Stop the game if the player has died, otherwise change the length of the bar.
     */
    public void changeValue(int delta) {
        value += delta;
        if (value <= 0) {
            getImage().setTransparency(0); // Hide the image.
            // Load the level again if the player has died.
            if (type == "health") {
                Player player = Omgeving.getPlayer(); // Get the reference to the player.
                player.healthBar.setValue(player.checkpointHealth);
                player.ammoBar.setValue(player.checkpointAmmo);
                if (player.checkpointAmmo <= 0) player.ammoBar.getImage().setTransparency(0);
                player.setGameOver(true);
                System.out.println(player.getGameOver());
                Greenfoot.setWorld(new DoodScherm(2));
            }
        } else {
            int newX = getX() + delta/2;
            setLocation(newX, getY());
            changeBar();
        }
    }
    
    /**
     * Change the length of the bar.
     */
    public void changeBar() {
        GreenfootImage image = new GreenfootImage(value, 20);
        image.setColor(color);
        image.fill();
        setImage(image);
    }
    
    /**
     * Make the value available.
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Change the value and change the bar accoringly.
     */
    public void setValue(int newValue) {
        value = newValue; // Change the value.
        if (value > 0) changeBar(); // Change the bar.
    }
    
    /**
     * Make the width available.
     */
    public int getWidth() {
        return width;
    }
}
