package BLL;

import DAO.MotivosDAO;
import java.util.List;

/**
 * Clase que representa un motivo. Un motivo puede estar relacionado con una cita
 * y puede incluir información como descripción, precio y si aplica un examen.
 * También proporciona métodos para interactuar con la base de datos mediante la clase DAO correspondiente.
 * 
 * @author Andrey Pérez Gutiérrez
 */
public class Motivo {
    private final int id_motivo;
    private boolean aplicaExamen;
    private String descripcion;
    protected double precio;

    /**
     * Constructor para inicializar un objeto de tipo Motivo con todos los atributos.
     * 
     * @param id_motivo Identificador único del motivo.
     * @param descripcion Descripción del motivo.
     * @param precio Precio del motivo.
     * @param aplicaExamen Indica si aplica un examen.
     */
    public Motivo(int id_motivo, String descripcion, double precio, boolean aplicaExamen) {
        this.id_motivo = id_motivo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.aplicaExamen = aplicaExamen;
    }
    
    /**
     * Constructor para inicializar un objeto de tipo Motivo sin especificar un identificador.
     * 
     * @param descripcion Descripción del motivo.
     * @param precio Precio del motivo.
     * @param aplicaExamen Indica si aplica un examen.
     */
    public Motivo(String descripcion, double precio, boolean aplicaExamen) {
        this.id_motivo = 0;
        this.descripcion = descripcion;
        this.precio = precio;
        this.aplicaExamen = aplicaExamen;
    }
    
    /**
     * Constructor para inicializar un objeto de tipo Motivo con descripción y si aplica examen, sin especificar precio.
     * 
     * @param descripcion Descripción del motivo.
     * @param aplicaExamen Indica si aplica un examen.
     */
    public Motivo(String descripcion, boolean aplicaExamen) {
        this.id_motivo = 0;
        this.descripcion = descripcion;
        this.precio = 0;
        this.aplicaExamen = aplicaExamen;
    }
    
    /**
     * Constructor para inicializar un objeto de tipo Motivo con identificador, descripción y si aplica examen, sin precio.
     * 
     * @param id_motivo Identificador único del motivo.
     * @param descripcion Descripción del motivo.
     * @param aplicaExamen Indica si aplica un examen.
     */
    public Motivo(int id_motivo, String descripcion, boolean aplicaExamen) {
        this.id_motivo = id_motivo;
        this.descripcion = descripcion;
        this.precio = 0;
        this.aplicaExamen = aplicaExamen;
    }
    
    /**
     * Clona el objeto actual y devuelve una nueva instancia con los mismos valores.
     * 
     * @return Un nuevo objeto de tipo Motivo con los mismos valores.
     */
    public Motivo clonar(){
            return new Motivo(this.getId_motivo(), this.getDescripcion(), this.getPrecio(), this.isAplicaExamen());
    }

    /**
     * Representa al motivo como una cadena con su descripción.
     * 
     * @return Descripción del motivo.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(descripcion);
        return sb.toString();
    }

    /**
     * Representa al motivo como una cadena con información detallada, incluyendo si aplica examen y su precio.
     * 
     * @return Información detallada del motivo.
     */
    public String toStringInformacion() {
        StringBuilder sb = new StringBuilder();
        sb.append(descripcion);
        sb.append("\nAplica examen: ").append((aplicaExamen) ? "Si" : "No");
        sb.append("\nPrecio: ").append(precio).append("₡\n");
        return sb.toString();
    }

    /**
     * Obtiene si el motivo aplica un examen.
     * 
     * @return {@code true} si aplica un examen, {@code false} en caso contrario.
     */
    public boolean isAplicaExamen() {
        return aplicaExamen;
    }

    /**
     * Establece si el motivo aplica un examen.
     * 
     * @param aplicaExamen {@code true} para indicar que aplica un examen, {@code false} en caso contrario.
     */
    public void setAplicaExamen(boolean aplicaExamen) {
        this.aplicaExamen = aplicaExamen;
    }

    /**
     * Obtiene la descripción del motivo.
     * 
     * @return Descripción del motivo.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece una nueva descripción para el motivo.
     * 
     * @param descripcion nueva descripción del motivo.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio del motivo.
     * 
     * @return Precio del motivo.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece un nuevo precio para el motivo.
     * 
     * @param precio Nuevo precio del motivo.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el identificador único del motivo.
     * 
     * @return Identificador único del motivo.
     */
    public int getId_motivo() {
        return id_motivo;
    }
    
    /**
     * Agrega un motivo a la base de datos.
     * 
     * @param motivo Objeto Motivo a agregar.
     * @throws Exception Si ocurre un error al realizar la operación.
     */
    public static void agregarMotivo(Motivo motivo) throws Exception{
        new MotivosDAO().agregarMotivo(motivo);
    }
    
    /**
     * Consulta y obtiene todos los motivos disponibles en la base de datos.
     * 
     * @return Lista de objetos Motivo.
     * @throws Exception Si ocurre un error al realizar la operación.
     */
    public static List<Motivo> consultarMotivos() throws Exception{
        return new MotivosDAO().consultarMotivos();
    }
    
    /**
     * Elimina un motivo de la base de datos.
     * 
     * @param motivo Objeto Motivo a eliminar.
     * @throws Exception Si ocurre un error al realizar la operación.
     */
    public static void eliminarMotivo(Motivo motivo) throws Exception{
        new MotivosDAO().eliminarMotivo(motivo);
    }
    
    /**
     * Modifica un motivo existente en la base de datos.
     * 
     * @param motivo Objeto Motivo con los cambios a realizar.
     * @throws Exception Si ocurre un error al realizar la operación.
     */
    public static void modificarMotivo(Motivo motivo) throws Exception{
        new MotivosDAO().mofificarMotivo(motivo);
    }
}
