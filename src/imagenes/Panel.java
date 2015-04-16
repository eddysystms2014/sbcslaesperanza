/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author JC-PC
 */
public abstract class Panel extends javax.swing.JPanel {

    BufferedImage _image;

    public Panel(BufferedImage imagen, Dimension d) {
        this._image = imagen;
        this.setSize(d);
    }

    @Override
    public void paint(Graphics g) {
        ImageIcon imagenFondo = new ImageIcon(_image);
        g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), null);
        setOpaque(false);
        super.paintComponent(g);
    }
}
