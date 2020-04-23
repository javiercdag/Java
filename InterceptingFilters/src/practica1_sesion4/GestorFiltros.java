/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_sesion4;

/**
 *
 * @author mumo
 */
public class GestorFiltros {
    CadenaFiltros cadenaFiltros;
    double revoluciones;
    Salpicadero s;

    public GestorFiltros() {
        cadenaFiltros = new CadenaFiltros();
        CalcularVelocidad c = new CalcularVelocidad();
        RepercutirRozamiento r = new RepercutirRozamiento();
        s = new Salpicadero();
        s.setVisible(true);
        
        cadenaFiltros.addFiltro((Filtro)c);
        cadenaFiltros.addFiltro((Filtro)r);
        revoluciones = 0.0;
    }
    
    public void ejecutar(EstadoMotor estadoMotor){
        this.revoluciones = cadenaFiltros.ejecutar(this.revoluciones,estadoMotor);
        s.ejecutar(revoluciones, estadoMotor);
    }
    
    
    
}
