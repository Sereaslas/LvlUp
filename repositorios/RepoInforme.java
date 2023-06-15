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
import lvlup.shop.Informe;

/**
 * Clase que representa al repositorio de texto de las informes. Se utiliza para
 * almacenar los datos en un archivo de texto plano.
 *
 * @author Marcos&&German
 */
public class RepoInforme extends Repositorio<Informe> {

    /**
     * Constructor que crea un repositorio a partir un direccion.
     *
     * @param filePath Direccion en donde se guardara el archivo.
     */
    public RepoInforme(String filePath) {
        super(filePath);
    }

    /**
     * Metodo sobreescrito que guarda la lista de informes en el repositorio de
     * texto.
     *
     * @param i lista de informes
     */
    @Override
    public void guardar(ArrayList<Informe> i) {
        try {
            ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(getFile()));
            escritor.writeObject(i);
            escritor.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error");
            e.printStackTrace();
        }
    }

    /**
     * Metodo sobreescrito que guarda un informe individual.
     *
     * @param i informe a ser guaradado.
     */
    @Override
    public void guardar(Informe i) {
        try {
            ArrayList<Informe> nuevaLista = this.obtener();
            ArrayList<Informe> otraLista = new ArrayList(nuevaLista);
            Informe inforDes = null;
            for (Informe informe : nuevaLista) {
                if (informe.getFecha().isEqual(i.getFecha())) {
                    i.setNumTran(informe.getNumTran());
                    i.setNumJuegAlqu(informe.getNumJuegAlqu());
                    i.setGanancias(informe.getGanancias());
                }
                int diaDifen = i.getFecha().getDayOfYear() - informe.getFecha().getDayOfYear();
                if (diaDifen >= 7) {
                    inforDes = informe;
                }
            }
            
            for(Informe informe: nuevaLista){
                if (informe.getFecha().isEqual(i.getFecha())) {
                    otraLista.remove(informe);
                }
            }
            if (inforDes != null) {
                borrar(inforDes);
            }
            otraLista.add(i);
            this.guardar(otraLista);
        } catch (Exception e) {
            System.out.println("Ocurrio un error. F");
        }
    }

    /**
     * Metodo sobreescrito que retorna la lista de informes.
     *
     * @return la lista de infomres.
     */
    @Override
    public ArrayList<Informe> obtener() {
        ArrayList<Informe> listaInformes = null;
        try {
            ObjectInputStream lector = new ObjectInputStream(new FileInputStream(getFile()));
            listaInformes = (ArrayList<Informe>) lector.readObject();
            lector.close();
        } catch (Exception e) {
        }
        return listaInformes;
    }

    /**
     * Metodo sobreescrito que borra un informe.
     *
     * @param i juego a ser borrado
     */
    @Override
    public void borrar(Informe i) {
        ArrayList<Informe> listaInformes = obtener();
        listaInformes.forEach(c -> {
            if (c.getFecha().equals(i.getFecha())) {
                informeTemp = i;
            }
        });
        listaInformes.remove(informeTemp);
        guardar(listaInformes);
    }

    private Informe informeTemp = null;

}
