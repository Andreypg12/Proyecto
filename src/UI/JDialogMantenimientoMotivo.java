/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package UI;

import BLL.TipoMantenimiento;
import BLL_Motivos.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class JDialogMantenimientoMotivo extends javax.swing.JDialog {

    private TipoMantenimiento tipoMantenimiento;
    private Motivo motivo;

    /**
     * Creates new form JDialogMantenimientoMotivo
     */
    public JDialogMantenimientoMotivo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public JDialogMantenimientoMotivo(TipoMantenimiento tipoMantenimiento, Motivo motivo) {
        initComponents();
        this.setModal(true);
        this.setLocationRelativeTo(null);
        this.tipoMantenimiento = tipoMantenimiento;
        jCmbTipoMotivo.setModel(new DefaultComboBoxModel<>(TiposMotivos.values()));
        llenarComboBox();

        switch (tipoMantenimiento) {
            case AGREGAR -> {
                this.setTitle("Agregar Motivo");
                jLblVacuna.setVisible(false);
                jCmbVacunas.setVisible(false);
                jPanelMantenimientoVacunas.setVisible(false);
                jLblMantenimiento.setVisible(false);

            }
            case MODIFICAR -> {
                this.motivo = motivo;
                this.setTitle("Modificar Motivo");
                jCmbTipoMotivo.setEnabled(false);

            }
            case CONSULTAR -> {
                this.motivo = motivo;
                this.setTitle("Consulta de motivo");

                jCmbTipoMotivo.setEnabled(false);
                jTxtDescripcion.setEditable(false);
                jTxtPrecio.setEditable(false);

                if (motivo.isAplicaExamen()) {
                    jRBSiAplicaExamen.setSelected(true);
                } else {
                    jRBNoAplicaExamen.setSelected(true);
                }
                
                jRBSiAplicaExamen.setEnabled(false);
                jRBNoAplicaExamen.setEnabled(false);
                jBtnAceptar.setVisible(false);
                jBtnCancelar.setText("Salir");
                jCmbVacunas.setEnabled(false);
            }
        }

        if (this.motivo != null) {
            jTxtDescripcion.setText(motivo.getDescripcion());
            jTxtPrecio.setText(String.valueOf(motivo.getPrecio()));
            
            if (motivo instanceof Vacunacion) {
                jCmbTipoMotivo.setSelectedIndex(2);

            } else if(motivo.getPrecio() > 0){
                jCmbTipoMotivo.setSelectedIndex(0);
            }
            else {
                jCmbTipoMotivo.setSelectedIndex(1);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jCmbTipoMotivo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTxtDescripcion = new javax.swing.JTextField();
        jLblPrecio = new javax.swing.JLabel();
        jTxtPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jRBSiAplicaExamen = new javax.swing.JRadioButton();
        jRBNoAplicaExamen = new javax.swing.JRadioButton();
        jLblVacuna = new javax.swing.JLabel();
        jCmbVacunas = new javax.swing.JComboBox<>();
        jBtnAceptar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jPanelMantenimientoVacunas = new javax.swing.JPanel();
        jBtnAgregar = new javax.swing.JButton();
        jBtnModificar = new javax.swing.JButton();
        jBtnConsultar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jLblMantenimiento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tipo de motivo");

        jCmbTipoMotivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbTipoMotivoActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Descripcion");

        jTxtDescripcion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtDescripcionActionPerformed(evt);
            }
        });

        jLblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblPrecio.setText("Precio");

        jTxtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtPrecioActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Aplica examen");

        buttonGroup1.add(jRBSiAplicaExamen);
        jRBSiAplicaExamen.setSelected(true);
        jRBSiAplicaExamen.setText("Si");

        buttonGroup1.add(jRBNoAplicaExamen);
        jRBNoAplicaExamen.setText("No");
        jRBNoAplicaExamen.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jRBNoAplicaExamen.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLblVacuna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblVacuna.setText("Vacuna");

        jCmbVacunas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbVacunasActionPerformed(evt);
            }
        });

        jBtnAceptar.setText("Aceptar");
        jBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarActionPerformed(evt);
            }
        });

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnAgregar.setText("Agregar");
        jBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarActionPerformed(evt);
            }
        });
        jPanelMantenimientoVacunas.add(jBtnAgregar);

        jBtnModificar.setText("Modificar");
        jBtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarActionPerformed(evt);
            }
        });
        jPanelMantenimientoVacunas.add(jBtnModificar);

        jBtnConsultar.setText("Consultar");
        jBtnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConsultarActionPerformed(evt);
            }
        });
        jPanelMantenimientoVacunas.add(jBtnConsultar);

        jBtnSalir.setText("Eliminar");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });
        jPanelMantenimientoVacunas.add(jBtnSalir);

        jLblMantenimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblMantenimiento.setText("Mantenimiento de vacunas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelMantenimientoVacunas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnAceptar)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnCancelar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLblVacuna, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addComponent(jRBSiAplicaExamen)
                                    .addGap(18, 18, 18)
                                    .addComponent(jRBNoAplicaExamen))
                                .addComponent(jCmbVacunas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTxtPrecio, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTxtDescripcion, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLblPrecio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCmbTipoMotivo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jCmbTipoMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jTxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLblPrecio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRBSiAplicaExamen)
                    .addComponent(jRBNoAplicaExamen))
                .addGap(18, 18, 18)
                .addComponent(jLblVacuna)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCmbVacunas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnAceptar)
                    .addComponent(jBtnCancelar))
                .addGap(18, 18, 18)
                .addComponent(jLblMantenimiento)
                .addGap(11, 11, 11)
                .addComponent(jPanelMantenimientoVacunas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCmbTipoMotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbTipoMotivoActionPerformed
        // TODO add your handling code here:
        switch ((TiposMotivos) jCmbTipoMotivo.getSelectedItem()) {
            case PRECIO_PREESTABLECIDO -> {
                jLblVacuna.setVisible(false);
                jCmbVacunas.setVisible(false);
                jTxtPrecio.setEditable(true);
                jRBSiAplicaExamen.setEnabled(true);
                jRBSiAplicaExamen.setSelected(true);
                jRBNoAplicaExamen.setEnabled(true);
                jPanelMantenimientoVacunas.setVisible(false);
                jLblMantenimiento.setVisible(false);
                jLblPrecio.setVisible(true);
                jTxtPrecio.setVisible(true);
            }
            case PRECIO_NO_PREESTABLECIDO -> {
                jLblVacuna.setVisible(false);
                jCmbVacunas.setVisible(false);
                jTxtPrecio.setEditable(true);
                jRBSiAplicaExamen.setEnabled(true);
                jRBSiAplicaExamen.setSelected(true);
                jRBNoAplicaExamen.setEnabled(true);
                jPanelMantenimientoVacunas.setVisible(false);
                jLblMantenimiento.setVisible(false);
                jLblPrecio.setVisible(false);
                jTxtPrecio.setVisible(false);
            }
            case CON_VACUNA -> {
                jLblVacuna.setVisible(true);
                jCmbVacunas.setVisible(true);
                jTxtPrecio.setText(String.valueOf(((Vacuna) jCmbVacunas.getSelectedItem()).getPrecio()));
                jTxtPrecio.setEditable(false);
                jRBNoAplicaExamen.setSelected(true);
                jRBSiAplicaExamen.setEnabled(false);
                jRBNoAplicaExamen.setEnabled(false);
                jPanelMantenimientoVacunas.setVisible(true);
                jLblMantenimiento.setVisible(true);
                jLblPrecio.setVisible(true);
                jTxtPrecio.setVisible(true);
            }
        }
    }//GEN-LAST:event_jCmbTipoMotivoActionPerformed

    private void llenarComboBox() {
        try {
            jCmbVacunas.setModel(new DefaultComboBoxModel(Vacuna.consultarVacunas().toArray()));
        } catch (Exception ex) {
            Logger.getLogger(JDialogMantenimientoMotivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
        // TODO add your handling code here:
        switch (tipoMantenimiento) {
            case AGREGAR -> {

                try {
                    String descripcion = jTxtDescripcion.getText();

                    boolean aplicaExamen = aplicaExamen();
                    Motivo motivo = null;

                    switch ((TiposMotivos) jCmbTipoMotivo.getSelectedItem()) {
                        case PRECIO_PREESTABLECIDO -> {
                            motivo = new Motivo(descripcion, Double.parseDouble(jTxtPrecio.getText()), aplicaExamen);
                        }
                        case PRECIO_NO_PREESTABLECIDO -> {
                            motivo = new Motivo(descripcion, aplicaExamen);
                        }
                        case CON_VACUNA -> {
                            motivo = new Vacunacion(descripcion, null);
                        }
                    }

                    Motivo.agregarMotivo(motivo);
                    JOptionPane.showMessageDialog(null, "El motivo fue agregado", "Motivo agregado", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Debes ingresar un numero en el precio", "Valor incorrecto", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    Logger.getLogger(JDialogMantenimientoMotivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case MODIFICAR -> {
                try {
                    motivo.setDescripcion(jTxtDescripcion.getText());
                    motivo.setPrecio(Double.parseDouble(jTxtPrecio.getText()));
                    motivo.setAplicaExamen(aplicaExamen());

                    Motivo.modificarMotivo(motivo);
                    JOptionPane.showMessageDialog(null, "El motivo fue modificado", "Motivo modificado", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();

                } catch (Exception ex) {
                    Logger.getLogger(JDialogMantenimientoMotivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jBtnAceptarActionPerformed

    private void jCmbVacunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbVacunasActionPerformed
        // TODO add your handling code here:
        jTxtPrecio.setText(String.valueOf(((Vacuna) jCmbVacunas.getSelectedItem()).getPrecio()));
    }//GEN-LAST:event_jCmbVacunasActionPerformed

    private void jTxtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtDescripcionActionPerformed
        // TODO add your handling code here:
        jTxtPrecio.requestFocus();
    }//GEN-LAST:event_jTxtDescripcionActionPerformed

    private void jTxtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtPrecioActionPerformed
        // TODO add your handling code here:
        jBtnAceptar.doClick();
    }//GEN-LAST:event_jTxtPrecioActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarActionPerformed
        // TODO add your handling code here:
        JDialogMantenimientoVacunas ventana = new JDialogMantenimientoVacunas(tipoMantenimiento.AGREGAR, null);
        ventana.setVisible(true);
        llenarComboBox();
    }//GEN-LAST:event_jBtnAgregarActionPerformed

    private void jBtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarActionPerformed
        // TODO add your handling code here:
        JDialogMantenimientoVacunas ventana = new JDialogMantenimientoVacunas(tipoMantenimiento.MODIFICAR, (Vacuna)jCmbVacunas.getSelectedItem());
        ventana.setVisible(true);
        llenarComboBox();
    }//GEN-LAST:event_jBtnModificarActionPerformed

    private void jBtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConsultarActionPerformed
        // TODO add your handling code here:
        JDialogMantenimientoVacunas ventana = new JDialogMantenimientoVacunas(tipoMantenimiento.CONSULTAR, (Vacuna)jCmbVacunas.getSelectedItem());
        ventana.setVisible(true);
    }//GEN-LAST:event_jBtnConsultarActionPerformed

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        // TODO add your handling code here:
        if (motivo != null) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar la vacuna?", "Eliminar", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                try {
                    Vacuna.eliminarVacuna((Vacuna)jCmbVacunas.getSelectedItem());
                } catch (Exception ex) {
                    Logger.getLogger(jInternalMantenimientoMotivos.class.getName()).log(Level.SEVERE, null, ex);
                }
                llenarComboBox();
            }
        }
    }//GEN-LAST:event_jBtnSalirActionPerformed

    private boolean aplicaExamen() {
        return (jRBSiAplicaExamen.isSelected()) ? true : false;
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnAceptar;
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConsultar;
    private javax.swing.JButton jBtnModificar;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JComboBox<TiposMotivos> jCmbTipoMotivo;
    private javax.swing.JComboBox<Vacuna> jCmbVacunas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLblMantenimiento;
    private javax.swing.JLabel jLblPrecio;
    private javax.swing.JLabel jLblVacuna;
    private javax.swing.JPanel jPanelMantenimientoVacunas;
    private javax.swing.JRadioButton jRBNoAplicaExamen;
    private javax.swing.JRadioButton jRBSiAplicaExamen;
    private javax.swing.JTextField jTxtDescripcion;
    private javax.swing.JTextField jTxtPrecio;
    // End of variables declaration//GEN-END:variables
}
