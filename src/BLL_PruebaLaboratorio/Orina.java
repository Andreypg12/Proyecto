package BLL_PruebaLaboratorio;

public class Orina extends PruebaLaboratorio{
    private String descripcion;

    public Orina(double precio, String descripcion) {
        super(precio);
        this.descripcion = "Prueba de orina " + descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("Orina: ");
        sb.append("\nDescripcion:").append(descripcion);
        sb.append(super.toString());
        return sb.toString();
    }
}
