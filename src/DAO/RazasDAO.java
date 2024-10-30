package DAO;

import BLL.Especie;
import BLL.Gato;
import BLL.Perro;
import BLL.Raza;
import static DAO.ConeccionDB.conectarBaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RazasDAO {

    public static void agregarRaza(Raza raza) throws Exception{
        try {
            String sql = "INSERT INTO Razas (nombre_raza, id_especie) VALUES (?, ?)";

            try (Connection conexion = conectarBaseDatos(); 
                    PreparedStatement pstmt = conexion.prepareStatement(sql);) {

                String nombreRaza = raza.getNombreRaza();
                int id_especie = raza.getEspecieAQuePertenece().getId_especie();
                
                pstmt.setString(1, nombreRaza);
                pstmt.setInt(2, id_especie);
                
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public static void modificarRaza(String nombreNuevo, int id_raza) throws Exception{
        conectarBaseDatos();
        try {
            String sql = "UPDATE Razas SET nombre_raza = ? WHERE id_raza = ?";
            try (Connection conexion = conectarBaseDatos();
                    PreparedStatement pstmt = conexion.prepareStatement(sql)) {

                pstmt.setString(1, nombreNuevo);
                pstmt.setInt(1, id_raza);
                
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Raza> consultarRazas() throws Exception{
        List<Raza> arrayRazas = new ArrayList<>();
        try {
            String sql = "SELECT id_raza, nombre_raza, id_especie FROM Razas";

            try (PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql);
                    ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {

                    int id_raza = rs.getInt("id_raza");
                    String nombreRaza = rs.getString("nombre_raza");
                    int id_especie = rs.getInt("id_especie");
                    
                    Especie especie  = null;
                    if (id_especie == 1) {
                        especie = new Perro();
                    }
                    else if (id_especie == 2) {
                        especie = new Gato();
                    }
                    
                    Raza raza = new Raza(id_raza, nombreRaza, especie);

                    arrayRazas.add(raza);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arrayRazas;
    }

    public static void eliminarRaza(Raza raza) throws Exception{
        try {
            String sql = "DELETE FROM Razas WHERE id_raza = ?";

            try (PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql)) {

                int id_raza = raza.getId_raza();
                
                pstm.setInt(1, id_raza);
                pstm.executeUpdate();

            }

        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Especie> consultarEspecies() throws Exception{
        List<Especie> arrayEspecies = new ArrayList<>();
        try {
            String sql = "SELECT nombre_especie, id_especie FROM Especies";

            try (PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql);
                    ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {

                    int id_especie = rs.getInt("id_especie");
                    if (id_especie == 1) {
                        arrayEspecies.add(new Perro());
                    } else if (id_especie == 2) {
                        arrayEspecies.add(new Gato());
                    }
                }
            }

        } catch (SQLException e) {
            throw e;
        }
        return arrayEspecies;
    }
}
