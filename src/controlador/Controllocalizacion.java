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
import modelo.dao.LocalizacionJpaController;
import modelo.entidades.Institucion;
import modelo.entidades.Localizacion;
import modelo.entidades.Medico;
import vista.FrmPaciente;
import vista.frmParametrosInsti;

/**
 *
 * @author JC-PC
 */
public class Controllocalizacion {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SBCSLaEsperanzaPU");
    private LocalizacionJpaController localizacionJpacontrolador = new LocalizacionJpaController(emf);

    public List<Localizacion> getLocalizacion() {
        return localizacionJpacontrolador.findLocalizacionEntities();
    }

    public void cargarCmbPais() {
        ArrayList<String> datos = new ArrayList<String>();
        for (Localizacion item : getLocalizacion()) {
            datos.add(item.getPais());
        }
        HashSet hs = new HashSet();
        hs.addAll(datos);
        datos.clear();
        datos.addAll(hs);
        for (int i = 0; i < datos.size(); i++) {
            frmParametrosInsti.cbmpais.addItem(datos.get(i));
        }
    }

    public void cargarCmbProvincia(String pais) {
        ArrayList<String> datos = new ArrayList<String>();
        for (Localizacion item : getLocalizacion()) {
            if (item.getPais().equals(pais)) {
                datos.add(item.getProvincia());
            }
        }
        HashSet hs = new HashSet();
        hs.addAll(datos);
        datos.clear();
        datos.addAll(hs);
        for (int i = 0; i < datos.size(); i++) {
            frmParametrosInsti.cmdprovincia.addItem(datos.get(i));
        }
    }

    public void cargarCmbCanton(String provincia) {

        ArrayList<String> datos = new ArrayList<String>();
        for (Localizacion item : getLocalizacion()) {
            if (item.getProvincia().equals(provincia)) {
                datos.add(item.getCanton());
            }
        }
        HashSet hs = new HashSet();
        hs.addAll(datos);
        datos.clear();
        datos.addAll(hs);
        for (int i = 0; i < datos.size(); i++) {
            frmParametrosInsti.cbmcanton.addItem(datos.get(i));
        }
    }

    public void cargarCmbParroquia(String canton) {
        ArrayList<String> datos = new ArrayList<String>();
        for (Localizacion item : getLocalizacion()) {
            if (item.getCanton().equals(canton)) {
                datos.add(item.getParroquia());
            }
        }
        HashSet hs = new HashSet();
        hs.addAll(datos);
        datos.clear();
        datos.addAll(hs);
        for (int i = 0; i < datos.size(); i++) {
            frmParametrosInsti.cbmparroquia.addItem(datos.get(i));
        }
    }

    public Localizacion buscarlocalizacion(String pais, String provincia, String canton, String parroquia) {

        for (Localizacion md : getLocalizacion()) {
            if (md.getPais().equals(pais) && md.getProvincia().equals(provincia) && md.getCanton().equals(canton) && md.getParroquia().equals(parroquia)) {
                return md;
            }
        }
        return null;
    }

    public Localizacion buscar(int id) {

        for (Localizacion md : getLocalizacion()) {
            if (md.getId().equals(id)) {
                return md;
            }
        }
        return null;
    }

    public void Provincia() {
        ArrayList<String> datos = new ArrayList<String>();
        for (Localizacion item : getLocalizacion()) {
                datos.add(item.getProvincia());
        }
        HashSet hs = new HashSet();
        hs.addAll(datos);
        datos.clear();
        datos.addAll(hs);
        for (int i = 0; i < datos.size(); i++) {
            FrmPaciente.txtprovincia.addItem(datos.get(i));
        }
    }

    public void Canton(String provincia) {
        ArrayList<String> datos = new ArrayList<String>();
        for (Localizacion item : getLocalizacion()) {
            if (item.getProvincia().equals(provincia)) {
                datos.add(item.getCanton());
            }
        }
        HashSet hs = new HashSet();
        hs.addAll(datos);
        datos.clear();
        datos.addAll(hs);
        for (int i = 0; i < datos.size(); i++) {
            FrmPaciente.txtcanton.addItem(datos.get(i));
        }
    }

    public void Parroquia(String canton) {
        ArrayList<String> datos = new ArrayList<String>();
        for (Localizacion item : getLocalizacion()) {
            if (item.getCanton().equals(canton)) {
                datos.add(item.getParroquia());
            }
        }
        HashSet hs = new HashSet();
        hs.addAll(datos);
        datos.clear();
        datos.addAll(hs);
        for (int i = 0; i < datos.size(); i++) {
            FrmPaciente.txtparroquia.addItem(datos.get(i));
        }
    }
}
