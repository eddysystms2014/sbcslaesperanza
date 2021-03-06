/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import SBCSLaEsperanza.DesktopConFondo;
import controlador.ControlHistorias;
import controlador.ControlPaciente;
import controlador.ValidarCedula;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static vista.FrmHistorias.jLabel1;

/**
 *
 * @author JC-PC
 */
public class FrmBusquedas extends javax.swing.JInternalFrame {

    /**
     * Creates new form FrmBusquedas
     */
    public FrmBusquedas() {
        initComponents();
        jButton3.setVisible(true);
        Dimension desktopSize = VistaPrincipal.jDesktopPane1.getSize();
        Dimension jInternalFrameSize = this.getSize();
        this.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, 4);

        ((DesktopConFondo) fonbusqueda).setImagen("onda.jpg");

    }
    ControlPaciente CP = new ControlPaciente();
    ControlHistorias ch = new ControlHistorias();
    ValidarCedula valc = new ValidarCedula();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btndrupo = new javax.swing.ButtonGroup();
        fonbusqueda = new DesktopConFondo();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtBusquedaCedula = new javax.swing.JTextField();
        txtBusquedaNumHist = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        txtBusquedaNombres = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Cestion De Turnos");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Datos Para Turno"));

        jTextField3.setEditable(false);
        jTextField3.setBorder(javax.swing.BorderFactory.createTitledBorder("Num. Historia"));

        jTextField4.setEditable(false);
        jTextField4.setBorder(javax.swing.BorderFactory.createTitledBorder("Cedula De Identidad"));

        jTextField5.setEditable(false);
        jTextField5.setBorder(javax.swing.BorderFactory.createTitledBorder("Apellido Paterno"));

        jTextField6.setEditable(false);
        jTextField6.setBorder(javax.swing.BorderFactory.createTitledBorder("Apellido Materno"));

        jTextField7.setEditable(false);
        jTextField7.setBorder(javax.swing.BorderFactory.createTitledBorder("Primer Nombre"));

        jTextField8.setEditable(false);
        jTextField8.setBorder(javax.swing.BorderFactory.createTitledBorder("Segundo Nombre"));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/down_alt.png"))); // NOI18N
        jButton1.setText("OK");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField8)
                    .addComponent(jTextField7)
                    .addComponent(jTextField6)
                    .addComponent(jTextField5)
                    .addComponent(jTextField4)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 158, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        txtBusquedaCedula.setBorder(javax.swing.BorderFactory.createTitledBorder("Cedula"));
        txtBusquedaCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaCedulaKeyReleased(evt);
            }
        });

        txtBusquedaNumHist.setBorder(javax.swing.BorderFactory.createTitledBorder("Numero Historia"));
        txtBusquedaNumHist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaNumHistKeyReleased(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        jButton3.setToolTipText("Buscar");
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txtBusquedaNombres.setBorder(javax.swing.BorderFactory.createTitledBorder("Apellidos y Nombres"));
        txtBusquedaNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBusquedaNombresActionPerformed(evt);
            }
        });
        txtBusquedaNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaNombresKeyReleased(evt);
            }
        });

        jLabel1.setText("TIPO DE BUSQUEDA");

        javax.swing.GroupLayout fonbusquedaLayout = new javax.swing.GroupLayout(fonbusqueda);
        fonbusqueda.setLayout(fonbusquedaLayout);
        fonbusquedaLayout.setHorizontalGroup(
            fonbusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fonbusquedaLayout.createSequentialGroup()
                .addGroup(fonbusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fonbusquedaLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(fonbusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusquedaNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBusquedaCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(fonbusquedaLayout.createSequentialGroup()
                                .addComponent(txtBusquedaNumHist, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        fonbusquedaLayout.setVerticalGroup(
            fonbusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fonbusquedaLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusquedaCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(fonbusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtBusquedaNumHist, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(txtBusquedaNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        fonbusqueda.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fonbusqueda.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fonbusqueda.setLayer(txtBusquedaCedula, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fonbusqueda.setLayer(txtBusquedaNumHist, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fonbusqueda.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fonbusqueda.setLayer(txtBusquedaNombres, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fonbusqueda.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fonbusqueda)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fonbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaNombresKeyReleased
        // TODO add your handling code here:
        try {
            txtBusquedaCedula.setText("");
            txtBusquedaNumHist.setText("");
            CP.BuscarApePat();
            limpiar();
            String cadena = (txtBusquedaNombres.getText()).toUpperCase();
            txtBusquedaNombres.setText(cadena);
            if (txtBusquedaNombres.getText() != "") {
                CP.BuscarApePat();
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_txtBusquedaNombresKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTextField3.getText().isEmpty() == false) {
            FrmHistorias fh = new FrmHistorias();
            fh.show();
            VistaPrincipal.jDesktopPane1.add(fh);

//            ch.cargarTabla();
            ch.fillTabla();
            FrmHistorias.jTextField1.setText(jTextField3.getText());
            FrmHistorias.jTextField1.setText(jTextField3.getText());
            FrmHistorias.jTextField3.setText(jTextField4.getText());
            FrmHistorias.jTextField7.setText(jTextField5.getText() + " " + jTextField6.getText() + " " + jTextField7.getText() + " " + jTextField8.getText());
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Paciente ", "Información", 1);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        int n = jTable1.getSelectedRow();
        jTextField3.setText(jTable1.getValueAt(n, 0).toString());
        jTextField4.setText(jTable1.getValueAt(n, 1).toString());
        jTextField5.setText(jTable1.getValueAt(n, 2).toString());
        jTextField6.setText(jTable1.getValueAt(n, 3).toString());
        jTextField7.setText(jTable1.getValueAt(n, 4).toString());
        jTextField8.setText(jTable1.getValueAt(n, 5).toString());
        jButton1.setEnabled(true);

    }//GEN-LAST:event_jTable1MouseClicked
    public void limpiar() {
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (txtBusquedaNumHist.getText().isEmpty() == false) {
            try {
                limpiar();
                CP.buscarpacienteNumHistoria(Integer.valueOf(txtBusquedaNumHist.getText()));
                int id = Integer.valueOf(txtBusquedaNumHist.getText());
                if (CP.paciente(id) == null) {
                    JOptionPane.showMessageDialog(null, "No se encontro ningun Paciente", "Información", 1);
                }
                jTextField3.setText(CP.paciente(id).getIdpaciente().toString());
                jTextField4.setText(CP.paciente(id).getCedpaciente());
                jTextField5.setText(CP.paciente(id).getApeppaciente());
                jTextField6.setText(CP.paciente(id).getApempaciente());
                jTextField7.setText(CP.paciente(id).getNom1paciente());
                jTextField8.setText(CP.paciente(id).getNom2paciente());
                jButton1.setEnabled(true);
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingres Bun. Historia", "Información", 1);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        int n = jTable1.getSelectedRow();
        jTextField3.setText(jTable1.getValueAt(n, 0).toString());
        jTextField4.setText(jTable1.getValueAt(n, 1).toString());
        jTextField5.setText(jTable1.getValueAt(n, 2).toString());
        jTextField6.setText(jTable1.getValueAt(n, 3).toString());
        jTextField7.setText(jTable1.getValueAt(n, 4).toString());
        jTextField8.setText(jTable1.getValueAt(n, 5).toString());
        jButton1.setEnabled(true);

    }//GEN-LAST:event_jTable1KeyReleased

    private void txtBusquedaCedulaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaCedulaKeyReleased
        // TODO add your handling code here:
        txtBusquedaNumHist.setText("");
        txtBusquedaNombres.setText("");
        CP.Buscarcedula();
        limpiar();
        if (txtBusquedaNombres.getText() != "") {
            CP.Buscarcedula();
        }
    }//GEN-LAST:event_txtBusquedaCedulaKeyReleased

    private void txtBusquedaNumHistKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaNumHistKeyReleased
        // TODO add your handling code here:
        txtBusquedaCedula.setText("");
        txtBusquedaNombres.setText("");
    }//GEN-LAST:event_txtBusquedaNumHistKeyReleased

    private void txtBusquedaNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBusquedaNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaNombresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btndrupo;
    private javax.swing.JDesktopPane fonbusqueda;
    public static javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JTextField jTextField3;
    public static javax.swing.JTextField jTextField4;
    public static javax.swing.JTextField jTextField5;
    public static javax.swing.JTextField jTextField6;
    public static javax.swing.JTextField jTextField7;
    public static javax.swing.JTextField jTextField8;
    public static javax.swing.JTextField txtBusquedaCedula;
    public static javax.swing.JTextField txtBusquedaNombres;
    private javax.swing.JTextField txtBusquedaNumHist;
    // End of variables declaration//GEN-END:variables
}
