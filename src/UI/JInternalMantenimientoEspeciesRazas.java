/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package UI;
import BLL.*;
import java.sql.*;
import DAO.ConeccionDB;
import DAO.RazasDAO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class JInternalMantenimientoEspeciesRazas extends javax.swing.JInternalFrame {

    DefaultListModel<Raza> modeloLista = new DefaultListModel<>();
    List<Raza> arrayRazasGatos = new ArrayList<>();
    List<Raza> arrayRazasPerros = new ArrayList<>();
    private int codigoEspecie;
    
    /**
     * Creates new form JInternalMantenimientoEspeciesRazas
     */
    public JInternalMantenimientoEspeciesRazas() {
        initComponents();
        llenarComboBox();
        jListRazas.setModel(modeloLista);
        actualizarLista();
        llenarLista();
        codigoEspecie = ((Especie)jCmbEspecie.getSelectedItem()).getCodigoEspecie();
    }
    
    public void llenarComboBox(){
        try {
            jCmbEspecie.setModel(new DefaultComboBoxModel(RazasDAO.consultarEspecies().toArray()));
        } catch (Exception ex) {
            Logger.getLogger(JInternalMantenimientoEspeciesRazas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarLista(){
        try {
            arrayRazasPerros.clear();
            arrayRazasGatos.clear();
            for (Raza raza : Raza.consultarRazas()) {
                if (raza.getId_especie() == 1) {
                    arrayRazasPerros.add(raza);
                }
                else if (raza.getId_especie() == 2) {
                    arrayRazasGatos.add(raza);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(JInternalMantenimientoEspeciesRazas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void llenarLista() {
        modeloLista.clear();

        if (jCmbEspecie.getSelectedItem() instanceof Perro) {
            for (Raza razasPerro : arrayRazasPerros) {
                modeloLista.addElement(razasPerro);
            }
        } else if (jCmbEspecie.getSelectedItem() instanceof Gato) {
            for (Raza razaGato : arrayRazasGatos) {
                modeloLista.addElement(razaGato);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jCmbEspecie = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListRazas = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        jBtnAgregar = new javax.swing.JButton();
        jBtnModificar = new javax.swing.JButton();
        jBtnConsultar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Mantenimiento de especies y razas");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Especie");

        jCmbEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbEspecieActionPerformed(evt);
            }
        });

        jListRazas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListRazas);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 154, Short.MAX_VALUE)
                .addComponent(jCmbEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(224, 224, 224))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jCmbEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCmbEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbEspecieActionPerformed
        // TODO add your handling code here:
        llenarLista();
        codigoEspecie = ((Especie)jCmbEspecie.getSelectedItem()).getCodigoEspecie();
    }//GEN-LAST:event_jCmbEspecieActionPerformed

    private void jBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarActionPerformed
        // TODO add your handling code here:
        JDialogMantenimientoEspecieRazas ventana = new JDialogMantenimientoEspecieRazas(TipoMantenimiento.AGREGAR, (Especie)jCmbEspecie.getSelectedItem(), null);
        ventana.setVisible(true);
        actualizarLista();
        llenarLista();
    }//GEN-LAST:event_jBtnAgregarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed

        int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar la raza?","Eliminar", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcion == JOptionPane.YES_OPTION) {
            try {
                if (Raza.eliminarRaza(jListRazas.getSelectedValue())) {
                    actualizarLista();
                    llenarLista();
                    JOptionPane.showMessageDialog(null, "¡Raza Eliminada!", "", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception ex) {
                Logger.getLogger(JInternalMantenimientoEspeciesRazas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    private void jBtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnModificarActionPerformed

        if (jListRazas.getSelectedIndex() != -1) {
            JDialogMantenimientoEspecieRazas ventana = new JDialogMantenimientoEspecieRazas(TipoMantenimiento.MODIFICAR
                    ,(Especie) jCmbEspecie.getSelectedItem()
                    ,jListRazas.getSelectedValue());

            ventana.setVisible(true);
            actualizarLista();
            llenarLista();
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una raza",
                    "Raza no especificada", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBtnModificarActionPerformed

    private void jBtnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConsultarActionPerformed
        // TODO add your handling code here:

        if (jListRazas.getSelectedIndex() != -1) {
            JDialogMantenimientoEspecieRazas ventana = new JDialogMantenimientoEspecieRazas(TipoMantenimiento.CONSULTAR,
                    (Especie) jCmbEspecie.getSelectedItem(),
                    jListRazas.getSelectedValue());

            ventana.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una raza",
                    "Raza no especificada", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jBtnConsultarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JButton jBtnConsultar;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnModificar;
    private javax.swing.JComboBox<Especie> jCmbEspecie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<BLL.Raza> jListRazas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
