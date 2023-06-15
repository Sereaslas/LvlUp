
package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lvlup.shop.Politicas;
import repositorios.RepoPoliticas;

/**
 * Esta clase crea una ventana que se encarga de modificar las politicas de la tienda
 * @author Marcos&&German
 */
public class ModificarPoliticasUI extends JFrame {
    /**
     * Este constructor se encarga de crear una ventana que permite modicar las policas que se desee
     * @param politicas
     * @param polUI 
     */
    public ModificarPoliticasUI(RepoPoliticas politicas, PoliticasUI polUI) {
        this.repoPoliticas = politicas;
        this.polUI = polUI;
        setTitle("Modificar Politicas");
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
     * Este metodo se encarga de crear un panel que incluira el titulo y la parte uperiorde la ventana
     * @return 
     */
    private JPanel crearPanelTitulo() {
        JPanel panel = new JPanel();
        JLabel titulo = new JLabel("Modificar Politicas");
        titulo.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
        panel.add(titulo);
        panel.setBackground(Color.WHITE);

        return panel;
    }
    
    /**
     * Este metodo crear y devuelve un panel con los componentes donde se pueden ingresar 
     * los nuevos datos de las policas que se desean modificar
     * @return 
     */
    private JPanel crearPanelFormulario() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));

        txtPrecio = new JTextField(25);
        txtRetraso = new JTextField(25);
        txtNuevo = new JTextField(25);

        JPanel pnlNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlNombre.add(txtPrecio);
        pnlNombre.setBackground(Color.WHITE);
        JPanel pnlCedula = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlCedula.add(txtRetraso);
        pnlCedula.setBackground(Color.WHITE);

        JPanel pnlEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlEmail.add(txtNuevo);
        pnlEmail.setBackground(Color.WHITE);;

        JPanel pnlLblPrecio = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlLblPrecio.add(new JLabel("Precio por dia:"));
        pnlLblPrecio.setBackground(Color.WHITE);

        JPanel pnlLblRetraso = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlLblRetraso.add(new JLabel("Multa por retraso:"));
        pnlLblRetraso.setBackground(Color.WHITE);

        JPanel pnlLblNuevo = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnlLblNuevo.add(new JLabel("Nuevo:"));
        pnlLblNuevo.setBackground(Color.WHITE);

        panel.add(pnlLblPrecio);
        panel.add(pnlNombre);

        panel.add(pnlLblRetraso);
        panel.add(pnlCedula);

        panel.add(pnlLblNuevo);
        panel.add(pnlEmail);
        panel.setBackground(Color.WHITE);
        return panel;
    }

    /**
     * Este metodo crea y devuelve un panel donde se encuentran los botones
     * para poder guardar los datos ingresados
     * @return
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
                String precio = txtPrecio.getText().trim();
                String retraso = txtRetraso.getText().trim();
                String nuevo = txtNuevo.getText().trim();

                Politicas politics = repoPoliticas.obtener().get(0);
                if (!precio.equals("")) {
                    politics.setCostoDia(Integer.parseInt(precio));
                }
                if (!retraso.equals("")) {
                    politics.setCostoRetraso(Integer.parseInt(retraso));
                }

                if (!nuevo.equals("")) {
                    politics.agregarPolitica(nuevo);
                }

                repoPoliticas.guardar(politics);

                txtPrecio.setText("");
                txtRetraso.setText("");
                txtNuevo.setText("");

                PoliticasUI neoPolUi = new PoliticasUI();

                JOptionPane.showMessageDialog(null, "Las politicas han sido modificadas exitosamente!", "Exito!!", JOptionPane.INFORMATION_MESSAGE/*, JOptionPane.ERROR_MESSAGE*/);

            } catch (HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "Error inesperado");
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Error: Valor no numerico ingresado");
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

    
    /*
    *Se definen las variables de clase
    */
    private RepoPoliticas repoPoliticas = null;
    private JTextField txtNuevo = null;
    private JTextField txtRetraso = null;
    private JTextField txtPrecio = null;
    private PoliticasUI polUI = null;
}
