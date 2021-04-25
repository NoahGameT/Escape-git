import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zaklamp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zaklamp extends Actor
{
    int[] posPlayer;
    public Actor player;
    public Zaklamp(Actor _player) {
        player = _player;   
    }
    
    public void act() 
    {
        //turnAround();
        GreenfootImage image = getImage();
        image.scale(Omgeving.WorldSizeX*5, Omgeving.WorldSizeY*5);
        setLocation(player.getX(), player.getY());
    }
    public void turnAround()
    {
        if(Greenfoot.getMouseInfo() != null)
        turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
    }
}
