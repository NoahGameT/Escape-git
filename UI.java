import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class UI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UI extends Actor
{
    /**
     * Act - do whatever the UI wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public boolean buttonHovered() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse !=null) {
            int mouseX = mouse.getX();
            int mouseY = mouse.getY();
            
            if (mouseX < getImage().getWidth()/2 + getX() && mouseX > getX() - getImage().getWidth()/2 && 
            mouseY > getY() - getImage().getHeight()/2 && mouseY < getY() + getImage().getHeight()/2) {
                return true;
                
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean mouseClicked() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse !=null) {
            int button = mouse.getButton();
            if (button == 1 && Greenfoot.mouseClicked(null)) {
                return true;
            }
        } else {
            System.out.println("geen muis");
            return false;
        }
        return false;
    }
}
