/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import modelo.dao.TurnoJpaController;
import modelo.entidades.Medico;
import static modelo.entidades.Medico_.idmedico;
import modelo.entidades.Paciente;
import modelo.entidades.Turno;

/**
 *
 * @author JC-PC
 */
public class ControlTurnos {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SBCSLaEsperanzaPU");
    private TurnoJpaController turnosJpacontrolador = new TurnoJpaController(emf);

    public List<Turno> getMedicos() {
        return turnosJpacontrolador.findTurnoEntities();
    }

    public void guardarTurnos(Paciente idPaciente, Medico idMedico, Date entrada) {

        Turno m = new Turno();
        Date fechaActual = new Date();
        int numT = numTurno(fechaActual, idMedico);
        String r = String.valueOf(numT);

        m.setIdpaciente(idPaciente);
        m.setIdmedico(idMedico);
        m.setHorarioatencion(entrada);
        m.setEstadoturno(r);
        turnosJpacontrolador.create(m);
        JOptionPane.showMessageDialog(null, "Realizado", "Información", 1);
    }

// 
    public Turno buscarMedico(String cedula) {

        for (Turno md : turnosJpacontrolador.findTurnoEntities()) {
            if (md.getIdpaciente().equals(cedula)) {
                return md;
            }
        }
        return null;
    }

    public int numTurno(Date fec, Medico idmedico) {
        Date fechaIng = fec;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String hoy = formato.format(fechaIng);
        int r = 1;
        for (Turno md : turnosJpacontrolador.findTurnoEntities()) {

            Date fechaActual = md.getHorarioatencion();
            SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");
            String hoy2 = formato2.format(fechaActual);

            if (hoy.equals(hoy2) && md.getIdmedico().getIdmedico().equals(idmedico.getIdmedico())) {
                r = r + 1;
            }
        }
        return r;
    }
//    public int fecha(Date fec) {
//        Date fechaIng = fec;
//        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//        String hoy = formato.format(fechaIng);
//        for (Turno md : turnosJpacontrolador.findTurnoEntities()) {
//            Date fechaActual = md.getHorarioatencion();
//            SimpleDateFormat formato2 = new SimpleDateFormat("yyyy-MM-dd");
//            String hoy2 = formato2.format(fechaActual);
//        }
//        return r;
//    }

}
