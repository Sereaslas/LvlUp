/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositorios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import lvlup.shop.Politicas;

/**
 * Clase que representa al repositorio de texto de las politicas. Se utiliza
 * para almacenar los datos en un archivo de texto plano.
 *
 * @author Marcos&&German
 */
public class RepoPoliticas extends Repositorio<Politicas> {

    /**
     * Constructor que crea un repositorio a partir un direccion.
     *
     * @param filePath Direccion en donde se guardara el archivo.
     */
    public RepoPoliticas(String filePath) {
        super(filePath);
    }

    /**
     * Metodo sobreescrito que guarda la lista de politicas en el repositorio de
     * texto.
     *
     * @param p lista de politicas
     */
    @Override
    public void guardar(ArrayList<Politicas> p) {
        try {
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(getFile()));
            escritor.writeObject(p);
            escritor.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error");
        }
    }

    /**
     * Metodo sobreescrito que guarda una politica individual.
     *
     * @param p politica a ser guaradada.
     */
    @Override
    public void guardar(Politicas p) {
        try {
            borrar(p);
            ArrayList nuevaLista = this.obtener();
            if (nuevaLista == null) {
                nuevaLista = new ArrayList();
            }
            nuevaLista.add(p);
            this.guardar(nuevaLista);
        } catch (Exception e) {
            System.out.println("Ocurrio un error");
        }
    }

    /**
     * Metodo sobreescrito que retorna la lista de politicas.
     *
     * @return la lista de politicas.
     */
    @Override
    public ArrayList<Politicas> obtener() {
        ArrayList<Politicas> listaClientes = null;
        try {
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(getFile()));
            listaClientes = (ArrayList<Politicas>) lector.readObject();
            lector.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error");
        }
        return listaClientes;
    }

    /**
     * Metodo sobreescrito que borra todas politicas.
     *
     * @param p
     */
    @Override
    public void borrar(Politicas p) {
        ArrayList<Politicas> listaClientes = obtener();
        if (listaClientes != null) {
            listaClientes.clear();
        }
        guardar(listaClientes);
    }

    /**
     * Metodo que restablece las politicas a su valor por defecto.
     */
    public void restabablecerPols() {
        try {
            guardar(new Politicas());
        } catch (Exception e) {
            System.out.println("Ocurrio un error");
        }
    }

}
