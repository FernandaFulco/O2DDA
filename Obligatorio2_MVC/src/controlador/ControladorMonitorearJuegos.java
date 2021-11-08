/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Administrador;
import modelo.Participacion;
import modelo.Partida;
import modelo.Sesion;
import modelo.Sistema;
import modelo.SistemaPartidas;
import modelo.SistemaUsuarios;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author mariafernandafulco
 */
public class ControladorMonitorearJuegos implements Observador {
    
    private VistaMonitorearJuegos vistaMonitorearJuegos;
    private Sistema sistema = Sistema.getInstancia();
    private Administrador administrador;
    private Participacion participacion;
    private Sesion sesion;
    private Partida partida;
    private SistemaUsuarios sistemaUsuarios;
    private SistemaPartidas sistemaPartidas;
    
    public ControladorMonitorearJuegos(VistaMonitorearJuegos vistaMonitorearJuegos, Administrador administrador) {
        this.vistaMonitorearJuegos = vistaMonitorearJuegos;
       /* this.sesion = sesion;
        this.participacion = sesion.getParticipacion();
        this.partida = sesion.getParticipacion().getPartida();
        this.sistemaPartidas = sistema.getSistemaPartidas();
        this.sistemaUsuarios = sistema.getSistemaUsuarios();
        this.administrador = administrador;
        this.partida.agregar(this);*/
        vistaMonitorearJuegos.mostrarNombreUsuario(administrador.getNombreCompleto());
//        mostrarPartidasEnCurso();
    }
    
    //*--¿CUÀLES SON LOS EVENTOS DEL USUARIO EN ESTE CASO DE USO?--*
    //*--SALIR-----------------------------------------------------*
    //*--MOSTRAR DETALLES DE UNA PARTIDA---------------------------*       
    
    public void salir(){
        partida.quitar(this);
        sistema.logout(sesion);
    }
    
    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Sistema.Eventos.cambioListaUsuariosConectados) || 
             evento.equals(Sistema.Eventos.nuevoContactoDeCualquierAgenda)  ){
            mostrarPartidasEnCurso();
        }
    }
    public void mostrarDetallesDeUnaPartida(){
        
    }
    
    private void mostrarPartidasEnCurso() {
        vistaMonitorearJuegos.mostrarPartidasEnCurso();
    }


    
}
