package BLL;

import java.util.ArrayList;
import java.util.List;

public class Evaluacion {
    private String descripcion;
    private Estado estado;
    private StringBuffer observacion;

    public Evaluacion(Estado estado, TiposEvaluaciones tipoEvaluacion) {
        this.descripcion = tipoEvaluacion.toString();
        this.estado = estado;
        this.observacion = new StringBuffer();
    }
    
    public void definirObersevaciones(){
        switch (estado) {
            case NORMAL -> observacion.append("No hay observaciones");
            case ANORMAL -> observacion.append("La evaluacion de ").append(descripcion).append(" es ").append(estado);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Evaluación: ");
        sb.append("\nDescripcion: ").append(descripcion);
        sb.append("\nEstado: ").append(estado);
        definirObersevaciones();
        sb.append("\n").append(observacion);
        return sb.toString();
    }
}
