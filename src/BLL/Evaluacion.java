package BLL;

/**
 * Clase que representa una evaluacion que se hace en la cita hacia un paciente,
 * identificada por un ID único, un tipo de evalucion, un estado, y la
 * observación.
 *
 * @author Andrey Pérez Gutiérrez
 */
public class Evaluacion {

    private final int id_evaluacion;
    private TiposEvaluaciones tipoEvaluacion;
    private Estado estado;
    private StringBuffer observacion;

    /**
     * Constructor para inicializar un objeto de tipo Evalucion donde no tiene asignado un id.
     * Se hace automaticamente la observación
     * 
     * @param estado Estado del tipo de evaluación.
     * @param tipoEvaluacion El tipo de evaluación.
     */
    public Evaluacion(Estado estado, TiposEvaluaciones tipoEvaluacion) {
        id_evaluacion = 0;
        this.tipoEvaluacion = tipoEvaluacion;
        this.estado = estado;
        this.observacion = new StringBuffer();
        observacion.append("La evaluacion de ").append(tipoEvaluacion).append(" es ").append(estado);
    }
    
    /**
     * Constructor para inicializar un objeto de tipo Evalucion donde se le asignará un id.
     * Se hace automaticamente la observación
     * 
     * @param id_evaluacion identificador único.
     * @param estado Estado del tipo de evaluación.
     * @param tipoEvaluacion El tipo de evaluación.
     */
    public Evaluacion(int id_evaluacion, Estado estado, TiposEvaluaciones tipoEvaluacion) {
        this.id_evaluacion = id_evaluacion;
        this.tipoEvaluacion = tipoEvaluacion;
        this.estado = estado;
        this.observacion = new StringBuffer();
        observacion.append("La evaluacion de ").append(tipoEvaluacion).append(" es ").append(estado);
    }

    /**
     * Obtiene el tipo de evaluación.
     * 
     * @return tipo de evaluación.
     */
    public TiposEvaluaciones getTipoEvaluacion() {
        return tipoEvaluacion;
    }

    /**
     * Obtiene el estado del tipo de evaluación.
     * 
     * @return estado del tipo de evaluación.
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Obtiene la observación.
     * 
     * @return observación realizada.
     */
    public StringBuffer getObservacion() {
        return observacion;
    }

    /**
     * Obtiene el id.
     * 
     * @return identificador único.
     */
    public int getId_evaluacion() {
        return id_evaluacion;
    }
    
    /**
     * @return La observación hecha en la evaluación.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(observacion);
        return sb.toString();
    }
}
