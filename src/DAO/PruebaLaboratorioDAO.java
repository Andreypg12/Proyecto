package DAO;

import BLL_PruebaLaboratorio.*;
import java.sql.*;

public class PruebaLaboratorioDAO {
    
    public void agregarPruebaLaboratorio(PruebaLaboratorio pruebaLaboratorio) throws Exception{
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
    
    public void agregarSubCategoria(SubCategoriaPrueba subCategoria) throws Exception{
        try {
            String sql = "INSERT INTO SubCategoriaPrueba (id_prueba, nombre, precio) VALUES (?, ?, ?)";
            try(Connection conexion = DAO.ConeccionDB.conectarBaseDatos();
                    PreparedStatement pstm = conexion.prepareStatement(sql)){
                
                int id_prueba = subCategoria.getId_prueba();
                String nombre = subCategoria.getNombre();
                double precio = subCategoria.getPrecio();
                
                pstm.setInt(1, id_prueba);
                pstm.setDouble(2, precio);
                pstm.setString(3, nombre);
                
                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public void modificarSubCategoria(SubCategoriaPrueba subCategoria) throws Exception{
        try {
            String sql = "UPDATE SubCategoriaPrueba SET id_prueba = ?, nombre = ?, precio = ? WHERE id_subCategoria = ?";
            try(Connection conexion = DAO.ConeccionDB.conectarBaseDatos();
                    PreparedStatement pstm = conexion.prepareStatement(sql)){
                
                int id_prueba = subCategoria.getId_prueba();
                String nombre = subCategoria.getNombre();
                double precio = subCategoria.getPrecio();
                
                pstm.setInt(1, id_prueba);
                pstm.setDouble(2, precio);
                pstm.setString(3, nombre);
                
                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
}
