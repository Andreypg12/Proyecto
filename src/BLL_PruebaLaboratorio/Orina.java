package BLL_PruebaLaboratorio;

public class Orina extends PruebaLaboratorio<CategoriasOrina>{
    private String descripcion;

    public Orina() {
        this.descripcion = "Prueba de orina";
    }

    @Override
    public void definirDescripcion() {
        for (CategoriasOrina categorias : super.arrayCategorias) {
            descripcion += ", " + categorias;
        }
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    @Override
    public String toString() {
        super.calcularPrecio(CategoriasOrina.class);
        definirDescripcion();
        
        StringBuilder sb = new StringBuilder();
        sb.append("Orina: ");
        sb.append("\nDescripcion:").append(descripcion);
        sb.append(super.toString());
        return sb.toString();
    }
}
