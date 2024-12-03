package BLL;

import BLL.Especie;
import DAO.VacunasDAO;
import java.util.List;

/**
 * Representa una vacuna asociada a una especie específica.
 * Contiene información como el nombre, precio, identificador, 
 * y la especie para la cual es válida la vacuna.
 * Proporciona métodos para agregar, consultar, modificar y eliminar vacunas
 * en la base de datos a través de la clase {@link VacunasDAO}.
 * @author Andrey Pérez Gutiérrez
 */
public class Vacuna {

    private String nombre;
    private double precio;
    private final int id_vacuna;
    private Especie especieVacuna;

    /**
     * Constructor que inicializa una nueva vacuna sin un identificador explícito.
     *
     * @param nombre El nombre de la vacuna.
     * @param precio El precio de la vacuna.
     * @param especieVacuna La especie a la que está asociada esta vacuna.
     */
    public Vacuna(String nombre, double precio, Especie especieVacuna) {
        this.nombre = nombre;
        this.precio = precio;
        this.id_vacuna = 0;
        this.especieVacuna = especieVacuna;
    }

    /**
     * Constructor que inicializa una nueva vacuna con un identificador explícito.
     *
     * @param nombre El nombre de la vacuna.
     * @param precio El precio de la vacuna.
     * @param id_vacuna El identificador único de la vacuna.
     * @param especieVacuna La especie a la que está asociada esta vacuna.
     */
    public Vacuna(String nombre, double precio, int id_vacuna, Especie especieVacuna) {
        this.nombre = nombre;
        this.precio = precio;
        this.id_vacuna = id_vacuna;
        this.especieVacuna = especieVacuna;
    }

    /**
     * Obtiene el nombre de la vacuna.
     *
     * @return El nombre de la vacuna.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene el precio de la vacuna.
     *
     * @return El precio de la vacuna.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Obtiene la especie a la que está asociada esta vacuna.
     *
     * @return La especie asociada.
     */
    public Especie getEspecieVacuna() {
        return especieVacuna;
    }

    /**
     * Obtiene el identificador único de la vacuna.
     *
     * @return El identificador único de la vacuna.
     */
    public int getId_vacuna() {
        return id_vacuna;
    }

    /**
     * Establece el nombre de la vacuna.
     *
     * @param nombre El nuevo nombre de la vacuna.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el precio de la vacuna.
     *
     * @param precio El nuevo precio de la vacuna.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Devuelve una representación en forma de texto de la vacuna.
     *
     * @return El nombre de la vacuna.
     */
    @Override
    public String toString() {
        return nombre;
    }

    /**
     * Agrega una nueva vacuna en la base de datos.
     *
     * @param vacuna La vacuna que se desea agregar.
     * @throws Exception Si ocurre un error al interactuar con la base de datos.
     */
    public static void agregarVacuna(Vacuna vacuna) throws Exception {
        new VacunasDAO().agregarVacuna(vacuna);
    }

    /**
     * Consulta todas las vacunas registradas en la base de datos.
     *
     * @return Una lista de objetos {@link Vacuna}.
     * @throws Exception Si ocurre un error al interactuar con la base de datos.
     */
    public static List<Vacuna> consultarVacunas() throws Exception {
        return new VacunasDAO().consultarVacunas();
    }

    /**
     * Elimina una vacuna de la base de datos.
     *
     * @param vacuna La vacuna que se desea eliminar.
     * @throws Exception Si ocurre un error al interactuar con la base de datos.
     */
    public static void eliminarVacuna(Vacuna vacuna) throws Exception {
        new VacunasDAO().eliminarVacuna(vacuna);
    }

    /**
     * Modifica una vacuna existente en la base de datos.
     *
     * @param vacuna La vacuna que se desea modificar.
     * @throws Exception Si ocurre un error al interactuar con la base de datos.
     */
    public static void modificarVacuna(Vacuna vacuna) throws Exception {
        new VacunasDAO().modificarVacuna(vacuna);
    }
}
