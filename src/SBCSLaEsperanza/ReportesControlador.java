/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SBCSLaEsperanza;

import controlador.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import vista.FrmHistorias;

/**
 *
 * @author COMPUAXIR
 */
public class ReportesControlador {

    Conexion con;

    public ReportesControlador() {
        con = new Conexion();
    }

    public void runReporte(String bddVar, String HORARIOATENCION, String archivo) {
        try {
            //System.getProperty("user.dir")+ dir;

//            File ruta = dir;
//            System.out.println("ruta : " + ruta);
//            if (ruta == null) {
//                System.out.println("No se encontro el archivo.");
//                System.exit(2);
//            }
            JasperReport reporte = null;
            try {
//                reporte = (JasperReport) JRLoader.loadObject(dir);
                URL in = this.getClass().getResource(archivo);
                reporte = (JasperReport) JRLoader.loadObject(in);
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
            JasperPrintManager.printReport(jasperPrint, false);

        } catch (Exception e) {
            System.out.println("Mensaje de Error" + e.getMessage());
        }

    }

    public void reporteTabular(String archivo) {
        try {

            JasperReport reporte = null;
            try {
                URL in = this.getClass().getResource(archivo);
                reporte = (JasperReport) JRLoader.loadObject(in);
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

    public void reportesGeneral(String bddVar, int HORARIOATENCION, String archivo) {
        try {
            //System.getProperty("user.dir")+ dir;

//            File ruta = dir;
//            System.out.println("ruta : " + ruta);
//            if (ruta == null) {
//                System.out.println("No se encontro el archivo.");
//                System.exit(2);
//            }
            JasperReport reporte = null;
            try {
//                reporte = (JasperReport) JRLoader.loadObject(dir);
                URL in = this.getClass().getResource(archivo);
                reporte = (JasperReport) JRLoader.loadObject(in);
            } catch (JRException jr) {
                System.out.println("Error al cargar reporte." + jr.getMessage());
                System.exit(3);
            }
            Map parametro = new HashMap();
            parametro.put(bddVar, HORARIOATENCION);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, con.getCon());
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("REPORTE");
            jv.setVisible(true);
            JasperPrintManager.printReport(jasperPrint, false);

        } catch (Exception e) {
            System.out.println("Mensaje de Error" + e.getMessage());
        }

    }

    public void reporteatenciones(String HORARIOATENCION, String VHORARIOATENCION, String mes, String Vmes, String archivo) {
        try {
            //System.getProperty("user.dir")+ dir;

//            File ruta = dir;
//            System.out.println("ruta : " + ruta);
//            if (ruta == null) {
//                System.out.println("No se encontro el archivo.");
//                System.exit(2);
//            }
            JasperReport reporte = null;
            try {
//                reporte = (JasperReport) JRLoader.loadObject(dir);
                URL in = this.getClass().getResource(archivo);
                reporte = (JasperReport) JRLoader.loadObject(in);
            } catch (JRException jr) {
                System.out.println("Error al cargar reporte." + jr.getMessage());
                System.exit(3);
            }
            Map parametro = new HashMap();
//            parametro.put(bddVar, HORARIOATENCION);
            parametro.put(VHORARIOATENCION, HORARIOATENCION);
            parametro.put(Vmes, mes);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(archivo, parametro, con.getCon());
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, con.getCon());
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("REPORTE");
            jv.setVisible(true);
//            JasperPrintManager.printReport(jasperPrint, false);

        } catch (Exception e) {
            System.out.println("Mensaje de Error " + e.getMessage());
        }

    }

    public void reporteatencionesDiario(String HORARIOATENCION, String VHORARIOATENCION, String mes, String Vmes, String dia, String Vdia, String archivo) {
        try {
            //System.getProperty("user.dir")+ dir;

//            File ruta = dir;
//            System.out.println("ruta : " + ruta);
//            if (ruta == null) {
//                System.out.println("No se encontro el archivo.");
//                System.exit(2);
//            }
            JasperReport reporte = null;
            try {
//                reporte = (JasperReport) JRLoader.loadObject(dir);
                URL in = this.getClass().getResource(archivo);
                reporte = (JasperReport) JRLoader.loadObject(in);
            } catch (JRException jr) {
                System.out.println("Error al cargar reporte." + jr.getMessage());
                System.exit(3);
            }
            Map parametro = new HashMap();
//            parametro.put(bddVar, HORARIOATENCION);
            parametro.put(VHORARIOATENCION, HORARIOATENCION);
            parametro.put(Vmes, mes);
            parametro.put(Vdia, dia);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(archivo, parametro, con.getCon());
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, con.getCon());
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("REPORTE");
            jv.setVisible(true);
//            JasperPrintManager.printReport(jasperPrint, false);

        } catch (Exception e) {
            System.out.println("Mensaje de Error " + e.getMessage());
        }

    }

    public void reporteatencionesAnual(String HORARIOATENCION, String VHORARIOATENCION, String archivo) {
        try {           //System.getProperty("user.dir")+ dir;

//            File ruta = dir;
//            System.out.println("ruta : " + ruta);
//            if (ruta == null) {
//                System.out.println("No se encontro el archivo.");
//                System.exit(2);
//            }
            JasperReport reporte = null;
            try {
//                reporte = (JasperReport) JRLoader.loadObject(dir);
                URL in = this.getClass().getResource(archivo);
                reporte = (JasperReport) JRLoader.loadObject(in);
            } catch (JRException jr) {
                System.out.println("Error al cargar reporte." + jr.getMessage());
                System.exit(3);
            }
            Map parametro = new HashMap();
//            parametro.put(bddVar, HORARIOATENCION);
            parametro.put(VHORARIOATENCION, HORARIOATENCION);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(archivo, parametro, con.getCon());
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, con.getCon());
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("REPORTE");
            jv.setVisible(true);
//            JasperPrintManager.printReport(jasperPrint, false);

        } catch (Exception e) {
            System.out.println("Mensaje de Error " + e.getMessage());
        }

    }

