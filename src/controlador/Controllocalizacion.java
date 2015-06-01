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
        ArrayList<Localizacion> datos = new ArrayList<>();
        Set<Localizacion> linkedHashSet = new LinkedHashSet<Localizacion>();
        for (Localizacion item : getLocalizacion()) {
            datos.add(item);
        }
        linkedHashSet.addAll(datos);
        datos.clear();
        datos.addAll(linkedHashSet);
        for (Localizacion dato : datos) {
            frmParametrosInsti.cbmpais.addItem(dato.getPais());
        }
    }

    public void cargarCmbProvincia(String pais) {
        for (Localizacion item : getLocalizacion()) {
            if (item.getPais().equals(pais)) {
                frmParametrosInsti.cmdprovincia.addItem(item.getProvincia());
            }
        }
    }

    public void cargarCmbCanton(String provincia) {
        for (Localizacion item : getLocalizacion()) {
            if (item.getProvincia().equals(provincia)) {
                frmParametrosInsti.cbmcanton.addItem(item.getCanton());
            }
        }
    }

    public void cargarCmbParroquia(String canton) {
        for (Localizacion item : getLocalizacion()) {
            if (item.getCanton().equals(canton)) {
                frmParametrosInsti.cbmparroquia.addItem(item.getParroquia());
            }
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
        for (Localizacion item : getLocalizacion()) {
            FrmPaciente.txtprovincia.addItem(item.getProvincia());
        }
    }

    public void Canton(String provincia) {
        for (Localizacion item : getLocalizacion()) {
            if (item.getProvincia().equals(provincia)) {
                FrmPaciente.txtcanton.addItem(item.getCanton());
            }
        }
    }

    public void Parroquia(String canton) {
        for (Localizacion item : getLocalizacion()) {
            if (item.getCanton().equals(canton)) {
                FrmPaciente.txtparroquia.addItem(item.getParroquia());
            }
        }
    }
}
