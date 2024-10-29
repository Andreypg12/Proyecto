package BLL_PruebaLaboratorio;

public class Sangre extends PruebaLaboratorio{
    private String descripcion;

    public Sangre(double precio, String descripcion) {
        super(precio);
        this.descripcion = "Prueba de sangre " + descripcion;
    }

    public Sangre(String descripcion, int numPrueba, double precio) {
        super(numPrueba, precio);
        this.descripcion = "Prueba de sangre " + descripcion;
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
