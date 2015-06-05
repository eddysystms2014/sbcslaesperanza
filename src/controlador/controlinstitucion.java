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
import modelo.dao.InstitucionJpaController;
import modelo.entidades.Divisionpolitica;
import modelo.entidades.Divisionpolitica_;
import modelo.entidades.Especialidad;
import modelo.entidades.Institucion;
import modelo.entidades.Medico;
import static vista.FrmMedicos.cbtIdEspecialidad;
import vista.FrmPaciente;
import vista.frmParametrosInsti;

/**
 *
 * @author JC-PC
 */
public class controlinstitucion {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SBCSLaEsperanzaPU");
    private InstitucionJpaController institucionJpacontrolador = new InstitucionJpaController(emf);

    public List<Institucion> getInstitucion() {
        return institucionJpacontrolador.findInstitucionEntities();
    }

    public void guardarInstitucion(Divisionpolitica id, String config, String instSistema, String unidadsistema, String coduo) {
        try {

            Institucion e = new Institucion();
            e.setIdlocalizacion(id);
            e.setDefault1(config);
            e.setInstitucionsistema(instSistema);
            e.setUnidadsistema(unidadsistema);
            e.setCoduo(coduo);
            institucionJpacontrolador.create(e);
            JOptionPane.showMessageDialog(null, "Se creo exitosamente", "Información", 1);

        } catch (Exception e) {
        }
    }

    public boolean ModificarEspecialidad(int id, Divisionpolitica idloc, String config, String instSistema, String unidadsistema, String coduo) {
        try {
            Institucion dat = institucionJpacontrolador.findInstitucion(id);
            if (dat == null) {
                return false;
            }

            dat.setIdlocalizacion(idloc);
            dat.setDefault1(config);
            dat.setInstitucionsistema(instSistema);
            dat.setUnidadsistema(unidadsistema);
            dat.setCoduo(coduo);
            institucionJpacontrolador.edit(dat);
            JOptionPane.showMessageDialog(null, "Se Modifico exitosamente", "Información", 1);

        } catch (Exception e) {
        }
        return true;
    }

    public int cont() {
        int r = 0;
        for (Institucion i : getInstitucion()) {
            if (i.getDefault1().equals("1")) {
                r++;
            }
        }
        return r;
    }

    public void parametrosIniciales() {
        Controllocalizacion cl = new Controllocalizacion();
        for (Institucion i : getInstitucion()) {
            if (i.getDefault1().equals("1")) {
                Integer r = i.getIdlocalizacion().getCodloc();
                String prov = String.valueOf(r).substring(3, 5);
                String cant = String.valueOf(r).substring(5, 7);
                String parro = String.valueOf(r).substring(7, 9);
                
                FrmPaciente.txtinstitucion.setText(i.getInstitucionsistema());
                FrmPaciente.txtunidadoperativa.setText(i.getUnidadsistema());
                FrmPaciente.txtcoduo.setText(i.getCoduo());

                FrmPaciente.txtparroquiacodlo.setText(String.valueOf(parro));
                FrmPaciente.txtcantoncodlo.setText(String.valueOf(cant));
                FrmPaciente.txtprovinciacodlo.setText(String.valueOf(prov));
                break;
            }
        }
    }

}
