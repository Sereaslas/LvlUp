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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import lvlup.shop.Cliente;
import lvlup.shop.Informe;
import lvlup.shop.Juego;
import repositorios.RepoClientes;
import repositorios.RepoInforme;
import repositorios.RepoJuegos;

/**
 * Clase que representa la ventana para devolver un juego.
 *
 * @author Marcos&&German
 */
public class DevolverJuegosUI extends JFrame {

    /**
     * Constructor que crea la ventana, le da sus propiedades, le genera los
     * componentes y la hace visible.
     *
     * @param cliente cliente que devolera los juegos
     * @param repoClientes repositorio de clientes
     * @param repoJuegos repositorio de juegos
     */
    public DevolverJuegosUI(Cliente cliente, RepoClientes repoClientes, RepoJuegos repoJuegos) {
        this.clienteActual = cliente;
        this.repoClientes = repoClientes;
        this.repoJuegos = repoJuegos;
        this.juegos = cliente.getJuegos();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setResizable(false);
        this.setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        this.setContentPane(crearComponentes());
        this.setVisible(true);
    }

    /**
     * Metodo que obtiene los datos de los juegos y los procesa para ingresarlos
     * en la tabla.
     *
     * @return matriz de objetos con lo datos de los juegos y precios
     */
    public Object[][] obtenerDatos() {
        boolean antes = clienteActual.getFechaDevol().isAfter(LocalDate.now());
        boolean igual = clienteActual.getFechaDevol().isEqual(LocalDate.now());
        int dias = 0;
        if (!(antes || igual)) {
            dias = clienteActual.getFechaDevol().getDayOfYear() - LocalDate.now().getDayOfYear();
        }
        if (juegos != null) {
            Object[][] datosJuegos = new Object[juegos.size() + 1][5];
            int i = 0;
            int totalPagar = 0;
            for (Juego j : juegos) {
                datosJuegos[i][0] = (j.getNombre() == null) ? "no posee" : j.getNombre();
                datosJuegos[i][1] = "[" + clienteActual.getFecha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "]";
                datosJuegos[i][2] = antes || igual ? "En fecha" : "Posee retraso";
                totalPagar += j.getPrecio();
                i++;
            }

            totalPagar += (dias * 2); //MIRAR LUEGO :D
            canJuegos = juegos.size();
            totalPag = totalPagar;

            datosJuegos[i][0] = "Total a Pagar";
            datosJuegos[i][1] = "[" + totalPagar + "Gs.]";

            return datosJuegos;
        } else {
            JOptionPane.showMessageDialog(null, "Este cliente no tiene juegos para devolver");
        }
        Object[][] datos = new Object[10][10];
        return datos;

    }

    /**
     * Metodo que crea un panel con la tabla donde se mostraran los datos de los
     * juegos.
     *
     * @return panel con los datos de los juegos a devolver
     */
    public JPanel crearTabla() {
        JPanel panel = new JPanel(new BorderLayout());
        Object[] cabecera = {"Juego", "Fecha de alquiler", "Fecha de devolucion"};

        tabla = new JTable(obtenerDatos(), cabecera);
        tabla.setPreferredSize(new Dimension(1000, 1000));
        tabla.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tabla.setRowHeight(30);
        panel.setPreferredSize(new Dimension(1000, 1000));

        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
        return panel;
    }

    /**
     * Metodo que genera la cabecera y sus componentes.
     *
     * @return la cabecera de la ventana
     */
    public JPanel crearCabecera() {
        JPanel cabecera = new JPanel(new BorderLayout());
        JPanel pnlNorte = new JPanel();
        JPanel pnlSur = new JPanel();
        JLabel titulo = new JLabel("Devolver Juego");
        titulo.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 30));
        pnlNorte.add(titulo);
        pnlNorte.setBackground(Color.WHITE);

        JButton btnListaCliente = new JButton("Ver lista de clientes");

        JLabel txt1 = new JLabel("Cliente : ");
        JLabel txtCliente = new JLabel(clienteActual.toString());
        pnlSur.add(txt1).setFont(new Font("Tahoma", Font.CENTER_BASELINE, 22));
        pnlSur.add(txtCliente).setFont(new Font("Tahoma", Font.CENTER_BASELINE, 22));
        pnlSur.setBackground(Color.WHITE);

        cabecera.add(pnlNorte, BorderLayout.NORTH);
        cabecera.add(pnlSur, BorderLayout.SOUTH);
        /*
         */
        btnListaCliente.addActionListener(e -> {
            ClientesUI panelCrear = new ClientesUI(repoClientes.obtener());
        });

        return cabecera;
    }

    /**
     * Metodo que genera un panel de devolucion similar a un carrito con sus
     * componentes.
     *
     * @return el panel con los datos de los juegos a devolver.
     */
    public JPanel crearComponentes() {
        JPanel carrito = new JPanel(new BorderLayout());
        carrito.add(crearCabecera(), BorderLayout.NORTH);
        carrito.add(crearTabla(), BorderLayout.CENTER);
        JButton btnDevolver = new JButton("DEVOLVER");
        btnDevolver.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 28));
        carrito.add(btnDevolver, BorderLayout.SOUTH);

        btnDevolver.addActionListener(e -> {
            ArrayList<Juego> juegosDev = repoJuegos.obtener();
            for (int i = 0; i < juegos.size(); i++) {
                for (int j = 0; j < juegosDev.size(); j++) {
                    if (juegos.get(i).getNombre().equalsIgnoreCase(juegosDev.get(j).getNombre())) {
                        juegosDev.get(j).devJuego();
                    }
                }

            }
            clienteActual.setDeuda(false);
            clienteActual.setJuegos(new ArrayList<Juego>());

            repoClientes.borrar(clienteActual);
            repoClientes.guardar(clienteActual);
            repoJuegos.guardar(juegosDev);

            informe = new Informe(LocalDate.now());
            informe.setNumJuegAlqu(canJuegos);
            informe.setGanancias(totalPag);
            repoInf.guardar(informe);

            JOptionPane.showMessageDialog(null, "Se han devuelto los juegos con exito");
        });

        return carrito;
    }

    //atributos
    private ArrayList<Juego> juegos = null;
    private RepoJuegos repoJuegos = null;
    private RepoClientes repoClientes = null;
    private JTable tabla = null;
    private Cliente clienteActual = null;

    int canJuegos = 0;
    int totalPag = 0;

    private static Informe informe = null;

    private RepoInforme repoInf = new RepoInforme("./src/TxtRepositorios/TxTInforme.txt");

}
