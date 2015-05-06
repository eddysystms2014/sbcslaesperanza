/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.PacienteJpaController;
import modelo.entidades.Especialidad;
import modelo.entidades.Paciente;
import vista.FrmBusquedas;
import vista.frmEspecialidad;

/**
 *
 * @author EddyA
 */
public class ControlPaciente {

    Paciente p = new Paciente();

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SBCSLaEsperanzaPU");
    private PacienteJpaController pacienteJpaControlador = new PacienteJpaController(emf);

    DefaultTableModel modelo;

    public List<Paciente> getPacientes() {
        return pacienteJpaControlador.findPacienteEntities();
    }

    public void guardarpaciente(String inst, String uo, String coduo, String parr, String cant, String prov, int codpaciente,
            String ced, String ape1, String ape2, String nom1, String nom2, String dir, String barr, String parro, String canton,
            String provin, String zona, String telf, Date fechanac, String lugarnac, String nacio, String grupoc, int edad, String genero,
            String estadoc, String instrucc, Date fechaad, String ocup, String emp, String seg, String refe, String llamar, String paren,
            String dirparen, String nroparen, String codadmi) {

        p.setInstpaciente(inst);
        p.setUnidadepaciente(uo);
        p.setParropaciente(parr);
        p.setCantpaciente(cant);
        p.setProvinpaciente(prov);
        p.setIdpaciente(codpaciente);
        p.setCedpaciente(ced);
        p.setApeppaciente(ape1);
        p.setApempaciente(ape2);
        p.setNom1paciente(nom1);
        p.setNom2paciente(nom2);
        p.setDirpaciente(dir);
        p.setBarriopaciente(barr);
        p.setParrpaciente(parro);
        p.setCanpaciente(canton);
        p.setProvpaciente(provin);
        p.setZonapaciente(zona);
        p.setTelfpaciente(telf);
        p.setFenacpaciente(fechanac);
        p.setLugarnacpaciente(lugarnac);
        p.setNaciopaciente(nacio);
        p.setGruppaciente(grupoc);
        p.setEdadpaciente(edad);
        p.setGenpaciente(genero);
        p.setEcpaciente(estadoc);
        p.setInstrpaciente(instrucc);
        p.setFecadpaciente(fechaad);
        p.setOcuppaciente(ocup);
        p.setEmpaciente(emp);
        p.setSegpaciente(seg);
        p.setRefpaciente(refe);
        p.setLlamarpaciente(llamar);
        p.setParenpaciente(paren);
        p.setDirecpaciente(dirparen);
        p.setNrotelpaciente(nroparen);
        p.setCodadmisionista(codadmi);
        try {
            pacienteJpaControlador.create(p);
            JOptionPane.showMessageDialog(null, "Paciente creado con éxito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Algo está mal");
        }

//        
//        int i = 0;
//        try {
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
//        } catch (Exception e) {
////            p.setNombrePaciente(nombre);
//            p.setDomicilioPaciente(domicilio);
//            p.setTelefonoPaciente(telefono);
//            p.setSintomas(sintomas);
//            p.setEstadoPaciente(true);
//            daoPaciente.create(p);
//            JOptionPane.showMessageDialog(f, "Paciente creado exitosamente", "Información", 1);
//            
//        }
    }

    public boolean editarpaciente(String inst, String uo, String coduo, String parr, String cant, String prov, int codpaciente,
            String ced, String ape1, String ape2, String nom1, String nom2, String dir, String barr, String parro, String canton,
            String provin, String zona, String telf, Date fechanac, String lugarnac, String nacio, String grupoc, int edad, String genero,
            String estadoc, String instrucc, Date fechaad, String ocup, String emp, String seg, String refe, String llamar, String paren,
            String dirparen, String nroparen, String codadmi) {

        p = pacienteJpaControlador.findPaciente(codpaciente);
        if (p == null) {
            return false;
        }
        p.setInstpaciente(inst);
        p.setUnidadepaciente(uo);
        p.setParropaciente(parr);
        p.setCantpaciente(cant);
        p.setProvinpaciente(prov);
        p.setIdpaciente(codpaciente);
        p.setCedpaciente(ced);
        p.setApeppaciente(ape1);
        p.setApempaciente(ape2);
        p.setNom1paciente(nom1);
        p.setNom2paciente(nom2);
        p.setDirpaciente(dir);
        p.setBarriopaciente(barr);
        p.setParrpaciente(parro);
        p.setCanpaciente(canton);
        p.setProvpaciente(provin);
        p.setZonapaciente(zona);
        p.setTelfpaciente(telf);
        p.setFenacpaciente(fechanac);
        p.setLugarnacpaciente(lugarnac);
        p.setNaciopaciente(nacio);
        p.setGruppaciente(grupoc);
        p.setEdadpaciente(edad);
        p.setGenpaciente(genero);
        p.setEcpaciente(estadoc);
        p.setInstrpaciente(instrucc);
        p.setFecadpaciente(fechaad);
        p.setOcuppaciente(ocup);
        p.setEmpaciente(emp);
        p.setSegpaciente(seg);
        p.setRefpaciente(refe);
        p.setLlamarpaciente(llamar);
        p.setParenpaciente(paren);
        p.setDirecpaciente(dirparen);
        p.setNrotelpaciente(nroparen);
        p.setCodadmisionista(codadmi);
        try {
            pacienteJpaControlador.edit(p);
            JOptionPane.showMessageDialog(null, "Paciente Modificado con éxito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Algo está mal");
        }
        return true;
    }

