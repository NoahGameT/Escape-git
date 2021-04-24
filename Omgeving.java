import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Omgeving here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Omgeving extends World
{

    /**
     * Constructor for objects of class Omgeving.
     * 
     */
    public static int speed = 60;
    
    
    
    public Omgeving(int WSX, int WSY, int PS)
    {   
        super(WSX, WSY, PS);
        Greenfoot.setSpeed(speed);
    }
    
    public static int WorldSizeX = 1200;
    public static int WorldSizeY = 800;
    public static int PixelSize = 1;
    public static int ActorSizeX = 75;
    public static int ActorSizeY = 120;
    
    
    
    
}
