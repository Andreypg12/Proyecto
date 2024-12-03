package BLL;

/**
 * Es una clase ayuda a facilitar saber el tipo de  evaluación que se va arealizar en la clase {@link Evaluacion}
 * Tienen un nombre  y un identificador  único
 * @author Andrey Pérez Gutiérrez
 */
public enum TiposEvaluaciones {
    PIEL("Piel", 1),
    OJOS("Ojos", 2),
    OREJAS("Orejas", 3),
    MEMBRANAS_MUCOSAS("Membranas Mucosas", 4),
    DIENTES("Dientes", 5),
    NARIZ("Nariz", 6),
    PELO("Pelo", 7),
    HIDRATACION("Hidratación", 8);
    
    private final int id_tipo_evaluacion;
    private final String nombre;
    
    /**
     * Constructor privado para inicializar los valores de la enumeración.
     *
     * @param nombre Nombre descriptivo del tipo de evaluación.
     * @param id_tipo_evaluacion Identificador unico del tipo de evaluación
     */
    TiposEvaluaciones(String nombre, int id_tipo_evaluacion) {
        this.id_tipo_evaluacion = id_tipo_evaluacion;
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador único del tipo de evaluación.
     *
     * @return Identificador único del tipo de evaluación.
     */
    public int getId_tipo_evaluacion() {
        return id_tipo_evaluacion;
    }

    /**
     * Devuelve una representación en forma de texto del tipo de evaluación.
     *
     * @return El nombre del tipo de evaluación.
     */
    @Override
    public String toString() {
        return nombre;
    }
}
