import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author Dinand
 * @version 1
 */
public class Bullet extends ExtraFuncties
{
    /**
     * Generate a bullet and fire it in the right direction.
     */
    
    private char bulletDirection;
    private int bulletDimensionX;
    private int bulletDimensionY;
    private int bulletSpeed = 3;
    private Player player;
    
    public Bullet(Player _player) {
        player = _player;
        makeBullet();
    }
    
    public void act() 
    {
        moveBullet();
        checkCollision();
        if (getWorld() != null) checkAtEdge();
    }
    
    /**
     * Create a bullet and set its image in accordance with the direction in which it moves.
     */
    private void makeBullet() {
        bulletDirection = player.getPlayerDirection();
        if (bulletDirection == 'u') {
            setImage(new GreenfootImage("/bullets/bullet_1_up.png"));
        } else if (bulletDirection == 'd') {
            setImage(new GreenfootImage("/bullets/bullet_1_down.png"));
        } else if (bulletDirection == 'l') {
            setImage(new GreenfootImage("/bullets/bullet_1_left.png"));
        } else if (bulletDirection == 'r') {
            setImage(new GreenfootImage("/bullets/bullet_1_right.png"));
        }
        bulletDimensionX = getImage().getWidth();
        bulletDimensionY = getImage().getHeight();
        Greenfoot.playSound("gun_firing.mp3");
    }
    
    private void removeBullet() {
        player.bulletCounter--;
        getWorld().removeObject(this);
    }
    
    /**
     * Verwijder kogel als hij het scherm verlaat.
     */
    private void checkAtEdge() {
        
        if (getX() <= 0 || getX() >= Omgeving.WorldSizeX-1) {
            removeBullet();
        } else if (getY() <= 0 || getY() >= Omgeving.WorldSizeY-1) { 
            removeBullet();
        }
    }
    
    public boolean Collision(java.lang.Class collider) {
        for (Object obj : getIntersectingObjects(collider))
        {
            Actor actor = (Actor) obj;
            if(actor != null) {
                return true;
            }
            return false;
        }
        return false;
    }
    
    public Actor getActorAfterCollision(java.lang.Class actor) {
        Actor actorObj = getOneIntersectingObject(actor);
        if (actorObj != null) {
            return actorObj;
        } else {
            return null;
        }
    }
    
    /**
     * Check if the bullet has collided with a object.
     */
    private void checkCollision() {
        if (Collision(Politie.class) || Collision(OnzichtbareMuur.class)) {
            removeBullet();
        }
    }
    
    /**
     * Move the bullet in the direction the player was facing when the bullet was fired.
     */
    private void moveBullet() {
        // Initialize the coordinates.
        int newY = getY();
        int newX = getX();
        if (bulletDirection == 'u') {
            newY -= bulletSpeed;
        } else if (bulletDirection == 'd') {
            newY += bulletSpeed;
        } else if (bulletDirection == 'l') {
            newX -= bulletSpeed;
        } else if (bulletDirection == 'r') {
            newX += bulletSpeed;
        }
        setLocation(newX, newY);
    }
}