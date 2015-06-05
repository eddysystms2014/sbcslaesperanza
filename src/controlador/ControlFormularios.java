/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.beans.PropertyVetoException;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;
import vista.VistaPrincipal;

/**
 *
 * @author JC-PC
 */
public class ControlFormularios {

    public void ControlaInstancia(JInternalFrame inter) {

        boolean mostrar = true;
        String Nombre = inter.getTitle();
        for (int a = 0; a < VistaPrincipal.jDesktopPane1.getComponentCount(); a++) {
            if (inter.getClass().isInstance(VistaPrincipal.jDesktopPane1.getComponent(a))) {
                VistaPrincipal.jDesktopPane1.moveToFront(inter);
                inter.toFront();
                mostrar = false;

            } 
        }
        if (mostrar) {
            VistaPrincipal.jDesktopPane1.add(inter);

        }
        inter.show();
        
    }

    
}
