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

public class PruebaLaboratorioDAO {
    
    public void agregarPruebaLaboratorio(PruebaLaboratorio pruebaLaboratorio) throws SQLException{
        try {
            String sql = "INSERT INTO PruebaLaboratorio (id_prueba, nombre, precio) VALUES (?, ?, ?)";
            try(Connection conexion = DAO.ConeccionDB.conectarBaseDatos();
                    PreparedStatement pstm = conexion.prepareStatement(sql)){
                
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
    
    public List<PruebaLaboratorio> consultarPruebasLaboratorio() throws SQLException {
        List<PruebaLaboratorio> arrayPruebas = new ArrayList<>();
        try {
            String sql = "SELECT id_prueba FROM PruebaLaboratorio";
            try (Connection conexion = DAO.ConeccionDB.conectarBaseDatos(); 
                    PreparedStatement pstm = conexion.prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {

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
    
    public void agregarSubCategoria(SubCategoriaPrueba subCategoria) throws SQLException{
        try {
            String sql = "INSERT INTO SubCategoriaPrueba (id_prueba, nombre, precio) VALUES (?, ?, ?)";
            try(Connection conexion = DAO.ConeccionDB.conectarBaseDatos();
                    PreparedStatement pstm = conexion.prepareStatement(sql)){
                
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
    
    public void modificarSubCategoria(SubCategoriaPrueba subCategoria) throws SQLException{
        try {
            String sql = "UPDATE SubCategoriaPrueba SET nombre = ?, precio = ? WHERE id_subCategoria = ?";
            try(Connection conexion = DAO.ConeccionDB.conectarBaseDatos();
                    PreparedStatement pstm = conexion.prepareStatement(sql)){
                
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
    
    public List<SubCategoriaPrueba> consultarSubCategorias() throws SQLException{
        List<SubCategoriaPrueba> arraySubCategorias = new ArrayList<>();
        try {
                String sql = "SELECT * FROM SubCategoriaPrueba";
            try (Connection conexion = DAO.ConeccionDB.conectarBaseDatos();
                    PreparedStatement pstm = conexion.prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {
                    SubCategoriaPrueba subCategoria = new SubCategoriaPrueba(rs.getString("nombre")
                            , rs.getDouble("precio")
                            , rs.getInt("id_prueba")
                            ,rs.getInt("id_subCategoria"));
                    
                    arraySubCategorias.add(subCategoria);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arraySubCategorias;
    }
    
    public void eliminarSubCategoria(SubCategoriaPrueba subCategoria) throws SQLException{
        try {
            String sql = "DELETE FROM SubCategoriaPrueba where id_subCategoria = ?";
            try(PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql)){
                int id_subCategoria = subCategoria.getId_subCategoria();
                pstm.setInt(1, id_subCategoria);
                
                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
}
