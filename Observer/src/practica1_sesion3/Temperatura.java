/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_sesion3;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author mumo
 */
public class Temperatura extends java.util.Observable implements Runnable{
    
    Random r = new Random();
    public Float temperature;
    public String name;
    
    Temperatura(float f, String name){
        temperature = new Float(f);
        this.name = name;
    }

    @Override
    public void run() {
        while(true){
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Temperatura.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Temperatura (ºC): " + temperature.floatValue() + "\n");
            System.out.println("Temperatura (ºF): " + ((temperature.floatValue()*1.8)+32.0) + "\n");
            this.setChanged();
            this.notifyObservers();
        }
        
    }
    
    public float getTemperatureC(){
        return temperature.floatValue();
    }
    
    public float getTemperatureF(){
        Float f1 = new Float(1.8);
        Float f2 = new Float(32.0);
        return ((temperature.floatValue()*f1)+f2);
    }
    
    public void setTemperature(float t){
        temperature = new Float(t);
    }
    
    public String getName(){
        return name;
    }
    
}
