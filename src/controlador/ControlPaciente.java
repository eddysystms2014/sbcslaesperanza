/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import modelo.dao.PacienteJpaController;
import modelo.entidades.Paciente;

/**
 *
 * @author EddyA
 */
public class ControlPaciente {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SBCSLaEsperanzaPU");
    private PacienteJpaController pacienteJpaControlador= new PacienteJpaController(emf);
    
    public List<Paciente> getPacientes()
    {
        return pacienteJpaControlador.findPacienteEntities();
    }
    
    
    public void guardarpaciente(String inst, String uo, String coduo, String parr, String cant, String prov, int codpaciente, 
            String ced, String ape1, String ape2, String nom1, String nom2, String dir, String barr, String parro, String canton, 
            String provin, String zona, String telf, Date fechanac, String lugarnac, String nacio, String grupoc, int edad, String genero, 
            String estadoc, String instrucc, Date fechaad, String ocup, String emp, String seg, String refe, String llamar, String paren, 
            String dirparen, String nroparen, String codadmi)
    {
        Paciente p = new Paciente();
        int i = 0;
        try {
//            for (Paciente pa : getPacientes()) {
//                if (pa.getInstpaciente().equalsIgnoreCase(inst) && pa.getDomicilioPaciente().equals(domicilio) && pa.getTelefonoPaciente().equals(telefono)) {
//                    i = 1;
//                    p = pa;
//                    break;
//                }
//            }
//            if (i == 1) {
//                if (p.getEstadoPaciente() == false) {
//                    JOptionPane.showMessageDialog(f, "El paciente esta bloqueado", "Información", 0);
//                } else {
//                    JOptionPane.showMessageDialog(f, "Ya existe el paciente ", "Información", 0);
//                }
//            } else {
//                p.setNombrePaciente(nombre);
//                p.setDomicilioPaciente(domicilio);
//                p.setTelefonoPaciente(telefono);
//                p.setSintomas(sintomas);
//                p.setEstadoPaciente(true);
//                daoPaciente.create(p);
//                JOptionPane.showMessageDialog(f, "Paciente creado exitosamente", "Información", 1);

            }
        catch (Exception e) 
        {
//            p.setNombrePaciente(nombre);
//            p.setDomicilioPaciente(domicilio);
//            p.setTelefonoPaciente(telefono);
//            p.setSintomas(sintomas);
//            p.setEstadoPaciente(true);
//            daoPaciente.create(p);
//            JOptionPane.showMessageDialog(f, "Paciente creado exitosamente", "Información", 1);
        }
    }
}

