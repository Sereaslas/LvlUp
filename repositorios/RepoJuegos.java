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
import lvlup.shop.Juego;

/**
 * Clase que representa al repositorio de texto de los juegos. Se utiliza para
 * almacenar los datos en un archivo de texto plano.
 *
 * @author Marcos&&German
 */
public class RepoJuegos extends Repositorio<Juego> {

    /**
     * Constructor que crea un repositorio a partir un direccion.
     *
     * @param filePath Direccion en donde se guardara el archivo.
     */
    public RepoJuegos(String filePath) {
        super(filePath);
    }

    /**
     * Metodo sobreescrito que guarda una juego individual.
     *
     * @param j juego a ser guaradado
     */
    @Override
    public void guardar(Juego j) {
        try{
            ArrayList<Juego> nuevaLista = this.obtener();
            Juego juegoEliminar = null;
            for(Juego juego : nuevaLista){
                if(j.getNombre().equalsIgnoreCase(juego.getNombre())){
                    juegoEliminar = juego;                   
                }
            }
            if(juegoEliminar!=null){
            nuevaLista.remove(juegoEliminar);
            }
            nuevaLista.add(j);
            this.guardar(nuevaLista);
        }catch(Exception e){
            System.out.println("Ocurrio un error");
        }
    }

    /**
     * Metodo sobreescrito que guarda la lista de juegos en el repositorio de
     * texto.
     *
     * @param m lista de juegos
     */
    @Override
    public void guardar(ArrayList<Juego> m) {
        try {
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(getFile()));
            escritor.writeObject(m);
            escritor.close();
        } catch (Exception e) {
        }
    }

    /**
     * Metodo sobreescrito que borra un juego.
     *
     * @param j juego a ser borrado
     */
    @Override
    public void borrar(Juego m) {
        ArrayList<Juego> listaJuegos = obtener();
        listaJuegos.forEach(j -> {
            if (j.getNombre().equals(m.getNombre())) {
                juegoTemp = j;
            }
        });
        listaJuegos.remove(juegoTemp);
        guardar(listaJuegos);
    }

    /**
     * Metodo sobreescrito que retorna la lista de juegos.
     *
     * @return la lista de juegos.
     */
    @Override
    public ArrayList<Juego> obtener() {
        ArrayList<Juego> listaJuegos = null;
        try {
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(getFile()));
            listaJuegos = (ArrayList<Juego>) lector.readObject();
            lector.close();
        } catch (Exception e) {
        }
        return listaJuegos == null ? new ArrayList() : listaJuegos;
    }

    private Juego juegoTemp = null;
}
