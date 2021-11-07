/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author mariafernandafulco
 */
public class SistemaUsuarios {
    private ArrayList<Jugador> listaJugadores = new ArrayList();
    private ArrayList<Administrador> listaAdministradores = new ArrayList();
    private ArrayList<Sesion> listaConexiones = new ArrayList();
    private ArrayList<Participacion> listaParticipaciones = new ArrayList();
    
    //Metodo que agrega a la lista listaJugadores, usuarios del tipo Jugador
    public void agregarUsuarioJugador(int saldo, String nombreUsuario, String nombreCompleto, String contrasenia){
        listaJugadores.add(new Jugador(saldo,nombreUsuario,nombreCompleto, contrasenia));
    }
    
    //Metodo que agrega a la lista listaAdministradores, usuarios del tipo Administrador
    public void agregarUsuarioAdministrador(String nombreUsuario, String nombreCompleto, String contrasenia){
        listaAdministradores.add(new Administrador(nombreUsuario, nombreCompleto, contrasenia));
    }
    
    //Método que devuelve la Sesiòn del usuario
    public Sesion loginJugador(String nombreDeUsuario,String contrasenia){
        Jugador jugador = (Jugador) login(nombreDeUsuario, contrasenia, listaJugadores);

        Sesion s = null;
        if(jugador!=null){
            s = new Sesion(jugador);
            listaConexiones.add(s);
            Sistema.getInstancia().avisar(Sistema.Eventos.cambioListaUsuariosConectados);
        }
        return s;
    }
    public Administrador loginAdministrador(String nombreUsuario,String contrasenia){
       Administrador administrador = (Administrador) login(nombreUsuario, contrasenia, listaAdministradores);
        return administrador;
    }
    private Usuario login(String nombreUsuario,String contrasenia,ArrayList usuarios){
        Usuario u;
        for(Object obj:usuarios){
            u = (Usuario) obj;
            if(u.getNombreUsuario().equals(nombreUsuario) && u.getContrasenia().equals(contrasenia)){
                return u;
            }
        }
        return null;
    }

    public ArrayList<Sesion> getConexiones() {
        return listaConexiones;
    }
    public void logout(Sesion s){
        listaConexiones.remove(s);
        Sistema.getInstancia().avisar(Sistema.Eventos.cambioListaUsuariosConectados);
    }
   
    
}
