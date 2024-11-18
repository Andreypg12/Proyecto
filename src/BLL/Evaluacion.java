package BLL;

public class Evaluacion {

    private final int id_evaluacion;
    private TiposEvaluaciones tipoEvaluacion;
    private Estado estado;
    private StringBuffer observacion;

    public Evaluacion(Estado estado, TiposEvaluaciones tipoEvaluacion) {
        id_evaluacion = 0;
        this.tipoEvaluacion = tipoEvaluacion;
        this.estado = estado;
        this.observacion = new StringBuffer();
        observacion.append("La evaluacion de ").append(tipoEvaluacion).append(" es ").append(estado);
    }
    public Evaluacion(int id_evaluacion, Estado estado, TiposEvaluaciones tipoEvaluacion) {
        this.id_evaluacion = id_evaluacion;
        this.tipoEvaluacion = tipoEvaluacion;
        this.estado = estado;
        this.observacion = new StringBuffer();
        observacion.append("La evaluacion de ").append(tipoEvaluacion).append(" es ").append(estado);
    }

    public TiposEvaluaciones getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public StringBuffer getObservacion() {
        return observacion;
    }

    public int getId_evaluacion() {
        return id_evaluacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(observacion);
        return sb.toString();
    }
}
