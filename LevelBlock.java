import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Load a new level when the player collides with a level block.
 * 
 * @author Dinand 
 * @version 1
 */
public class LevelBlock extends Actor
{
    private int scaleX = 60;
    private int scaleY = 100;
    
    /**
     * Create a level block.
     */
    public LevelBlock() {
        GreenfootImage image = new GreenfootImage("/level_block.png");
        image.scale(scaleX, scaleY);
        setImage(image);
    }
    
    /**
     * Check if the player has collided with the level block. If so, load a new level, otherwise do nothing.
     */
    public void act() 
    {
        if (checkPlayerCollision()) {
            Player player = Omgeving.getPlayer(); // This call gets the reference to the player.
            // Store the current amount of health and ammo. This eliminates the need to make a deep copy of player in order to make a checkpoint.
            player.setCheckpointHealth(player.healthBar.getValue());
            player.setCheckpointAmmo(player.ammoBar.getValue());
            // Load a new world.
            World currentWorld = getWorld();
            if (currentWorld instanceof Level1) {
                Greenfoot.setWorld(new Level2());
            } else if (currentWorld instanceof Level2) {
                Greenfoot.setWorld(new PreLevel3());
            } else if (currentWorld instanceof PreLevel3) {
                Greenfoot.setWorld(new Level3());
            } else if (currentWorld instanceof Level3) {
                Greenfoot.setWorld(new Level4());
            }
        }
    }
    
    /**
     * Check if the player has collided with the level block.
     */
    private boolean checkPlayerCollision() {
        Actor actor = getOneIntersectingObject(Player.class);
        if (actor != null) {
            return true;
        } else {
            return false;
        }
    }
}
