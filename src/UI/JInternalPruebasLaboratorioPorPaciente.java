/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package UI;

import BLL.Cita;
import BLL.Paciente;
import BLL.PruebaLaboratorio;
import BLL.SubCategoriaPrueba;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author andre
 */
public class JInternalPruebasLaboratorioPorPaciente extends javax.swing.JInternalFrame {

    DefaultTableModel modeloTablaPacientes;
    DefaultTableModel modeloTablaCitas;
    /**
     * Creates new form JInternalPruebasLaboratorioPorPaciente
     */
    public JInternalPruebasLaboratorioPorPaciente() {
        initComponents();
        modeloTablaPacientes = (DefaultTableModel)jTablePacientes.getModel();
        modeloTablaCitas = (DefaultTableModel)jTableCitas.getModel();
        llenarTablaPacientes();
    }

    private void llenarTablaPacientes(){
        try {
            for (Paciente paciente : Cita.consultarPacientesConCita()) {
                Object [] fila = {paciente.getDueño().getNombre(), paciente.getDueño().getCedula(), paciente};
                modeloTablaPacientes.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JInternalListaCitasPorPaciente.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePacientes = new javax.swing.JTable();
        jBtnElegirPaciente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCitas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pacientes");

        jTablePacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dueño", "Cedula", "Paciente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTablePacientes);

        jBtnElegirPaciente.setText("Elegir paciente");
        jBtnElegirPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnElegirPacienteActionPerformed(evt);
            }
        });

        jTableCitas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha en que se realizó", "Tipo de prueba", "Categoría", "Costo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableCitas);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Citas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jBtnElegirPaciente)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnElegirPaciente)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnElegirPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnElegirPacienteActionPerformed
        // TODO add your handling code here:
        modeloTablaCitas.setRowCount(0);
        if (jTablePacientes.getSelectedRow() != -1) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

            Paciente paciente = (Paciente) jTablePacientes.getValueAt(jTablePacientes.getSelectedRow(), 2);

            for (Cita cita : paciente.getArrayCitas()) {
                for (PruebaLaboratorio prueba : cita.getArrayPruebaLaboratorio()) {
                    for (SubCategoriaPrueba subCategoria : prueba.getArraySubCategorias()) {
                        Object[] fila = new Object[4];
                        fila[0] = sdf.format(cita.getFechaCita());
                        fila[1] = prueba.getNombrePrueba();
                        fila[2] = subCategoria.getNombre();
                        fila[3] = subCategoria.getPrecio();
                        modeloTablaCitas.addRow(fila);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes elegir un paciente de la lista", "Paciente no elegido", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnElegirPacienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnElegirPaciente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCitas;
    private javax.swing.JTable jTablePacientes;
    // End of variables declaration//GEN-END:variables
}
