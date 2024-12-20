/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package UI;

import BLL.TipoMantenimiento;
import BLL.PruebaLaboratorio;
import BLL.SubCategoriaPrueba;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class JDialogMantenimientoPruebasLaboratorio extends javax.swing.JDialog {
    TipoMantenimiento tipoMantenimiento;
    PruebaLaboratorio pruebaLaboratorio;
    SubCategoriaPrueba subCategoriaPrueba;
    /**
     * Creates new form JDialogMantenimientoPruebasLaboratorio
     */
    public JDialogMantenimientoPruebasLaboratorio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public JDialogMantenimientoPruebasLaboratorio(TipoMantenimiento tipoMantenimiento, PruebaLaboratorio pruebaLaboratorio, SubCategoriaPrueba subCategoriaPrueba) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.tipoMantenimiento = tipoMantenimiento;
        this.pruebaLaboratorio = pruebaLaboratorio;
        
        switch (tipoMantenimiento) {
            case AGREGAR ->{
                this.setTitle("Agregar una Subcategoría");
                jLblTitulo.setText("Agregar una sub categoría de " + pruebaLaboratorio.getNombrePrueba());
                
            }
            case MODIFICAR -> {
                this.subCategoriaPrueba = subCategoriaPrueba;
                this.setTitle("Modificar una Subcategoría de " + pruebaLaboratorio.getNombrePrueba());
                jLblTitulo.setText("Modificando: " + subCategoriaPrueba.getNombre());
            }
            case CONSULTAR -> {
                this.subCategoriaPrueba = subCategoriaPrueba;
                this.setTitle("Consultando una Subcategoría de " + pruebaLaboratorio.getNombrePrueba());
                jLblTitulo.setText("Consulta");
                jTxtNombre.setEditable(false);
                jTxtPrecio.setEditable(false);
                jBtnAceptar.setVisible(false);
                jBtnCancelar.setText("Salir");
            }
        }
        
        if (subCategoriaPrueba != null) {
            jTxtNombre.setText(subCategoriaPrueba.getNombre());
            jTxtPrecio.setText(String.valueOf(subCategoriaPrueba.getPrecio()));
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

        jLblTitulo = new javax.swing.JLabel();
        jLblNombre = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jTxtPrecio = new javax.swing.JTextField();
        jLblPrecio = new javax.swing.JLabel();
        jBtnCancelar = new javax.swing.JButton();
        jBtnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTitulo.setText("Titulo");

        jLblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblNombre.setText("Nombre de la sub categoría");

        jTxtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNombreActionPerformed(evt);
            }
        });

        jTxtPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtPrecioActionPerformed(evt);
            }
        });

        jLblPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblPrecio.setText("Precio");

        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnAceptar.setText("Aceptar");
        jBtnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnAceptar)
                                .addGap(18, 18, 18)
                                .addComponent(jBtnCancelar))
                            .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLblTitulo)
                .addGap(18, 18, 18)
                .addComponent(jLblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLblPrecio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnAceptar))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAceptarActionPerformed
        // TODO add your handling code here:
        switch (tipoMantenimiento) {
            case AGREGAR ->{
                if (!jTxtNombre.getText().isBlank()) {
                    try {
                        SubCategoriaPrueba subCategoria = new SubCategoriaPrueba(jTxtNombre.getText()
                                , Double.parseDouble(jTxtPrecio.getText())
                                , pruebaLaboratorio.getId_prueba());
                        
                        SubCategoriaPrueba.agregarSubCategoria(subCategoria);
                        JOptionPane.showMessageDialog(null, "¡La sub categoría fue agregada!", "Categoría agregada", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        
                    } catch (SQLException e) {
                        Logger.getLogger(JDialogMantenimientoPruebasLaboratorio.class.getName()).log(Level.SEVERE, null, e);
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Debes ingresar un número en el precio", "Espacio no válido", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Debes ingresar un nombre", "Espacio no válido", JOptionPane.ERROR_MESSAGE);
                }
            }
            case MODIFICAR ->{
                if (!jTxtNombre.getText().isBlank()) {
                    try {
                        this.subCategoriaPrueba.setNombre(jTxtNombre.getText());
                        this.subCategoriaPrueba.setPrecio(Double.parseDouble(jTxtPrecio.getText()));
                        
                        SubCategoriaPrueba.modificarSubCategoria(this.subCategoriaPrueba);
                        JOptionPane.showMessageDialog(null, "¡La sub categoría fue modificada!", "Categoría modificada", JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                        
                    } catch (SQLException e) {
                        Logger.getLogger(JDialogMantenimientoPruebasLaboratorio.class.getName()).log(Level.SEVERE, null, e);
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Debes ingresar un número en el precio", "Espacio no válido", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Debes ingresar un nombre", "Espacio no válido", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jBtnAceptarActionPerformed

    private void jTxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNombreActionPerformed
        // TODO add your handling code here:
        jTxtPrecio.requestFocus();
    }//GEN-LAST:event_jTxtNombreActionPerformed

    private void jTxtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtPrecioActionPerformed
        // TODO add your handling code here:
        jBtnAceptar.doClick();
    }//GEN-LAST:event_jTxtPrecioActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jBtnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAceptar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JLabel jLblNombre;
    private javax.swing.JLabel jLblPrecio;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTextField jTxtPrecio;
    // End of variables declaration//GEN-END:variables
}
