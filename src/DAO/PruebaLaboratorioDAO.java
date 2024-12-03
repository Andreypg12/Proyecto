package DAO;

import BLL.Cultivos;
import BLL.Sangre;
import BLL.SubCategoriaPrueba;
import BLL.Heces;
import BLL.PruebaLaboratorio;
import BLL.Orina;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de acceso a datos (DAO) para realizar operaciones CRUD sobre las tablas relacionadas con las pruebas de laboratorio.
 * Permite gestionar pruebas y sus subcategorías en la base de datos.
 * 
 * @author Andrey Pérez Gutiérrez
 */
public class PruebaLaboratorioDAO {

    /**
     * Agrega una nueva prueba de laboratorio a la base de datos.
     *
     * @param pruebaLaboratorio El objeto {@link PruebaLaboratorio} que se desea agregar.
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    public void agregarPruebaLaboratorio(PruebaLaboratorio pruebaLaboratorio) throws SQLException {
        try {
            String sql = "INSERT INTO PruebaLaboratorio (id_prueba, nombre, precio) VALUES (?, ?, ?)";
            try (Connection conexion = DAO.ConeccionDB.conectarBaseDatos();
                 PreparedStatement pstm = conexion.prepareStatement(sql)) {

                int id_prueba = pruebaLaboratorio.getId_prueba();
                double precio = pruebaLaboratorio.getPrecio();
                String nombre = pruebaLaboratorio.getNombrePrueba();

                pstm.setInt(1, id_prueba);
                pstm.setString(2, nombre);
                pstm.setDouble(3, precio);

                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Consulta todas las pruebas de laboratorio registradas en la base de datos.
     *
     * @return Una lista de objetos {@link PruebaLaboratorio} representando las pruebas almacenadas.
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    public List<PruebaLaboratorio> consultarPruebasLaboratorio() throws SQLException {
        List<PruebaLaboratorio> arrayPruebas = new ArrayList<>();
        try {
            String sql = "SELECT id_prueba FROM PruebaLaboratorio";
            try (Connection conexion = DAO.ConeccionDB.conectarBaseDatos();
                 PreparedStatement pstm = conexion.prepareStatement(sql);
                 ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {
                    int id_prueba = rs.getInt("id_prueba");

                    PruebaLaboratorio prueba = switch (id_prueba) {
                        case 1 -> new Sangre();
                        case 2 -> new Heces();
                        case 3 -> new Orina();
                        case 4 -> new Cultivos();
                        default -> null;
                    };
                    arrayPruebas.add(prueba);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arrayPruebas;
    }

    /**
     * Agrega una nueva subcategoría de prueba de laboratorio a la base de datos.
     *
     * @param subCategoria El objeto {@link SubCategoriaPrueba} que se desea agregar.
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    public void agregarSubCategoria(SubCategoriaPrueba subCategoria) throws SQLException {
        try {
            String sql = "INSERT INTO SubCategoriaPrueba (id_prueba, nombre, precio) VALUES (?, ?, ?)";
            try (Connection conexion = DAO.ConeccionDB.conectarBaseDatos();
                 PreparedStatement pstm = conexion.prepareStatement(sql)) {

                int id_prueba = subCategoria.getId_prueba();
                String nombre = subCategoria.getNombre();
                double precio = subCategoria.getPrecio();

                pstm.setInt(1, id_prueba);
                pstm.setString(2, nombre);
                pstm.setDouble(3, precio);

                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Modifica los datos de una subcategoría de prueba de laboratorio en la base de datos.
     *
     * @param subCategoria El objeto {@link SubCategoriaPrueba} con los datos actualizados.
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    public void modificarSubCategoria(SubCategoriaPrueba subCategoria) throws SQLException {
        try {
            String sql = "UPDATE SubCategoriaPrueba SET nombre = ?, precio = ? WHERE id_subCategoria = ?";
            try (Connection conexion = DAO.ConeccionDB.conectarBaseDatos();
                 PreparedStatement pstm = conexion.prepareStatement(sql)) {

                String nombre = subCategoria.getNombre();
                double precio = subCategoria.getPrecio();
                int id_subCategoria = subCategoria.getId_subCategoria();

                pstm.setString(1, nombre);
                pstm.setDouble(2, precio);
                pstm.setInt(3, id_subCategoria);

                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Consulta todas las subcategorías de pruebas de laboratorio registradas en la base de datos.
     *
     * @return Una lista de objetos {@link SubCategoriaPrueba} representando las subcategorías almacenadas.
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    public List<SubCategoriaPrueba> consultarSubCategorias() throws SQLException {
        List<SubCategoriaPrueba> arraySubCategorias = new ArrayList<>();
        try {
            String sql = "SELECT * FROM SubCategoriaPrueba";
            try (Connection conexion = DAO.ConeccionDB.conectarBaseDatos();
                 PreparedStatement pstm = conexion.prepareStatement(sql);
                 ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {
                    SubCategoriaPrueba subCategoria = new SubCategoriaPrueba(
                            rs.getString("nombre"),
                            rs.getDouble("precio"),
                            rs.getInt("id_prueba"),
                            rs.getInt("id_subCategoria")
                    );

                    arraySubCategorias.add(subCategoria);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arraySubCategorias;
    }

    /**
     * Elimina una subcategoría de prueba de laboratorio de la base de datos.
     *
     * @param subCategoria El objeto {@link SubCategoriaPrueba} que se desea eliminar.
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    public void eliminarSubCategoria(SubCategoriaPrueba subCategoria) throws SQLException {
        try {
            String sql = "DELETE FROM SubCategoriaPrueba WHERE id_subCategoria = ?";
            try (PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql)) {
                int id_subCategoria = subCategoria.getId_subCategoria();
                pstm.setInt(1, id_subCategoria);

                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
