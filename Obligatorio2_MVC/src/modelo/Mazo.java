/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import modelo.Carta.Palo;
import modelo.Carta.Valor;
import java.util.Collections;

/**
 *
 * @author mariafernandafulco
 */
public class Mazo {

    ArrayList<Carta> mazo;

    public Mazo() {
        this.generarMazo();
    }

    public ArrayList<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList<Carta> mazo) {
        this.mazo = mazo;
    }

    public void generarMazo() {
        int contador = 0;
        Carta carta = new Carta();
        for (int i = 0; i < 3; i++) {//Recorrida palos
            for (int j = 0; j < 12; j++) {//Recorrida valores
                mazo.add(carta.generarCarta(contador++, i, j));
            //Agrego al array de mazo las cartas.
            }
        }
    }

}
