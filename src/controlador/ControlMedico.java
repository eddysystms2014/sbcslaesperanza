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
import modelo.dao.MedicoJpaController;
import modelo.entidades.Especialidad;
import modelo.entidades.Medico;
import vista.formularios.FrmHistorias;

/**
 *
 * @author JC-PC
 */
public class ControlMedico {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SBCSLaEsperanzaPU");
    private MedicoJpaController medicosJpacontrolador = new MedicoJpaController(emf);

    public List<Medico> getMedicos() {
        return medicosJpacontrolador.findMedicoEntities();
    }

    public void guardarMedico(Especialidad idEspecialidad, String nombresMedico,
            String domiciliomedico, String tlfMedico, byte[] imgMedico, String estadoMedico) {
        int i = 0;
        Medico mee = new Medico();
        try {
            for (Medico me : getMedicos()) {
                if (me.getDomiciliomedico().equals(domiciliomedico)) {
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

    public Medico buscarMedico(String cedula) {

        for (Medico md : medicosJpacontrolador.findMedicoEntities()) {
            if (md.getDomiciliomedico().equals(cedula)) {
                return md;
            }
        }
        return null;
    }

    public Medico buscarMedicoID(int id) {

        for (Medico md : medicosJpacontrolador.findMedicoEntities()) {
            if (md.getIdmedico().equals(id)) {
                return md;
            }
        }
        return null;
    }

    public Medico buscarMedicoNombre(String nombre) {

        for (Medico md : medicosJpacontrolador.findMedicoEntities()) {
            if (md.getNombremedico().equals(nombre)) {
                return md;
            }
        }
        return null;
    }

//    public void cargarCmbEspecialidad() {
//        frmcontrol fr = new frmcontrol();
//        for (Especialidad item : fr.getEspecialidad()) {
//            FrmHistorias.jComboBox2.addItem(item.getNombreespecialidad());
//        }
//    }
    public void cargarCmbMedico() {
        for (Medico item : getMedicos()) {
            if (item.getEstadomedico().equals("SI")) {
                FrmHistorias.jComboBox1.addItem(item.getNombremedico());
            }
        }
    }

    public boolean Modificar(Especialidad idEspecialidad, String nombresMedico,
            String domiciliomedico, String tlfMedico, byte[] imgMedico, String estadoMedico) {
        try {
            Medico m = medicosJpacontrolador.cedulaMed(tlfMedico);
            if (m == null) {
                return false;
            }
            if (nombresMedico != "" && domiciliomedico != "" && tlfMedico != "" && estadoMedico != "") {
                m.setNombremedico(nombresMedico);
                m.setDomiciliomedico(domiciliomedico);
                m.setTelefonomedico(tlfMedico);
                m.setImagenmedico(imgMedico);
                m.setEstadomedico(estadoMedico);
                medicosJpacontrolador.create(m);
                JOptionPane.showMessageDialog(null, "Se Modifico exitosamente", "Información", 1);

            } else {
                JOptionPane.showMessageDialog(null, "Textos Obligatorios", "Información", 1);
            }

        } catch (Exception e) {
        }
        return true;
    }
}
