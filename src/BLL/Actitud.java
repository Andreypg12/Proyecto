package BLL;

/**
 * @author Andrey Pérez Gutiérrez Enum que representa diferentes actitudes de un
 * paciente. Cada actitud tiene un nombre descriptivo y un identificador único.
 */
public enum Actitud {
    EXCITADO("Excitado", 1),
    DEPRIMIDO("Deprimido", 2),
    POSTRADO("Postrado", 3);

    private final int id_actitud;
    private final String actitud;

    /**
     * Constructor del enúm.
     *
     * @param actitud Nombre descriptivo de la actitud.
     * @param id_actitud Identificador único de la actitud.
     */
    Actitud(String actitud, int id_actitud) {
        this.id_actitud = id_actitud;
        this.actitud = actitud;
    }

    /**
     * Obtiene el identificador único de la actitud.
     *
     * @return El identificador de la actitud.
     */
    public int getId_actitud() {
        return id_actitud;
    }

    /**
     * Muestra la escritura entendible del valor.
     *
     * @return El nombre descriptivo de la actitud.
     */
    @Override
    public String toString() {
        return actitud;
    }
}
