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
public class Jugador extends Usuario{
    private int saldo;

    public Jugador(int saldo, String nombreUsuario, String nombreCompleto, String contrasenia) {
        super(nombreUsuario, nombreCompleto, contrasenia);
        this.saldo = saldo;
    }

    public Jugador(int saldo) {
        this.saldo = saldo;
    }

    public Jugador() {
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    
}
