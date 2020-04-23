package practica1;

import java.util.ArrayList;

public class CarreraMontana extends Carrera {
        
    public CarreraMontana(ArrayList <BicicletaMontana> listaBicicletas) {
        
        for (int i = 0; i < listaBicicletas.size(); i++) {
            this.bicicletas.add(listaBicicletas.get(i)); // Uppercasting BibicletaMontana -> Bicicleta
        }
        
        this.numBicicletas = listaBicicletas.size();
    }
    
}