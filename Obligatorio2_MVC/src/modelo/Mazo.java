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
        this.mazo = new ArrayList<>();
    }

    public ArrayList<Carta> getMazo() {
        return mazo;
    }

    public void setMazo(ArrayList<Carta> mazo) {
        this.mazo = mazo;
    }

       public enum Palo {
        CORAZON, DIAMANTE, PICA, TREBOL
    }

    public enum Valor {
        AS, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE, J, Q, K
    }
    
   
}

// String numero[] = { "As", "Dos", "Tres", "Cuatro", "Cinco", "Seis",
//         "Siete", "Ocho", "Nueve", "Diez", "Jota", "Reina", "Rey" };
//      
//      String palos[] = { "Corazones", "Diamantes", "Tréboles", "Pique" };
//        for(int cuenta=0;cuenta<52;cuenta++  ){
//            this.myBaraja.add(new Carta(numero[cuenta%13],palos[cuenta/13]));
//        }
//        Collections.shuffle(this.myBaraja);
