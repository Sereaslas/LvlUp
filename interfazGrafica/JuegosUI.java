
package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import lvlup.shop.Juego;

/**
 * Esta clase es una ventana que lista en una tabla todos los juegos que 
 * tiene la tienda con sus datos
 * @author Marcos&&German
 */
public class JuegosUI extends JFrame{
    
    /**
     * Este constructor crea una ventana que contiene la tabla con los 
     * juegos de la lista que recibe como parametro
     * @param lista 
     */
    public JuegosUI(ArrayList<Juego> lista){
        juegos = lista;
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setResizable(false);
        this.setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);       
        this.setContentPane(crearTabla());
        this.setVisible(true);
    }
    
    /**
     * Este metodo obtiene todos los datos de los juegos y los guarda dentro de una matriz
     * para luego crear una tabla con esos datos
     * @return 
     */
    public String[][] obtenerDatos(){
        String[][] datosJuegos = new String[juegos.size()][5];
        int i =0;//for (int i = 0; i < juegos.size(); i++) {
            for(Juego j : juegos){
                datosJuegos[i][0]= (j.getNombre()==null) ? "no posee" : j.getNombre();
                datosJuegos[i][1]= (j.getConsola()==null) ? "no posee" : j.getConsola();
                datosJuegos[i][2]= (""+j.getCantidad());
                datosJuegos[i][3]= "["+j.getPrecio()+"GS.]";
                datosJuegos[i][4]= j.isDisponible()? "Disponible" : "No disponible"; 
                i++;
            }
     
        return datosJuegos;
    }
    
    /**
     * Este metodo crea la tabla a partir de los datos obtenidos mediante el metodo obtener datos
     * @return 
     */
    public JPanel crearTabla(){
        JPanel panel = new JPanel(new BorderLayout());
        Object[] cabecera = {"Nombre", "Consola", "Cantidad", "Precio", "Disponible"};
        JTable tabla = new JTable(obtenerDatos(), cabecera);
        tabla.setPreferredSize(new Dimension(1000,1000));
        tabla.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tabla.setRowHeight(30);
        panel.setPreferredSize(new Dimension(1000,1000));
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);      
        return panel;
    }
    
    /*
    *Se definen las variables de la clase
    */
    private ArrayList<Juego> juegos = null; 
}