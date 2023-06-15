/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
 * Clase que representa la ventana para modificar un cliente.
 *
 * @author Marcos&&German
 */
public class ModificarClienteUI extends JFrame {

    /**
     * Constructor que crea la ventana, le da sus propiedades, le genera los
     * componentes y la hace visible.
     *
     * @param clientes repositorio de clientes
     */
    public ModificarClienteUI(RepoClientes clientes) {

        this.clientesList = clientes.obtener();
        this.repoClientes = clientes;
        setTitle("Modificar Cliente");
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
        JPanel panel = new JPanel(new BorderLayout());
        JPanel cabecera = new JPanel(new BorderLayout());
        JLabel titulo = new JLabel("Modificar a un Cliente", (int) Component.CENTER_ALIGNMENT);
        titulo.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
        JLabel lblModificar = new JLabel("Modificar aqui al Cliente", (int) Component.CENTER_ALIGNMENT);
        lblModificar.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
        JPanel pnlBuscador = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel lblCliente = new JLabel("Cliente :");
        JButton btnBuscar = new JButton("Buscar");
        this.txtBuscador = new JTextField(25);
        pnlBuscador.add(lblCliente);
        pnlBuscador.add(txtBuscador);
        pnlBuscador.add(btnBuscar);
        cabecera.add(pnlBuscador, BorderLayout.NORTH);
        cabecera.add(lblModificar, BorderLayout.SOUTH);
        panel.add(titulo, BorderLayout.NORTH);
        panel.add(cabecera, BorderLayout.SOUTH);
        panel.setBackground(Color.WHITE);
        pnlBuscador.setBackground(Color.WHITE);
        cabecera.setBackground(Color.WHITE);
        btnBuscar.addActionListener((ActionEvent e) -> {
            clientesList = repoClientes.obtener();
            for (Cliente c : clientesList) {
                if (c.getNombreApellido().equalsIgnoreCase(txtBuscador.getText())
                        || c.getcIdentidad().equals(txtBuscador.getText())) {
                    txtNombre.setText(c.getNombreApellido());
                    txtCedula.setText(c.getcIdentidad());
                    txtEmail.setText(c.getEmail());
                    clienteModificar = c;
                    break;
                }
            }
            if (clienteModificar == null) {
                JOptionPane.showMessageDialog(null, "El cliente no existe", "Error!!", JOptionPane.ERROR_MESSAGE);
            }

        });

        return panel;
    }

    /**
     * Metodo que genera un panel con el formulario donde se mostrara la
     * informacion a ser modificada.
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

        JButton btnModificar = new JButton("Modificar");
        btnModificar.addActionListener((ActionEvent e) -> {
            // Leer los valores de los campos de texto
            // Borrar al cliente de la lista en el repositorio
            // Notificar al usuario acerca del exito o fracaso de la operacion

            try {
                if (clienteModificar != null) {
                    clientesList.remove(clienteModificar);
                    repoClientes.guardar(clientesList);

                    String nombre = txtNombre.getText();
                    String dir = txtCedula.getText();
                    String email = txtEmail.getText();
                    Cliente c1 = new Cliente(nombre, dir, email);
                    repoClientes.guardar(c1);
                    txtBuscador.setText("");
                    txtNombre.setText("");
                    txtCedula.setText("");
                    txtEmail.setText("");
                    clienteModificar = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Busque al cliente que desea Modificar", "Error!!", JOptionPane.ERROR_MESSAGE);
                }

                JOptionPane.showMessageDialog(null, "El cliente se a modificado exitosamente!", "Exito!!", JOptionPane.INFORMATION_MESSAGE);

            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Error inesperado");
            }
        });

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener((e) -> {
            // Salir, cerrar ventana sin guardar cambios
            frame.dispose();
        });
        panel.add(btnModificar);
        panel.add(btnSalir);
        panel.setBackground(Color.WHITE);
        return panel;
    }
    
    //atributos de la clase 
    private ArrayList<Cliente> clientesList = null;
    private RepoClientes repoClientes = null;
    private Cliente clienteModificar = null;
    private JTextField txtEmail = null;
    private JTextField txtCedula = null;
    private JTextField txtNombre = null;
    private JTextField txtBuscador = null;

}
