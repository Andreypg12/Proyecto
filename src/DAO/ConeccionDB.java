package DAO;

import java.sql.*;

/**
 * Clase que funciona para la conexión con la base de datos está se encargara de
 * conectarse a la base de datos con su usuario, contraseña y todo lo necesario
 * para conectarse
 *
 * @author Andrey Pérez Gutiérrez
 */
public class ConeccionDB {

    /**
     * Método estático para la conexion con la base de datos
     * 
     * @return Conexión con la base de datos
     */
    public static Connection conectarBaseDatos() {
        Connection conexion = null;

        String usuario = "sa";
        String contrasenia = "123321";
        String db = "ProyectoVeterinaria";
        String ip = "localhost";
        String puerto = "1433";

        String connectionUrl = "jdbc:sqlserver://" + ip + ":" + puerto + ";"
                + "databaseName=" + db + ";"
                + "user=" + usuario + ";"
                + "password=" + contrasenia + ";"
                + "encrypt=false";
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            conexion = DriverManager.getConnection(connectionUrl);
            System.out.println("Conexión a la base de datos exitosa.");

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado: " + e.getMessage());
            e.printStackTrace();
        }
        return conexion;
    }
}