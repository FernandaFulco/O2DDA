/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import vistaEscritorio.IngresarAPartida;
import vistaEscritorio.EsperandoInicioDeJuego;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PartidaException;
import modelo.Sesion;
import modelo.Sistema;
/**
 *
 * @author mariafernandafulco
 */
public class LoginJugador extends LoginAbstracto {

    public LoginJugador(Frame parent, boolean modal) {
        super(parent, modal);
    }

    @Override
    public String getTitulo() {
       return "LOGIN JUGADOR";
    }

    @Override
    public Object invocarLoginLogicaNegocio(String nom, String pwd) {
        Sesion sesion = Sistema.getInstancia().loginJugador(nom, pwd);

        return sesion; 
    }

    @Override
    public void ejecutarProximoCasoUso(Object dato) {
        
        try {
            //Ingresar a una Partida
            new IngresarAPartida(null,false,(Sesion)dato).setVisible(true);
//            new EsperandoInicioDeJuego(null, false,(Sesion)dato).setVisible(true);
        } catch (PartidaException ex) {
            Logger.getLogger(LoginJugador.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }
    
}
