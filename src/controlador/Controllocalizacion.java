/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.dao.DivisionpoliticaJpaController;
import modelo.entidades.Divisionpolitica;
import modelo.entidades.Institucion;
import modelo.entidades.Medico;
import vista.FrmPaciente;
import vista.frmDistribucion;
import vista.frmParametrosInsti;

/**
 *
 * @author JC-PC
 */
public class Controllocalizacion {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SBCSLaEsperanzaPU");
    private DivisionpoliticaJpaController divisionJpacontrolador = new DivisionpoliticaJpaController(emf);

    public List<Divisionpolitica> getLocalizacion() {
        return divisionJpacontrolador.findDivisionpoliticaEntities();
    }

    public Divisionpolitica buscar(int nivel, String descripcion) {
        for (Divisionpolitica col : getLocalizacion()) {
            if (col.getNivel() == nivel && col.getDescripcion().equals(descripcion)) {
                return col;
            }
        }
        return null;
    }

    public void cargarCmbPais() {
        for (Divisionpolitica item : getLocalizacion()) {
            if (item.getNivel() == 1) {
                frmParametrosInsti.cbmpais.addItem(item.getDescripcion());
            }
        }
    }

    public void cargarCmbProvincia(String pais) {
        for (Divisionpolitica item : getLocalizacion()) {
            if (item.getNivel() == 2 && item.getDivCodloc().getCodloc() == (buscar(1, pais).getCodloc())) {
                frmParametrosInsti.cmdprovincia.addItem(item.getDescripcion());
            }
        }
    }

    public void cargarCmbCanton(String provincia) {
        for (Divisionpolitica item : getLocalizacion()) {
            if (item.getNivel() == 3 && item.getDivCodloc().getCodloc() == (buscar(2, provincia).getCodloc())) {
                frmParametrosInsti.cbmcanton.addItem(item.getDescripcion());
            }
        }
    }

    public void cargarCmbParroquia(String canton) {
        for (Divisionpolitica item : getLocalizacion()) {
            if (item.getNivel() == 4 && item.getDivCodloc().getCodloc() == (buscar(3, canton).getCodloc())) {
                frmParametrosInsti.cbmparroquia.addItem(item.getDescripcion());

            }
        }
    }

    public ArrayList<String> cargarCmbParroquiacod(String canton) {
        ArrayList<String> datos = new ArrayList<String>();
        for (Divisionpolitica item : getLocalizacion()) {
            if (item.getNivel() == 4 && item.getDivCodloc().getCodloc() == (buscar(3, canton).getCodloc())) {
                datos.add(item.getDescripcion() + "-" + item.getCodloc());
            }
        }
        HashSet hs = new HashSet();
        hs.addAll(datos);
        datos.clear();
        datos.addAll(hs);
        return datos;
    }

    public Divisionpolitica buscar(int id) {

        for (Divisionpolitica md : getLocalizacion()) {
            if (md.getCodloc().equals(id)) {
                return md;
            }
        }
        return null;
    }

    public void Provincia() {
        for (Divisionpolitica item : getLocalizacion()) {
            if (item.getNivel() == 2 && item.getDivCodloc().getCodloc() == (buscar(1, "ECUADOR").getCodloc())) {
                FrmPaciente.txtprovincia.addItem(item.getDescripcion());
            }
        }
    }

    public void Canton(String provincia) {
        for (Divisionpolitica item : getLocalizacion()) {
            if (item.getNivel() == 3 && item.getDivCodloc().getCodloc() == (buscar(2, provincia).getCodloc())) {
                FrmPaciente.txtcanton.addItem(item.getDescripcion());
            }
        }
    }

    public void Parroquia(String canton) {
        for (Divisionpolitica item : getLocalizacion()) {
            if (item.getNivel() == 4 && item.getDivCodloc().getCodloc() == (buscar(3, canton).getCodloc())) {
                FrmPaciente.txtparroquia.addItem(item.getDescripcion());

            }
        }
    }

