/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import modelo.Sesion;
import observador.Observable;
import observador.Observador;
import modelo.Jugador;
import modelo.Sistema;
import modelo.SistemaPartidas;
/**
 *
 * @author mariafernandafulco
 */
public class IngresarAPartida extends javax.swing.JFrame implements Observador {
    
    private Jugador jugador;
    private Sesion sesion;
    /**
     * Creates new form Partida
     */
//    public IngresarAPartida() {
//        initComponents();
//    }

    public IngresarAPartida(java.awt.Frame parent, boolean modal,Sesion s) {
//         super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        sesion = s;
        jugador = sesion.getParticipacion().getJugador();
        SistemaPartidas.ingresarJugadorAUnaPartida(jugador);
//        jugador.agreagar(this);
//        jugador.getAgenda().agregar(this);
        mostrarTitulo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Hola, soy Partida!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel1)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizar(Object evento, Observable origen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  private void mostrarTitulo() {
        setTitle(jugador.getNombreCompleto());// + " - " + 
//                 jugador.getAgenda().cantidadContactos() + " contacto(s)");
    }
}
