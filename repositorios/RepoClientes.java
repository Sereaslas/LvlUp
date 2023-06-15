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
import lvlup.shop.Cliente;

/**
 * Clase que representa al repositorio de texto de las clientes. Se utiliza para
 * almacenar los datos en un archivo de texto plano.
 *
 * @author Marcos&&German
 */
public class RepoClientes extends Repositorio<Cliente> {

    /**
     * Clase que representa al repositorio de texto de los clientes. Se utiliza
     * para almacenar los datos en un archivo de texto plano.
     *
     * @param filePath Direccion en donde se guardara el archivo.
     */
    public RepoClientes(String filePath) {
        super(filePath);

    }

    /**
     * Metodo sobreescrito que guarda la lista de clientes en el repositorio de
     * texto.
     *
     * @param m lista de clientes
     */
    @Override
    public void guardar(ArrayList<Cliente> m) {
        try {
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(getFile()));
            escritor.writeObject(m);
            escritor.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error");
        }
    }

    /**
     * Metodo sobreescrito que guarda una cliente individual.
     *
     * @param c cliente a ser guaradado
     */
    @Override
    public void guardar(Cliente c) {
        try {
            ArrayList nuevaLista = this.obtener();
            nuevaLista.add(c);
            this.guardar(nuevaLista);
        } catch (Exception e) {
            System.out.println("Ocurrio un error");
        }
    }

    /**
     * Metodo sobreescrito que retorna la lista de clientes.
     *
     * @return la lista de clientes.
     */
    @Override
    public ArrayList<Cliente> obtener() {
        ArrayList<Cliente> listaClientes = null;
        try {
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(getFile()));
            listaClientes = (ArrayList<Cliente>) lector.readObject();
            lector.close();
        } catch (Exception e) {
        }
        return listaClientes;
    }

    /**
     * Metodo sobreescrito que borra un cliente.
     *
     * @param m cliente a ser borrado
     */
    @Override
    public void borrar(Cliente m) {
        ArrayList<Cliente> listaClientes = obtener();
        listaClientes.forEach(c -> {
            if (c.getcIdentidad().equals(m.getcIdentidad())) {
                clienteTemp = c;
            }
        });
        listaClientes.remove(clienteTemp);
        guardar(listaClientes);
    }

    private Cliente clienteTemp = null;
}
