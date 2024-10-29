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
            String sql = "INSERT INTO Razas (nombre_raza, id_especie) VALUES (" + raza.getNombreRaza() + ", " + raza.getCodigoEspecie() + ")";

            try (Connection conexion = conectarBaseDatos(); 
                    PreparedStatement pstmt = conexion.prepareStatement(sql);) {

                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void modificarRaza(String nombreNuevo, int id_raza) throws Exception{
        conectarBaseDatos();
        try {
            String sql = "UPDATE Razas SET nombre_raza = " + nombreNuevo + " WHERE id_raza = " + id_raza;
            try (Connection conexion = conectarBaseDatos();
                    PreparedStatement pstmt = conexion.prepareStatement(sql)) {

                pstmt.executeUpdate();
            }
        } catch (Exception e) {
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
                    int codigoEspecie = rs.getInt("id_especie");
                    
                    Raza raza = new Raza(id_raza, nombreRaza, codigoEspecie);

                    arrayRazas.add(raza);
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return arrayRazas;
    }

    public static boolean eliminarRaza(Raza raza) throws Exception{
        try {
            String sql = "DELETE FROM Razas WHERE id_raza = " + raza.getId_raza();

            try (PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql)) {

                pstm.executeUpdate();
                return true;
            }

        } catch (Exception e) {
            return false;
        }
    }

    public static List<Especie> consultarEspecies() throws Exception{
        List<Especie> arrayEspecies = new ArrayList<>();
        try {
            String sql = "SELECT nombre_especie, id_especie FROM Especies";

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

        } catch (Exception e) {
            throw e;
        }
        return arrayEspecies;
    }
}
