
package lvlup.shop;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta clase define las politicas de la empresa 
 * e implementa la interfaz serializable para poder guardar los datos en su repositorio
 * @author Marcos&&German
 */
public class Politicas implements Serializable {
    /**
     * Este constructor crea una politica con valores por defecto 
     */
    public Politicas() {
        listaPol = new ArrayList();
        costoDia = 5000;
        costoRetraso = 10000;
        listaPol.add("El precio por dia de cada juego sera de " + costoDia + " gs.");
        listaPol.add("La multa por cada dia de retraso sera de " + costoRetraso + " gs.");
        listaPol.add("Los juegos deben ser devueltos en las mismas condiciones <br> en las que fueron alquilados");

    }

    /*
    *Se definen los getters y setters
    */
    public int getCostoDia() {
        return costoDia;
    }

    public void setCostoDia(int costoDia) {
        this.costoDia = costoDia;
        this.listaPol.set(0, "El precio por dia de cada juego sera de " + costoDia + " gs.");
    }

    public int getCostoRetraso() {
        return costoRetraso;
    }

    public void setCostoRetraso(int costoRetraso) {
        this.costoRetraso = costoRetraso;
        this.listaPol.set(1, "La multa por cada dia de retraso sera de " + costoRetraso + " gs.");
    }

    public ArrayList<String> getListaPol() {
        return listaPol;
    }

    public void setListaPol(ArrayList<String> listaPol) {
        this.listaPol = listaPol;
    }

    public void agregarPolitica(String pol) {
        listaPol.add(pol);
    }
    
    /*
    *Se definen las variables de clase
    */
    ArrayList<String> listaPol = null;
    private int costoDia = 0;
    private int costoRetraso = 0;

}
