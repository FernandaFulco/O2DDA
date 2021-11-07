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
public class Baraja {

    ArrayList<Carta> mazo;

    public static void main(String[] args) {
    Carta carta = new Carta();

        generarCartas(carta);
        
        
    }

    public static void generarCartas(Carta carta) {

        int contador = 0; //-> id de la carta

        for (int i = 0; i < carta.palo.values().length; i++) {
            for (int j = 0; j < carta.valor.values().length; j++) {

            }
//            System.out.println(carta.valor.values()[i]);
//            System.out.println(mazo.toArray());
        }
    }
}
