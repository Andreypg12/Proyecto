package BLL;

import DAO.PruebaLaboratorioDAO;
import java.sql.SQLException;
import java.util.List;

/**
 * Representa una subcategoría de una prueba de laboratorio.
 * Contiene información como su identificador, el nombre, el precio, y 
 * el identificador de la prueba de laboratorio a la que pertenece.
 * Proporciona métodos para agregar, modificar, consultar y eliminar subcategorías 
 * en la base de datos a través de la clase {@link PruebaLaboratorioDAO}.
 * @author Andrey Pérez Gutiérrez
 */
public class SubCategoriaPrueba {

    private final int id_subCategoria;
    private int id_prueba;
    private String nombre;
    private double precio;

    /**
     * Constructor que inicializa una nueva subcategoría sin un identificador explícito.
     *
     * @param nombre El nombre de la subcategoría.
     * @param precio El precio de la subcategoría.
     * @param id_prueba El identificador de la prueba de laboratorio a la que pertenece.
     */
    public SubCategoriaPrueba(String nombre, double precio, int id_prueba) {
        this.id_subCategoria = 0;
        this.nombre = nombre;
        this.precio = precio;
        this.id_prueba = id_prueba;
    }

    /**
     * Constructor que inicializa una nueva subcategoría con un identificador explícito.
     *
     * @param nombre El nombre de la subcategoría.
     * @param precio El precio de la subcategoría.
     * @param id_prueba El identificador de la prueba de laboratorio a la que pertenece.
     * @param id_subCategoria El identificador único de la subcategoría.
     */
    public SubCategoriaPrueba(String nombre, double precio, int id_prueba, int id_subCategoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.id_prueba = id_prueba;
        this.id_subCategoria = id_subCategoria;
    }

    /**
     * Obtiene el nombre de la subcategoría.
     *
     * @return El nombre de la subcategoría.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la subcategoría.
     *
     * @param nombre El nuevo nombre de la subcategoría.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio de la subcategoría.
     *
     * @return El precio de la subcategoría.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio de la subcategoría.
     *
     * @param precio El nuevo precio de la subcategoría.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el identificador de la prueba de laboratorio a la que pertenece esta subcategoría.
     *
     * @return El identificador de la prueba de laboratorio.
     */
    public int getId_prueba() {
        return id_prueba;
    }

    /**
     * Establece el identificador de la prueba de laboratorio a la que pertenece esta subcategoría.
     *
     * @param id_prueba El nuevo identificador de la prueba de laboratorio.
     */
    public void setId_prueba(int id_prueba) {
        this.id_prueba = id_prueba;
    }

    /**
     * Obtiene el identificador único de la subcategoría.
     *
     * @return El identificador único de la subcategoría.
     */
    public int getId_subCategoria() {
        return id_subCategoria;
    }

    /**
     * Agrega una nueva subcategoría en la base de datos.
     *
     * @param subCategoria La subcategoría que se desea agregar.
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    public static void agregarSubCategoria(SubCategoriaPrueba subCategoria) throws SQLException {
        new PruebaLaboratorioDAO().agregarSubCategoria(subCategoria);
    }

    /**
     * Modifica una subcategoría existente en la base de datos.
     *
     * @param subCategoria La subcategoría que se desea modificar.
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    public static void modificarSubCategoria(SubCategoriaPrueba subCategoria) throws SQLException {
        new PruebaLaboratorioDAO().modificarSubCategoria(subCategoria);
    }

    /**
     * Consulta todas las subcategorías registradas en la base de datos.
     *
     * @return Una lista de objetos {@link SubCategoriaPrueba}.
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    public static List<SubCategoriaPrueba> consultarSubCategorias() throws SQLException {
        return new PruebaLaboratorioDAO().consultarSubCategorias();
    }

    /**
     * Elimina una subcategoría de la base de datos.
     *
     * @param subCategoria La subcategoría que se desea eliminar.
     * @throws SQLException Si ocurre un error al interactuar con la base de datos.
     */
    public static void eliminarSubCategoria(SubCategoriaPrueba subCategoria) throws SQLException {
        new PruebaLaboratorioDAO().eliminarSubCategoria(subCategoria);
    }

    /**
     * Devuelve una representación en forma de texto de la subcategoría.
     *
     * @return El nombre de la subcategoría.
     */
    @Override
    public String toString() {
        return nombre;
    }
}
