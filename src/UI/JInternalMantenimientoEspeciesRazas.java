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
    
    /**
     * Creates new form JInternalMantenimientoEspeciesRazas
     */
    public JInternalMantenimientoEspeciesRazas() {
        initComponents();
        llenarComboBox();
        jListRazas.setModel(modeloLista);
        actualizarLista();
        llenarLista();
    }
    
    public void llenarComboBox(){
        try {
            jCmbEspecie.setModel(new DefaultComboBoxModel(Especie.consultarEspecies().toArray()));
        } catch (Exception ex) {
            Logger.getLogger(JInternalMantenimientoEspeciesRazas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void actualizarLista(){
        try {
            arrayRazasPerros.clear();
            arrayRazasGatos.clear();
            for (Raza raza : Raza.consultarRazas()) {
                if (raza.getEspecieAQuePertenece().getId_especie() == 1) {
                    arrayRazasPerros.add(raza);
                }
                else if (raza.getEspecieAQuePertenece().getId_especie() == 2) {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Mantenimiento de especies y razas");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Especie");

        jCmbEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbEspecieActionPerformed(evt);
            }
        });

        jListRazas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListRazas);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jBtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/agregar.png"))); // NOI18N
        jBtnAgregar.setPreferredSize(new java.awt.Dimension(110, 30));
        jBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarActionPerformed(evt);
            }
        });

        jBtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar.png"))); // NOI18N
        jBtnModificar.setPreferredSize(new java.awt.Dimension(110, 30));
        jBtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnModificarActionPerformed(evt);
            }
        });

        jBtnConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/consultar.png"))); // NOI18N
        jBtnConsultar.setPreferredSize(new java.awt.Dimension(110, 30));
        jBtnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConsultarActionPerformed(evt);
            }
        });

        jBtnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar.png"))); // NOI18N
        jBtnEliminar.setPreferredSize(new java.awt.Dimension(110, 30));
        jBtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEliminarActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Agregar");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Modificar");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Consultar");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Eliminar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jBtnConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jBtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnModificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jCmbEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jCmbEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCmbEspecieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbEspecieActionPerformed
        // TODO add your handling code here:
        llenarLista();
    }//GEN-LAST:event_jCmbEspecieActionPerformed

    private void jBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarActionPerformed
        // TODO add your handling code here:
        JDialogMantenimientoEspecieRazas ventana = new JDialogMantenimientoEspecieRazas(TipoMantenimiento.AGREGAR, (Especie)jCmbEspecie.getSelectedItem(), null);
        ventana.setVisible(true);
        actualizarLista();
        llenarLista();
    }//GEN-LAST:event_jBtnAgregarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed

        if (jListRazas.getSelectedIndex() != -1) {
            int opcion = JOptionPane.showConfirmDialog(null, "¿Deseas eliminar la raza?", "Eliminar", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opcion == JOptionPane.YES_OPTION) {
                try {
                    Raza.eliminarRaza(jListRazas.getSelectedValue());
                    actualizarLista();
                    llenarLista();
                    JOptionPane.showMessageDialog(null, "¡Raza Eliminada!", "Eliminación de raza", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No puedes eliminar esta raza porque un paciente es de esa raza",
                    "¡Raza no eliminada!", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una raza",
                    "Raza no especificada", JOptionPane.ERROR_MESSAGE);
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<BLL.Raza> jListRazas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
