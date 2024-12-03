package DAO;

import BLL.Usuario;
import java.sql.*;

/**
 * Clase con métodos necesarios para la comunicación de la base de datos con la clase {@link Usuario}
 * 
 * @author Andrey Pérez Gutiérrez
 */
public class UsuarioDao {
    
    /**
     * Método para insertar un usuario a la base de datos
     * 
     * @param usuario Es el usuario que se va agregar a la base de datos
     */
    public void agregarUsuario(Usuario usuario) throws SQLException{
        String sql = "INSERT INTO Usuario (nombre_usuario, contraseña) VALUES (?, ?)";
        try {
            try(PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql)){
                pstm.setString(1, usuario.getNombreUsuario());
                pstm.setString(2, String.format("%-6s", usuario.getContrasenia()));
                pstm.executeUpdate();
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    /**
     * Método para verificar si un usuario existe en la base de datos
     * 
     * @param usuario Es el usuario que se va a verificar en la dabase de datos
     */
    public boolean verificarUsuario(Usuario usuario) throws SQLException {
        String sql = "SELECT 1 FROM Usuario WHERE CAST(nombre_usuario AS NVARCHAR(MAX)) = ? AND CAST(contraseña AS NVARCHAR(MAX)) = ?";
        try {
            try (PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql)) {
                pstm.setString(1, usuario.getNombreUsuario());
                pstm.setString(2, usuario.getContrasenia());
                try (ResultSet rs = pstm.executeQuery()) {
                    return rs.next();
                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
