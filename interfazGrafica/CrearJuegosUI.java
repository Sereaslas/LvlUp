/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lvlup.shop.Juego;
import repositorios.RepoJuegos;

/**
 * Clase que representa una ventana para crear un juego.
 *
 * @author Marcos&&German
 */
public class CrearJuegosUI extends JFrame {

    /**
     * Constructor que crea la ventana, le da sus propiedades, le genera los
     * componentes y la hace visible.
     *
     * @param juegos repositorio de los juegos
     */
    public CrearJuegosUI(RepoJuegos juegos) {

        this.repoJuegos = juegos;
        setTitle("Añadir Juego");
        setBounds(250, 250, 800, 800);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBackground(Color.WHITE);
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(crearPanelFormulario(), BorderLayout.CENTER);
        panel.add(crearPanelBotones(), BorderLayout.SOUTH);
        getContentPane().add(crearPanelTitulo(), BorderLayout.NORTH);
        getContentPane().add(panel);
        this.setVisible(true);
        pack();
    }

    /**
     * Metodo que genera el panel titulo del panel.
     *
     * @return el panel del titulo.
     */
    private JPanel crearPanelTitulo() {
        JPanel panel = new JPanel();
        JLabel titulo = new JLabel("Añadir un nuevo Juego");
        titulo.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
        panel.add(titulo);
        panel.setBackground(Color.WHITE);

        return panel;
    }

    /**
     * Metodo que genera un panel con el formulario donde se ingresara la
     * informacion.
     *
     * @return el panel con el formulario
     */
    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new GridLayout(8, 2, 10, 10));

        txtNombre = new JTextField(25);
        txtGenero = new JTextField(25);
        txtConsola = new JTextField(25);
        txtDesarrollador = new JTextField(25);
        txtAño = new JTextField(25);
        txtCantidad = new JTextField(25);
        txtPrecio = new JTextField(25);
        txtDescripcion = new JTextField(25);

        JPanel pnlNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlNombre.add(txtNombre);
        JPanel pnlGenero = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlGenero.add(txtGenero);
        JPanel pnlConsola = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlConsola.add(txtConsola);
        JPanel pnlDesarrollador = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlDesarrollador.add(txtDesarrollador);
        JPanel pnlAño = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlAño.add(txtAño);
        JPanel pnlCantidad = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlCantidad.add(txtCantidad);
        JPanel pnlPortada = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlPortada.add(txtPrecio);
        JPanel pnlDescripcion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlDescripcion.add(txtDescripcion);

        JPanel pnlLblNombre = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlLblNombre.add(new JLabel("Nombre:"));
        JPanel pnlLblGenero = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlLblGenero.add(new JLabel("Genero:"));
        JPanel pnlLblConsola = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlLblConsola.add(new JLabel("Consola:"));
        JPanel pnlLblDesarrollador = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlLblDesarrollador.add(new JLabel("Desarrollador:"));
        JPanel pnlLblAño = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlLblAño.add(new JLabel("Año:"));
        JPanel pnlLblCantidad = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlLblCantidad.add(new JLabel("Cantidad:"));
        JPanel pnlLblPortada = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlLblPortada.add(new JLabel("Precio:"));
        JPanel pnlLblDescripcion = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlLblDescripcion.add(new JLabel("Descripcion:"));

        JPanel[] paneles = {pnlLblNombre, pnlNombre, pnlLblGenero, pnlGenero, pnlLblConsola, pnlConsola, pnlLblDesarrollador,
            pnlDesarrollador, pnlLblAño, pnlAño, pnlLblCantidad, pnlCantidad, pnlPortada, pnlLblPortada, pnlPortada, pnlLblDescripcion, pnlDescripcion};
        for (JPanel p : paneles) {
            p.setBackground(Color.WHITE);
            panel.add(p);
        }

        panel.setBackground(Color.WHITE);
        return panel;
    }

    /**
     * Metodo que genera un panel con los botones inferiores.
     *
     * @return el panel con los bonotes inferiores.
     */
    private JPanel crearPanelBotones() {
        JFrame frame = this;
        JPanel panel = new JPanel();

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener((ActionEvent e) -> {
            // Leer los valores de los campos de texto
            // Crear una instancia de la clase Juego
            // Guardar la instancia creada en el repositorio
            // Notificar al usuario acerca del exito o fracaso de la operacion

            try {
                String nombre = txtNombre.getText();
                String genero = txtGenero.getText();
                String consola = txtConsola.getText();
                String desarrollador = txtDesarrollador.getText();
                int año = (Integer.parseInt(txtAño.getText()));
                int cantidad = Integer.parseInt(txtCantidad.getText());
                int precio = Integer.parseInt((txtPrecio.getText()));
                String descripcion = txtDescripcion.getText();

                Juego j1 = new Juego(nombre, genero, consola, desarrollador, año, cantidad, precio, descripcion);
                repoJuegos.guardar(j1);
                txtNombre.setText("");
                txtGenero.setText("");
                txtConsola.setText("");
                txtDesarrollador.setText("");
                txtAño.setText("");
                txtCantidad.setText("");
                txtPrecio.setText("");
                txtDescripcion.setText("");
                JOptionPane.showMessageDialog(null, "El juego se a guardado exitosamente!", "Exito!!", JOptionPane.INFORMATION_MESSAGE/*, JOptionPane.ERROR_MESSAGE*/);

            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Error inesperado cambiar");
            } catch (NumberFormatException ex2) {
                JOptionPane.showMessageDialog(null, "Verificar (Cantidad)-(Precio)-(Año), deben ser valores numericos");
            }
        });

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener((e) -> {
            // Salir, cerrar ventana sin guardar cambios
            frame.dispose();
        });
        panel.add(btnGuardar);
        panel.add(btnSalir);
        panel.setBackground(Color.WHITE);
        return panel;
    }

    //atributos de la clase 
    private RepoJuegos repoJuegos = null;
    private JTextField txtConsola = null;
    private JTextField txtGenero = null;
    private JTextField txtNombre = null;
    private JTextField txtDesarrollador = null;
    private JTextField txtAño = null;
    private JTextField txtCantidad = null;
    private JTextField txtPrecio = null;
    private JTextField txtDescripcion = null;

}
