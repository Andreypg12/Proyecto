package BLL_PruebaLaboratorio;

public class Sangre extends PruebaLaboratorio <CategoriasSangre>{
    private String descripcion;

    public Sangre() {
        this.descripcion = "Prueba de sangre";
    }

    @Override
    public void definirDescripcion() {
        for (CategoriasSangre categorias : super.arrayCategorias) {
            descripcion += ", " + categorias;
        }
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        super.calcularPrecio(CategoriasSangre.class);
        definirDescripcion();
        
        StringBuilder sb = new StringBuilder();
        sb.append("Sangre: ");
        sb.append("\nDescripcion:").append(descripcion);
        sb.append(super.toString());
        return sb.toString();
    }
}
