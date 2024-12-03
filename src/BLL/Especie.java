package BLL;

import DAO.RazasDAO;
import java.util.List;

/**
 * Clase que representa una especie, identificada por un ID único y un nombre.
 * También proporciona métodos para interactuar con la base de datos a través de la clase DAO correspondiente.
 * 
 * @author Andrey Pérez Gutiérrez
 */
public class Especie {
    private final int id_especie;
    private String nombreEspecie;

    /**
     * Constructor para inicializar un objeto de tipo Especie con los valores proporcionados.
     * 
     * @param nombreEspecie Nombre de la especie.
     * @param id_especie Identificador único de la especie.
     */
    public Especie(String nombreEspecie, int id_especie) {
        this.id_especie = id_especie;
        this.nombreEspecie = nombreEspecie;
    }

    /**
     * Constructor alternativo para inicializar un objeto de tipo Especie con los valores proporcionados.
     * 
     * @param id_especie Identificador único de la especie.
     * @param nombreEspecie Nombre de la especie.
     */
    public Especie(int id_especie, String nombreEspecie) {
        this.id_especie = id_especie;
        this.nombreEspecie = nombreEspecie;
    }
    

    /**
     * Obtiene el nombre de la especie.
     * 
     * @return Nombre de la especie.
     */
    public String getNombreEspecie() {
        return nombreEspecie;
    }

    /**
     * Establece un nuevo nombre para la especie.
     * 
     * @param nombreEspecie Nuevo nombre de la especie.
     */
    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }

    /**
     * Obtiene el identificador único de la especie.
     * 
     * @return Identificador único de la especie.
     */
    public int getId_especie() {
        return id_especie;
    }
    
    /**
     * Método estático para consultar la lista de especies de la base de datos.
     * 
     * @return Lista de objetos de tipo Especie.
     * @throws Exception Si ocurre un error durante la operación de base de datos.
     */
    public static List<Especie> consultarEspecies() throws Exception{
        return new RazasDAO().consultarEspecies();
    }

    /**
     * Representa a la especie como una cadena con su nombre.
     * 
     * @return Nombre de la especie como una cadena.
     */
    @Override
    public String toString() {
        return nombreEspecie;
    }
}
