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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import lvlup.shop.Informe;
import repositorios.RepoClientes;
import repositorios.RepoInforme;
import repositorios.RepoJuegos;

/**
 * Metodo que genera una ventana con el informe semanal.
 *
 * @author Marcos&&German
 */
public class InformeUI extends JFrame {

    /**
     * Constructor que crea la ventana, le da sus propiedades, le genera los
     * componentes y la hace visible.
     *
     * @param repoClientes repositorio de clientes
     * @param repoJuegos repositorio de juegos
     */
    public InformeUI(RepoClientes repoClientes, RepoJuegos repoJuegos) {
        this.repoClientes = repoClientes;
        this.repoJuegos = repoJuegos;
        this.informes = repoInf.obtener();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setResizable(false);
        this.setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setContentPane(crearComponentes());
        this.setVisible(true);
    }

    /**
     * Metodo que obtiene los datos de los informes y los procesa para
     * ingresarlos en la tabla.
     *
     * @return matriz de objetos con lo datos de los informes
     */
    public Object[][] obtenerDatos() {
        if (informes != null) {
            Object[][] datosJuegos = new Object[informes.size() + 1][5];
            int i = 0;
            int ganaciasTot = 0;
            int numVentas = 0;
            int numJuegos = 0;
            for (Informe info : informes) {

                int ventas = info.getNumTran();
                int juegos = info.getNumJuegAlqu();
                int ganacias = info.getGanancias();

                datosJuegos[i][0] = info.getFecha().getDayOfWeek().toString();
                datosJuegos[i][1] = ventas;
                datosJuegos[i][2] = juegos;
                datosJuegos[i][3] = ganacias + " Gs.";
                i++;

                numVentas += ventas;
                numJuegos += juegos;
                ganaciasTot += ganacias;

            }

            datosJuegos[i][0] = "Totales:";
            datosJuegos[i][1] = "[" + numVentas + "]";
            datosJuegos[i][2] = "[" + numJuegos + "]";
            datosJuegos[i][3] = "[" + ganaciasTot + "Gs.]";

            return datosJuegos;
        } else {
            JOptionPane.showMessageDialog(null, "No hay informes disponibles.");
        }
        Object[][] datos = new Object[10][10];
        return datos;

    }

    /**
     * Metodo que crea un panel con la tabla donde se mostraran los datos de los
     * informes.
     *
     * @return panel con los datos de los informes
     */
    public JPanel crearTabla() {
        JPanel panel = new JPanel(new BorderLayout());
        Object[] cabecera = {"Dia", "Ventas realizadas", "Juegos Alquilados", "Ganancias"};

        tabla = new JTable(obtenerDatos(), cabecera);
        tabla.setPreferredSize(new Dimension(1000, 1000));
        tabla.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tabla.setRowHeight(30);
        panel.setPreferredSize(new Dimension(1000, 1000));

        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
        return panel;
    }

    public JPanel crearCabecera() {
        JPanel cabecera = new JPanel(new BorderLayout());
        JPanel pnlNorte = new JPanel();

        JLabel titulo = new JLabel("Informe semanal: ");
        titulo.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 30));
        pnlNorte.add(titulo);
        pnlNorte.setBackground(Color.WHITE);

        cabecera.add(pnlNorte, BorderLayout.NORTH);

        return cabecera;
    }

    /**
     * Metodo que genera los componentes y los posiciona.
     *
     * @return el panel con los componentes
     *
     */
    public JPanel crearComponentes() {
        JPanel carrito = new JPanel(new BorderLayout());
        carrito.add(crearCabecera(), BorderLayout.NORTH);
        carrito.add(crearTabla(), BorderLayout.CENTER);
        return carrito;
    }

    //atributos
    private ArrayList<Informe> informes = null;
    private RepoJuegos repoJuegos = null;
    private RepoClientes repoClientes = null;
    private JTable tabla = null;

    private static Informe informe = null;

    private RepoInforme repoInf = new RepoInforme("./src/TxtRepositorios/TxTInforme.txt");

}
