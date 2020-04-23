package practica1;
import java.util.*;

public abstract class Carrera {
    
        protected int numBicicletas;
        protected ArrayList<Bicicleta> bicicletas; // participantes de la carrera
        
        Carrera() {
            bicicletas = new ArrayList<>();
        }
        
        public void empezar() {
            
            System.out.println("Comienza la carrera");
            
            for (int i = 0; i < bicicletas.size(); i++) {
                bicicletas.get(i).start(); // da el pistoletazo de salida para la bicicleta i
            }
            
            /* Si hay algún participante corriendo, la carrera les espera */
            if (bicicletas.size() > 0) {
                
                try {
                    Thread.sleep(61000); // el thread principal también duerme para esperar a que se complete la carrera
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
        
}