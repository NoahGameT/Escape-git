import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.*;
/**
 * Write a description of class Politie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Politie extends ExtraFuncties
{
    private int X1;
    private int Y1;
    private int X2;
    private int Y2;
    private float tijd;
    private int tijdInterval;
    private boolean timerBegonnen = false;
    private boolean aanHetTerugLopen = false;
    
    
    private long startTime = System.currentTimeMillis();
    private double deltaTime;
    private long intervalStart;
    
    private boolean firstRun = true;
    private boolean terugLopen = false;
    public Politie(int x1, int y1, int x2, int y2, float duration, int interval) {     
        X1 = x1;
        Y1 = y1;
        X2 = x2;
        Y2 = y2;
        tijd = duration;
        tijdInterval = interval;
        setLocation(X1,Y1);
    }
    
    /**
     * Act - do whatever the Politie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        long msSinceLast = System.currentTimeMillis()-startTime;
        startTime = System.currentTimeMillis();
        deltaTime = 1000 / msSinceLast;
        Lopen(X1,Y1,X2,Y2, tijd, tijdInterval);
    }
    
    private void Lopen(int x1, int y1, int x2, int y2, float tijd, int interval) {
        double deltaX = (x2-x1)/(deltaTime * tijd);
        double deltaY = (y2-y1)/(deltaTime * tijd);
        if(firstRun) {
           deltaX = 0.001;
           deltaY = 0.001;
           firstRun = false;
        }
        double x = getExactX();
        double y = getExactY();
        
        if(terugLopen) {
            
            if ((System.currentTimeMillis() - intervalStart) >= interval * 1000 || aanHetTerugLopen) {
                System.out.println(intervalStart - System.currentTimeMillis());
                x = getExactX() - deltaX;
                y = getExactY() - deltaY;
                aanHetTerugLopen = true;
            }
        } else {
            x = getExactX() + deltaX;
            y = getExactY() + deltaY;
            aanHetTerugLopen = false;
            timerBegonnen = false;
        }
        
        if(getExactX()-1000 >= x2 || getExactY() >= y2) {
            terugLopen = true;
            generateIntervalTimer();
        } else if(getExactX() <= x1 || getExactY() <= y1) {
            terugLopen = false;
        }
        System.out.println(terugLopen);
        setLocation(x, y);
    }
    
    private void generateIntervalTimer() {
        if (!timerBegonnen) {
            intervalStart = System.currentTimeMillis();
            timerBegonnen = true;
        }
    }
}













