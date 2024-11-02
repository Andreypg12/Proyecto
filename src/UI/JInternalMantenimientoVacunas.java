package UI;

import BLL.*;
import BLL_Motivos.Vacuna;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class JInternalMantenimientoVacunas extends javax.swing.JInternalFrame {

    List<Vacuna> arrayVacunasPerros = new ArrayList<>();
    List<Vacuna> arrayVacunasGatos = new ArrayList<>();
    DefaultListModel modeloLista = new DefaultListModel();
    
    public JInternalMantenimientoVacunas() {
        initComponents();
        jListVacunas.setModel(modeloLista);
        llenarComboBox();
        actualizarLista();
        llenarLista();
    }
    
    private void llenarComboBox(){
        try {
            jCmbEspecies.setModel(new DefaultComboBoxModel(Especie.consultarEspecies().toArray()));
        } catch (Exception ex) {
            Logger.getLogger(JInternalMantenimientoVacunas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void llenarLista(){
        modeloLista.clear();
        if (((Especie)jCmbEspecies.getSelectedItem()).getId_especie() == 1) {
            modeloLista.addAll(arrayVacunasPerros);
        }
        else if(((Especie)jCmbEspecies.getSelectedItem()).getId_especie() == 2){
            modeloLista.addAll(arrayVacunasGatos);
        }
    }
    
    private void actualizarLista(){
        arrayVacunasPerros.clear();
        arrayVacunasGatos.clear();
        try {
            for (Vacuna vacuna : Vacuna.consultarVacunas()) {
                if (vacuna.getEspecieVacuna().getId_especie() == 1) {
                    arrayVacunasPerros.add(vacuna);
                }
                else{
                    arrayVacunasGatos.add(vacuna);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(JInternalMantenimientoVacunas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCmbEspecies = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jBtnAgregar = new javax.swing.JButton();
        jBtnModificar = new javax.swing.JButton();
        jBtnConsultar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListVacunas = new javax.swing.JList<>();

        setClosable(true);
        setTitle("Mantenimiento de vacunas");

        jCmbEspecies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbEspeciesActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Especie de la vacuna");

        jBtnAgregar.setText("Agregar");
        jBtnAgregar.setPreferredSize(new java.awt.Dimension(110, 30));
        jBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnAgregar);

        jBtnModificar.setText("Modificar");
        jBtnModificar.setPreferredSize(new java.awt.Dimension(110, 30));
        jBtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnModificar);

        jBtnConsultar.setText("Consultar");
        jBtnConsultar.setPreferredSize(new java.awt.Dimension(110, 30));
        jBtnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnConsultar);

        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.setPreferredSize(new java.awt.Dimension(110, 30));
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jBtnEliminar);

        jListVacunas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListVacunas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jCmbEspecies, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCmbEspecies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCmbEspeciesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbEspeciesActionPerformed

        llenarLista();
    }//GEN-LAST:event_jCmbEspeciesActionPerformed

    private void jBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarActionPerformed

        JDialogMantenimientoVacunas ventana = new JDialogMantenimientoVacunas(TipoMantenimiento.AGREGAR, null);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        actualizarLista();
        llenarLista();
    }//GEN-LAST:event_jBtnAgregarActionPerformed

    private void jBtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarActionPerformed

        Vacuna vacuna = jListVacunas.getSelectedValue();
        if (vacuna != null) {
        JDialogMantenimientoVacunas ventana = new JDialogMantenimientoVacunas(TipoMantenimiento.MODIFICAR, vacuna);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        actualizarLista();
        llenarLista();
        }
        else{
            JOptionPane.showMessageDialog(null, "Debes seleccionar una vacuna de la lista", "Vacuna sin elegir", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnModificarActionPerformed

    private void jBtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConsultarActionPerformed

        Vacuna vacuna = jListVacunas.getSelectedValue();
        if (vacuna != null) {
        JDialogMantenimientoVacunas ventana = new JDialogMantenimientoVacunas(TipoMantenimiento.CONSULTAR, vacuna);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        actualizarLista();
        llenarLista();
        }
        else{
            JOptionPane.showMessageDialog(null, "Debes seleccionar una vacuna de la lista", "Vacuna sin elegir", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnConsultarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed

        Vacuna vacuna = jListVacunas.getSelectedValue();
        if (vacuna != null) {
            try {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar la vacuna?", "Eliminar", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (opcion == JOptionPane.YES_OPTION) {
                    Vacuna.eliminarVacuna(vacuna);
                    actualizarLista();
                    llenarLista();
                }
            } catch (Exception ex) {
                Logger.getLogger(JInternalMantenimientoVacunas.class.getName()).log(Level.SEVERE, null, ex);
            }
            actualizarLista();
            llenarLista();
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una vacuna de la lista", "Vacuna sin elegir", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnEliminarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JButton jBtnConsultar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnModificar;
    private javax.swing.JComboBox<Especie> jCmbEspecies;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<Vacuna> jListVacunas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
