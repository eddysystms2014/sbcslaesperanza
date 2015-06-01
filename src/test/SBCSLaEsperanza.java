/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controlador.ControlUsuario;
import controlador.controlinstitucion;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import static vista.FrmHistorias.jLabel1;
import vista.FrmLogin;
import vista.frmParametrosInsti;
import vista.frmconfigInicial;

/**
 *
 * @author EddyA
 */
public class SBCSLaEsperanza {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControlUsuario cu = new ControlUsuario();
        controlinstitucion ci = new controlinstitucion();
        if (cu.contusuario() > 0 && ci.cont() > 0) {
            FrmLogin fr = new FrmLogin();
            fr.show();
        } else if (cu.contusuario() == 0) {
            frmconfigInicial cf = new frmconfigInicial();
            cf.show();
        } else if (ci.cont() == 0) {
            frmParametrosInsti fp = new frmParametrosInsti();
            fp.show();
        }

    }

}
