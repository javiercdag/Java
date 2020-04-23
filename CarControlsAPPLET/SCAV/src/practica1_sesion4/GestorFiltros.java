/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_sesion4;

public class GestorFiltros {
    CadenaFiltros cadenaFiltros;
    double revoluciones;
    double revolucionesMantenidas = 0;
    
    EstadoMotor estadoMotor;
        
    double porcentajeAceite = 100.0;
    double porcentajeFrenos = 100.0;
    double porcentajeGeneral = 100.0;
    
    CalcularVelocidad c;
    RepercutirRozamiento r;
    
    RevisionAceite a;
    RevisionFrenos f;
    RevisionGeneral g;
    
    Salpicadero s;

    public GestorFiltros(Salpicadero s) {
        cadenaFiltros = new CadenaFiltros();
        c = new CalcularVelocidad();
        r = new RepercutirRozamiento();
        
        a = new RevisionAceite();
        f = new RevisionFrenos();
        g = new RevisionGeneral();
        
        this.s = s;
        this.s.enlazar(this);
        //s.setVisible(true);
        
        cadenaFiltros.addFiltro((Filtro)c);
        cadenaFiltros.addFiltro((Filtro)r);
        cadenaFiltros.addFiltroRevision((FiltroRevision)a);
        cadenaFiltros.addFiltroRevision((FiltroRevision)f);
        cadenaFiltros.addFiltroRevision((FiltroRevision)g);

        revoluciones = 0.0;
    }
    
    public boolean ejecutar(EstadoMotor estadoMotor){
        
        double revolucionesAceite = a.getRevolucionesTotales();
        double revolucionesFrenos = f.getRevolucionesTotales();
        double revolucionesGeneral = g.getRevolucionesTotales();
        
        this.revoluciones = cadenaFiltros.ejecutar(this.revoluciones,estadoMotor);
        this.estadoMotor = estadoMotor;
        cadenaFiltros.ejecutar(revoluciones);
        
        revolucionesMantenidas = c.getRevolucionesMantenidas();
        
        porcentajeAceite = a.getPorcentajeRevision();
        porcentajeFrenos = f.getPorcentajeRevision();
        porcentajeGeneral = g.getPorcentajeRevision();
        
        return (s.ejecutar(revoluciones, estadoMotor, revolucionesMantenidas, porcentajeAceite,
                revolucionesAceite, porcentajeFrenos, revolucionesFrenos, porcentajeGeneral, revolucionesGeneral));
    }
    
    public void revisarAceite(){
        a.hacerRevision(revoluciones, estadoMotor);
    }
    
    public void revisarFrenos(){
        f.hacerRevision(revoluciones, estadoMotor);
    }
    
    public void revisarGeneral(){
        g.hacerRevision(revoluciones, estadoMotor);
    }
    
    
    
}
