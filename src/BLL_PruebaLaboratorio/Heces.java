package BLL_PruebaLaboratorio;

public class Heces extends PruebaLaboratorio{
    private String descripcion;
    
    public Heces(double precio, String descripcion) {
        super(precio);
        this.descripcion = "Prueba de heces" + descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("Heces: ");
        sb.append("\nDescripcion:").append(descripcion);
        sb.append(super.toString());
        return sb.toString();
    }
}
