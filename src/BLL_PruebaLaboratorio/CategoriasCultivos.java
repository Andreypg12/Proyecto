package BLL_PruebaLaboratorio;

public enum CategoriasCultivos {
    HONGOS("Hongos", 4800),
    BACTERIAS("Bacterias", 4800);
    
    private final String nombre;
    private final double precio;

    private CategoriasCultivos(String nombre, double precio) {
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
