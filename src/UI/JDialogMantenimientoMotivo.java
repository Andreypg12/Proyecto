/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package UI;

import BLL.TipoMantenimiento;
import BLL_Motivos.*;
import javax.swing.ComboBoxModel;
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
        jCmbVacunas.setModel(new DefaultComboBoxModel(Vacunas.values()));
        
        jLblVacuna.setVisible(false);
        jCmbVacunas.setVisible(false);
        
        switch (tipoMantenimiento) {
            case AGREGAR ->{
                this.setTitle("Agregar Motivo");
            }
            case MODIFICAR ->{
                this.motivo = motivo;
                this.setTitle("Modificar Motivo");
                if (motivo instanceof Vacunacion) {
                    jCmbTipoMotivo.setSelectedIndex(1);
                    jCmbVacunas.setSelectedItem(((Vacunacion) motivo).getVacuna());
                }
                else{
                    jCmbTipoMotivo.setSelectedIndex(0);
                }
                jCmbTipoMotivo.setEnabled(false);
                
                jTxtDescripcion.setText(motivo.getDescripcion());
                jTxtPrecio.setText(String.valueOf(motivo.getPrecio()));
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
        jLabel3 = new javax.swing.JLabel();
        jTxtPrecio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jRBSiAplicaExamen = new javax.swing.JRadioButton();
        jRBNoAplicaExamen = new javax.swing.JRadioButton();
        jLblVacuna = new javax.swing.JLabel();
        jCmbVacunas = new javax.swing.JComboBox<>();
        jBtnAceptar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tipo de motivo");

        jCmbTipoMotivo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Vacunación" }));
        jCmbTipoMotivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbTipoMotivoActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Descripcion");

        jTxtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtDescripcionActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Precio");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCmbVacunas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jRBSiAplicaExamen)
                        .addGap(18, 18, 18)
                        .addComponent(jRBNoAplicaExamen)
                        .addGap(25, 25, 25))
                    .addComponent(jLblVacuna, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTxtPrecio)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTxtDescripcion)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCmbTipoMotivo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnAceptar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(94, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
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
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCmbTipoMotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbTipoMotivoActionPerformed
        // TODO add your handling code here:
        if (jCmbTipoMotivo.getSelectedItem().equals("Normal")) {
            jLblVacuna.setVisible(false);
            jCmbVacunas.setVisible(false);
            jTxtPrecio.setText("");
            jTxtPrecio.setEditable(true);
            jRBSiAplicaExamen.setEnabled(true);
            jRBSiAplicaExamen.setSelected(true);
            jRBNoAplicaExamen.setEnabled(true);
        }
        else if (jCmbTipoMotivo.getSelectedItem().equals("Vacunación")) {
            jLblVacuna.setVisible(true);
            jCmbVacunas.setVisible(true);
            jTxtPrecio.setText(String.valueOf(((Vacunas)jCmbVacunas.getSelectedItem()).getPrecio()));
            jTxtPrecio.setEditable(false);
            jRBNoAplicaExamen.setSelected(true);
            jRBSiAplicaExamen.setEnabled(false);
            jRBNoAplicaExamen.setEnabled(false);
        }
    }//GEN-LAST:event_jCmbTipoMotivoActionPerformed

    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
        // TODO add your handling code here:
        switch (tipoMantenimiento) {
            case AGREGAR -> {
                Motivo motivo = crearMotivo();
                if (motivo != null) {
                    Motivo.agregarMotivo(motivo);
                    JOptionPane.showMessageDialog(null, "El motivo fue agregado","Motivo agregado", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            case MODIFICAR ->{
                Motivo motivoNuevo = crearMotivo();
                if (Motivo.modificarMotivo(this.motivo, motivoNuevo)) {
                    JOptionPane.showMessageDialog(null, "El motivo fue modificado", "Motivo modificado", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
                
            }
        }
    }//GEN-LAST:event_jBtnAceptarActionPerformed

    private void jCmbVacunasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbVacunasActionPerformed
        // TODO add your handling code here:
        jTxtPrecio.setText(String.valueOf(((Vacunas)jCmbVacunas.getSelectedItem()).getPrecio()));
    }//GEN-LAST:event_jCmbVacunasActionPerformed

    private void jTxtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtDescripcionActionPerformed
        // TODO add your handling code here:
        jTxtPrecio.requestFocus();
    }//GEN-LAST:event_jTxtDescripcionActionPerformed

    private void jTxtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtPrecioActionPerformed
        // TODO add your handling code here:
        jBtnAceptar.doClick();
    }//GEN-LAST:event_jTxtPrecioActionPerformed

    private boolean aplicaExamen(){
        return (jRBSiAplicaExamen.isSelected()) ? true : false;
    }
  
    private Motivo crearMotivo() {
        String descripcion = jTxtDescripcion.getText();
        double precio;
        try {
            precio = Double.parseDouble(jTxtPrecio.getText());
            boolean aplicaExamen = aplicaExamen();

            if (jCmbTipoMotivo.getSelectedItem().equals("Normal")) {
                return new Motivo(descripcion, precio, aplicaExamen);
            } else {
                return new Vacunacion(descripcion, (Vacunas) jCmbVacunas.getSelectedItem());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debes ingresar un numero en el precio", "Valor incorrecto", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnAceptar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JComboBox<String> jCmbTipoMotivo;
    private javax.swing.JComboBox<Vacunas> jCmbVacunas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLblVacuna;
    private javax.swing.JRadioButton jRBNoAplicaExamen;
    private javax.swing.JRadioButton jRBSiAplicaExamen;
    private javax.swing.JTextField jTxtDescripcion;
    private javax.swing.JTextField jTxtPrecio;
    // End of variables declaration//GEN-END:variables
}
