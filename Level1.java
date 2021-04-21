import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends Omgeving
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WorldSizeX, WorldSizeY, PixelSize);
        Actor Player = new Player();
        MuurPlaatsingen();
        addObject(Player, WorldSizeX/4, WorldSizeY/4);
    }
    
    
    private void MuurPlaatsingen() {
        Actor LangeCellMuur = new Muur(20, WorldSizeY, Color.RED);
        addObject(LangeCellMuur, WorldSizeX/6, WorldSizeY/2);
        return;
    }
}
