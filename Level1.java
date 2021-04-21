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
        super(WorldSizeX, WorldSizeY, PixelSize);
        Actor Player = new Player();
        Actor Politie = new Politie(400, 200, 600, 600, 1);
        MuurPlaatsingen();
        
        addObject(Politie, 400, 200);
        addObject(Player, WorldSizeX/4, WorldSizeY/4);
    }
    
    private void MuurPlaatsingen() {
        Actor LangeCellMuur = new Muur(20, WorldSizeY, Color.RED);
        Actor gayMuur = new Muur(20, 60, Color.RED);
        addObject(LangeCellMuur, WorldSizeX/6, WorldSizeY/2);
        addObject(gayMuur, WorldSizeX-400, WorldSizeY/2);
        return;
    }
}
