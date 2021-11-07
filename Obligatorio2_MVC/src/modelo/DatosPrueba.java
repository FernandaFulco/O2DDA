/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import modelo.Carta;
import modelo.Sesion;
import modelo.Sistema;


/**
 *
 * @author Dario
 */
public class DatosPrueba {
    
    public static void cargar(){
        Sistema sistema = Sistema.getInstancia();
    
        //      agregarUsuarioJugador(int saldo, String nombreUsuario, String nombreCompleto, String contrasenia)
        sistema.agregarUsuarioJugador(10, "f", "f", "f");
        sistema.agregarUsuarioJugador(10, "m", "m", "m");
        sistema.agregarUsuarioJugador(10, "a", "a", "a");
//        sistema.agregarUsuarioJugador(10, "Fer", "Fernanda Fulco", "Fer1234");
//        sistema.agregarUsuarioJugador(10, "Matias", "Matias Michelini", "Matias1234");
        
        Sesion s = sistema.loginJugador("f", "f");
        Sesion s2 = sistema.loginJugador("m", "m");
        Sesion s1 = sistema.loginJugador("a", "a");
       
        //      agregarUsuarioAdministrador(String nombreUsuario, String nombreCompleto, String contrasenia)
        sistema.agregarUsuarioAdministrador("Gustavo", "Gustavo Rizzo", "Gustavo1234");
        sistema.agregarUsuarioAdministrador("z", "z", "z");
         
//        System.out.println(c.toString());
//        System.out.println(s.getParticipacion().getJugador().getNombreCompleto());
       
//        Sistema.getInstancia().logout(s);
        
        /*System.out.println("Cantidad contactos:" + u.getAgenda().cantidadContactos());
        System.out.println("Contactos:" + u.getAgenda().getContactos());
        */
        
                
        
//        System.out.println(s.getParticipacion().getJugador().getNombreCompleto());
    }
}
