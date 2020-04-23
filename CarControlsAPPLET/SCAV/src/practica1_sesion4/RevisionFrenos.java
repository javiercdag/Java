/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_sesion4;

public class RevisionFrenos implements FiltroRevision {
    
    double cambioFrenos;
    double revolucionesTotales = 0;
    double revolucionesHastaCambio = 0;
    static final double totalFrenos = 6000;
    
    RevisionFrenos(){
        cambioFrenos = totalFrenos;
    }
    
    @Override
    public void ejecutar(double revoluciones) {
        double revolucionesSegundo = (revoluciones /60) /2;
        
        if (cambioFrenos - revolucionesSegundo < 0){
            cambioFrenos = 0;
        }else{
            cambioFrenos -= revolucionesSegundo;
        }
        revolucionesHastaCambio -= revolucionesSegundo;
    }
    
    @Override
    public void hacerRevision(double revoluciones, EstadoMotor estadoMotor) {
        if (revoluciones == 0 && estadoMotor == EstadoMotor.APAGADO){
            revolucionesTotales += -revolucionesHastaCambio;
            revolucionesHastaCambio = 0;
            cambioFrenos = totalFrenos;
        }
    }

    @Override
    public double getRevolucionesTotales() {
        return revolucionesTotales;
    }

    @Override
    public double getPorcentajeRevision() {
        return ((cambioFrenos*100)/totalFrenos);
    }
    
}
