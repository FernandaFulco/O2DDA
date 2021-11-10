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
    
    public ArrayList<Partida> listaDePartidas = new ArrayList<Partida>();
    public Partida partidaAbierta = null;
    
    
    
    
    public  void CrearNuevaPartida(Sesion sesion) {
        //Si no existe una partida creada
        //partidaAbierta.AgregarParticipante(participante)<-----ESTA VARIABLE
        //validar el agregar participante a partida, consultar(¿puedo recibir en
        //esta clase el participante?)
        
        if(!partidaAbierta.ExisteEnPartida(sesion.getParticipacion()))
            //Exepcion: Debe esperar a la siguiente partida para volver a ingresar
if(sesion.getParticipacion().getJugador().getSaldo()<partidaAbierta.getValorDeLaApuestaBaseOLuz())
    //Exepcion: No cuenta con saldo suficiente para unirse a una partida.
    
        partidaAbierta.AgregarParticipante(sesion.getParticipacion());
        if(partidaAbierta.JugadoresFaltantes()==0){
                           listaDePartidas.add(partidaAbierta);
                           partidaAbierta = new Partida(3, 25);
                       }//Contultar
   vista.mostrarJugadoresFaltantes(partidaAbierta.JugadoresFaltantes());
    }

    public ControladorJugarAlPoker(Partida modelo, VistaJugarAlPoker vista,Sesion s) {
        this.modelo = modelo;
        this.vista = vista;
        this.sesion = s;
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
