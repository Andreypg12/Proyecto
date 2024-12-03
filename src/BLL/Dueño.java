package BLL;

import DAO.DueñosDAO;
import java.util.List;

/**
 * Clase que representa al dueño de un paciente, asociada a información personal
 * como cédula, nombre, dirección y teléfono. Esta clase también proporciona
 * métodos estáticos para interactuar con la base de datos a través de la clase
 * DAO correspondiente.
 *
 * @author Andrey Pérez Gutiérrez
 */
public class Dueño {

    private final String cedula;
    private String direccion;
    private String nombre;
    private String telefono;

    /**
     * Constructor para inicializar un objeto de tipo Dueño con los valores
     * proporcionados.
     *
     * @param cedula Número de cédula del dueño.
     * @param nombre Nombre del dueño.
     * @param direccion Dirección del dueño.
     * @param telefono Número de teléfono del dueño.
     */
    public Dueño(String cedula, String nombre, String direccion, String telefono) {
        this.cedula = cedula;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    /**
     * Obtiene la dirección del dueño.
     *
     * @return Dirección del dueño.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece una nueva dirección para el dueño.
     *
     * @param direccion Nueva dirección del dueño.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el nombre del dueño.
     *
     * @return Nombre del dueño.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece un nuevo nombre para el dueño.
     *
     * @param nombre Nuevo nombre del dueño.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el número de teléfono del dueño.
     *
     * @return Número de teléfono del dueño.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece un nuevo número de teléfono para el dueño.
     *
     * @param telefono Nuevo número de teléfono del dueño.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    /**
     * Método estático para agregar un dueño a la base de datos mediante la clase DAO.
     *
     * @param dueno Objeto de tipo Dueño que se desea agregar.
     * @throws Exception Si ocurre un error durante la operación de base de
     * datos.
     */
    public static void agregar(Dueño dueno) throws Exception {
        new DueñosDAO().agregar(dueno);
    }

    /**
     * Método estático para consultar la lista de dueños en la base de datos.
     *
     * @return Lista de objetos de tipo Dueño.
     * @throws Exception Si ocurre un error durante la operación de base de
     * datos.
     */
    public static List<Dueño> cosultarDueños() throws Exception {
        return new DueñosDAO().consultarDuenos();
    }

    /**
     * Representa al dueño como una cadena con su nombre y cédula.
     *
     * @return Una cadena en el formato "nombre - cédula: {cédula}".
     */
    @Override
    public String toString() {
        return nombre + " - cédula: " + cedula;
    }
}
