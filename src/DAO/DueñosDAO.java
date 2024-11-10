package DAO;

import BLL.Dueño;
import java.sql.*;
import DAO.ConeccionDB;
import java.util.ArrayList;
import java.util.List;

public class DueñosDAO {
    
    public void agregar(Dueño dueno) throws SQLException{
        try {
            String sql = "INSERT INTO Dueño (cedula, nombre, direccion, numero_telefono) VALUES(?, ?, ?, ?)";
            try(PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql)){
                
                String cedula = dueno.getCedula();
                String nombre = dueno.getNombre();
                String direccion = dueno.getDireccion();
                String numero_telefono = dueno.getTelefono();
                
                pstm.setString(1, cedula);
                pstm.setString(2, nombre);
                pstm.setString(3, direccion);
                pstm.setString(4, numero_telefono);
                
                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Dueño> consultarDuenos() throws SQLException {
        List<Dueño> arrayDuenos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Dueño";
            try (PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {
                    arrayDuenos.add(new Dueño(rs.getString("cedula").trim(),
                            rs.getString("nombre").trim(),
                            rs.getString("direccion").trim(),
                            rs.getString("numero_telefono"))
                    );
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arrayDuenos;
    }
}
