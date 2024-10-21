package BLL_Motivos;

public class Motivo {
    private boolean aplicaExamen;
    private String descripcion;
    private double precio;

    public Motivo(String descripcion, double precio, boolean aplicaExamen) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.aplicaExamen = aplicaExamen;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Motivo:");
        sb.append("\nDescripcion: ").append(descripcion);
        sb.append("\nAplica examen: ").append((aplicaExamen) ? "Si" : "No");
        sb.append("\nPrecio: ").append(precio).append("\n");
        return sb.toString();
    }
}
