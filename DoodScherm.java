import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoodScherm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoodScherm extends Omgeving
{

    /**
     * Constructor for objects of class DoodScherm.
     * 
     */
    
    private int nextLvl;
    
    public DoodScherm(int _nextLvl)
    {
        super(WorldSizeX, WorldSizeY, PixelSize);
        nextLvl = _nextLvl;
        RestartKnop reset = new RestartKnop(_nextLvl);
        addObject(reset, 600, 400);
    }
    
}
