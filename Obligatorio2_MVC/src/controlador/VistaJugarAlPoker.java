/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Partida;

/**
 *
 * @author Dario
 */
public interface VistaJugarAlPoker {

    public void mostrarPartida(int valor);

    public void terminar();

    public void error(String msg);
    
    public void mostrarJugadoresFaltantes(int faltan);

    public void iniciar(Partida modelo);
    
}
