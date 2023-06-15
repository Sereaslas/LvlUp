/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.StyleConstants;
import lvlup.shop.JFondo;
import lvlup.shop.Juego;
import repositorios.RepoClientes;
import repositorios.RepoJuegos;

/**
 * Clase que crea la etiqueta de juego para ser procesada y mostrada.
 *
 * @author Marcos&&German
 */
public class EtiquetaJuegoUI {

    /**
     * Constructor de la etiqueta.
     *
     * @param juego el juego del que se hara la etiqueta
     * @param juegosCliente juegos del cliente
     * @param juegos el repositorio de juegos
     * @param clientes el repositorio de clientes
     * @param ventana la ventana principal
     */
    public EtiquetaJuegoUI(Juego juego, ArrayList juegosCliente, RepoJuegos juegos, RepoClientes clientes, VentanaPrincipal ventana) {
        this.ventana = ventana;
        this.juegos = juegos;
        this.clientes = clientes;
        this.juego = juego;
        this.juegosParaCliente = juegosCliente;
    }

    /**
     * Metodo que genera la etiqueta.
     *
     * @param contador contador que lleva el numero de juegos en el carrito
     * @return
     */
    public JPanel getEtiqueta(JLabel contador) {
        JFondo etiqueta = new JFondo(juego.getNombre() + ".png");
        JPanel panel = new JPanel();
        etiqueta.setSize(450, 550);
        etiqueta.setPreferredSize(new Dimension(250, 300));
        JButton btnAlqui = new JButton("|Alquilar||Info|");
        JButton carrito = new JButton("");
        carrito.setIcon(new ImageIcon("./src/images/carritoMas.png"));
        carrito.setOpaque(false);
        etiqueta.setLayout(new BorderLayout());
        panel.setOpaque(false);
        panel.add(btnAlqui).setBackground(Color.WHITE);
        panel.add(carrito).setBackground(Color.WHITE);
        etiqueta.add(panel, BorderLayout.SOUTH);
        carrito.addActionListener(e -> {
            carrito.setIcon(new ImageIcon("./src/images/carrito.png"));
            juegosParaCliente.add(juego);
            contador.setText("" + juegosParaCliente.size());
        });

        btnAlqui.addActionListener(e -> {
            JuegoUI infoJuego = new JuegoUI(juego, juegos, clientes, ventana);

        });

        return etiqueta;
    }

    //atributos
    private Juego juego = null;
    private ArrayList juegosParaCliente = null;
    private RepoJuegos juegos = null;
    private RepoClientes clientes = null;
    private VentanaPrincipal ventana = null;
}
