package BLL;

/**
 * @author Andrey Pérez Gutiérrez Enum que representa los estados en que puede estar una evalución
 * paciente. Cada estado tiene un nombre descriptivo y un identificador único.
 */
public enum Estado {
    NORMAL("Normal", 1),
    ANORMAL("Anormal", 2);
    
    
    private final int id_estado;
    private final String estado;

    /**
     * Constructor del enúm.
     *
     * @param id_estado Nombre descriptivo del estado.
     * @param estado Identificador único del estado.
     */
    private Estado(String estado, int id_estado) {
        this.id_estado = id_estado;
        this.estado = estado;
    }

    /**
     * Obtiene el identificador único del estado.
     *
     * @return El identificador del estado.
     */
    public int getId_estado() {
        return id_estado;
    }

    /**
     * Muestra la escritura entendible del valor.
     *
     * @return El nombre descriptivo del estado.
     */
    @Override
    public String toString() {
        return estado;
    }
}
