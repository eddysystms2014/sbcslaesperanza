/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import SBCSLaEsperanza.ReportesControlador;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import modelo.dao.PacienteJpaController;
import modelo.dao.exceptions.NonexistentEntityException;
import modelo.entidades.Especialidad;
import modelo.entidades.Paciente;
import vista.FrmBusquedas;
import static vista.FrmBusquedas.jTable1;
import vista.FrmPaciente;
import static vista.FrmPaciente.txthistoriaclinica;
import vista.VistaPrincipal;
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
        p.setCoduopaciente(coduo);
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
        p.setCoduopaciente(coduo);
        p.setParropaciente(parr);
        p.setCantpaciente(cant);
        p.setProvinpaciente(prov);
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

    public void eliminarRegistro(int id) {
        try {
            pacienteJpaControlador.destroy(id);
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(null, "No se puede Eliminar ...");
        }
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

    public int edad(String fecha) {
        Date fechaNac = null;
        try {

            fechaNac = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
        } catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
        Calendar fechaNacimiento = Calendar.getInstance();
        Calendar fechaActual = Calendar.getInstance();
        fechaNacimiento.setTime(fechaNac);
        int año = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        int mes = fechaActual.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE) - fechaNacimiento.get(Calendar.DATE);
        if (mes < 0 || (mes == 0 && dia < 0)) {
            año--;
        }
        return año;
    }

    public int años(int id) {
        String r;
        Date fechaN = paciente(id).getFenacpaciente();
        SimpleDateFormat formatoN = new SimpleDateFormat("dd-MM-yyyy");
        String fecha_nac = formatoN.format(fechaN);

        Date fechaNac = null;
        try {

            fechaNac = new SimpleDateFormat("dd-MM-yyyy").parse(fecha_nac);
        } catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
        Calendar fechaNacimiento = Calendar.getInstance();
        Calendar fechaActual = Calendar.getInstance();
        fechaNacimiento.setTime(fechaNac);
        int año = fechaActual.get(Calendar.YEAR) - fechaNacimiento.get(Calendar.YEAR);
        int mes = fechaActual.get(Calendar.MONTH) - fechaNacimiento.get(Calendar.MONTH);
        int dia = fechaActual.get(Calendar.DATE) - fechaNacimiento.get(Calendar.DATE);
        if (mes < 0 || (mes == 0 && dia < 0)) {
            año--;
        }
        return año;
    }

    public Paciente paciente(int id) {

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
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Primer Nombre");
        modelo.addColumn("Segundo Nombre");

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

    public int num() {
        int r;
        r = pacienteJpaControlador.getPacienteCount() + 1;
        return r;
    }

    public void imprimirTodo() {
        ReportesControlador rc = new ReportesControlador();
        int i = JOptionPane.showConfirmDialog(null, "¿Realmente desea Imprimir " + num() + " Registros de pacientes", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (i == 0) {
            String ruta = "registro.jasper";
            for (Paciente p : pacienteJpaControlador.findPacienteEntities()) {

                rc.imprimirTodo("IDPACIENTE", p.getIdpaciente(), ruta);

            }
        }
    }

    public void historias() {
        int r = 0;
        String s = "";
        ArrayList<Integer> Listado = new ArrayList<Integer>();
        ArrayList<Integer> Listado2 = new ArrayList<Integer>();
        for (Paciente e : getPacientes()) {
            Listado.add(e.getIdpaciente());
        }
        for (int i = 0; i < Listado.size(); i++) {
//            System.out.println("" + Listado.get(i));
            if (Listado.get(i) > r) {
                r = Listado.get(i);
            }
        }
        FrmPaciente.txthistoriaclinica.setText(String.valueOf(r + 1));
        for (int j = 0; j < r; j++) {
            Listado2.add(j);
        }
        for (int i = 0; i < Listado.size(); i++) {
            for (int j = 0; j < Listado2.size(); j++) {
                if (Listado.get(i).equals(Listado2.get(j))) {
                    Listado2.remove(j);
                }
            }
        }

//        for (int i = 0; i < Listado2.size(); i++) {
//            System.out.println(" " + Listado2.get(i));
//        }
//        System.out.println("" + Listado.size());
//        System.out.println("" + Listado2.size());
    }

//public static void main(String[] args) {
//        ControlPaciente c = new ControlPaciente();
//        c.historias();
//    }
    public void Buscarcedula() {
        //String cadenaInformativa = "";
        modelo = new DefaultTableModel();
        FrmBusquedas.jTable1.setModel(modelo);
        Object[] fila = new Object[6];
        modelo.addColumn("Nro_Historia");
        modelo.addColumn("Cedula");
        modelo.addColumn("Apellido Paterno");
        modelo.addColumn("Apellido Materno");
        modelo.addColumn("Primer Nombre");
        modelo.addColumn("Segundo Nombre");

        for (Paciente e : getPacientes()) {
            if (e.Cedula(e.elimiEspacio(FrmBusquedas.txtBusquedaCedula.getText()))) {

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

    public List<Paciente> getbuscarPacientes(String nombres) {
        try {
            List<Paciente> datos = new ArrayList<Paciente>();
            for (Paciente e : getPacientes()) {
                if (e.prueba(e.elimiEspacio(nombres))) {
                    datos.add(e);
                }
            }
            return datos;
        } catch (Exception e) {
        }
        return null;

    }

}
