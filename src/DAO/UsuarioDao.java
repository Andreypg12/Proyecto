package DAO;

import BLL.Usuario;
import java.sql.*;

public class UsuarioDao {
    
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
