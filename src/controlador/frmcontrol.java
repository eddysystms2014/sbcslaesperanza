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

/**
 *
 * @author JC-PC
 */
public class frmcontrol {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SBCSLaEsperanzaPU");
    private MedicoJpaController medicosJpacontrolador = new MedicoJpaController(emf);
    private EspecialidadJpaController especialidadJpacontrolador = new EspecialidadJpaController(emf);

    DefaultTableModel modelo;

    public List<Especialidad> getEspecialidad() {
        return especialidadJpacontrolador.findEspecialidadEntities();
    }

    public List<Medico> getMedicos() {
        return medicosJpacontrolador.findMedicoEntities();
    }

    public void guardarEspecialidad(String nombreEspecialidad) {
        try {
            Especialidad e = new Especialidad();
            e.setNombreespecialidad(nombreEspecialidad);
            especialidadJpacontrolador.create(e);
            JOptionPane.showMessageDialog(null, "La especialidad se creo exitosamente", "Información", 1);

        } catch (Exception e) {
        }
    }

    public boolean ModificarEspecialidad(int id, String nombreEspecialidad) {
        try {
            Especialidad dat = especialidadJpacontrolador.findEspecialidad(id);
            if (dat == null) {
                return false;
            }
            dat.setNombreespecialidad(nombreEspecialidad);
            especialidadJpacontrolador.edit(dat);
            JOptionPane.showMessageDialog(null, "La especialidad se Modifico exitosamente", "Información", 1);

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
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        for (Especialidad e : f) {
            fila[0] = e.getIdespecialidad();
            fila[1] = e.getNombreespecialidad();
            modelo.addRow(fila);
        }
    }

    public void guardarMedico(int idMedico, Especialidad idEspecialidad, String nombresMedico,
            String domiciliomedico, String tlfMedico, byte[] imgMedico, String estadoMedico) {
        int i = 0;
        Medico mee = new Medico();
        try {
            for (Medico me : getMedicos()) {
                if (me.getIdespecialidad().getIdespecialidad() == idEspecialidad.getIdespecialidad()
                        && me.getNombremedico().equalsIgnoreCase(nombresMedico) && me.getDomiciliomedico().equalsIgnoreCase(domiciliomedico)) {
                    i = 1;
                    mee = me;
                    break;
                }
            }
            if (i == 1) {

                if (mee.getEstadomedico().equals("NO")) {
                    JOptionPane.showMessageDialog(null, "Ya existe el medico pero se encuentra Inabilitado", "Información", 1);
                    mee = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Ya existe el medico", "Información", 1);
                    mee = null;
                }
            } else {
                Medico m = new Medico();
                m.setIdmedico(idMedico);
                m.setIdespecialidad(idEspecialidad);
                m.setNombremedico(nombresMedico);
                m.setDomiciliomedico(domiciliomedico);
                m.setTelefonomedico(tlfMedico);
                m.setImagenmedico(imgMedico);
                m.setEstadomedico(estadoMedico);
                medicosJpacontrolador.create(m);
                JOptionPane.showMessageDialog(null, "El medico fue creado exitosamente", "Información", 1);
            }
        } catch (Exception e) {

        }
    }
}
