package practica1;
import java.util.Scanner;

public class cliente {
    
    public static void main(String[] args) {
        int numBicicletas;
        Scanner in;
        
        System.out.println("Elige el número de participantes para la carrera en carretera:");
        
        do { // lee datos de input
            in = new Scanner(System.in);
        } while (!in.hasNextInt()); // e ignoralos mientras no sean un dato de tipo entero
        
        numBicicletas = in.nextInt(); // lee un entero
        
        /* Creacion de las factorias */
        FactoriaCarretera fcarretera = new FactoriaCarretera();
        FactoriaMontana fmontana = new FactoriaMontana();
        
        Carrera carreraC = fcarretera.crearCarrera(numBicicletas); // Uso de la factoria
        carreraC.empezar();
        
        System.out.println("\nElige el número de participantes para la carrera en montana:");
        
        do { // lee datos de input
            in = new Scanner(System.in);
        } while (!in.hasNextInt()); // e ignoralos mientras no sean un dato de tipo entero
        
        numBicicletas = in.nextInt(); // lee un entero

        Carrera carreraM = fmontana.crearCarrera(numBicicletas); // Uso de la factoria
        carreraM.empezar();
    }
    
}