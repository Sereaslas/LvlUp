/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import lvlup.shop.Cliente;

/**
 * Clase que represnta la lista de clientes
 *
 * @author Marcos&&German
 */
public class ClientesUI extends JFrame {

    /**
     * Constructor que crea la ventana, le da sus propiedades, le genera los
     * componentes y la hace visible.
     *
     * @param lista lista de clientes que estaran en la tabla
     */
    public ClientesUI(ArrayList<Cliente> lista) {
        clientes = lista;
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setResizable(false);
        this.setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setContentPane(crearTabla());
        this.setVisible(true);
    }

    /**
     * metodo que obtiene los datos de los clientes y los procesa.
     *
     * @return matriz con los datos de los clientes
     */
    public String[][] obtenerDatos() {
        String[][] datosClientes = new String[clientes.size()][4];
        int i = 0;
        for (Cliente e : clientes) {
            datosClientes[i][0] = e.getNombreApellido();
            datosClientes[i][1] = e.getcIdentidad();
            datosClientes[i][2] = e.getEmail();
            datosClientes[i][3] = e.getDeuda() ? ("Posee Deuda") : ("No posee deuda");
            i++;
        }

        return datosClientes;
    }

    /**
     * Metodo que genera la tabla donde iran los datos.
     *
     * @return un panel con la tabla de datos
     */
    public JPanel crearTabla() {
        JPanel panel = new JPanel(new BorderLayout());
        Object[] cabecera = {"Nombre", "N° de Cedula", "Email", "Deuda"};
        JTable tabla = new JTable(obtenerDatos(), cabecera);
        tabla.setPreferredSize(new Dimension(1000, 1000));
        tabla.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tabla.setRowHeight(30);
        panel.setPreferredSize(new Dimension(1000, 1000));
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
        return panel;
    }

    //atributo
    private ArrayList<Cliente> clientes;
}
