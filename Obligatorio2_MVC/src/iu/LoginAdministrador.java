/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import vistaEscritorio.MonitorearJuegos;
import java.awt.Frame;
import modelo.Administrador;
import modelo.Sesion;
import modelo.Sistema;
import modelo.Usuario;
import vistaEscritorio.CasoDeUsoAdmin;
/**
 *
 * @author mariafernandafulco
 */
public class LoginAdministrador extends LoginAbstracto {
    
    public LoginAdministrador(Frame parent, boolean modal) {
        super(parent, modal);
    }

    @Override
    public String getTitulo() {
        return "LOGIN ADMINISTRADOR";
    }

    @Override
    public Object invocarLoginLogicaNegocio(String nom, String pwd) {
        
        Administrador usuario = Sistema.getInstancia().loginAdministrador(nom, pwd);
        return usuario;
    }

    @Override
    public void ejecutarProximoCasoUso(Object dato) {
        //Ingresar a una Partida
//        new IngresarAPartida(null,false,(Sesion)dato).setVisible(true);
//        new EsperandoInicioDeJuego(null, false).setVisible(true);
//        Sistema.getInstancia().CrearNuevaPartida();
        new CasoDeUsoAdmin(null,false,(Administrador)dato).setVisible(true);
        //new MonitorearJuegos(null,false,(Administrador)dato).setVisible(true);
        
    }
}
