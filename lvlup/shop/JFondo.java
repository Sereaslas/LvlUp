
package lvlup.shop;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Esta clase extiende de JPanel
 * Se utiliza para crear un panel que pueda tener como fondo una imagen
 * @author Marcos&&German
 */
public class JFondo extends JPanel {
    /**
     * El contructor cra un panel con el fondo de una imagen que se 
     * encuantra en la direccion name
     * @param name 
     */
    public JFondo(String name){
     this.name = name;    
    }
    /**
     * Este metodo pinta el panel con la imagen obtenida
     * @param g 
     */
    @Override
    public void paint(Graphics g){
        fondo = new ImageIcon("./src/images/"+name).getImage();
        g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
                
    }
    
    /*
    *Se definen las variables de clase
    */
    private Image fondo = null;
    private String name = null;
}
