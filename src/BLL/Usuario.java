package BLL;

import DAO.UsuarioDao;
import java.sql.SQLException;

public class Usuario {
    private String nombreUsuario;
    private String contrasenia;

    public Usuario(String nombreUsuario, String contrasenia) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return nombreUsuario;
    }
    
    
    
    public static void agregarUsuario(Usuario usuario) throws SQLException{
        new UsuarioDao().agregarUsuario(usuario);
    }
    
    public static boolean verificarUsuario(Usuario usuario) throws SQLException{
        return new UsuarioDao().verificarUsuario(usuario);
    }
}
