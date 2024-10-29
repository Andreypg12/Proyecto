package BLL_Motivos;

public class Vacunacion extends Motivo{
    private Vacunas vacuna;

    public Vacunacion(int id_motivo, String descripcion, Vacunas vacuna) {
        super(id_motivo, descripcion, vacuna.getPrecio(), false);
        this.vacuna = vacuna;
    }
    
    public Vacunacion(String descripcion, Vacunas vacuna) {
        super(descripcion, vacuna.getPrecio(), false);
        this.vacuna = vacuna;
    }

    public Vacunas getVacuna() {
        return vacuna;
    }
}