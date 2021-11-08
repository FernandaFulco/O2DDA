/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import observador.Observable;
/**
 *
 * @author mariafernandafulco
 */
public class Sistema extends Observable{
    private SistemaUsuarios sistemaUsuarios = new SistemaUsuarios();
    private SistemaPartidas sistemaPartidas = new SistemaPartidas();
    
    private static Sistema instancia = new Sistema();

    public void CrearNuevaPartida() {
        //SistemaPartidas.CrearNuevaPartida();
    }

    public enum Eventos{cambioListaUsuariosConectados,nuevoContactoDeCualquierAgenda,cambioListaParticipantes};
    
    public static Sistema getInstancia() {
        return instancia;
    }

    private Sistema() {
    }

    public void agregarUsuarioJugador(int saldo, String nombreUsuario, String nombreCompleto, String contrasenia) {
        sistemaUsuarios.agregarUsuarioJugador(saldo, nombreUsuario, nombreCompleto, contrasenia);
    }

    public Sesion loginJugador(String nombreUsuario, String contrasenia) {
        return sistemaUsuarios.loginJugador(nombreUsuario, contrasenia);
    }

    public void agregarUsuarioAdministrador(String nombreUsuario, String nombreCompleto, String contrasenia) {
        sistemaUsuarios.agregarUsuarioAdministrador(nombreUsuario, nombreCompleto, contrasenia);
    }

    public Administrador loginAdministrador(String nombreUsuario, String contrasenia) {
        return sistemaUsuarios.loginAdministrador(nombreUsuario, contrasenia);
    }

    public ArrayList<Sesion> getConexiones() {
        return sistemaUsuarios.getConexiones();
    }

    public SistemaUsuarios getSistemaUsuarios() {
        return sistemaUsuarios;
    }

    public void setSistemaUsuarios(SistemaUsuarios sistemaUsuarios) {
        this.sistemaUsuarios = sistemaUsuarios;
    }

    public SistemaPartidas getSistemaPartidas() {
        return sistemaPartidas;
    }

    public void setSistemaPartidas(SistemaPartidas sistemaPartidas) {
        this.sistemaPartidas = sistemaPartidas;
    }
    
    public void logout(Sesion s) {
        sistemaUsuarios.logout(s);
    }
}
