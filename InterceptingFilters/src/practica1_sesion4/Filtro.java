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
public interface Filtro {
    static final double VELOCIDADMAX = 5000;
    static final double INCREMENTOVEL = 100;
    static final double ROZAMIENTO = 25;
    
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor);
    
}
