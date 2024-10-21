package BLL_PruebaLaboratorio;

public class Cultivos extends PruebaLaboratorio<CategoriasCultivos>{
    private String descripcion;

    public Cultivos() {
        this.descripcion = "Prueba de cultivos";
    }
    
    @Override
    public void definirDescripcion() {
        for (CategoriasCultivos categorias : super.arrayCategorias) {
            descripcion += ", " + categorias;
        }
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public String toString() {
        super.calcularPrecio(CategoriasCultivos.class);
        definirDescripcion();
        
        StringBuilder sb = new StringBuilder();
        sb.append("Cultivos: ");
        sb.append("\nDescripcion:").append(descripcion);
        sb.append(super.toString());
        return sb.toString();
    }
}
