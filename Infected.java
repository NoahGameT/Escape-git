import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Infected here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Infected extends ExtraFuncties
{
    /**
     * Act - do whatever the Infected wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor player = (Actor)getWorld().getObjects(Player.class).get(0); // gets reference to tank
        turnTowards(player.getX(), player.getY()); // turn toward tank
        move(2);
    }    
}
