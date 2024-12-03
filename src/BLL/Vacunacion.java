package BLL;

/**
 * Clase que representa un motivo de tipo vacunación en el sistema.
 * Extiende la clase {@link Motivo} e incluye una vacuna específica asociada al motivo.
 * También proporciona métodos para manejar los datos relacionados con la vacuna.
 * 
 * @see Motivo
 */
public class Vacunacion extends Motivo {
    
    private Vacuna vacuna;

    /**
     * Constructor que inicializa un motivo de vacunación con identificador, descripción y vacuna.
     * 
     * @param id_motivo Identificador único del motivo.
     * @param descripcion Descripción del motivo.
     * @param vacuna Vacuna asociada al motivo.
     */
    public Vacunacion(int id_motivo, String descripcion, Vacuna vacuna) {
        super(id_motivo, descripcion, 0, false);
        this.vacuna = vacuna;
    }

    /**
     * Constructor que inicializa un motivo de vacunación con identificador, descripción, vacuna y precio.
     * 
     * @param id_motivo Identificador único del motivo.
     * @param descripcion Descripción del motivo.
     * @param vacuna Vacuna asociada al motivo.
     * @param precio Precio del motivo.
     */
    public Vacunacion(int id_motivo, String descripcion, Vacuna vacuna, double precio) {
        super(id_motivo, descripcion, precio, false);
        this.vacuna = vacuna;
    }

    /**
     * Constructor que inicializa un motivo de vacunación con descripción y vacuna, sin identificador ni precio.
     * 
     * @param descripcion Descripción del motivo.
     * @param vacuna Vacuna asociada al motivo.
     */
    public Vacunacion(String descripcion, Vacuna vacuna) {
        super(descripcion, false);
        this.vacuna = vacuna;
    }

    /**
     * Obtiene la vacuna asociada al motivo de vacunación.
     * 
     * @return Vacuna asociada al motivo.
     */
    public Vacuna getVacuna() {
        return vacuna;
    }

    /**
     * Establece una nueva vacuna asociada al motivo de vacunación y actualiza el precio.
     * 
     * @param vacuna Nueva vacuna asociada al motivo.
     */
    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
        precio = vacuna.getPrecio();
    }

    /**
     * Crea una copia del objeto actual sin asociar una vacuna.
     * 
     * @return Un nuevo objeto de tipo {@code Vacunacion} con los mismos valores excepto la vacuna.
     */
    public Vacunacion clonar() {
        return new Vacunacion(this.getId_motivo(), this.getDescripcion(), null);
    }

    /**
     * Representa al motivo de vacunación como una cadena con información detallada.
     * Incluye la información básica del motivo y los datos de la vacuna asociada.
     * 
     * @return Información detallada del motivo de vacunación.
     */
    @Override
    public String toStringInformacion() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toStringInformacion());
        if (vacuna != null) {
            sb.append("Vacuna: ").append(vacuna.getNombre()).append("\n");
        }
        return sb.toString();
    }
}