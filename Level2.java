import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level2 extends Omgeving
{

    /**
     * Constructor for objects of class level2.
     * 
     */
    public Level2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WorldSizeX, WorldSizeY, PixelSize);
        Actor Player = new Player();
        addObject(Player, WorldSizeX/2, WorldSizeY/2);
    }
}
