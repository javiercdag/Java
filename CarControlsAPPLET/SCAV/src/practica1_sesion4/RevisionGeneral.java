/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_sesion4;

public class RevisionGeneral implements FiltroRevision{
    
    double cambioGeneral;
    double revolucionesTotales = 0;
    double revolucionesHastaCambio = 0;
    static final double totalGeneral = 8000;
    
    RevisionGeneral(){
        cambioGeneral = totalGeneral;
    }
    
    @Override
    public void ejecutar(double revoluciones) {
        double revolucionesSegundo = (revoluciones /60) /2;
        
        if (cambioGeneral - revolucionesSegundo < 0){
            cambioGeneral = 0;
        }else{
            cambioGeneral -= revolucionesSegundo;
        }
        revolucionesHastaCambio -= revolucionesSegundo;
    }
    
    @Override
    public void hacerRevision(double revoluciones, EstadoMotor estadoMotor) {
        if (revoluciones == 0 && estadoMotor == EstadoMotor.APAGADO){
            revolucionesTotales += -revolucionesHastaCambio;
            revolucionesHastaCambio = 0;
            cambioGeneral = totalGeneral;
        }
    }

    @Override
    public double getRevolucionesTotales() {
        return revolucionesTotales;
    }

    @Override
    public double getPorcentajeRevision() {
        return ((cambioGeneral*100)/totalGeneral);
    }
    
}
