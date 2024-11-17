package BLL;

public class Evaluacion {

    private TiposEvaluaciones tipoEvaluacion;
    private Estado estado;
    private StringBuffer observacion;

    public Evaluacion(Estado estado, TiposEvaluaciones tipoEvaluacion) {
        this.tipoEvaluacion = tipoEvaluacion;
        this.estado = estado;
        this.observacion = new StringBuffer();
        observacion.append("La evaluacion de ").append(tipoEvaluacion).append(" es ").append(estado);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(observacion);
        return sb.toString();
    }
}
