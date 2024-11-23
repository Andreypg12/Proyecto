package BLL;

import DAO.MotivosDAO;
import java.util.List;

public class Motivo {
    private final int id_motivo;
    private boolean aplicaExamen;
    private String descripcion;
    protected double precio;

    public Motivo(int id_motivo, String descripcion, double precio, boolean aplicaExamen) {
        this.id_motivo = id_motivo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.aplicaExamen = aplicaExamen;
    }
    public Motivo(String descripcion, double precio, boolean aplicaExamen) {
        this.id_motivo = 0;
        this.descripcion = descripcion;
        this.precio = precio;
        this.aplicaExamen = aplicaExamen;
    }
    public Motivo(String descripcion, boolean aplicaExamen) {
        this.id_motivo = 0;
        this.descripcion = descripcion;
        this.precio = 0;
        this.aplicaExamen = aplicaExamen;
    }
    public Motivo(int id_motivo, String descripcion, boolean aplicaExamen) {
        this.id_motivo = id_motivo;
        this.descripcion = descripcion;
        this.precio = 0;
        this.aplicaExamen = aplicaExamen;
    }
    
    public Motivo clonar(){
            return new Motivo(this.getId_motivo(), this.getDescripcion(), this.getPrecio(), this.isAplicaExamen());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(descripcion);
        return sb.toString();
    }

    public String toStringInformacion() {
        StringBuilder sb = new StringBuilder();
        sb.append(descripcion);
        sb.append("\nAplica examen: ").append((aplicaExamen) ? "Si" : "No");
        sb.append("\nPrecio: ").append(precio).append("₡\n");
        return sb.toString();
    }

    public boolean isAplicaExamen() {
        return aplicaExamen;
    }

    public void setAplicaExamen(boolean aplicaExamen) {
        this.aplicaExamen = aplicaExamen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_motivo() {
        return id_motivo;
    }
    
    public static void agregarMotivo(Motivo motivo) throws Exception{
        new MotivosDAO().agregarMotivo(motivo);
    }
    
    public static List<Motivo> consultarMotivos() throws Exception{
        return new MotivosDAO().consultarMotivos();
    }
    
    public static void eliminarMotivo(Motivo motivo) throws Exception{
        new MotivosDAO().eliminarMotivo(motivo);
    }
    
    public static void modificarMotivo(Motivo motivo) throws Exception{
        new MotivosDAO().mofificarMotivo(motivo);
    }
}
