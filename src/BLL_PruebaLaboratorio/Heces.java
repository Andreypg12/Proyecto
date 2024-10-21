package BLL_PruebaLaboratorio;

public class Heces extends PruebaLaboratorio <CategoriasHeces>{
    private String descripcion;
    
    public Heces() {
        this.descripcion = "Prueba de heces";
    }
    
    @Override
    public void definirDescripcion() {
        for (CategoriasHeces categorias : super.arrayCategorias) {
            descripcion += ", " + categorias;
        }
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString() {
        super.calcularPrecio(CategoriasHeces.class);
        definirDescripcion();
        
        StringBuilder sb = new StringBuilder();
        sb.append("Heces: ");
        sb.append("\nDescripcion:").append(descripcion);
        sb.append(super.toString());
        return sb.toString();
    }
}
