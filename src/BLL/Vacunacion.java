package BLL;

public class Vacunacion extends Motivo{
    private Vacuna vacuna;

    public Vacunacion(int id_motivo, String descripcion, Vacuna vacuna) {
        super(id_motivo, descripcion, 0, false);
        this.vacuna = vacuna;
    }
    
    public Vacunacion(int id_motivo, String descripcion, Vacuna vacuna, double precio) {
        super(id_motivo, descripcion, precio, false);
        this.vacuna = vacuna;
    }
    
    public Vacunacion(String descripcion, Vacuna vacuna) {
        super(descripcion,  false);
        this.vacuna = vacuna;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
        precio = vacuna.getPrecio();
    }
    
    public Vacunacion clonar(){
        return new Vacunacion(this.getId_motivo(), this.getDescripcion(), null);
    }
    
    public String toStringInformacion() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toStringInformacion());
        sb.append("Vacuna: ").append(vacuna.getNombre()).append("\n");
        return sb.toString();
    }
}