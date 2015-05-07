/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.dao.MedicoJpaController;
import modelo.dao.UsuarioJpaController;
import modelo.dao.exceptions.IllegalOrphanException;
import modelo.dao.exceptions.NonexistentEntityException;
import modelo.entidades.Especialidad;
import modelo.entidades.Medico;
import modelo.entidades.Usuario;

/**
 *
 * @author JC-PC
 */
public class ControlUsuario {

    DefaultTableModel modelo;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SBCSLaEsperanzaPU");
    private UsuarioJpaController usuarioJpacontrolador = new UsuarioJpaController(emf);

    public List<Usuario> getUsuario() {
        return usuarioJpacontrolador.findUsuarioEntities();
    }

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

    public boolean editarPass(int cedula, String Unombre) {
        {
            Usuario usu = usuarioJpacontrolador.findUsuario(cedula);
            if (usu == null) {
                return false;
            }
            usu.setContrasena(Unombre);

            try {
                usuarioJpacontrolador.edit(usu);
            } catch (Exception ex) {
                Logger.getLogger(ControlUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }

            return true;
        }

    }

    public void guardarUsuario(String nombresUsuario, String Contraseña, String tipoUsuario, String estadoUsuario) {
        int i = 0;
        Usuario usu = new Usuario();
        try {
            for (Usuario us : getUsuario()) {
                if (us.getNombreusuario().equals(nombresUsuario)) {
                    i = 1;
                    usu = us;
                    break;
                }
            }
            if (i == 1) {

                if (usu.getEstadousuario().equals("NO")) {
                    JOptionPane.showMessageDialog(null, "Ya existe el Usuario pero se encuentra Inabilitado", "Información", 1);
                    usu = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre Usuario Ya Existe", "Información", 1);
                    usu = null;
                }
            } else {
                Usuario m = new Usuario();
                m.setNombreusuario(nombresUsuario);
                m.setContrasena(Contraseña);
                m.setTipousuario(tipoUsuario);
                m.setEstadousuario(estadoUsuario);
                usuarioJpacontrolador.create(m);
                JOptionPane.showMessageDialog(null, "Usuario creado exitosamente", "Información", 1);
            }
        } catch (Exception e) {

        }
    }

    public void cargarTablaEspecialidad(List<Usuario> f, JTable tabla) {
        modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        Object[] fila = new Object[5];
        modelo.addColumn("Nro");
        modelo.addColumn("Nombre_Usuario");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Tipo_Cuenta");
        modelo.addColumn("Estado");
        String r;
        for (Usuario u : f) {
            if (u.getEstadousuario().equals("SI")) {
                r = "Activo";
            } else {
                r = "Inactivo";
            }
            fila[0] = u.getIdusuario();
            fila[1] = u.getNombreusuario();
            fila[2] = u.getContrasena();
            fila[3] = u.getTipousuario();
            fila[4] = r;
            modelo.addRow(fila);
        }
    }

    public boolean Modificarusuario(int id, String nombresUsuario, String Contraseña, String tipoUsuario, String estadoUsuario) {
        int i = 0;
        Usuario usu = new Usuario();

        try {
            for (Usuario us : getUsuario()) {
                if (us.getNombreusuario().equals(nombresUsuario)) {
                    i = 1;
                    usu = us;
                    break;
                }
            }
            if (i == 1) {

                if (usu.getEstadousuario().equals("NO")) {
                    JOptionPane.showMessageDialog(null, "Ya existe el Usuario pero se encuentra Inabilitado", "Información", 1);
                    usu = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Nombre Usuario Ya Existe", "Información", 1);
                    usu = null;
                }
            } else {

                Usuario dat = usuarioJpacontrolador.findUsuario(id);
                if (dat == null) {
                    return false;
                }
                String r;
                if (estadoUsuario.equals("Activo")) {
                    r = "SI";
                } else {
                    r = "NO";
                }
                dat.setNombreusuario(nombresUsuario);
                dat.setContrasena(Contraseña);
                dat.setTipousuario(tipoUsuario);
                dat.setEstadousuario(r);
                usuarioJpacontrolador.edit(dat);
                JOptionPane.showMessageDialog(null, "El Usuario se Modifico exitosamente", "Información", 1);

            }
        } catch (Exception e) {
        }
        return true;
    }

    public void eliminarUsuario(int id) throws IllegalOrphanException {

        try {
            usuarioJpacontrolador.destroy(id);
            JOptionPane.showMessageDialog(null, "El Usuario se Elimino exitosamente", "Información", 1);
        } catch (NonexistentEntityException ex) {
        }

    }
}
