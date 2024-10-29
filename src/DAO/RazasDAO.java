package DAO;

import BLL.Especie;
import BLL.Gato;
import BLL.Perro;
import BLL.Raza;
import static DAO.ConeccionDB.conectarBaseDatos;
import UI.JInternalMantenimientoEspeciesRazas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RazasDAO {

    public static void agregarRaza(Raza raza) {
        try {
            String sql = "INSERT INTO Razas (nombre_raza, id_especie) VALUES (?, ?)";

            try (Connection conexion = conectarBaseDatos(); 
                    PreparedStatement pstmt = conexion.prepareStatement(sql);) {
                
                int codigoRaza = raza.getCodigoEspecie();

                String nombreRaza = raza.getNombreRaza();

                pstmt.setString(1, nombreRaza);
                pstmt.setInt(2, codigoRaza);

                pstmt.execute();
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void modificarRaza(String nombreNuevo, int id_raza) {
        conectarBaseDatos();
        try {
            String sql = "update Razas set nombre_raza = ? where id_raza = ?";
            try (Connection conexion = conectarBaseDatos();
                    PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                
                pstmt.setString(1, nombreNuevo);
                pstmt.setInt(2, id_raza);

                pstmt.execute();
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar datos: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Raza> consultarRazas() {
        List<Raza> arrayRazas = new ArrayList<>();
        try {
            String sql = "select id_raza, nombre_raza, id_especie from Razas";

            try (PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql);
                    ResultSet rs = pstm.executeQuery();) {

                while (rs.next()) {

                    int id_raza = rs.getInt("id_raza");
                    String nombreRaza = rs.getString("nombre_raza");
                    int codigoEspecie = rs.getInt("id_especie");
                    
                    Raza raza = new Raza(id_raza, nombreRaza, codigoEspecie);

                    arrayRazas.add(raza);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JInternalMantenimientoEspeciesRazas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayRazas;
    }

    public static boolean eliminarRaza(Raza raza) {
        try {
            String sql = "delete from Razas where id_raza = ?";

            try (PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql)) {
                
                int id_raza = raza.getId_raza();
                
                pstm.setInt(1, id_raza);

                pstm.execute();
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una raza",
                    "Raza no especificada", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public static List<Especie> consultarEspecies() {
        List<Especie> arrayEspecies = new ArrayList<>();
        try {
            String sql = "select nombre_especie, id_especie from Especies";

            try (PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql);
                    ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {

                    int codigoEspecie = rs.getInt("id_especie");
                    if (codigoEspecie == 1) {
                        arrayEspecies.add(new Perro());
                    } else if (codigoEspecie == 2) {
                        arrayEspecies.add(new Gato());
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(JInternalMantenimientoEspeciesRazas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayEspecies;
    }
}
