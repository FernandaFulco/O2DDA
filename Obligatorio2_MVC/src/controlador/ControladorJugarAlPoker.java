/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Partida;
import modelo.Sesion;
import modelo.Sistema;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author XD
 */
public class ControladorJugarAlPoker implements Observador{
    
    private Partida modelo;
    private VistaJugarAlPoker vista;
    private Sistema sistema;
    private Sesion sesion;

    public ControladorJugarAlPoker(Partida modelo, VistaJugarAlPoker vista,Sesion s) {
        this.modelo = modelo;
        this.vista = vista;
        this.sesion = s;
        modelo.agregar(this);
        mostrarPartida();
        //MostrarFaltantes();
    }
    public void salir(){
        modelo.quitar(this);
    }
    public void sumar(){
        modelo.sumar();
    }
    public void restar(){
        if(!modelo.restar()){
            vista.error("No se pudo restar");
        }
    }
    public void expulsarAlResto(){
        modelo.expulsarAlResto(this);
    }
    public void contadorFaltantes(){
        modelo.JugadoresFaltantes();
    }
    
    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Partida.Eventos.nuevaParticipacion)){
            mostrarPartida();
            MostrarFaltantes();
        }
        if(evento.equals(Partida.Eventos.salir)){
            if(modelo.getExpulsador()!=this){
                vista.terminar();
            }
        }
        if(evento.equals(Sistema.Eventos.cambioListaParticipantes)){
            vista.mostrarJugadoresFaltantes(Sistema.getInstancia().getSistemaPartidas().partidaAbierta.faltan());
        }
    }
    private void MostrarFaltantes(){
        vista.mostrarJugadoresFaltantes(modelo.faltan());
    }
    private void mostrarPartida() {
        vista.mostrarPartida(modelo.getIdPartida());
    }

    public Partida getModelo() {
        return modelo;
    }
    
    
}
