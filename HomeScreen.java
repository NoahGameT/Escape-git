import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HomeScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HomeScreen extends Omgeving
{

    /**
     * Constructor for objects of class HomeScreen.
     * 
     */
    public HomeScreen()
    {
        super(WorldSizeX, WorldSizeY, PixelSize);
        
        StartKnop startKnop = new StartKnop();
        addObject(startKnop, 275, 490);
        ControlsKnop controlKnop = new ControlsKnop();
        addObject(controlKnop, 275, 590);
        
    }
    
    
    
    
}
