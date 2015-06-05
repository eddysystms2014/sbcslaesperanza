/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.MedicoJpaController;
import modelo.dao.exceptions.NonexistentEntityException;
import modelo.entidades.Especialidad;
import modelo.entidades.Medico;
import modelo.entidades.Paciente;
import vista.FrmBusquedas;
import vista.FrmHistorias;
import vista.FrmMedicos;
import vista.frmDistribucion;
import vista.frmReportes;

/**
 *
 * @author JC-PC
 */
public class ControlMedico {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SBCSLaEsperanzaPU");
    private MedicoJpaController medicosJpacontrolador = new MedicoJpaController(emf);
    FileInputStream entrada;
    FileOutputStream salida;
    File archivo;

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

    public void eliminar(String cedula){
        try {
            medicosJpacontrolador.destroy(buscarMedico(cedula).getIdmedico());
        } catch (NonexistentEntityException ex) {
            
        }
    }
    public Medico buscarMedico(String cedula) {

        for (Medico md : medicosJpacontrolador.findMedicoEntities()) {
            if (md.getDomiciliomedico().equals(cedula)) {
                return md;
            }
            if (md == null) {
                JOptionPane.showMessageDialog(null, "No se encontro", "Información", 1);
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

    public void cargarCmbMedico1() {
        for (Medico item : getMedicos()) {
            if (item.getEstadomedico().equals("SI")) {
                frmReportes.jComboBox2.addItem(item.getNombremedico());
            }
        }
    }

    public boolean Modificar(Especialidad idEspecialidad, String nombresMedico,
            String domiciliomedico, String tlfMedico, byte[] imgMedico, String estadoMedico) {
        try {
            Medico m = medicosJpacontrolador.findMedico(buscarMedico(domiciliomedico).getIdmedico());

            if (m == null) {
                return false;
            }
            if (nombresMedico != "" && domiciliomedico != "" && tlfMedico != "" && estadoMedico != "" && imgMedico != null) {
                m.setIdespecialidad(idEspecialidad);
                m.setNombremedico(nombresMedico);
                m.setTelefonomedico(tlfMedico);
                m.setImagenmedico(imgMedico);
                m.setEstadomedico(estadoMedico);
                medicosJpacontrolador.edit(m);
                JOptionPane.showMessageDialog(null, "Se Modifico exitosamente", "Información", 1);

            } else {
                JOptionPane.showMessageDialog(null, "Textos Obligatorios", "Información", 1);
            }

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return true;
    }

    public boolean ModificarSinFoto(Especialidad idEspecialidad, String nombresMedico,
            String domiciliomedico, String tlfMedico, String estadoMedico) {
        try {
            Medico m = medicosJpacontrolador.findMedico(buscarMedico(domiciliomedico).getIdmedico());

            if (m == null) {
                return false;
            }
            if (nombresMedico != "" && domiciliomedico != "" && tlfMedico != "" && estadoMedico != "") {
                m.setIdespecialidad(idEspecialidad);
                m.setNombremedico(nombresMedico);
                m.setTelefonomedico(tlfMedico);
                m.setEstadomedico(estadoMedico);
                medicosJpacontrolador.edit(m);
                JOptionPane.showMessageDialog(null, "Se Modifico exitosamente", "Información", 1);

            } else {
                JOptionPane.showMessageDialog(null, "Textos Obligatorios", "Información", 1);
            }

        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
        return true;
    }

    public byte[] AbrirAImagen(File archivo) {
        byte[] bytesImg = new byte[1024 * 100];
        try {
            entrada = new FileInputStream(archivo);
            entrada.read(bytesImg);
        } catch (Exception e) {
        }
        return bytesImg;
    }

    public String GuardarAImagen(File archivo, byte[] bytesImg) {
        String respuesta = null;
        try {
            salida = new FileOutputStream(archivo);
            salida.write(bytesImg);
            respuesta = "La imagen se guardo con exito.";
        } catch (Exception e) {
        }
        return respuesta;
    }

    public void cargarTabla(String estado) {
        if (estado.equals("Activos")) {
            estado = "SI";
        } else if (estado.equals("Inactivos")) {
            estado = "NO";
        }
        frmcontrol fc = new frmcontrol();
        DefaultTableModel modelo;

        modelo = new DefaultTableModel();
        FrmMedicos.jTable1.setModel(modelo);
        Object[] fila = new Object[6];
        modelo.addColumn("NRO.");
        modelo.addColumn("ESPECIALIDAD");
        modelo.addColumn("NOMBRE MEDICO");
        modelo.addColumn("DECULA");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("ESTADO");

        if (estado.equals("SI")) {
            for (Medico e : getMedicos()) {
                if (e.getEstadomedico().equals("SI")) {
                    String r;
                    if (e.getEstadomedico().equals("SI")) {
                        r = "Activo";
                    } else {
                        r = "Inactivo";
                    }
                    fila[0] = e.getIdmedico();
                    fila[1] = fc.buscarEspecialidad(e.getIdespecialidad().getIdespecialidad()).getNombreespecialidad();
                    fila[2] = e.getNombremedico();
                    fila[3] = e.getDomiciliomedico();
                    fila[4] = e.getTelefonomedico();
                    fila[5] = r;
                    modelo.addRow(fila);
                }
            }

        } else if (estado.equals("NO")) {
            for (Medico e : getMedicos()) {
                if (e.getEstadomedico().equals("NO")) {
                    String r;
                    if (e.getEstadomedico().equals("SI")) {
                        r = "Activo";
                    } else {
                        r = "Inactivo";
                    }
                    fila[0] = e.getIdmedico();
                    fila[1] = e.getIdespecialidad().getNombreespecialidad();
                    fila[2] = e.getNombremedico();
                    fila[3] = e.getDomiciliomedico();
                    fila[4] = e.getTelefonomedico();
                    fila[5] = r;
                    modelo.addRow(fila);
                }
            }

        }

    }

    public void BuscarnombreMedico() {
        DefaultTableModel modelo;
        frmcontrol fc = new frmcontrol();
        modelo = new DefaultTableModel();
        FrmMedicos.jTable1.setModel(modelo);
        Object[] fila = new Object[6];
        modelo.addColumn("NRO.");
        modelo.addColumn("ESPECIALIDAD");
        modelo.addColumn("NOMBRE MEDICO");
        modelo.addColumn("DECULA");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("ESTADO");

        for (Medico e : getMedicos()) {
            if (e.prueba(e.elimiEspacio(FrmMedicos.jTextField3.getText()))) {
                {
                    String r;
                    if (e.getEstadomedico().equals("SI")) {
                        r = "Activo";
                    } else {
                        r = "Inactivo";
                    }
                    fila[0] = e.getIdmedico();
                    fila[1] = fc.buscarEspecialidad(e.getIdespecialidad().getIdespecialidad()).getNombreespecialidad();
                    fila[2] = e.getNombremedico();
                    fila[3] = e.getDomiciliomedico();
                    fila[4] = e.getTelefonomedico();
                    fila[5] = r;
                    modelo.addRow(fila);
                }
            }

        }

    }

    public void buscarmedicoCedula() {
        DefaultTableModel modelo;
        frmcontrol fc = new frmcontrol();
        modelo = new DefaultTableModel();
        FrmMedicos.jTable1.setModel(modelo);
        Object[] fila = new Object[6];
        modelo.addColumn("NRO.");
        modelo.addColumn("ESPECIALIDAD");
        modelo.addColumn("NOMBRE MEDICO");
        modelo.addColumn("CECULA");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("ESTADO");

        for (Medico e : getMedicos()) {
            if (e.cedula(e.elimiEspacio(FrmMedicos.jTextField2.getText()))) {
                {
                    String r;
                    if (e.getEstadomedico().equals("SI")) {
                        r = "Activo";
                    } else {
                        r = "Inactivo";
                    }
                    fila[0] = e.getIdmedico();
                    fila[1] = fc.buscarEspecialidad(e.getIdespecialidad().getIdespecialidad()).getNombreespecialidad();
                    fila[2] = e.getNombremedico();
                    fila[3] = e.getDomiciliomedico();
                    fila[4] = e.getTelefonomedico();
                    fila[5] = r;
                    modelo.addRow(fila);
                }
            }

        }

    }
}
