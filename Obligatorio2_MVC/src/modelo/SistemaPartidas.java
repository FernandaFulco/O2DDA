/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.Partida;
/**
 *
 * @author mariafernandafulco
 */
public class SistemaPartidas {
    public ArrayList<Partida> listaDePartidas = new ArrayList<Partida>();
    public Partida partidaAbierta = null;
    
    
    
    
    public  void CrearNuevaPartida() {
        //Si no existe una partida creada
        //partidaAbierta.AgregarParticipante(participante)<-----ESTA VARIABLE
        //validar el agregar participante a partida, consultar(¿puedo recibir en
        //esta clase el participante?)
        
        listaDePartidas.add(partidaAbierta);
          
    
        
    }

    
    public static void ingresarJugadorAUnaPartida(Jugador jugador) {
        
        
    }
    
}
