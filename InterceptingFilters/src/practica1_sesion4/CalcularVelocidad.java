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
public class CalcularVelocidad implements Filtro {
    
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        if (estadoMotor == EstadoMotor.ACELERANDO){
            if (revoluciones + INCREMENTOVEL <= VELOCIDADMAX)
                revoluciones += INCREMENTOVEL;
        }
        else if (estadoMotor == EstadoMotor.FRENANDO){
            if (revoluciones - INCREMENTOVEL >= 0)
                revoluciones -= INCREMENTOVEL;
        }
        
        return revoluciones;
    }
}
