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
        
        txtBusquedaNumHist.setEditable(false);
        txtBusquedaNombres.setEditable(false);
        txtBusquedaCedula.setEditable(true);
        jButton2.setVisible(true);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
        Dimension desktopSize = VistaPrincipal.jDesktopPane1.getSize();
        Dimension jInternalFrameSize = this.getSize();
        this.setLocation((desktopSize.width - jInternalFrameSize.width) / 2, 4);
        jButton5.setVisible(false);
        jTable1.setVisible(false);
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
        jPanel2 = new javax.swing.JPanel();
        txtBusquedaCedula = new javax.swing.JTextField();
        txtBusquedaNombres = new javax.swing.JTextField();
        txtBusquedaNumHist = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Cestion De Turnos");

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        txtBusquedaCedula.setBorder(javax.swing.BorderFactory.createTitledBorder("Cedula"));

        txtBusquedaNombres.setBorder(javax.swing.BorderFactory.createTitledBorder("Apellidos y Nombres"));
        txtBusquedaNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaNombresKeyReleased(evt);
            }
        });

        txtBusquedaNumHist.setBorder(javax.swing.BorderFactory.createTitledBorder("Numero Historia"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBusquedaNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBusquedaCedula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBusquedaNumHist, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBusquedaCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(txtBusquedaNumHist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(txtBusquedaNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        jButton2.setText("Buscar");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        jButton3.setText("Buscar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/search.png"))); // NOI18N
        jButton4.setText("Buscar");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
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

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Busqueda Por:"));

        jRadioButton1.setBackground(new java.awt.Color(204, 204, 255));
        btndrupo.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Cedula");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(204, 204, 255));
        btndrupo.add(jRadioButton2);
        jRadioButton2.setText("Numero Historia");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setBackground(new java.awt.Color(204, 204, 255));
        btndrupo.add(jRadioButton3);
        jRadioButton3.setText("Inteligente");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Para Turno"));

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

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit_1.png"))); // NOI18N
        jButton5.setText("Modificar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
                        .addGap(0, 158, Short.MAX_VALUE))
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fonbusquedaLayout = new javax.swing.GroupLayout(fonbusqueda);
        fonbusqueda.setLayout(fonbusquedaLayout);
        fonbusquedaLayout.setHorizontalGroup(
            fonbusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fonbusquedaLayout.createSequentialGroup()
                .addGroup(fonbusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fonbusquedaLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(fonbusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(fonbusquedaLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fonbusquedaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        fonbusquedaLayout.setVerticalGroup(
            fonbusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fonbusquedaLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(fonbusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(fonbusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        fonbusqueda.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fonbusqueda.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fonbusqueda.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fonbusqueda.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fonbusqueda.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fonbusqueda.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        fonbusqueda.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fonbusqueda)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fonbusqueda)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaNombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaNombresKeyReleased
        // TODO add your handling code here:
//        CP.BuscarApePat();
        limpiar();
        String cadena = (txtBusquedaNombres.getText()).toUpperCase();
        txtBusquedaNombres.setText(cadena);
        if (txtBusquedaNombres.getText() != "") {
            CP.BuscarApePat();
        }
    }//GEN-LAST:event_txtBusquedaNombresKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTextField3.getText().isEmpty() == false) {
            FrmHistorias fh = new FrmHistorias();
            fh.show();
            VistaPrincipal.jDesktopPane1.add(fh);

            ch.cargarTabla();
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
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        jTable1.setVisible(false);
        txtBusquedaNumHist.setEditable(false);
        txtBusquedaNombres.setEditable(false);
        txtBusquedaCedula.setEditable(true);
        txtBusquedaNumHist.setText("");
        txtBusquedaNombres.setText("");
        txtBusquedaCedula.setText("");
        limpiar();
        jButton2.setVisible(true);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        jTable1.setVisible(false);
        txtBusquedaNumHist.setEditable(true);
        txtBusquedaNombres.setEditable(false);
        txtBusquedaCedula.setEditable(false);
        txtBusquedaNumHist.setText("");
        txtBusquedaNombres.setText("");
        txtBusquedaCedula.setText("");
        limpiar();
        jButton2.setVisible(false);
        jButton3.setVisible(true);
        jButton4.setVisible(false);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        limpiar();
        jTable1.setVisible(true);
        txtBusquedaNumHist.setEditable(false);
        txtBusquedaNombres.setEditable(true);
        txtBusquedaCedula.setEditable(false);
        txtBusquedaNumHist.setText("");
        txtBusquedaNombres.setText("");
        txtBusquedaCedula.setText("");
        jButton2.setVisible(false);
        jButton3.setVisible(false);
        jButton4.setVisible(false);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            if (txtBusquedaCedula.getText().isEmpty() == false) {
                limpiar();

                CP.buscarpacienteCI(txtBusquedaCedula.getText());
                String cedula = txtBusquedaCedula.getText();
                if (CP.buscarPacienteCI(cedula) == null) {
                    JOptionPane.showMessageDialog(null, "No se encontro ningun Paciente", "Información", 1);
                }
                jTextField3.setText(CP.buscarPacienteCI(cedula).getIdpaciente().toString());
                jTextField4.setText(CP.buscarPacienteCI(cedula).getCedpaciente());
                jTextField5.setText(CP.buscarPacienteCI(cedula).getApeppaciente());
                jTextField6.setText(CP.buscarPacienteCI(cedula).getApempaciente());
                jTextField7.setText(CP.buscarPacienteCI(cedula).getNom1paciente());
                jTextField8.setText(CP.buscarPacienteCI(cedula).getNom2paciente());
                jButton1.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Ingres Bun. Cedula", "Información", 1);
            }

        } catch (Exception e) {
        }


    }//GEN-LAST:event_jButton2ActionPerformed

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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if (txtBusquedaNombres.getText() != "") {
            CP.BuscarApePat();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        if (jTextField3.getText().isEmpty() == false) {
            FrmPaciente fp = new FrmPaciente();
            fp.show();
            VistaPrincipal.jDesktopPane1.add(fp);
            FrmPaciente.jButton1.setVisible(false);
            FrmPaciente.jButton2.setVisible(true);
            int cedula = Integer.valueOf(jTextField3.getText());
            FrmPaciente.txthistoriaclinica.setEditable(false);
            FrmPaciente.txthistoriaclinica.setText(CP.paciente(cedula).getIdpaciente().toString());
            FrmPaciente.txtcedula.setText(CP.paciente(cedula).getCedpaciente());
            FrmPaciente.txtapellido1.setText(CP.paciente(cedula).getApeppaciente());
            FrmPaciente.txtapellido2.setText(CP.paciente(cedula).getApempaciente());
            FrmPaciente.txtnombre1.setText(CP.paciente(cedula).getNom1paciente());
            FrmPaciente.txtnombre2.setText(CP.paciente(cedula).getNom2paciente());
            FrmPaciente.txtdireccion.setText(CP.paciente(cedula).getDirecpaciente());
            FrmPaciente.txtbarrio.setText(CP.paciente(cedula).getBarriopaciente());
            FrmPaciente.cbxzona.setSelectedItem(CP.paciente(cedula).getZonapaciente());
            FrmPaciente.txtnrotelefono.setText(CP.paciente(cedula).getNrotelpaciente());
            FrmPaciente.jDateChooser1.setDate(CP.paciente(cedula).getFenacpaciente());
            FrmPaciente.txtlugarnacimiento.setText(CP.paciente(cedula).getLugarnacpaciente());
            FrmPaciente.txtnacionalidad.setText(CP.paciente(cedula).getNaciopaciente());
            FrmPaciente.txtgrupocultural.setText(CP.paciente(cedula).getGruppaciente());
            FrmPaciente.txtedad.setText(CP.paciente(cedula).getEdadpaciente().toString());
            FrmPaciente.cbxgenero.setSelectedItem(CP.paciente(cedula).getGenpaciente());
            FrmPaciente.cbxestadocivil.setSelectedItem(CP.paciente(cedula).getEcpaciente());
            FrmPaciente.txtinstruccion.setSelectedItem(CP.paciente(cedula).getInstrpaciente());
            FrmPaciente.jDateChooser2.setDate(CP.paciente(cedula).getFecadpaciente());
            FrmPaciente.txtocupacion.setText(CP.paciente(cedula).getOcuppaciente());
            FrmPaciente.txtempresa.setText(CP.paciente(cedula).getEmpaciente());
            FrmPaciente.txtsegurosalud.setText(CP.paciente(cedula).getSegpaciente());
            FrmPaciente.txtreferido.setText(CP.paciente(cedula).getRefpaciente());
            FrmPaciente.txtencasonecesario.setText(CP.paciente(cedula).getLlamarpaciente());
            FrmPaciente.txtparentesco.setText(CP.paciente(cedula).getParenpaciente());
            FrmPaciente.txtafinidad.setText(CP.paciente(cedula).getDirecpaciente());
            FrmPaciente.txtnrotelefonoreferido.setText(CP.paciente(cedula).getNrotelpaciente());
            FrmPaciente.txtcodadmisionista.setText(CP.paciente(cedula).getCodadmisionista());
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Primero Busque un Paciente", "Información", 1);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btndrupo;
    private javax.swing.JDesktopPane fonbusqueda;
    public static javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public static javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JTextField jTextField3;
    public static javax.swing.JTextField jTextField4;
    public static javax.swing.JTextField jTextField5;
    public static javax.swing.JTextField jTextField6;
    public static javax.swing.JTextField jTextField7;
    public static javax.swing.JTextField jTextField8;
    private javax.swing.JTextField txtBusquedaCedula;
    public static javax.swing.JTextField txtBusquedaNombres;
    private javax.swing.JTextField txtBusquedaNumHist;
    // End of variables declaration//GEN-END:variables
}