    public void buscarpacienteNumHistoria(int app1) {
        modelo = new DefaultTableModel();
        FrmBusquedas.jTable1.setModel(modelo);
        Object[] fila = new Object[6];
        modelo.addColumn("Nro_Historia");
        modelo.addColumn("Cedula");
        modelo.addColumn("Apellido_Paterno");
        modelo.addColumn("Apellido_Materno");
        modelo.addColumn("Primer_nombre");
        modelo.addColumn("Segundo_nombre");
        for (Paciente e : pacienteJpaControlador.findPacienteEntities()) {
            if (e.getIdpaciente() == app1) {
                fila[0] = e.getIdpaciente();
                fila[1] = e.getCedpaciente();
                fila[2] = e.getApeppaciente();
                fila[3] = e.getApempaciente();
                fila[4] = e.getNom1paciente();
                fila[5] = e.getNom2paciente();
                modelo.addRow(fila);
            }
        }
    }

    public void buscarpacienteCI(String app1) {
        modelo = new DefaultTableModel();
        FrmBusquedas.jTable1.setModel(modelo);
        Object[] fila = new Object[6];
        modelo.addColumn("Nro_Historia");
        modelo.addColumn("Cedula");
        modelo.addColumn("Apellido_Paterno");
        modelo.addColumn("Apellido_Materno");
        modelo.addColumn("Primer_nombre");
        modelo.addColumn("Segundo_nombre");
        for (Paciente e : pacienteJpaControlador.findPacienteEntities()) {
            String r = e.getCedpaciente();
            if (r.equals(app1)) {
                fila[0] = e.getIdpaciente();
                fila[1] = e.getCedpaciente();
                fila[2] = e.getApeppaciente();
                fila[3] = e.getApempaciente();
                fila[4] = e.getNom1paciente();
                fila[5] = e.getNom2paciente();
                modelo.addRow(fila);
            }
        }
    }

    public int edad(String fecha_nac) {

        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String hoy = formato.format(fechaActual);
        String[] dat1 = fecha_nac.split("-");
        String[] dat2 = hoy.split("-");
        int años = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
        int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
        if (mes < 0) {
            años = años - 1;
        } else if (mes == 0) {
            int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
            if (dia > 0) {
                años = años - 1;
            }
        }
        return años;
    }

    public int años(int id) {
        String r;
        Date fechaN = buscarPaciente(id).getFenacpaciente();
        SimpleDateFormat formatoN = new SimpleDateFormat("dd-MM-yyyy");
        String fecha_nac = formatoN.format(fechaN);

        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String hoy = formato.format(fechaActual);

        String[] dat1 = fecha_nac.split("-");
        String[] dat2 = hoy.split("-");
        int años = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
        int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
        if (mes < 0) {
            años = años - 1;
        } else if (mes == 0) {
            int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
            if (dia > 0) {
                años = años - 1;
            }
        }

        return años;
    }

    public Paciente buscarPaciente(int id) {

        for (Paciente p : pacienteJpaControlador.findPacienteEntities()) {
            if (p.getIdpaciente().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Paciente buscarPacienteCI(String id) {

        for (Paciente p : pacienteJpaControlador.findPacienteEntities()) {
            if (p.getCedpaciente().equals(id)) {
                return p;
            }
        }
        return null;
    }

//    public void BuscarApePat() {
//        //String cadenaInformativa = "";
//        modelo = new DefaultTableModel();
//        FrmBusquedas.jTable1.setModel(modelo);
//        Object[] fila = new Object[6];
//        modelo.addColumn("Nro_Historia");
//        modelo.addColumn("Cedula");
//        modelo.addColumn("Apellido_Paterno");
//        modelo.addColumn("Apellido_Materno");
//        modelo.addColumn("Primer_nombre");
//        modelo.addColumn("Segundo_nombre");
//        for (int i = 0; i < getPacientes().size(); i++) {
//
////            for (Paciente e : getPacientes()) {
//            if (getPacientes().get(i).prueba(getPacientes().get(i).elimiEspacio(FrmBusquedas.txtBusquedaNombres.getText()))) {
//
//                fila[0] = getPacientes().get(i).getIdpaciente();
//                fila[1] = getPacientes().get(i).getCedpaciente();
//                fila[2] = getPacientes().get(i).getApeppaciente();
//                fila[3] = getPacientes().get(i).getApempaciente();
//                fila[4] = getPacientes().get(i).getNom1paciente();
//                fila[5] = getPacientes().get(i).getNom2paciente();
//                modelo.addRow(fila);
//            }
////            }
//        }
//    }
    public void BuscarApePat() {
        //String cadenaInformativa = "";
        modelo = new DefaultTableModel();
        FrmBusquedas.jTable1.setModel(modelo);
        Object[] fila = new Object[6];
        modelo.addColumn("Nro_Historia");
        modelo.addColumn("Cedula");
        modelo.addColumn("Apellido_Paterno");
        modelo.addColumn("Apellido_Materno");
        modelo.addColumn("Primer_nombre");
        modelo.addColumn("Segundo_nombre");

//        for (Paciente e : pacienteJpaControlador.findPacienteEntities()){
        for (Paciente e : getPacientes()) {
            if (e.prueba(e.elimiEspacio(FrmBusquedas.txtBusquedaNombres.getText()))) {

                fila[0] = e.getIdpaciente();
                fila[1] = e.getCedpaciente();
                fila[2] = e.getApeppaciente();
                fila[3] = e.getApempaciente();
                fila[4] = e.getNom1paciente();
                fila[5] = e.getNom2paciente();
                modelo.addRow(fila);
            }
//            }
        }
    }
}
