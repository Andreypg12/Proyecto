package BLL_Motivos;

public class Vacunacion extends Motivo{
    private Vacunas vacuna;

    public Vacunacion(Vacunas vacuna, boolean aplicaExamen) {
        super("Vacunación", vacuna.getPrecio(), aplicaExamen);
        this.vacuna = vacuna;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Vacuna: ").append(vacuna);
        return sb.toString();
    }
}