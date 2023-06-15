/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import java.util.ArrayList;

/**
 * Clase abstracta que representa el repositorio de texto base.
 *
 * @author Marcos&&German
 */
public abstract class Repositorio<M> {

    /**
     * Constructor que crea un repositorio a partir un direccion.
     *
     * @param filePath Direccion en donde se guardara el archivo.
     */
    public Repositorio(String filePath) {
        this.filePath = filePath;
    }

    //metodos abstractos
    public abstract void guardar(ArrayList<M> m);

    public abstract void guardar(M m);

    public abstract ArrayList<M> obtener();

    public abstract void borrar(M m);

    //getter
    public String getFile() {
        return filePath;
    }
    //atributos
    private String filePath = null;
}
