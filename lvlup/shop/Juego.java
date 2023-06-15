package lvlup.shop;

import java.io.Serializable;

/**
 * Esta clase modela los juegos que se alquilaran en la tienda
 * @author Marcos&&German
 */
public class Juego implements Serializable{

    /**
     * Este contructor crea un juego a partir de su nombre y la cantidad
     * @param nombre
     * @param cantidad 
     */
    public Juego(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.consola = "Desconocida";
        this.genero = "Desconocido";
        this.desarrollador = "Desconocido";
        this.año = 2000;
        this.descripcion = "";
        this.precio = 0;

        this.disponible = cantidad >= 1;
    }

    /**
     * Este constructor crea un juego a partir de su nombre, edad y precio
     * @param nombre
     * @param cantidad
     * @param precio 
     */
    public Juego(String nombre, int cantidad, int precio) {
        this(nombre, cantidad);
        this.precio = precio;
    }

    /**
     * Este coonstructor crea un juego a partir de los sgtes parametros
     * @param nombre
     * @param consola
     * @param genero
     * @param desarrollador
     * @param año
     * @param cantidad
     * @param precio
     * @param descripcion 
     */
    public Juego(String nombre, String consola, String genero, String desarrollador, int año, int cantidad, int precio, String descripcion) {
        this(nombre, cantidad, precio);
        this.consola = consola;
        this.genero = genero;
        this.desarrollador = desarrollador;
        this.año = año;
        this.descripcion = descripcion;
    }

    /*
     * Se definen los getters y setters 
     *  
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getConsola() {
        return consola;
    }

    public void setConsola(String consola) {
        this.consola = consola;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void restarCant(){
        this.cantidad--;
    }
    
    public void devJuego(){
        this.cantidad++;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /*
    *Se definen las variables de clase
    */
    private String nombre = null;
    private String consola = "sin especificar";
    private String genero = "sin especificar";
    private String desarrollador = "sin especificar";
    private int año = 0;
    private int precio = 0;
    private String descripcion = "sin especificar";
    private int cantidad = 0;
    private boolean disponible = false;
}
