import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Muur extends Actor
{
    public Muur(int width, int height, Color color) {
        generateWall(width, height, color);
    }
    
    private void generateWall(int width, int height, Color color) {
        GreenfootImage image = new GreenfootImage(width, height);
        image.setColor(color);
        image.fill();
        setImage(image);
    }
}
