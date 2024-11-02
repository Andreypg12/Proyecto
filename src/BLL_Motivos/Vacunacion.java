package BLL_Motivos;

public class Vacunacion extends Motivo{
    private Vacuna vacuna;

    public Vacunacion(int id_motivo, String descripcion, Vacuna vacuna) {
        super(id_motivo, descripcion, vacuna.getPrecio(), false);
        this.vacuna = vacuna;
    }
    
    public Vacunacion(String descripcion, Vacuna vacuna) {
        super(descripcion, vacuna.getPrecio(), false);
        this.vacuna = vacuna;
    }

    public Vacuna getVacuna() {
        return vacuna;
    }

    public void setVacuna(Vacuna vacuna) {
        this.vacuna = vacuna;
    }
}