    public void cargarTabla() {
        DefaultTableModel modelo;

        modelo = new DefaultTableModel();
        frmDistribucion.jTable1.setModel(modelo);
        Object[] fila = new Object[5];
        modelo.addColumn("COD.");
        modelo.addColumn("COD. P");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("NIVEL");
        modelo.addColumn("D.NIVEL");

        for (Divisionpolitica e : getLocalizacion()) {

            fila[0] = e.getCodloc();
            fila[1] = e.getDivCodloc();
            fila[2] = e.getDescripcion();
            fila[3] = e.getNivel();
            fila[4] = e.getUltimonivel();
            modelo.addRow(fila);

        }
    }
//
//    public void cargarTabla1(String PAIS) {
//        DefaultTableModel modelo;
//
//        modelo = new DefaultTableModel();
//        frmDistribucion.jTable1.setModel(modelo);
//        Object[] fila = new Object[8];
//        modelo.addColumn("NRO.");
//        modelo.addColumn("PAIS");
//        modelo.addColumn("COD. PROVINCIA");
//        modelo.addColumn("PROVINCIA");
//        modelo.addColumn("COD. CANTON");
//        modelo.addColumn("CANTON");
//        modelo.addColumn("COD. PARROQUIA");
//        modelo.addColumn("PARROQUIA");
//
//        for (Localizacion e : getLocalizacion()) {
//            if (e.getPais().equals(PAIS)) {
//                fila[0] = e.getId();
//                fila[1] = e.getPais();
//                fila[2] = e.getIdprovincia();
//                fila[3] = e.getProvincia();
//                fila[4] = e.getIdcanton();
//                fila[5] = e.getCanton();
//                fila[6] = e.getIdparroquia();
//                fila[7] = e.getParroquia();
//                modelo.addRow(fila);
//
//            }
//
//        }
//    }
//
//    public void cargarTabla2(String PAIS, String provincia) {
//        DefaultTableModel modelo;
//
//        modelo = new DefaultTableModel();
//        frmDistribucion.jTable1.setModel(modelo);
//        Object[] fila = new Object[8];
//        modelo.addColumn("NRO.");
//        modelo.addColumn("PAIS");
//        modelo.addColumn("COD. PROVINCIA");
//        modelo.addColumn("PROVINCIA");
//        modelo.addColumn("COD. CANTON");
//        modelo.addColumn("CANTON");
//        modelo.addColumn("COD. PARROQUIA");
//        modelo.addColumn("PARROQUIA");
//
//        for (Localizacion e : getLocalizacion()) {
//            if (e.getPais().equals(PAIS) && e.getProvincia().equals(provincia)) {
//                fila[0] = e.getId();
//                fila[1] = e.getPais();
//                fila[2] = e.getIdprovincia();
//                fila[3] = e.getProvincia();
//                fila[4] = e.getIdcanton();
//                fila[5] = e.getCanton();
//                fila[6] = e.getIdparroquia();
//                fila[7] = e.getParroquia();
//                modelo.addRow(fila);
//
//            }
//
//        }
//    }
//
//    public void cargarTabla3(String PAIS, String provincia, String canton) {
//        DefaultTableModel modelo;
//
//        modelo = new DefaultTableModel();
//        frmDistribucion.jTable1.setModel(modelo);
//        Object[] fila = new Object[8];
//        modelo.addColumn("NRO.");
//        modelo.addColumn("PAIS");
//        modelo.addColumn("COD. PROVINCIA");
//        modelo.addColumn("PROVINCIA");
//        modelo.addColumn("COD. CANTON");
//        modelo.addColumn("CANTON");
//        modelo.addColumn("COD. PARROQUIA");
//        modelo.addColumn("PARROQUIA");
//
//        for (Localizacion e : getLocalizacion()) {
//            if (e.getPais().equals(PAIS) && e.getProvincia().equals(provincia) && e.getCanton().equals(canton)) {
//                fila[0] = e.getId();
//                fila[1] = e.getPais();
//                fila[2] = e.getIdprovincia();
//                fila[3] = e.getProvincia();
//                fila[4] = e.getIdcanton();
//                fila[5] = e.getCanton();
//                fila[6] = e.getIdparroquia();
//                fila[7] = e.getParroquia();
//                modelo.addRow(fila);
//
//            }
//
//        }
//    }
//
//    public void cargarCmbPais1() {
//        ArrayList<String> datos = new ArrayList<String>();
//        for (Localizacion item : getLocalizacion()) {
//            datos.add(item.getPais());
//        }
//        HashSet hs = new HashSet();
//        hs.addAll(datos);
//        datos.clear();
//        datos.addAll(hs);
//        for (int i = 0; i < datos.size(); i++) {
//            frmDistribucion.cbmpais.addItem(datos.get(i));
//        }
//    }
//
//    public void cargarCmbProvincia1(String pais) {
//        ArrayList<String> datos = new ArrayList<String>();
//        for (Localizacion item : getLocalizacion()) {
//            if (item.getPais().equals(pais)) {
//                datos.add(item.getProvincia());
//            }
//        }
//        HashSet hs = new HashSet();
//        hs.addAll(datos);
//        datos.clear();
//        datos.addAll(hs);
//        for (int i = 0; i < datos.size(); i++) {
//            frmDistribucion.cmdprovincia.addItem(datos.get(i));
//        }
//    }
//
//    public void cargarCmbCanton1(String provincia) {
//
//        ArrayList<String> datos = new ArrayList<String>();
//        for (Localizacion item : getLocalizacion()) {
//            if (item.getProvincia().equals(provincia)) {
//                datos.add(item.getCanton());
//            }
//        }
//        HashSet hs = new HashSet();
//        hs.addAll(datos);
//        datos.clear();
//        datos.addAll(hs);
//        for (int i = 0; i < datos.size(); i++) {
//            frmDistribucion.cbmcanton.addItem(datos.get(i));
//        }
//    }

//    public void guardarEspecialidad(String pais, int idprov, String provincia, int idcanton, String canton, int idparro, String parroquia) {
//        try {
//            Localizacion e = new Localizacion();
//            e.setPais(pais);
//            e.setIdprovincia(idprov);
//            e.setProvincia(provincia);
//            e.setIdcanton(idcanton);
//            e.setCanton(canton);
//            e.setIdparroquia(idparro);
//            e.setParroquia(parroquia);
//            localizacionJpacontrolador.create(e);
//            JOptionPane.showMessageDialog(null, "Se creo exitosamente", "Información", 1);
//
//        } catch (Exception e) {
//        }
//    }
//
//    public boolean ModificarEspecialidad(int id, String pais, int idprov, String provincia, int idcanton, String canton, int idparro, String parroquia) {
//        try {
//            Localizacion e = localizacionJpacontrolador.findLocalizacion(id);
//            if (e == null) {
//                return false;
//            }
//
//            e.setPais(pais);
//            e.setIdprovincia(idprov);
//            e.setProvincia(provincia);
//            e.setIdcanton(idcanton);
//            e.setCanton(canton);
//            e.setIdparroquia(idparro);
//            e.setParroquia(parroquia);
//            localizacionJpacontrolador.create(e);
//            JOptionPane.showMessageDialog(null, "Se Modifico exitosamente", "Información", 1);
//
//        } catch (Exception e) {
//        }
//        return true;
//    }
}
