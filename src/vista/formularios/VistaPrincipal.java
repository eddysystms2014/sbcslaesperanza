/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.formularios;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import vista.formularios.FrmPaciente;

/**
 *
 * @author JC-PC
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form P
     */
    public VistaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(this);
        mnPass.setVisible(false);
        mnid.setVisible(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setIconImage(new ImageIcon(getClass().getResource("../bot.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        mnid = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        mnNomUs = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        mnRol = new javax.swing.JMenu();
        mnPass = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1125, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/folder.png"))); // NOI18N
        jMenu1.setText("Archivo");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/back_alt.png"))); // NOI18N
        jMenuItem3.setText("Cambiar de Usuario");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/exit.png"))); // NOI18N
        jMenuItem2.setText("Salir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/new archive.png"))); // NOI18N
        jMenu8.setText("Admisión");
        jMenu8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/new doc.png"))); // NOI18N
        jMenu9.setText("Paciente");

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        jMenuItem11.setText("Buscar");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem11);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/new doc.png"))); // NOI18N
        jMenuItem1.setText("Registrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem1);

        jMenu8.add(jMenu9);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/doc.jpg"))); // NOI18N
        jMenu3.setText("Médicos");

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/up_alt.png"))); // NOI18N
        jMenuItem6.setText("Activar");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/notebook.png"))); // NOI18N
        jMenuItem4.setText("Modificar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/new doc.png"))); // NOI18N
        jMenuItem5.setText("Registrar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenu8.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/new archive.png"))); // NOI18N
        jMenu4.setText("Especialidad");

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/advanced.png"))); // NOI18N
        jMenuItem7.setText("Gestión");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenu8.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N
        jMenu5.setText("Usuarios");
        jMenu5.setToolTipText("");

        jMenuItem9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/notebook.png"))); // NOI18N
        jMenuItem9.setText("Modificar");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/new doc.png"))); // NOI18N
        jMenuItem8.setText("Registrar");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem8);

        jMenu8.add(jMenu5);

        jMenuBar1.add(jMenu8);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/lock.png"))); // NOI18N
        jMenu6.setText("Control");
        jMenu6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/key32.png"))); // NOI18N
        jMenuItem10.setText("Gestión");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuBar1.add(jMenu6);

        mnid.setText("jMenu6");
        jMenuBar1.add(mnid);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N
        jMenu7.setText("Usuario Actual: ");
        jMenuBar1.add(jMenu7);

        mnNomUs.setText("jMenu8");
        jMenuBar1.add(mnNomUs);

        jMenu2.setText("Tipo De Usuario :");
        jMenuBar1.add(jMenu2);

        mnRol.setText("jMenu9");
        mnRol.setToolTipText("Tipo De Usuario");
        jMenuBar1.add(mnRol);

        mnPass.setText("jMenu");
        jMenuBar1.add(mnPass);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed


          FrmPaciente  FP = new FrmPaciente();
            FP.show();
            jDesktopPane1.add(FP);


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        FrmMedicos FE;
        try {
            FE = new FrmMedicos();
            FE.show();
            jDesktopPane1.add(FE);
            FrmMedicos.btnModificarMedico.setVisible(false);
            FrmMedicos.jButton3.setVisible(false);
            FrmMedicos.jButton4.setVisible(false);
            FrmMedicos.jPanel5.setVisible(false);
            FrmMedicos.jButton2.setVisible(false);

        } catch (IllegalAccessException ex) {

        }


    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        FrmMedicos FE;
        try {
            FE = new FrmMedicos();
            FE.show();
            jDesktopPane1.add(FE);
            FrmMedicos.btnModificarMedico.setVisible(false);
            FrmMedicos.jButton3.setVisible(false);
            FrmMedicos.jButton4.setVisible(true);
            FrmMedicos.jPanel2.setVisible(false);
            FrmMedicos.jPanel3.setVisible(false);
            FrmMedicos.jPanel4.setVisible(false);
            FrmMedicos.jButton1.setVisible(false);
            FrmMedicos.btnAbrirE.setVisible(false);
            FrmMedicos.txtNombreMedico.setEnabled(false);
            FrmMedicos.txtTlf.setEnabled(false);
            FrmMedicos.txtid.setEnabled(false);
            FrmMedicos.cbtIdEspecialidad.setEnabled(false);
        } catch (IllegalAccessException ex) {

        }


    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        frmEspecialidad FE = new frmEspecialidad();
        FE.show();
        jDesktopPane1.add(FE);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:

        FrmUsuario FU = new FrmUsuario();
        FU.show();
        FU.setSize(460, 450);
        jDesktopPane1.add(FU);
        FrmUsuario.btnModificar.setVisible(false);
        FrmUsuario.btnEliminar.setVisible(false);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        FrmUsuario FU = new FrmUsuario();
        FU.show();
        jDesktopPane1.add(FU);
        FrmUsuario.btnGuardar.setVisible(false);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        FrmContraseña FC = new FrmContraseña();
        FC.show();
        jDesktopPane1.add(FC);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        FrmBusquedas FT = new FrmBusquedas();
        FT.show();
        jDesktopPane1.add(FT);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        FrmLogin fl=new FrmLogin();
        fl.show();
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
         FrmMedicos FE;
        try {
            FE = new FrmMedicos();
            FE.show();
            jDesktopPane1.add(FE);
            FrmMedicos.btnModificarMedico.setVisible(false);
            FrmMedicos.jButton3.setVisible(false);
            FrmMedicos.jButton4.setVisible(true);
            FrmMedicos.jPanel2.setVisible(false);
            FrmMedicos.jPanel3.setVisible(false);
            FrmMedicos.jPanel4.setVisible(false);
            FrmMedicos.jButton1.setVisible(false);
            FrmMedicos.btnAbrirE.setVisible(false);
//            FrmMedicos.txtNombreMedico.setEnabled(false);
//            FrmMedicos.txtTlf.setEnabled(false);
            FrmMedicos.txtid.setEnabled(false);
//            FrmMedicos.cbtIdEspecialidad.setEnabled(false);
        } catch (IllegalAccessException ex) {

        }

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    public static javax.swing.JMenu jMenu3;
    public static javax.swing.JMenu jMenu4;
    public static javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    public static javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    public static javax.swing.JMenu mnNomUs;
    public static javax.swing.JMenu mnPass;
    public static javax.swing.JMenu mnRol;
    public static javax.swing.JMenu mnid;
    // End of variables declaration//GEN-END:variables
}
