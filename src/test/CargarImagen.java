/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author JC-PC
 */
public abstract class CargarImagen {

    private BufferedImage _image = null;
    private FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de Imagen", "jpg", "png");
    private URL obtener;

    public CargarImagen() {
    }

    public void cargar_imagen(URL _url) {
        try {
            _image = ImageIO.read(_url);
        } catch (IOException ex) {
            Logger.getLogger(CargarImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public BufferedImage Obtener_imagen_de_Buffer() {
        return _image;
    }

    public void Abrir_Dialogo(JPanel p) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                setObtener(fileChooser.getSelectedFile().toURL());
                URL url = fileChooser.getSelectedFile().toURL();
                cargar_imagen(url);
                p.add(new Panel(Obtener_imagen_de_Buffer(), p.getSize()) {
                });
                p.setVisible(true);
                p.repaint();
            } catch (IOException ex) {
                Logger.getLogger(CargarImagen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Mostrar(JPanel p) {
        try {
            URL url = getObtener();
            cargar_imagen(url);
            p.add(new Panel(Obtener_imagen_de_Buffer(), p.getSize()) {
            });
            p.setVisible(true);
            p.repaint();
        } catch (Exception ex) {
            Logger.getLogger(CargarImagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String ObtenerUrl() {
        return " " + getObtener() + " ";
    }

    public URL getObtener() {
        return obtener;
    }

    public void setObtener(URL obtener) {
        this.obtener = obtener;
    }
}
