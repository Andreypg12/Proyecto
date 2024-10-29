package DAO;

import DAO.ConeccionDB;
import BLL_PruebaLaboratorio.*;
import java.sql.*;

public class PruebaLaboratorioDAO {
    
    public static void agregarPruebaLaboratorio(PruebaLaboratorio pruebaLaboratorio) throws Exception{
        try {
            String sql = "insert into PruebaLaboratorio (precio, descripcion) values (?, ?)";
            try(Connection conexion = DAO.ConeccionDB.conectarBaseDatos();
                    PreparedStatement pstm = conexion.prepareStatement(sql)){
                
                double precio = pruebaLaboratorio.getPrecio();
                String descripcion = pruebaLaboratorio.toString();
                
                pstm.setDouble(1, precio);
                pstm.setString(2, descripcion);
                
                pstm.executeUpdate();
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
