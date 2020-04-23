/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_sesion3;

import java.util.ArrayList;

/*
 *
 * @author mumo
 */
public class Cliente {
    public static void main(String[] args) {
        Float tespania = new Float(30.0);        
        Float tsuecia = new Float(20.0);
        Float titalia = new Float(10.0);

        
        ArrayList<Temperatura> temp= new ArrayList<>();
        
        temp.add(new Temperatura(tespania,"España"));
        temp.add(new Temperatura(tsuecia,"Suecia"));
        temp.add(new Temperatura(titalia,"Italia"));
        
        ArrayList<pantallaTemperatura> p= new ArrayList<>();
        ArrayList<graficaTemperatura> g= new ArrayList<>();
        ArrayList<botonCambio> b= new ArrayList<>();
        
        p.add(new pantallaTemperatura(temp.get(0),temp.get(0).getName()));
        p.add(new pantallaTemperatura(temp.get(1),temp.get(1).getName()));
        p.add(new pantallaTemperatura(temp.get(2),temp.get(2).getName()));
        
        g.add(new graficaTemperatura(temp.get(0),temp.get(0).getName()));
        g.add(new graficaTemperatura(temp.get(1),temp.get(1).getName()));
        g.add(new graficaTemperatura(temp.get(2),temp.get(2).getName()));
        
        b.add(new botonCambio(temp.get(0),temp.get(0).getName()));
        b.add(new botonCambio(temp.get(1),temp.get(1).getName()));
        b.add(new botonCambio(temp.get(2),temp.get(2).getName()));
        
        TiempoSatelital t = new TiempoSatelital(p,g,b);
        
        
        for (int i=0; i< temp.size(); i++){
            temp.get(i).addObserver(t);
            temp.get(i).addObserver(p.get(i));
            temp.get(i).addObserver(g.get(i));
            temp.get(i).addObserver(b.get(i));
        }
        
        Thread t1 = new Thread(temp.get(0));
        Thread t2 = new Thread(temp.get(1));
        Thread t3 = new Thread(temp.get(2));
        
        t1.start();
        t2.start();
        t3.start();

        t.setVisible(true);

        
        
        
    }
}
