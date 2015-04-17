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
