/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author andre
 */
public class DesktopConFondo extends JDesktopPane {

    private Image imagenFondo;

    public DesktopConFondo(String rutaImagen) {
        // Cargar la imagen de fondo
        ImageIcon icono = new ImageIcon(getClass().getResource(rutaImagen));
        if (icono.getImageLoadStatus() == MediaTracker.COMPLETE) {
            this.imagenFondo = icono.getImage();
        } else {
            System.err.println("Error: No se pudo cargar la imagen de fondo.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagenFondo != null) {
            // Dibuja la imagen escalada al tamaño del DesktopPane
            g.drawImage(imagenFondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
