package BLL_PruebaLaboratorio;

public class Heces extends PruebaLaboratorio{
    private String descripcion;
    
    public Heces(double precio, String descripcion) {
        super(precio);
        this.descripcion = "Prueba de heces" + descripcion;
    }

    public Heces(String descripcion, int numPrueba, double precio) {
        super(numPrueba, precio);
        this.descripcion = "Prueba de heces" + descripcion;
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
