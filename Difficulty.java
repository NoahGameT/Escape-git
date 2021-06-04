import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Difficulty here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Difficulty extends Omgeving
{

    /**
     * Constructor for objects of class Difficulty.
     * 
     */
    public Difficulty()
    {
        super(WorldSizeX, WorldSizeY, PixelSize);
        
        GreenfootImage bg = new GreenfootImage("/HomeScreen.png");
        setBackground(bg);
        addObject(new Moeilijk(), 900, 500);
        addObject(new Makkelijk(), 300, 500);
    }
}
