package BLL_PruebaLaboratorio;

public class Cultivos extends PruebaLaboratorio{
    private String descripcion;

    public Cultivos(double precio, String descripcion) {
        super(precio);
        this.descripcion = "Prueba de cultivos " + descripcion;
    }

    public Cultivos(String descripcion, int numPrueba, double precio) {
        super(numPrueba, precio);
        this.descripcion = "Prueba de cultivos " + descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append(descripcion);
        return sb.toString();
    }
}