package BLL_PruebaLaboratorio;

public class Orina extends PruebaLaboratorio{
    private String descripcion;

    public Orina(double precio, String descripcion) {
        super(precio);
        this.descripcion = "Prueba de orina " + descripcion;
    }
    
    public Orina(String descripcion, int numPrueba, double precio) {
        super(numPrueba, precio);
        this.descripcion = "Prueba de orina " + descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(descripcion);
        return sb.toString();
    }
}
