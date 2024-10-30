/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package UI;

import BLL.TipoMantenimiento;
import BLL_Motivos.Motivo;
import BLL_Motivos.Vacunacion;
import BLL_Motivos.Vacunas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andre
 */
public class jInternalMantenimientoMotivos extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTabla;
    /**
     * Creates new form jInternalMantenimientoMotivos
     */
    public jInternalMantenimientoMotivos() {
        initComponents();
        modeloTabla = (DefaultTableModel)jTable1.getModel();
        llenarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBtnAgregar = new javax.swing.JButton();
        jBtnModificar = new javax.swing.JButton();
        jBtnConsultar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();

        setClosable(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Motivo", "Precio", "Examen", "Vacuna"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Motivos:");

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jBtnAgregar.setText("Agregar");
        jBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnAgregar);

        jBtnModificar.setText("Modificar");
        jBtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnModificar);

        jBtnConsultar.setText("Consultar");
        jBtnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnConsultar);

        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnEliminar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarActionPerformed
        // TODO add your handling code here:
        JDialogMantenimientoMotivo ventana = new JDialogMantenimientoMotivo(TipoMantenimiento.AGREGAR, null);
        ventana.setVisible(true);
        llenarTabla();
    }//GEN-LAST:event_jBtnAgregarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        // TODO add your handling code here:
        Motivo motivo = crearMotivo();
        if (motivo != null) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar el motivo?", "Eliminar", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                try {
                    Motivo.eliminarMotivo(motivo);
                } catch (Exception ex) {
                    Logger.getLogger(jInternalMantenimientoMotivos.class.getName()).log(Level.SEVERE, null, ex);
                }
                llenarTabla();
            }
        }
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    private void jBtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarActionPerformed
        // TODO add your handling code here:
        Motivo motivo = crearMotivo();
        if (motivo != null) {
            JDialogMantenimientoMotivo ventana = new JDialogMantenimientoMotivo(TipoMantenimiento.MODIFICAR, motivo);
            ventana.setVisible(true);
            llenarTabla();
        }
    }//GEN-LAST:event_jBtnModificarActionPerformed

    private void jBtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConsultarActionPerformed
        // TODO add your handling code here:
        Motivo motivo = crearMotivo();
        if (motivo != null) {
            JDialogMantenimientoMotivo ventana = new JDialogMantenimientoMotivo(TipoMantenimiento.CONSULTAR, motivo);
            ventana.setVisible(true);
        }
    }//GEN-LAST:event_jBtnConsultarActionPerformed

    private void llenarTabla() {
        try {
            modeloTabla.setNumRows(0);
            for (Motivo motivo : Motivo.consultarMotivos()) {

                double precio = motivo.getPrecio();
                String aplica_examen = (motivo.isAplicaExamen()) ? "Si" : "No";
                Vacunas vacuna = null;

                if (motivo instanceof Vacunacion) {
                    vacuna = ((Vacunacion) motivo).getVacuna();
                }
                Object[] arreglo = {motivo, precio, aplica_examen, vacuna};
                modeloTabla.addRow(arreglo);
            }
        } catch (Exception ex) {
            Logger.getLogger(jInternalMantenimientoMotivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Motivo crearMotivo(){
        int fila = jTable1.getSelectedRow();
        if (fila != -1) {
            return (Motivo) jTable1.getValueAt(fila, 0);

        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar un elemento de la tabla", "Valor sin seleccionar", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JButton jBtnConsultar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
