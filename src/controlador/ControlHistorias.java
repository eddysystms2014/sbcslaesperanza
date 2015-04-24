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
import vista.formularios.FrmBusquedas;
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

   

    public void cargarTabla() {
        int txt=Integer.valueOf(FrmBusquedas.jTextField3.getText());
                
        modelo = new DefaultTableModel();
        FrmHistorias.jTable1.setModel(modelo);
        Object[] fila = new Object[6];
        modelo.addColumn("NUM_ HISTORIA");
        modelo.addColumn("FECHA");
        modelo.addColumn("EDAD");
        modelo.addColumn("REFERIDO DE");
        modelo.addColumn("ATENCION");
        modelo.addColumn("CODIGO_ADMISIONISTA");

        for (Historia e : getHistorias()) {
            if (e.getIdpaciente().getIdpaciente()==txt) {
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
