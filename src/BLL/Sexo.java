package BLL;

/**
 * Enumeración que representa los sexos posibles de un paciente: Macho o Hembra.
 * Proporciona métodos para obtener una representación en texto del sexo.
 * @author Andrey Péerzs Gutiérrez
 */
public enum Sexo {

    MACHO("Macho"),
    HEMBRA("Hembra");

    private final String nombreSexo;

    /**
     * Constructor privado para inicializar los valores de la enumeración.
     *
     * @param nombreSexo Nombre descriptivo del sexo.
     */
    private Sexo(String nombreSexo) {
        this.nombreSexo = nombreSexo;
    }

    /**
     * Obtiene el nombre descriptivo del sexo.
     *
     * @return El nombre del sexo.
     */
    public String getNombreSexo() {
        return nombreSexo;
    }

    /**
     * Devuelve una representación en forma de texto del sexo.
     *
     * @return El nombre del sexo.
     */
    @Override
    public String toString() {
        return nombreSexo;
    }
}
