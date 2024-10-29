package BLL_PruebaLaboratorio;

public enum CategoriasOrina {
    SEDIMIENTOS("Sedimientos", 3600),
    PROTEINAS("Proteínas", 3600),
    CULTIVOS_PARA_HONGOS("Cultivos para hongos", 3600),
    BACTERIAS("Bacterias", 3600);
    
    private final String nombre;
    private final double precio;

    private CategoriasOrina(String nombre, double precio) {
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
