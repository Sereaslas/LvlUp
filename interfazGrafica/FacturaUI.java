/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import lvlup.shop.Cliente;
import lvlup.shop.Juego;

/**
 * Metodo que genera una ventana con la factura de alquiler.
 *
 * @author Marcos&&German
 */
public class FacturaUI extends JFrame {

    /**
     * Constructor que crea la ventana, le da sus propiedades, le genera los
     * componentes y la hace visible.
     *
     * @param c cliente que recibira la factura
     * @param juegos lista de juegos de la factura
     * @param dias numero de dias de alquiler de juegos
     */
    public FacturaUI(Cliente c, ArrayList<Juego> juegos, int dias) {
        this.cliente = c;
        this.juegos = juegos;
        this.dias = dias;
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(1000, 750);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(crearPanel());
        this.setVisible(true);
    }

    /**
     * Metodo que genera todos componentes de la factura.
     *
     * @return un panel con dichos componentes
     */
    public JPanel crearPanel() {
        JPanel panel1 = new JPanel();

        panel1.setLayout(new BorderLayout());
        panel1.setOpaque(false);

        JLabel txtNombre = new JLabel("<html> Factura : <br> &nbsp </html>", JLabel.CENTER);
        txtNombre.setFont(new Font("Tahoma", Font.BOLD, 36));

        JLabel txtDerecha = new JLabel("<html> <br> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp </html>");

        JButton btnSalir = new JButton("<html> <br> &nbsp Volver a la tienda &nbsp <br> &nbsp </html>");
        btnSalir.setFont(new Font("Tahoma", Font.BOLD, 28));
        btnSalir.setBackground(new Color(225, 225, 225));
        btnSalir.setOpaque(true);
        btnSalir.setBorder(null);

        panel1.add(txtNombre, BorderLayout.NORTH);
        panel1.add(generarDatos(), BorderLayout.CENTER);
        panel1.add(btnSalir, BorderLayout.SOUTH);
        panel1.add(txtDerecha, BorderLayout.EAST);
        panel1.add(txtDerecha, BorderLayout.WEST);

        btnSalir.addActionListener(e -> {
            VentanaPrincipal nuevaVentana = new VentanaPrincipal();
            this.dispose();
        });

        return panel1;
    }

    /**
     * Metodo que toma los datos, los procesa y los devuelve en forma de panel.
     * 
     * @return panel con los datos.
     */
    public JPanel generarDatos() {
        int total = 0;
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setBackground(new Color(225, 225, 225));

        String uno = "<html> Nombre de : " + cliente.toString() + " <br> &nbsp </html>";
        String dos = "<html> Fecha : " + cliente.getFecha().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + " <br> &nbsp  </html> ";
        String tres = "<html> Juegos a alquilar : <br> &nbsp </html>";

        JLabel txtNombre = new JLabel(uno);
        JLabel txtFecha = new JLabel(dos);
        JLabel txtJuegos = new JLabel(tres);

        txtNombre.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 22));
        txtFecha.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 22));
        txtJuegos.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 22));

        txtNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtFecha.setAlignmentX(Component.CENTER_ALIGNMENT);
        txtJuegos.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelCentro.add(txtNombre);
        panelCentro.add(txtFecha);
        panelCentro.add(txtJuegos);

        for (Juego j : juegos) {
            JLabel txtJ = new JLabel("+ " + j.getNombre());
            txtJ.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 22));
            panelCentro.add(txtJ);
            total += j.getPrecio();
        }

        total *= dias;

        JLabel txtTotal = new JLabel("<html> <br> Total a pagar: " + total + " Gs.  </html>");
        panelCentro.add(txtTotal).setFont(new Font("Tahoma", Font.CENTER_BASELINE, 28));

        return panelCentro;
    }

    //atributos
    private Cliente cliente = null;
    private ArrayList<Juego> juegos = null;
    private int dias = 1;
}
