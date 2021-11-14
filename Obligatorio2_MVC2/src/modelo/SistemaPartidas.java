/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Event;
import java.util.ArrayList;
import modelo.Partida;
/**
 *
 * @author mariafernandafulco
 */
public class SistemaPartidas {
    public ArrayList<Partida> listaDePartidas = new ArrayList<Partida>();
    public Partida partidaAbierta = new Partida(3,1);


    
        public enum Eventos {
        cambioValor, salir, nuevaParticipacion
    };
    
    

    
    public  void CrearNuevaPartida() throws PartidaException {
        partidaAbierta = new Partida(3,25);
    }
    public void AsignarJugadorAPartida(Sesion sesion)throws PartidaException{
        
        if(partidaAbierta==null){
            CrearNuevaPartida();
        }
        sesion.setParticipacion(new Participacion(partidaAbierta,sesion.getJugador()));    
        Participacion p = sesion.getParticipacion();
        if(partidaAbierta.ExisteEnPartida(p))
            throw new PartidaException("Debe esperar a la siguiente partida para volver a ingresar");

if(sesion.getParticipacion().getJugador().getSaldo()<partidaAbierta.getValorDeLaApuestaBaseOLuz() * partidaAbierta.getCantidadDeJugadores())
    throw new PartidaException("No cuenta con saldo suficiente para unirse a una partida.");

        partidaAbierta.AgregarParticipante(sesion.getParticipacion());
        if(partidaAbierta.faltan()==0){
                           listaDePartidas.add(partidaAbierta);
                           CrearNuevaPartida();
                       }
    
//    avisar(Eventos.nuevaParticipacion);
   Sistema.getInstancia().avisar(Sistema.Eventos.cambioListaParticipantes);
   //vista.mostrarJugadoresFaltantes(partidaAbierta.JugadoresFaltantes());
    }

    public ArrayList<Partida> getListaDePartidas() {
        return listaDePartidas;
    }

    public Partida getPartidaAbierta() {
        return partidaAbierta;
    }
    
    
    public static void ingresarJugadorAUnaPartida(Jugador jugador) {
        
        
    }
    
}
