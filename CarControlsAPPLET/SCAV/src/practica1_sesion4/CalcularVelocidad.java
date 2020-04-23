/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_sesion4;

public class CalcularVelocidad implements Filtro {
    
    public double revolucionesMantenidas = 0;
    public boolean guardarRevoluciones = true;
    public boolean reiniciar = false;
    
    
    public double ejecutar(double revoluciones, EstadoMotor estadoMotor){
        if (estadoMotor == EstadoMotor.ACELERANDO){
            if (revoluciones + INCREMENTOVEL <= VELOCIDADMAX)
                revoluciones += INCREMENTOVEL;
        }
        else if (estadoMotor == EstadoMotor.FRENANDO){
            if (revoluciones - INCREMENTOVEL >= 0)
                revoluciones -= INCREMENTOVEL;
        } else if (estadoMotor == EstadoMotor.REINICIANDO){
            reiniciar = true;
        }
        
        if (estadoMotor == EstadoMotor.MANTENIENDO || estadoMotor == EstadoMotor.REINICIANDO){
            if (guardarRevoluciones && !reiniciar){
                revolucionesMantenidas = revoluciones;
                guardarRevoluciones = false;
            }
            
            if (revoluciones + INCREMENTOVEL <= revolucionesMantenidas){
                revoluciones += INCREMENTOVEL;
            }
            
        }else{
            guardarRevoluciones = true;
            reiniciar = false;
        }
        
        return revoluciones;
    }
    
    double getRevolucionesMantenidas(){
        return revolucionesMantenidas;
    }
}
