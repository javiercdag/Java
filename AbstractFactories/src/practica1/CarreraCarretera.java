package practica1;
import java.util.*;

public class CarreraCarretera extends Carrera {
    
    public CarreraCarretera(ArrayList <BicicletaCarretera> listaBicicletas) {
        
        for (int i = 0; i < listaBicicletas.size(); i++) {
            this.bicicletas.add(listaBicicletas.get(i)); // Uppercasting BicicletaCarretera -> Bicicleta
        }
        
        this.numBicicletas = listaBicicletas.size();
    }
    
}