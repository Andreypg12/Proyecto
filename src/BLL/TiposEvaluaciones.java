package BLL;

//Usado en la evaluacion, hacerlo para ir agregando las evaluaciones mas facil

public enum TiposEvaluaciones {
    PIEL("Piel"),
    OJOS("Ojos"),
    OREJAS("Orejas"),
    MEMBRANAS_MUCOSAS("Membranas Mucosas"),
    DIENTES("Dientes"),
    NARIZ("Nariz"),
    PELO("Pelo"),
    HIDRATACION("Hidratación");

    private final String nombre;

    TiposEvaluaciones(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
