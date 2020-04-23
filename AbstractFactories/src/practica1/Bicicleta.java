package practica1;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

public abstract class Bicicleta extends Thread{

    int idBicicleta;
    boolean retirarse; //true si la bicicleta se retirará tempranamente, false en otro caso
    
    @Override
    public void run(){
        Random r = new Random();
        
        System.out.println("(+)Comienza la bicicleta " + idBicicleta);
        
        try {
            sleep(30000); // primera mitad de una carrera, toda bicicleta lo soporta
        } catch (InterruptedException ex) {
            Logger.getLogger(Bicicleta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (retirarse){
            System.out.println("(-)La bicicleta " + idBicicleta + " se retira");
        }
        else{
            try {
                sleep(30000); // segunda mitad de una carrera, solo para las bicicletas que no se retiran
            } catch (InterruptedException ex) {
                Logger.getLogger(Bicicleta.class.getName()).log(Level.SEVERE, null, ex);
            }
             System.out.println("(END)La bicicleta " + idBicicleta + " ha llegado");
        }
    }

}