import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class Level4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level4 extends Omgeving
{

    /**
     * Constructor for objects of class Level4.
     * 
     */
    public Level4()
    {
        super(WorldSizeX, WorldSizeY, PixelSize);
    }
    
    public void act() {
        if (getPlayer().getGameOver()) {
            List objects = getObjects(null);
            if (objects != null) { removeObjects(objects); }
        }
    }
}
