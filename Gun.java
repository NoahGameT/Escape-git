import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gun extends Pickups
{
    /**
     * Act - do whatever the Gun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int bounceFactor;
    int speed;
    public boolean gunPickedUp = false;
    
    public Gun(int _bounceFactor, int _speed, boolean bounce, GunType _type) {
        super(_bounceFactor,bounce);
        bounceFactor = _bounceFactor;
        speed = _speed;
    }
    
    public void act() 
    {
        int x = getX();
        int y = getY();
        bounce(x, y, bounceFactor, speed);
        if (Collision(Player.class)) {
            Player player = (Player)getActorAfterCollision(Player.class);
            if (player != null) {
                player.setPlayerState(PlayerState.Gevangenen_pistool);
                player.setGunState(true);
            }
            getWorld().removeObject(this);
        }
    }    
}
