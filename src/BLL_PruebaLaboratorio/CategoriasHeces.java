package BLL_PruebaLaboratorio;

public enum CategoriasHeces {
    SANGRE_EN_HECES("Sangre en las heces", 4000),
    PARASITOS("Parásitos", 4000);
    
    private final String nombre;
    private final double precio;

    private CategoriasHeces(String nombre, double precio) {
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
