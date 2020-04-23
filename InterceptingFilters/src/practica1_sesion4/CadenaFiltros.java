/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_sesion4;

import java.util.ArrayList;

/**
 *
 * @author mumo
 */
public class CadenaFiltros {
    
    ArrayList<Filtro> filtros;

    public CadenaFiltros() {
        filtros = new ArrayList<>();
    }
    
    public void addFiltro(Filtro f){
        filtros.add(f);
    }
    
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        for (int i=0; i<filtros.size(); i++){
            revoluciones = filtros.get(i).ejecutar(revoluciones, estadoMotor);
        }
        
        return revoluciones;
    }
}
