/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import observador.Observador;

/**
 *
 * @author mariafernandafulco
 */
public class Partida extends observador.Observable {
    public int idPartida = 0;
    public int cantidadDeJugadores;
    public int valorDeLaApuestaBaseOLuz;
    public ArrayList<Participacion> participaciones = new ArrayList();
    public Mazo mazo;

    public Partida(int cantidadDeJugadores, int valorDeLaApuestaBaseOLuz) {
        this.idPartida = this.idPartida +1;
        this.cantidadDeJugadores = cantidadDeJugadores;
        this.valorDeLaApuestaBaseOLuz = valorDeLaApuestaBaseOLuz;
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

    public void setParticipaciones(ArrayList<Participacion> participaciones) {
        this.participaciones = participaciones;
    }

    
    
    public enum Eventos{cambioValor,salir};
    private Observador expulsador;
    
    public void expulsarAlResto(Observador e) {
        expulsador=e;
        avisar(Eventos.salir);
    }

    public Observador getExpulsador() {
        return expulsador;
    }
   
    public void sumar(){
        idPartida++;
        avisar(Eventos.cambioValor);
    }
    public boolean restar(){
        if(idPartida==0) return false;
        idPartida--;
        avisar(Eventos.cambioValor);
        return true;
    }
    
}
