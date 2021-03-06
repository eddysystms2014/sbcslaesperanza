/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.dao.EspecialidadJpaController;
import modelo.dao.MedicoJpaController;
import modelo.dao.exceptions.IllegalOrphanException;
import modelo.dao.exceptions.NonexistentEntityException;
import modelo.entidades.Especialidad;
import modelo.entidades.Medico;
import modelo.entidades.Turno;
import vista.frmEspecialidad;

/**
 *
 * @author JC-PC
 */
public class frmcontrol {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SBCSLaEsperanzaPU");
    private EspecialidadJpaController especialidadJpacontrolador = new EspecialidadJpaController(emf);

    DefaultTableModel modelo;

    public List<Especialidad> getEspecialidad() {
        return especialidadJpacontrolador.findEspecialidadEntities();
    }

    public void guardarEspecialidad(String nombreEspecialidad) {
        try {
            int i = 0;
            for (Especialidad me : getEspecialidad()) {
                if (me.getNombreespecialidad().equals(nombreEspecialidad)) {
                    i = 1;
                    break;
                }
            }
            if (i == 1) {
                JOptionPane.showMessageDialog(null, "Esa Especialidad Ya Esta Registrada", "Información", 1);

            } else if (nombreEspecialidad != "") {
                Especialidad e = new Especialidad();
                e.setNombreespecialidad(nombreEspecialidad);
                especialidadJpacontrolador.create(e);
                JOptionPane.showMessageDialog(null, "La especialidad se creo exitosamente", "Información", 1);

            } else {
                JOptionPane.showMessageDialog(null, "Ponga Un Nombre de Especialidad", "Información", 1);
            }

        } catch (Exception e) {
        }
    }

    public boolean ModificarEspecialidad(int id, String nombreEspecialidad) {
        try {
            Especialidad dat = especialidadJpacontrolador.findEspecialidad(id);
            if (dat == null) {
                return false;
            }
            if (nombreEspecialidad != "") {
                dat.setNombreespecialidad(nombreEspecialidad);
                especialidadJpacontrolador.edit(dat);
                JOptionPane.showMessageDialog(null, "La especialidad se Modifico exitosamente", "Información", 1);

            } else {
                JOptionPane.showMessageDialog(null, "Ponga Un Nombre de Especialidad", "Información", 1);
            }

        } catch (Exception e) {
        }
        return true;
    }

    public void eliminarEspecialidad(int id) throws IllegalOrphanException {

        try {
            especialidadJpacontrolador.destroy(id);
        } catch (NonexistentEntityException ex) {
        }

    }

    public void cargarTablaEspecialidad(List<Especialidad> f, JTable tabla) {
        modelo = new DefaultTableModel();
        tabla.setModel(modelo);
        Object[] fila = new Object[2];
        modelo.addColumn("Nro");
        modelo.addColumn("Nombre Especialidad");
        for (Especialidad e : f) {
            fila[0] = e.getIdespecialidad();
            fila[1] = e.getNombreespecialidad();
            modelo.addRow(fila);
        }
    }

    public Especialidad buscarEspecialidad(int id) {

        for (Especialidad esp : especialidadJpacontrolador.findEspecialidadEntities()) {
            if (esp.getIdespecialidad().equals(id)) {
                return esp;
            }
        }
        return null;
    }

    public Especialidad buscarEspecialidadPorNombre(String nombre) {

        for (Especialidad esp : especialidadJpacontrolador.findEspecialidadEntities()) {
            if (esp.getNombreespecialidad().equals(nombre)) {
                return esp;
            }
        }
        return null;
    }

    

}
