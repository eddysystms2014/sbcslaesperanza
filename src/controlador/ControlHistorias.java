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
import javax.swing.table.DefaultTableModel;
import modelo.dao.HistoriaJpaController;
import modelo.entidades.Historia;
import vista.formularios.FrmHistorias;

/**
 *
 * @author JC-PC
 */
public class ControlHistorias {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("SBCSLaEsperanzaPU");
    private HistoriaJpaController historiaJpaControlador = new HistoriaJpaController(emf);

    DefaultTableModel modelo;

    public List<Historia> getHistorias() {
        return historiaJpaControlador.findHistoriaEntities();
    }

    public void tablaHistorial(int numHistorias) {

//        String cadenaInformativa = "";
        modelo = new DefaultTableModel();
        FrmHistorias.jTable1.setModel(modelo);
        Object[] fila = new Object[6];
        modelo.addColumn("NUM_ HISTORIA");
        modelo.addColumn("FECHA");
        modelo.addColumn("EDAD");
        modelo.addColumn("REFERIDO DE");
        modelo.addColumn("ATENCION");
        modelo.addColumn("CODIGO_ADMISIONISTA");

        for (int i = 0; i < getHistorias().size(); ++i) {
            Historia h = historiaJpaControlador.findHistoria(numHistorias);
            if (h != null) {

                fila[0] = getHistorias().get(i).getIdpaciente().getIdpaciente();
                fila[1] = getHistorias().get(i).getFechahistoria();
                fila[2] = getHistorias().get(i).getEdadhistoria();
                fila[3] = getHistorias().get(i).getReferidohistoria();
                fila[4] = getHistorias().get(i).getTipohistoria();
                fila[5] = getHistorias().get(i).getCodadmisionista();

//                JOptionPane.showMessageDialog(null, "hallado");
            } else {
                JOptionPane.showMessageDialog(null, "error");

            }

        }
    }

    public void cargarTabla(List<Historia> f,int codHist) {
        modelo = new DefaultTableModel();
        FrmHistorias.jTable1.setModel(modelo);
        Object[] fila = new Object[6];
        modelo.addColumn("NUM_ HISTORIA");
        modelo.addColumn("FECHA");
        modelo.addColumn("EDAD");
        modelo.addColumn("REFERIDO DE");
        modelo.addColumn("ATENCION");
        modelo.addColumn("CODIGO_ADMISIONISTA");

        for (Historia e : f) {
            if (e.getIdpaciente().getIdpaciente()==codHist) {
                fila[0] = e.getIdpaciente().getIdpaciente();
            fila[1] = e.getFechahistoria();
            fila[2] = e.getEdadhistoria();
            fila[3] = e.getReferidohistoria();
            fila[4] = e.getTipohistoria();
            fila[5] = e.getCodadmisionista();

            modelo.addRow(fila);
            }
            
        }
    }
}
