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
import lvlup.shop.Cliente;
import repositorios.RepoClientes;

/**
 * Clase que representa una ventana para crear un cliente.
 *
 * @author Marcos&&German
 */
public class CrearClienteUI extends JFrame {

    /**
     * Constructor que crea la ventana, le da sus propiedades, le genera los
     * componentes y la hace visible.
     *
     * @param clientes repositorio de los clientes
     */
    public CrearClienteUI(RepoClientes clientes) {

        this.repoClientes = clientes;
        setTitle("Crear Cliente");
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
        JLabel titulo = new JLabel("Crear un nuevo Cliente");
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
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        txtNombre = new JTextField(25);
        txtCedula = new JTextField(25);
        txtEmail = new JTextField(25);

        JPanel pnlNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlNombre.add(txtNombre);
        pnlNombre.setBackground(Color.WHITE);
        JPanel pnlCedula = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlCedula.add(txtCedula);
        pnlCedula.setBackground(Color.WHITE);

        JPanel pnlEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlEmail.add(txtEmail);
        pnlEmail.setBackground(Color.WHITE);;

        JPanel pnlLblNombre = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlLblNombre.add(new JLabel("Nombre y Apellido:"));
        pnlLblNombre.setBackground(Color.WHITE);

        JPanel pnlLblCedula = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlLblCedula.add(new JLabel("N° de Cedula:"));
        pnlLblCedula.setBackground(Color.WHITE);
        JPanel pnlLblEmail = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlLblEmail.add(new JLabel("Email:"));
        pnlLblEmail.setBackground(Color.WHITE);

        panel.add(pnlLblNombre);
        panel.add(pnlNombre);

        panel.add(pnlLblCedula);
        panel.add(pnlCedula);

        panel.add(pnlLblEmail);
        panel.add(pnlEmail);
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
            // Crear una instancia de la clase Persona
            // Guardar la instancia creada en el repositorio
            // Notificar al usuario acerca del exito o fracaso de la operacion

            try {
                String nombre = txtNombre.getText();
                String dir = txtCedula.getText();
                String email = txtEmail.getText();

                clienteNuevo = new Cliente(nombre, dir, email);
                repoClientes.guardar(clienteNuevo);
                txtNombre.setText("");
                txtCedula.setText("");
                txtEmail.setText("");
                JOptionPane.showMessageDialog(null, "Persona ha sido guardada exitosamente!", "Exito!!", JOptionPane.INFORMATION_MESSAGE/*, JOptionPane.ERROR_MESSAGE*/);

            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Error inesperado");
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
    private RepoClientes repoClientes = null;
    private JTextField txtEmail = null;
    private JTextField txtCedula = null;
    private JTextField txtNombre = null;
    private Cliente clienteNuevo = null;

}
