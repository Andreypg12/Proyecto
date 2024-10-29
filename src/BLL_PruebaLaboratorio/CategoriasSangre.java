package BLL_PruebaLaboratorio;

public enum CategoriasSangre {
    SERIE_ROJA("Serie roja", 3200),
    SERIE_BLANCA("Serie blanca", 3200),
    PLAQUETAS("Plaquetas", 3200),
    COAGULACION("Coagulación", 3200);
    
    private final String nombre;
    private final double precio;

    private CategoriasSangre(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
