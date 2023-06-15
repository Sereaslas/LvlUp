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
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import lvlup.shop.Cliente;
import lvlup.shop.Informe;
import lvlup.shop.Juego;
import repositorios.RepoClientes;
import repositorios.RepoInforme;
import repositorios.RepoJuegos;

/**
 * Ventana que representa el carrito de compras. Aqui es donde se procesa la
 * informacion previo al alquiler de juegos.
 *
 * @author Marcos&&German
 */
public class CarritoUI extends JFrame {

    /**
     * Constructor que crea la ventana, le da sus propiedades, le genera los
     * componentes y la hace visible.
     *
     * @param juegos lista con los juegos a ser alquilados
     * @param clientes repositorio de clientes
     * @param repoJuegos repositorio de juegos
     * @param ventana ventana principal
     */
    public CarritoUI(ArrayList juegos, RepoClientes clientes, RepoJuegos repoJuegos, VentanaPrincipal ventana) {
        this.ventana = ventana;
        this.juegos = juegos;
        this.clientes = clientes;
        this.repoJuegos = repoJuegos;
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setResizable(false);
        this.setBackground(Color.WHITE);
        this.setLocationRelativeTo(null);
        crearCarrito();
        this.setVisible(true);
    }

    /**
     * Metodo que obtiene los datos de los juegos y los procesa para ingresarlos
     * en la tabla.
     *
     * @return matriz de objetos con lo datos de los juegos y precios
     */
    public Object[][] obtenerDatos() {
        Object[][] datosJuegos = new Object[juegos.size() + 1][10];
        int i = 0;
        totalPagar = 0;
        for (Juego j : juegos) {
            datosJuegos[i][0] = (j.getNombre() == null) ? "no posee" : j.getNombre();
            datosJuegos[i][1] = "[" + j.getPrecio() + "Gs.]";
            i++;
            totalPagar = totalPagar + j.getPrecio();
        }

        totalPagar = totalPagar * cantDias;
        datosJuegos[i][0] = "Total a Pagar";
        datosJuegos[i][1] = "[" + totalPagar + "Gs.]";

        //}       
        return datosJuegos;
    }

    /**
     * Metodo que crea un panel con la tabla donde se mostraran los datos del
     * carrito.
     *
     * @return panel con los datos del carrito (del alquiler)
     */
    public JPanel crearTabla() {
        JPanel panel = new JPanel(new BorderLayout());
        tabla = new JTable(obtenerDatos(), cabecera);
        tabla.setModel(new DefaultTableModel(obtenerDatos(), cabecera));
        tabla.setPreferredSize(new Dimension(1000, 1000));
        tabla.setFont(new Font("Tahoma", Font.PLAIN, 20));
        tabla.setRowHeight(30);
        panel.setPreferredSize(new Dimension(1000, 1000));

        ////        
        TableColumn tc = tabla.getColumnModel().getColumn(2);
        tc.setCellEditor(tabla.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));

