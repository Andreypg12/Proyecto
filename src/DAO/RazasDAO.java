package DAO;

import BLL.Especie;
import BLL.Gato;
import BLL.Perro;
import BLL.Raza;
import static DAO.ConeccionDB.conectarBaseDatos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de acceso a datos (DAO) para realizar operaciones CRUD sobre la tabla `Raza`.
 * Permite gestionar las razas y sus relaciones con las especies en la base de datos.
 * @author Andrey Pérez Gutiérrez
 */
public class RazasDAO {

    /**
     * Agrega una nueva raza en la base de datos.
     *
     * @param raza El objeto {@link Raza} que se desea agregar.
     * @throws Exception Si ocurre un error al interactuar con la base de datos.
     */
    public void agregarRaza(Raza raza) throws Exception {
        try {
            String sql = "INSERT INTO Raza (nombre_raza, id_especie) VALUES (?, ?)";
            try (Connection conexion = conectarBaseDatos();
                 PreparedStatement pstmt = conexion.prepareStatement(sql)) {

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

    /**
     * Modifica los datos de una raza existente en la base de datos.
     *
     * @param raza El objeto {@link Raza} con los datos actualizados.
     * @throws Exception Si ocurre un error al interactuar con la base de datos.
     */
    public void modificarRaza(Raza raza) throws Exception {
        try {
            String sql = "UPDATE Raza SET nombre_raza = ? WHERE id_raza = ?";
            try (Connection conexion = conectarBaseDatos();
                 PreparedStatement pstmt = conexion.prepareStatement(sql)) {

                pstmt.setString(1, raza.getNombreRaza());
                pstmt.setInt(2, raza.getId_raza());

                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Consulta todas las razas registradas en la base de datos.
     *
     * @return Una lista de objetos {@link Raza} representando las razas almacenadas.
     * @throws Exception Si ocurre un error al interactuar con la base de datos.
     */
    public List<Raza> consultarRazas() throws Exception {
        List<Raza> arrayRazas = new ArrayList<>();
        try {
            String sql = "SELECT id_raza, nombre_raza, id_especie FROM Raza";
            try (PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql);
                 ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {
                    int id_raza = rs.getInt("id_raza");
                    String nombreRaza = rs.getString("nombre_raza");
                    int id_especie = rs.getInt("id_especie");

                    Especie especie = null;
                    if (id_especie == 1) {
                        especie = new Perro();
                    } else if (id_especie == 2) {
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

    /**
     * Elimina una raza existente en la base de datos.
     *
     * @param raza El objeto {@link Raza} que se desea eliminar.
     * @throws Exception Si ocurre un error al interactuar con la base de datos.
     */
    public void eliminarRaza(Raza raza) throws Exception {
        try {
            String sql = "DELETE FROM Raza WHERE id_raza = ?";
            try (PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql)) {

                int id_raza = raza.getId_raza();
                pstm.setInt(1, id_raza);
                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Consulta todas las especies registradas en la base de datos.
     *
     * @return Una lista de objetos {@link Especie} representando las especies disponibles.
     * @throws Exception Si ocurre un error al interactuar con la base de datos.
     */
    public List<Especie> consultarEspecies() throws Exception {
        List<Especie> arrayEspecies = new ArrayList<>();
        try {
            String sql = "SELECT nombre_especie, id_especie FROM Especie";
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
