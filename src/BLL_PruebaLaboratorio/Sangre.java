package BLL_PruebaLaboratorio;

public class Sangre extends PruebaLaboratorio{
    private String descripcion;

    public Sangre(double precio, String descripcion) {
        super(precio);
        this.descripcion = "Prueba de sangre " + descripcion;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("Sangre: ");
        sb.append("\nDescripcion:").append(descripcion);
        sb.append(super.toString());
        return sb.toString();
    }
}
