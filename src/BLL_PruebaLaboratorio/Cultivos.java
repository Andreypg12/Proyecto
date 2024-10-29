package BLL_PruebaLaboratorio;

public class Cultivos extends PruebaLaboratorio{
    private String descripcion;

    public Cultivos(double precio, String descripcion) {
        super(precio);
        this.descripcion = "Prueba de cultivos " + descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("Cultivos: ");
        sb.append("\nDescripcion:").append(descripcion);
        sb.append(super.toString());
        return sb.toString();
    }
}