        ////
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
        return panel;
    }

    /**
     * Metodo que comprueba si una fila fue seleccionada en la tabla.
     *
     * @param row fila a comprobar
     * @param tabla tabla de la fila
     * @return true si fue seleccionada, false si no
     */
    public boolean seleccionado(int row, JTable tabla) {
        return tabla.getValueAt(row, 2) != null;

    }

    /**
     * Metodo que genera la cabecera y sus componentes.
     *
     * @return la cabecera de la ventana
     */
    public JPanel crearCabecera() {
        JPanel cabecera = new JPanel(new BorderLayout());
        JPanel pnlNorte = new JPanel();
        JPanel pnlCentral = new JPanel();
        JPanel pnlSur = new JPanel(new BorderLayout());
        JPanel pnl1 = new JPanel();
        JPanel pnl2 = new JPanel();
        JLabel titulo = new JLabel("Carrito De Compras");
        titulo.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 28));
        pnlNorte.add(titulo);
        pnlNorte.setBackground(Color.WHITE);

        JButton btnSeleccionarCliente = new JButton("Buscar");
        JTextField buscarCliente = new JTextField("Buscar un cliente existente ", 20);
        JButton btnCrearCliente = new JButton("Crear nuevo cliente");
        JButton btnListaCliente = new JButton("Ver lista de clientes");
        pnlCentral.add(btnSeleccionarCliente).setBackground(new Color(200, 200, 200));;
        pnlCentral.add(buscarCliente);
        pnlCentral.add(btnCrearCliente).setBackground(new Color(200, 200, 200));;
        pnlCentral.add(btnListaCliente).setBackground(new Color(200, 200, 200));;
        pnlCentral.setBackground(Color.WHITE);

        JLabel txt1 = new JLabel("Cliente : ");
        JLabel txtCliente = new JLabel("Seleccione un Cliente");
        pnl1.add(txt1).setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
        pnl1.add(txtCliente).setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
        pnl1.setBackground(Color.WHITE);

        JLabel txtCant = new JLabel("Cantidad de dias a alquilar = ");
        JTextField textCant = new JTextField("1", 4);
        JButton btnAceptar = new JButton("OK");
        btnAceptar.setBackground(new Color(200, 200, 200));
        pnl2.add(txtCant).setFont(new Font("Tahoma", Font.CENTER_BASELINE, 16));
        pnl2.add(textCant).setFont(new Font("Tahoma", Font.CENTER_BASELINE, 16));
        pnl2.add(btnAceptar).setFont(new Font("Tahoma", Font.CENTER_BASELINE, 16));
        pnl2.setBackground(Color.WHITE);

        pnlSur.add(pnl1, BorderLayout.NORTH);
        pnlSur.add(pnl2, BorderLayout.SOUTH);
        pnlSur.setBackground(Color.WHITE);

        cabecera.add(pnlNorte, BorderLayout.NORTH);
        cabecera.add(pnlCentral, BorderLayout.CENTER);
        cabecera.add(pnlSur, BorderLayout.SOUTH);

        btnSeleccionarCliente.addActionListener(e -> {
            String nombre = buscarCliente.getText().trim();
            clienteActual = null;
            txtCliente.setText("Buscar un cliente para seleccionar");
            ArrayList<Cliente> clientesLista = clientes.obtener();
            for (Cliente c : clientesLista) {
                if (nombre.equalsIgnoreCase(c.getNombreApellido()) || nombre.equalsIgnoreCase(c.getcIdentidad())) {
                    if (c.getDeuda()) {
                        JOptionPane.showMessageDialog(null, "No se ah podido alquilar el juego, verificar deudas del cliente");
                    } else {
                        txtCliente.setText(c.toString());
                        clienteActual = c;
                    }
                }
            }
            if (clienteActual == null) {
                JOptionPane.showMessageDialog(null, "No se ah encontrado cliente");
            }
        });

        btnCrearCliente.addActionListener(e -> {
            CrearClienteUI panelCrear = new CrearClienteUI(clientes);
        });

        btnListaCliente.addActionListener(e -> {
            ClientesUI panelCrear = new ClientesUI(clientes.obtener());
        });

        btnAceptar.addActionListener(e -> {
            cantDias = (int) Integer.parseInt(textCant.getText().trim());
            refrescarTabla();

        });

        return cabecera;
    }

    /**
     * Metodo que crea el carrito.
     */
    public void crearCarrito() {
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(crearCabecera(), BorderLayout.NORTH);
        this.getContentPane().add(crearTabla(), BorderLayout.CENTER);
        JButton btnAlquilar = new JButton("ALQUILAR");
        btnAlquilar.setBackground(new Color(200, 200, 200));
        btnAlquilar.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 28));
        this.getContentPane().add(btnAlquilar, BorderLayout.SOUTH);

        btnAlquilar.addActionListener((e) -> {
            Juego juegoAlqui = null;
            if (clienteActual != null) {
                for (int i = 0; i < juegos.size(); i++) {
                    if (seleccionado(i, tabla) && juegos.get(i).isDisponible()) {
                        juegoAlqui = juegos.get(i);
                        juegoAlqui.restarCant();
                        clienteActual.addJuego(juegoAlqui);                       
                        repoJuegos.guardar(juegoAlqui);
                    }
                }
                LocalDate hoy = LocalDate.now();

                clienteActual.setFecha(hoy);
                clienteActual.setFechaDevol(hoy.plus(cantDias, ChronoUnit.DAYS));

                clientes.borrar(clienteActual);
                clienteActual.setDeuda(true);
                clientes.guardar(clienteActual);
                canVentas++;

                FacturaUI factura = new FacturaUI(clienteActual, generarListJuegos(juegos), cantDias);
                ventana.dispose();
                informe = new Informe(hoy);
                informe.setNumTran(canVentas);

                repoInf.guardar(informe);
                dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione un cliente para realizar el pedido");

            }
        });

    }

    /**
     * Metodo que actualiza la tabla.
     */
    public void refrescarTabla() {
        System.out.println(tabla.getModel());

        tabla.setModel(new DefaultTableModel(obtenerDatos(), cabecera));

        DefaultTableModel tableModel = ((DefaultTableModel) tabla.getModel());

        //tableModel.getDataVector().remove(juegos.size());
        tableModel.fireTableDataChanged();

        TableColumn tc = tabla.getColumnModel().getColumn(2);
        tc.setCellEditor(tabla.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(tabla.getDefaultRenderer(Boolean.class));

        tableModel.fireTableDataChanged();
    }

    /**
     * Metodo que genera la lista de juegos seleccionados
     *
     * @param juegos lista completa de juegos
     * @return lista de los juegos seleccionados
     */
    public ArrayList<Juego> generarListJuegos(ArrayList<Juego> juegos) {

        ArrayList<Juego> juegosAlq = new ArrayList();

        for (int i = 0; i < juegos.size(); i++) {
            if (seleccionado(i, tabla)) {
                juegosAlq.add(juegos.get(i));
                System.out.println("+" + juegos.get(i).getNombre());
            }
        }

        return juegosAlq;
    }

    //getter
    public static int getCanVentas() {
        return canVentas;
    }

    //atributos
    private ArrayList<Juego> juegos = null;
    private RepoClientes clientes = null;
    private RepoJuegos repoJuegos = null;
    private VentanaPrincipal ventana = null;
    private JTable tabla = null;
    private Cliente clienteActual = null;
    private int cantDias = 1;
    private static int canVentas = 0;
    private static int canJuegos = 0;
    private static Informe informe = null;
    private int totalPagar = 0;
    private Object[] cabecera = {"Juego", "Precio", "Confirmar alquiler"};

    private RepoInforme repoInf = new RepoInforme("./src/TxtRepositorios/TxTInforme.txt");

}
