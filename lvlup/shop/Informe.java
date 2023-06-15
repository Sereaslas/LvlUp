
package lvlup.shop;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Esta clase lleva el registro de las ventas realizadas en la ultima semana
 * implementa la clase serializable para poder guardar los datos en su repositorio
 * @author Marcos&&German
 */
public class Informe implements Serializable {

    /**
     * El constructor crea un informe para cada dia a partir de la fecha de ese dia.
     * @param fecha   
     */
    public Informe(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Se definen los getters y setters
     *  
     */
    public int getGanancias() {
        return ganancias;
    }

    public void setGanancias(int ganancias) {
        this.ganancias += ganancias;
    }

    public int getNumJuegAlqu() {
        return numJuegAlqu;
    }

    public void setNumJuegAlqu(int numJuegAlqu) {
        this.numJuegAlqu += numJuegAlqu;
    }

    public int getNumTran() {
        return numTran;
    }

    public void setNumTran(int numTran) {
        this.numTran += numTran;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /*
    *Se definen las variables de la clase
    */
    private LocalDate fecha = null;

    private int ganancias = 0;
    private int numJuegAlqu = 0;
    private int numTran = 0;

}
