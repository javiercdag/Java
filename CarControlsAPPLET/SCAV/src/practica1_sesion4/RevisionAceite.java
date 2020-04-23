/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_sesion4;

public class RevisionAceite implements FiltroRevision {
    
    double cambioAceite;
    double revolucionesTotales = 0;
    double revolucionesHastaCambio = 0;
    static final double totalAceite = 4000;
    
    RevisionAceite(){
        cambioAceite = totalAceite;
    }

    @Override
    public void ejecutar(double revoluciones) {
        double revolucionesSegundo = (revoluciones /60) /2;
        
        if (cambioAceite - revolucionesSegundo < 0){
            cambioAceite = 0;
        }else{
            cambioAceite -= revolucionesSegundo;
        }
        revolucionesHastaCambio -= revolucionesSegundo;
    }
    
    @Override
    public void hacerRevision(double revoluciones, EstadoMotor estadoMotor) {
        if (revoluciones == 0 && estadoMotor == EstadoMotor.APAGADO){
            revolucionesTotales += -revolucionesHastaCambio;
            revolucionesHastaCambio = 0;
            cambioAceite = totalAceite;
        }
    }

    @Override
    public double getRevolucionesTotales() {
        return revolucionesTotales;
    }

    @Override
    public double getPorcentajeRevision() {
        return ((cambioAceite*100)/totalAceite);
    }
    
}
