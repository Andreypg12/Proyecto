package BLL;

import DAO.UsuarioDao;
import java.sql.SQLException;

/**
 * Clase que hace referencia al usuario que va autilizar la aplicación
 * 
 * @author Andrey Pérez Gutiérrez
 */
public class Usuario {
    private String nombreUsuario;
    private String contrasenia;

    /**
     * Constructor que inicializa un nuevo usuario.
     *
     * @param nombreUsuario  El nombre del ususario.
     * @param contrasenia la contraseña ligada a ese usuario
     */
    public Usuario(String nombreUsuario, String contrasenia) {
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }
    
    /**
     * Muestra el nombre de usuario
     * 
     * @return Nombre del usuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    /**
     * Muestra la contraseña del usuario
     * 
     * @return Contraseña del usuario
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Muestra el nombre de usuario
     * 
     * @return Nombre del usuario
     */
    @Override
    public String toString() {
        return nombreUsuario;
    }
    
    /**
     * Método estático que funciona para agregar usuarios a la base de datos
     * 
     * @param usuario Es el usuario que se va a agregar a la base de datos
     */
    public static void agregarUsuario(Usuario usuario) throws SQLException{
        new UsuarioDao().agregarUsuario(usuario);
    }
    
    /**
     * Método estático que funciona para verificar un usuario en la base de daots
     * Verifica si existe tanto el nombre de usuario como la conraseña
     * 
     * @param usuario Es el usuario que se va a comprobar en la base de datos
     */
    public static boolean verificarUsuario(Usuario usuario) throws SQLException{
        return new UsuarioDao().verificarUsuario(usuario);
    }
}
