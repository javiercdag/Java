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
public class RepercutirRozamiento implements Filtro{
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        
        if (revoluciones - ROZAMIENTO >= 0)
            revoluciones -= ROZAMIENTO;
        
        return revoluciones;
    }
}
