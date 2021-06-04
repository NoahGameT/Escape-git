import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Vaccin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vaccin extends Pickups
{
    
    boolean onPlayer = false;
    
    public Vaccin() {
        super(20, true);
        GreenfootImage img = getImage();
        img.scale(64,64);
    }
    /**
     * Act - do whatever the Vaccin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int x = getX();
        int y = getY();
        bounce(x, y, 20, speed);
        if (onPlayer) {
            setLocation(Omgeving.getPlayer().getX()-20, Omgeving.getPlayer().getY()+20);
        }
    }
    
    public void OnPlayer() {
        onPlayer = true;
        getImage().scale(32,32);
        Greenfoot.setWorld(new Einde());
    }
    
    public boolean getOnPlayer() {
        return onPlayer;
    }
}
