package BLL_Motivos;

public class Vacunacion extends Motivo{
    private Vacuna vacuna;

    public Vacunacion(int id_motivo, String descripcion, Vacuna vacuna) {
        super(id_motivo, descripcion, 0, false);
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
    }
}