/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;
import vista.formularios.FrmLogin;

/**
 *
 * @author EddyA
 */
public class SBCSLaEsperanza {

    /**
     * @param args the command line arguments
     */
    

    public static void main(String[] args) {

        Date fecha1 = new Date();

        System.out.println(fecha1.toLocaleString());
        FrmLogin fr = new FrmLogin();
        fr.show();

  
    }

}
