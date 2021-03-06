/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author mariafernandafulco
 */
public class Partida extends Observable {

    public int idPartida = 0;
    public int cantidadDeJugadores;
    public int valorDeLaApuestaBaseOLuz;
    public ArrayList<Participacion> participaciones = new ArrayList();
    public ArrayList<Participacion> participantesActuales = new ArrayList();
    
    public Mazo mazo;

    public Partida(){
    
    }
    
    
    public Partida(int cantidadDeJugadores, int valorDeLaApuestaBaseOLuz) {
        this.idPartida = this.idPartida + 1;
        this.cantidadDeJugadores = cantidadDeJugadores;
        this.valorDeLaApuestaBaseOLuz = valorDeLaApuestaBaseOLuz;
    }

    public Boolean AgregarParticipante(Participacion participante) {

            participaciones.add(participante);
            avisar(Eventos.nuevaParticipacion);
            Sistema.getInstancia().avisar(Sistema.Eventos.cambioListaParticipantes);
            participantesActuales = participaciones;
            return true;


    }

    public Boolean hayLugar() {
        return participaciones.size() == cantidadDeJugadores;
        //Devuelve si un jugador puede unirse a una partida.
    }
    public void JugadoresFaltantes(){ 
        if(faltan()!=0){
            avisar(Eventos.nuevaParticipacion);
        }else{
            avisar(Eventos.EmpezarPartida);
        }
        
        
    }
    public int faltan(){
        return  cantidadDeJugadores - participaciones.size();
    }

    public Boolean ExisteEnPartida(Participacion participante) {
        for (Participacion p : participaciones) {
            if(p.getJugador().getNombreUsuario().equals(participante.getJugador().getNombreUsuario()))
                return true;
        }
        return false;
        //return participaciones.contains(participante);
    }

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public int getCantidadDeJugadores() {
        return cantidadDeJugadores;
    }

    public void setCantidadDeJugadores(int cantidadDeJugadores) {
        this.cantidadDeJugadores = cantidadDeJugadores;
    }

    public int getValorDeLaApuestaBaseOLuz() {
        return valorDeLaApuestaBaseOLuz;
    }

    public void setValorDeLaApuestaBaseOLuz(int valorDeLaApuestaBaseOLuz) {
        this.valorDeLaApuestaBaseOLuz = valorDeLaApuestaBaseOLuz;
    }

    public ArrayList<Participacion> getParticipaciones() {
        return participaciones;
    }
    public ArrayList<Participacion> getParticipantesActivos() {
        return participantesActuales;
    } 

    public void setParticipaciones(ArrayList<Participacion> participaciones) {
        this.participaciones = participaciones;
    }

        public enum Eventos {
        cambioValor, salir, nuevaParticipacion, EmpezarPartida
    };
        
    private Observador expulsador;

    public void expulsarAlResto(Observador e) {
        expulsador = e;
        avisar(Eventos.salir);
    }

    public Observador getExpulsador() {
        return expulsador;
    }

    public void sumar() {
        idPartida++;
        avisar(Eventos.cambioValor);
    }

    public boolean restar() {
        if (idPartida == 0) {
            return false;
        }
        idPartida--;
        avisar(Eventos.cambioValor);
        return true;
    }

}
