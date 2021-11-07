/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mariafernandafulco
 */
public class Sesion {
    private Date fechaHoraConectado ;
    private Participacion participacion;
    private Jugador jugador;

    public Sesion(Jugador jugador) {
        this.jugador = jugador;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Participacion getParticipacion() {
        return participacion;
    }

    public void setParticipacion(Participacion participacion) {
        this.participacion = participacion;
    }

    public Date getFechaHoraConectado() {
        return fechaHoraConectado;
    }
    
    
    
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy ");
        return jugador.getNombreCompleto() + " (" + 
               sdf.format(fechaHoraConectado);
    }
}