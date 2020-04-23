/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1_sesion4;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mumo
 */
public class PanelBotones extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form PanelBotones
     */
    Cliente cliente;
    EstadoMotor estadoActual;
    
    public PanelBotones() {
        initComponents();
        botonAcelerar.setText("ACELERAR");
        botonFrenar.setText("FRENAR");
        botonEncender.setText("ENCENDER");
        estado.setText("APAGADO");
        estadoActual = EstadoMotor.APAGADO;
        
        Thread t1 = new Thread(this);
        t1.start();
    }
    
    void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    @Override
    public void run(){
        while (true){
            if (botonEncender.isSelected()){
                botonEncender.setForeground(Color.red);
                estadoActual = EstadoMotor.ENCENDIDO;
                estado.setText("ENCENDIDO");
                botonEncender.setText("APAGAR");
                botonAcelerar.setText("ACELERAR");
                botonFrenar.setText("FRENAR");
                botonAcelerar.setForeground(Color.black);
                botonFrenar.setForeground(Color.black);
                
                if (botonAcelerar.isSelected()){
                    botonAcelerar.setForeground(Color.red);
                    estadoActual = EstadoMotor.ACELERANDO;
                    estado.setText("ACELERANDO");
                    botonAcelerar.setText("Soltar acelerador");
                    
                    
                    botonFrenar.setSelected(false);
                }
                else if  (botonFrenar.isSelected()){
                    botonFrenar.setForeground(Color.red);
                    estadoActual = EstadoMotor.FRENANDO;
                    estado.setText("FRENANDO");
                    botonFrenar.setText("Soltar freno");
                    botonAcelerar.setSelected(false);
                }
            }else{
                botonEncender.setForeground(Color.green);
                botonAcelerar.setForeground(Color.black);
                botonFrenar.setForeground(Color.black);
                estadoActual = EstadoMotor.APAGADO;
                estado.setText("APAGADO");
                botonEncender.setText("ENCENDER");
                botonAcelerar.setText("ACELERAR");
                botonFrenar.setText("FRENAR");
                botonAcelerar.setSelected(false);
                botonFrenar.setSelected(false);
            }
            if (cliente != null)
                this.cliente.ejecutar(estadoActual);
            
            this.repaint();
            this.revalidate();
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(PanelBotones.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonAcelerar = new javax.swing.JToggleButton();
        botonEncender = new javax.swing.JToggleButton();
        botonFrenar = new javax.swing.JToggleButton();
        estado = new javax.swing.JLabel();

        botonAcelerar.setText("jToggleButton1");

        botonEncender.setText("jToggleButton2");
        botonEncender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEncenderActionPerformed(evt);
            }
        });

        botonFrenar.setText("jToggleButton3");

        estado.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonEncender)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonAcelerar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonFrenar))
                    .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonEncender)
                    .addComponent(botonAcelerar)
                    .addComponent(botonFrenar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonEncenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEncenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEncenderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonAcelerar;
    private javax.swing.JToggleButton botonEncender;
    private javax.swing.JToggleButton botonFrenar;
    private javax.swing.JLabel estado;
    // End of variables declaration//GEN-END:variables
}
