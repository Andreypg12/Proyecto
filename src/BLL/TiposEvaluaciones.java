package BLL;

//Usado en la evaluacion, hacerlo para ir agregando las evaluaciones mas facil

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
    
    TiposEvaluaciones(String nombre, int id_tipo_evaluacion) {
        this.id_tipo_evaluacion = id_tipo_evaluacion;
        this.nombre = nombre;
    }

    public int getId_tipo_evaluacion() {
        return id_tipo_evaluacion;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
