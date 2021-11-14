/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author mariafernandafulco
 */
public class Carta {
    private int id;
    public Palo palo;
    public Valor valor;
    

    public Carta(int id, Palo palo, Valor valor) {

        this.id = id;
        this.palo = palo;
        this.valor = valor;
    }
    public Carta(){
        
    }
    
    public Carta generarCarta(int id, int ordinalPalo, int ordinalValor) {
        
        
      //Con los ordinales saber a que enum pertenece
        Palo palo =Palo.values()[ordinalPalo];
        Valor valor = Valor.values()[ordinalValor];
        
        Carta carta = new Carta(id,palo,valor);
        
        
        //Lo logre
        return carta;
    }
    
    
    public enum Palo {
        CORAZON, DIAMANTE, PICA, TREBOL
    }

    public enum Valor {
        A,K,Q,J,DIEZ,NUEVE,OCHO,SIETE,SEIS,CINCO,CUATRO,TRES,DOS;
        //AS, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE,DIEZ,J, Q, K por si acaso¿
    }

  

    public void setId(int id) {
        this.id = id;
    }

    public Palo getFigura() {
        return palo;
    }

    public Valor getNumero() {
        return valor;
    }

    @Override
    public String toString() {
        return "Carta: " + this.id + "  |Número: "+this.valor.toString() + " - Tipo: " + this.palo.toString() +"|";
    }
    
//    public void generarCartas() {
//        int contador = 0; //-> id de la carta
//     
//
//        for (int i = 0; i < Palo.values().length; i++) {
//            for (int j = 0; j < Valor.values().length; j++) {
////                mazo.add(carta);
////              System.out.println(mazo.toArray());
//            }
////            System.out.println(carta.valor.values()[i]);
////              System.out.println(mazo.toArray());
//        }
//
////////            System.out.println(Palo.values()[i]);
//
//
//    }
    
    
    //private enum enumMes  {Ene,Feb,Mar,Abr,May,Jun,Jul,Ago,Sep,Oct,Nov,Dic};
//        private int diaDelMes;
//        enumMes mes;
//        private int año;

//        public Fecha(int diaDelMes, enumMes mes, int año) {
//            this.diaDelMes = diaDelMes;
//            this.mes = mes;
//            this.año = año;
//        }

//        public enum enumMes {
//            Ene("Ene"), Feb("Feb"), Mar("Mar"), Abr("Abr"), May("May"), Jun("Jun"), Jul("Jul"), Ago("Ago"), Sep("Sep"), Oct("Oct"), Nov("Nov"), Dic("Dic");
//            private String value;
//
//            enumMes(String value) {
//                this.value = value;
//            }
//        }
//        public enum Palo {
//            CORAZON("CORAZON"), DIAMANTE("DIAMANTE"), PICA("PICA"), TREBOL("TREBOL"), CORAZONES;
//            private String value;
//
//            Palo(String value) {
//                this.value = value;
//            }
//        }
//        public enum Valor {
//            AS("AS"), DOS("DOS"), TRES("TRES"), CUATRO("CINCO"), SEIS("SEIS"), SIETE("SIETE"), OCHO("OCHO"), NUEVE("NUEVE"), J("J"), Q("Q"), K("K");
//            private String value;
//
//            Valor(String value) {
//                this.value = value;
//            }
//        }


   
        
        
    
    
    
    
    //Funciona
//    public static void main(String[] args) {
//        Carta c= new Carta(1,Palo.DIAMANTE, Valor.CUATRO);      
//        System.out.println(c.toString());
//    }
}
