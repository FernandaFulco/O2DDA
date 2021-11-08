/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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

    public ControladorJugarAlPoker(Partida modelo, VistaJugarAlPoker vista) {
        this.modelo = modelo;
        this.vista = vista;
        modelo.agregar(this);
        mostrarPartida();
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

    
    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Partida.Eventos.cambioValor)){
            mostrarPartida();
        }
        if(evento.equals(Partida.Eventos.salir)){
            if(modelo.getExpulsador()!=this){
                vista.terminar();
            }
        }
    }

    private void mostrarPartida() {
        vista.mostrarPartida(modelo.getIdPartida());
    }

    public Partida getModelo() {
        return modelo;
    }
    
    
}
