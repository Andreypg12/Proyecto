package BLL;

import static BLL.Estado.*;
import java.util.ArrayList;
import java.util.List;

public class Evaluacion {

    private List<Evaluacion> arrayEvaluaciones;
    private Estado estado;
    private StringBuffer observacion;

    public Evaluacion(Estado estado) {
        this.arrayEvaluaciones = new ArrayList<>();
        this.estado = estado;
        this.observacion = new StringBuffer();
//        switch (estado) {
//            case NORMAL ->
//                observacion.append("No hay observaciones");
//            case ANORMAL ->
//                observacion.append("La evaluacion de ").append(evaluacion).append(" es ").append(estado);
//        }
    }
    
    public void agregarEvaluaciones(Evaluacion evaluacion){
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Evaluación: ");
//        sb.append("\nDescripcion: ").append(evaluacion);
        sb.append("\nEstado: ").append(estado);
        sb.append("\n").append(observacion);
        return sb.toString();
    }
}
