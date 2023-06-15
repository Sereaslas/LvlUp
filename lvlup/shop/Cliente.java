package lvlup.shop;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Esta clase representa a un cliente que efectuara transacciones en la tienda
 * implementa la interfaz serializable para poder ser guardada en los repositorios con el ObjectOutputStream
 * @author Marcos&&German
 */
public class Cliente implements Serializable {
    /*
    * El constructor crea al cliete a partir de su nombre su numero de Identidad y su email
    */
    public Cliente(String nombreApellido, String ci, String email) {
        this.nombreApellido = nombreApellido;
        this.cIdentidad = ci;
        this.email = email;
        this.deuda = false;
        this.juegos = new ArrayList();
        this.fecha = LocalDate.now();
    }

    /**
     * Se definen los getter y los setter de la clase
     * 
     */
    
    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getcIdentidad() {
        return cIdentidad;
    }

    public void setcIdentidad(String cIdentidad) {
        this.cIdentidad = cIdentidad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getDeuda() {
        return deuda;
    }

    public void setDeuda(boolean deuda) {
        this.deuda = deuda;
    }

    public ArrayList<Juego> getJuegos() {
        return juegos;
    }

    public void setJuegos(ArrayList<Juego> juegos) {
        this.juegos = juegos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFechaDevol() {
        return fechaDevol;
    }

    public void setFechaDevol(LocalDate fechaDevol) {
        this.fechaDevol = fechaDevol;
    }

    /**
     * Este metodo añade un juego a la lista de juegos para alquilar del cliente.
     * @param j 
     */
    public void addJuego(Juego j) {
        this.getJuegos().add(j);
    }
    /**
     * Este metodo retorna los datos del cliente
     * @return 
     */
    @Override
    public String toString() {
        String cliente = this.getNombreApellido() + " -N° de Identidad : " + getcIdentidad();
        return cliente;
    }
    
    /*
    *Se definin las variables de la clase
    */

    private String nombreApellido = null;
    private String cIdentidad = null;
    private String email = null;
    private boolean deuda = false;
    private ArrayList<Juego> juegos = null;
    private LocalDate fecha = null;
    private LocalDate fechaDevol = null;
}
