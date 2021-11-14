
package modelo;



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

    public void quitar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
