/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import modelo.dao.TurnoJpaController;
import modelo.entidades.Medico;
import modelo.entidades.Paciente;
import modelo.entidades.Turno;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

/**
 *
 * @author JC-PC
 */
public class ControlTurno {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SBCSLaEsperanzaPU");
    private TurnoJpaController turnoJpacontrolador = new TurnoJpaController(emf);

    public List<Turno> getTurno() {
        return turnoJpacontrolador.findTurnoEntities();
    }

    public void guardarTurno(Paciente idPaciente, Medico idMedico, Date horaAtencion, String estadoTurno) {

        try {

            Turno t = new Turno();
            t.setIdpaciente(idPaciente);
            t.setIdmedico(idMedico);
            t.setHorarioatencion(horaAtencion);
            t.setEstadoturno(estadoTurno);
            turnoJpacontrolador.create(t);
            
        } catch (Exception e) {

        }
    }

  

}
