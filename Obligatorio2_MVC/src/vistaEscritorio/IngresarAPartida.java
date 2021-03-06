/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaEscritorio;

import controlador.ControladorJugarAlPoker;
import controlador.VistaJugarAlPoker;
import javax.swing.JOptionPane;
import modelo.Sesion;
import observador.Observable;
import observador.Observador;
import modelo.Jugador;
import modelo.Partida;
import modelo.PartidaException;
import modelo.Sistema;
import modelo.SistemaPartidas;
/**
 *
 * @author mariafernandafulco
 */
public class IngresarAPartida extends javax.swing.JFrame implements VistaJugarAlPoker  {
    
    private Jugador jugador;
    private Sesion sesion;
    private Sistema sistema;
    private ControladorJugarAlPoker controladorJugarPoker;


    public IngresarAPartida(java.awt.Frame parent, boolean modal,Sesion s) throws PartidaException {
//         super(parent, modal);
        try {
             initComponents();
        setLocationRelativeTo(null);
        sesion = s;
        sistema = Sistema.getInstancia();
        sistema.getSistemaPartidas().AsignarJugadorAPartida(sesion);
        controladorJugarPoker = new ControladorJugarAlPoker(s.getParticipacion().getPartida(), this, s);
        
        
        //jugador = sesion.getParticipacion().getJugador();
        //SistemaPartidas.ingresarJugadorAUnaPartida(jugador);
//        jugador.agreagar(this);
//        jugador.getAgenda().agregar(this);
        mostrarTitulo();
        actualizar(parent, sistema);
        //mostrarJugadoresFaltantes(s.getParticipacion().getPartida().falta());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Alert", JOptionPane.ERROR_MESSAGE);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 51));
        jLabel2.setText("ESPERANDO INICIO DE JUEGO...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    
    public void actualizar(Object evento, Observable origen) {
        controladorJugarPoker.contadorFaltantes();
    
    }

  private void mostrarTitulo() {
        setTitle("Jugador: "+sesion.getJugador().getNombreCompleto());// + " - " + 
        
//                 jugador.getAgenda().cantidadContactos() + " contacto(s)");
    }

    @Override
    public void mostrarPartida(int valor) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void terminar() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void error(String msg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mostrarJugadoresFaltantes(int faltan) {
        jLabel1.setText("Faltan: "+faltan+" jugadores para la partida n??: "+sistema.getSistemaPartidas().listaDePartidas.size());
    }

    @Override
    public void iniciar(Partida modelo) {
        this.setVisible(false);
        new InicioPartida(modelo,sesion,controladorJugarPoker).setVisible(true);
       
    }
}