    public void imprimirTodo(String bddVar, int HORARIOATENCION, String archivo) {
        try {
            //System.getProperty("user.dir")+ dir;

//            File ruta = dir;
//            System.out.println("ruta : " + ruta);
//            if (ruta == null) {
//                System.out.println("No se encontro el archivo.");
//                System.exit(2);
//            }
            JasperReport reporte = null;
            try {
//                reporte = (JasperReport) JRLoader.loadObject(dir);
                URL in = this.getClass().getResource(archivo);
                reporte = (JasperReport) JRLoader.loadObject(in);
            } catch (JRException jr) {
                System.out.println("Error al cargar reporte." + jr.getMessage());
                System.exit(3);
            }
            Map parametro = new HashMap();
            parametro.put(bddVar, HORARIOATENCION);
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, con.getCon());
            JasperViewer jv = new JasperViewer(jasperPrint, false);
//            jv.setTitle("REPORTE");
//            jv.setVisible(true);
            JasperPrintManager.printReport(jasperPrint, false);

        } catch (Exception e) {
            System.out.println("Mensaje de Error" + e.getMessage());
        }

    }

    public void reportediariomedico(String año, String Vaño, String mes, String Vmes, String dia, String Vdia, String medico, String Vmedico, String archivo) {
        try {
            //System.getProperty("user.dir")+ dir;

//            File ruta = dir;
//            System.out.println("ruta : " + ruta);
//            if (ruta == null) {
//                System.out.println("No se encontro el archivo.");
//                System.exit(2);
//            }
            JasperReport reporte = null;
            try {
//                reporte = (JasperReport) JRLoader.loadObject(dir);
                URL in = this.getClass().getResource(archivo);
                reporte = (JasperReport) JRLoader.loadObject(in);
            } catch (JRException jr) {
                System.out.println("Error al cargar reporte." + jr.getMessage());
                System.exit(3);
            }
            Map parametro = new HashMap();
//            parametro.put(bddVar, HORARIOATENCION);
            parametro.put(Vaño, año);
            parametro.put(Vmes, mes);
            parametro.put(Vdia, dia);
            parametro.put(Vmedico, medico);
//            JasperPrint jasperPrint = JasperFillManager.fillReport(archivo, parametro, con.getCon());
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametro, con.getCon());
            JasperViewer jv = new JasperViewer(jasperPrint, false);
            jv.setTitle("REPORTE");
            jv.setVisible(true);
//            JasperPrintManager.printReport(jasperPrint, false);

        } catch (Exception e) {
            System.out.println("Mensaje de Error " + e.getMessage());
        }

    }

//    public static void main(String[] args) {
//        ReportesControlador b = new ReportesControlador();
//        b.reporteatencionesDiario("2015", "HORARIOATENCION", "05", "mes", "07", "dia", "reportemes.jasper");
//    }
}
