/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.formularios.FrmHistorias;

/**
 *
 * @author COMPUAXIR
 */
public class ReportesControlador {
    Conexion con;

    public ReportesControlador() {
        con = new Conexion();
    }

    public void runReporte(String HORARIOATENCION, File dir, String bddVar) {
        try {
            //System.getProperty("user.dir")+ dir;
            File ruta = dir;
            System.out.println("ruta : " + ruta);
            if (ruta == null) {
                System.out.println("No se encontro el archivo.");
                System.exit(2);
            }

            JasperReport reporte = null;
            try {
                reporte = (JasperReport) JRLoader.loadObject(dir);
            } catch (JRException jr) {
                System.out.println("Error al cargar reporte." + jr.getMessage());
                System.exit(3);
            }
            Map parametro = new HashMap();
            parametro.put(bddVar, HORARIOATENCION);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, con.getCon());
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("TURNO");
            jv.setVisible(true);
        } catch (Exception e) {
            System.out.println("Mensaje de Error" + e.getMessage());
        }

    }

    public void reporteTabular(File dir) {
        try {
            //System.getProperty("user.dir")+ dir;
            File ruta = dir;
            System.out.println("ruta : " + ruta);
            if (ruta == null) {
                System.out.println("No se encontro el archivo.");
                System.exit(2);
            }
            JasperReport reporte = null;
            try {
                reporte = (JasperReport) JRLoader.loadObject(ruta);
            } catch (JRException jr) {
                System.out.println("Error al cargar reporte." + jr.getMessage());
                System.exit(3);
            }
            Map parametro = new HashMap();
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, con.getCon());
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("REPORTE ");
            jv.setVisible(true);
        } catch (Exception e) {
            System.out.println("Mensaje de Error" + e.getMessage());
        }

    }
    public void manual() {
        try {

            File objetofile = new File("reportes\\MATRICULA.pdf");
            Desktop.getDesktop().open(objetofile);

        } catch (IOException ex) {

            System.out.println(ex);

        }

    }

}
