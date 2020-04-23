/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_sesion4;

public interface FiltroRevision {
    public void ejecutar(double revoluciones);
    public void hacerRevision(double revoluciones, EstadoMotor estadoMotor);
    public double getRevolucionesTotales(); //Devuelve las revoluciones totales tras hacer la revisión
    public double getPorcentajeRevision();
}
