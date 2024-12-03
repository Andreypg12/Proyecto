package BLL;

/**
 * @author Andrey Pérez Gutiérrez Enum que define la condición de peso de un
 * paciente
 */
public enum Condicion {
    BAJO_PESO("Bajo Peso", 1),
    SOBRE_PESO("Sobrepeso", 2),
    NORMAL("Normal", 3);

    private final int id_condicion;
    private final String estado;

    /**
     * Constructor del enúm.
     *
     * @param estado Nombre descriptivo de la condicion.
     * @param id_condicion Identificador único de la condicion.
     */
    Condicion(String estado, int id_condicion) {
        this.id_condicion = id_condicion;
        this.estado = estado;
    }

    /**
     * @return Identificador unico de ola condición
     */
    public int getId_condicion() {
        return id_condicion;
    }

    /**
     * @return NOmbre descriptivo de la condición
     */
    @Override
    public String toString() {
        return estado;
    }
}
