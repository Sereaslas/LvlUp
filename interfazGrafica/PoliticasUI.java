/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lvlup.shop.JFondo;
import lvlup.shop.Politicas;
import repositorios.RepoPoliticas;

/**
 *
 * @author marco
 */
public class PoliticasUI extends JFrame {

    /**
     * Constructor que crea la ventana, le da sus propiedades, le genera los
     * componentes y la hace visible.
     */
    public PoliticasUI() {
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(crearPanel());
        this.setVisible(true);
    }

    /**
     * Metodo que genera el panel con los componentes de la ventana.
     *
     * @return panel con los componentes de la ventana
     */
    public JPanel crearPanel() {
        JPanel panel1 = new JPanel();

        panel1.setLayout(new BorderLayout());
        panel1.setOpaque(false);

        JLabel txtNombre = new JLabel("<html> Politicas de la empresa : <br> &nbsp </html>", JLabel.CENTER);
        txtNombre.setFont(new Font("Tahoma", Font.BOLD, 36));

        actualizarPanel();

        JButton btnModificar = new JButton("<html> <br> &nbsp MODIFICAR &nbsp <br> &nbsp </html>");
        btnModificar.setFont(new Font("Tahoma", Font.BOLD, 32));
        btnModificar.setBackground(new Color(225, 225, 225));
        btnModificar.setOpaque(true);
        btnModificar.setBorder(null);

        JButton btnRestablecer = new JButton("<html> <br> &nbsp Restablecer &nbsp <br> &nbsp Politicas <br>  &nbsp  </html>");
        btnRestablecer.setFont(new Font("Tahoma", Font.BOLD, 24));
        btnRestablecer.setBackground(new Color(225, 225, 225));
        btnRestablecer.setOpaque(true);
        btnRestablecer.setBorder(null);

        JPanel btns = new JPanel();
        JLabel txt = new JLabel("<html> <br> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp </html>");

        btns.add(btnModificar);
        btns.add(btnRestablecer);

        panel1.add(txtNombre, BorderLayout.NORTH);
        panel1.add(pnlPols);
        panel1.add(btns, BorderLayout.SOUTH);
        panel1.add(txt, BorderLayout.EAST);
        panel1.add(txt, BorderLayout.WEST);

        btnModificar.addActionListener(e -> {
            ModificarPoliticasUI modPols = new ModificarPoliticasUI(repoPol, this);
            this.dispose();
        });
        btnRestablecer.addActionListener(e -> {
            repoPol.restabablecerPols();
            this.dispose();
            PoliticasUI neoPolUi = new PoliticasUI();
        });

        return panel1;
    }

    /**
     * Metodo que actualiza la tabla.
     */
    public void actualizarPanel() {
        politica = repoPol.obtener().get(0);
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setBackground(new Color(225, 225, 225));
        for (String pol : politica.getListaPol()) {
            JLabel txtPol = new JLabel("<html>" + pol + "<br> &nbsp </html>");
            panelCentro.add(txtPol).setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));;
            txtPol.updateUI();
        }
        pnlPols = panelCentro;
    }

    //atributos
    private RepoPoliticas repoPol = new RepoPoliticas("./src/TxtRepositorios/TxTPoliticas.txt");
    private Politicas politica = repoPol.obtener().get(0);
    private JPanel pnlPols = null;
}
