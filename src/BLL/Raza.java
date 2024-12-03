package BLL;

import DAO.RazasDAO;
import java.util.List;

/**
 * Representa una raza de una especie en particular, como perro o gato.
 * Contiene información básica sobre la raza, incluyendo su ID, nombre,
 * y la especie a la que pertenece.
 * Proporciona métodos para agregar, consultar, modificar y eliminar razas
 * en la base de datos
 * @author  Andrey Pérez Gutiérrez
 */
public class Raza {

    private final int id_raza;
    protected String nombreRaza;
    private Especie especieAQuePertenece;

    /**
     * Constructor que inicializa una nueva raza sin un identificador explícito.
     *
     * @param nombreRaza Nombre de la raza.
     * @param especieAQuePertenece Especie a la que pertenece la raza.
     */
    public Raza(String nombreRaza, Especie especieAQuePertenece) {
        id_raza = 0;
        this.nombreRaza = nombreRaza;
        this.especieAQuePertenece = especieAQuePertenece;
    }

    /**
     * Constructor que inicializa una nueva raza con un identificador explícito.
     *
     * @param id_raza Identificador único de la raza.
     * @param nombreRaza Nombre de la raza.
     * @param especieAQuePertenece Especie a la que pertenece la raza.
     */
    public Raza(int id_raza, String nombreRaza, Especie especieAQuePertenece) {
        this.id_raza = id_raza;
        this.nombreRaza = nombreRaza;
        this.especieAQuePertenece = especieAQuePertenece;
    }

    /**
     * Obtiene el nombre de la raza.
     *
     * @return El nombre de la raza.
     */
    public String getNombreRaza() {
        return nombreRaza;
    }

    /**
     * Establece el nombre de la raza.
     *
     * @param nombreRaza El nuevo nombre de la raza.
     */
    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    /**
     * Obtiene el identificador único de la raza.
     *
     * @return El identificador único de la raza.
     */
    public int getId_raza() {
        return id_raza;
    }

    /**
     * Obtiene la especie a la que pertenece esta raza.
     *
     * @return La especie a la que pertenece.
     */
    public Especie getEspecieAQuePertenece() {
        return especieAQuePertenece;
    }

    /**
     * Establece la especie a la que pertenece esta raza.
     *
     * @param especieAQuePertenece La nueva especie a la que pertenece.
     */
    public void setEspecieAQuePertenece(Especie especieAQuePertenece) {
        this.especieAQuePertenece = especieAQuePertenece;
    }

    /**
     * Agrega una nueva raza en la base de datos.
     *
     * @param raza La raza que se desea agregar.
     * @throws Exception Si ocurre un error al interactuar con la base de datos.
     */
    public static void agregarRaza(Raza raza) throws Exception {
        new RazasDAO().agregarRaza(raza);
    }

    /**
     * Consulta todas las razas registradas en la base de datos.
     *
     * @return Una lista de objetos {@link Raza}.
     * @throws Exception Si ocurre un error al interactuar con la base de datos.
     */
    public static List<Raza> consultarRazas() throws Exception {
        return new RazasDAO().consultarRazas();
    }

    /**
     * Modifica una raza existente en la base de datos.
     *
     * @param raza La raza que se desea modificar.
     * @throws Exception Si ocurre un error al interactuar con la base de datos.
     */
    public static void modificarRaza(Raza raza) throws Exception {
        new RazasDAO().modificarRaza(raza);
    }

    /**
     * Elimina una raza de la base de datos.
     *
     * @param raza La raza que se desea eliminar.
     * @throws Exception Si ocurre un error al interactuar con la base de datos.
     */
    public static void eliminarRaza(Raza raza) throws Exception {
        new RazasDAO().eliminarRaza(raza);
    }

    /**
     * Devuelve una representación en forma de texto de la raza.
     *
     * @return El nombre de la raza.
     */
    @Override
    public String toString() {
        return nombreRaza;
    }
}
    
    
