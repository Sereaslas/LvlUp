
package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import lvlup.shop.JFondo;
import lvlup.shop.Juego;
import repositorios.RepoClientes;
import repositorios.RepoJuegos;

/**
 * Esta clase modela la informacion de cada juego para mostrarla en una interfaz grafica
 * @author Marcos&&German
 */
public class JuegoUI extends JFrame{
    /**
     * Este constructor crea una ventana con toda la iformacion del juego que tiene como parametro
     * @param juego
     * @param juegos
     * @param clientes
     * @param ventana 
     */
    public JuegoUI(Juego juego, RepoJuegos juegos, RepoClientes clientes, VentanaPrincipal ventana){
        this.ventana = ventana;
        this.clientes = clientes;
        this.juegos = juegos;
        this.juego = juego;
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setSize(1000, 600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(panelCentral());
        
    }
    /**
     * Este metodo crea todo el panel de la ventana
     * y retorna un panel para ser añadido a la ventana
     * @return 
     */
    @SuppressWarnings("empty-statement")
    private JFondo panelCentral(){
        JFondo panel1 = new JFondo("FondoUI.png");
        JPanel panelCentro = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.setOpaque(false);
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setBackground(new Color(225, 225, 225));
        
        JLabel imagen = new JLabel();  
        imagen.setIcon(new ImageIcon("./src/images/"+juego.getNombre()+".png"));
        imagen.setOpaque(false);
        
        JLabel txtNombre = new JLabel("<html>"+juego.getNombre()+"<br> &nbsp </html>", JLabel.CENTER );
        txtNombre.setFont(new Font("Tahoma", Font.BOLD, 36));
        JLabel titulo = new JLabel("Descripcion :");
        JLabel txtDescripcion = new JLabel("<html>"+juego.getDescripcion()+"<br> &nbsp </html>");
        JLabel txtDesarrollador = new JLabel("<html> Desarrollador = "+juego.getDesarrollador()+"<br> &nbsp </html>");
        JLabel txtGenero = new JLabel("<html> Genero = "+juego.getGenero()+"<br> &nbsp </html>");
        JLabel txtConsola = new JLabel("<html> Consola = "+juego.getConsola()+"<br> &nbsp </html>");
        JLabel txtAño = new JLabel("<html> Año = "+juego.getAño()+"<br> &nbsp </html>");
        JLabel txtPrecio = new JLabel("<html> Precio = "+juego.getPrecio()+"<br> &nbsp </html>");
        
        JButton btnAlquilar = new JButton("<html> &nbsp &nbsp &nbsp ALQUILAR &nbsp &nbsp &nbsp</html>");
        btnAlquilar.setFont(new Font("Tahoma", Font.BOLD, 24));
        btnAlquilar.setBackground(new Color(225, 225, 225));
        btnAlquilar.setOpaque(true);
        btnAlquilar.setBorder(null);
        panel1.add(txtNombre, BorderLayout.NORTH);
        panelCentro.add(titulo).setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
        panelCentro.add(txtDescripcion).setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
        panelCentro.add(txtDesarrollador).setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
        panelCentro.add(txtGenero).setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
        panelCentro.add(txtConsola).setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
        panelCentro.add(txtAño).setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
        panelCentro.add(txtPrecio).setFont(new Font("Tahoma", Font.CENTER_BASELINE, 18));
        panel1.add(panelCentro);
        panel1.add(imagen, BorderLayout.WEST);
        panel1.add(btnAlquilar, BorderLayout.EAST);
        
        btnAlquilar.addActionListener(e ->{
            ArrayList<Juego> juegoAux = new ArrayList();
            juegoAux.add(juego);
        CarritoUI carrito = new CarritoUI(juegoAux, clientes, juegos, ventana);
        });
        return panel1;
    }
   
    
    /*
    *Se definen las variables de clase
    */
    private Juego juego = null;    
    private RepoJuegos juegos = null;
    private RepoClientes clientes = null;
    private VentanaPrincipal ventana = null;
}
