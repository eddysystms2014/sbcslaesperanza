/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import modelo.dao.MedicoJpaController;
import modelo.dao.UsuarioJpaController;
import modelo.entidades.Usuario;

/**
 *
 * @author JC-PC
 */
public class ControlUsuario {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SBCSLaEsperanzaPU");
    private UsuarioJpaController usuarioJpacontrolador = new UsuarioJpaController(emf);

    public Usuario buscarRol(String nombreUsuario, String pasword) {

        for (Usuario usu : usuarioJpacontrolador.findUsuarioEntities()) {
            if (usu.getNombreusuario().equals(nombreUsuario) && usu.getContrasena().equals(pasword)) {
                return usu;
            }
        }
        return null;
    }

    public Usuario Validar_Usuario(String usuario, String password) {
        Usuario BuscarUsu = buscarRol(usuario, password);
        if (BuscarUsu == null) {
            JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta!.",
                    "Error de Auntetificación", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        if (BuscarUsu.getContrasena().equals(password) && BuscarUsu.getNombreusuario().equals(usuario)
                && BuscarUsu.getEstadousuario().equals("SI")) {
            return BuscarUsu;
        }
        if (BuscarUsu.getContrasena().equals(password) && BuscarUsu.getNombreusuario().equals(usuario)
                && BuscarUsu.getEstadousuario().equals("NO")) {
            JOptionPane.showMessageDialog(null, "Usuario Inactivo",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return null;
    }

}
