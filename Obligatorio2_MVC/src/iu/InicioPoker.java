/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import iu.MenuDesarrollo;
import modelo.DatosPrueba;
import modelo.PartidaException;

/**
 *
 * @author mariafernandafulco
 */
public class InicioPoker {
       public static void main(String[] args) throws PartidaException {
        // TODO code application logic here
        DatosPrueba.cargar();
        new MenuDesarrollo().setVisible(true);
    }
}
