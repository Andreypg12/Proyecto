package BLL;

import BLL_PruebaLaboratorio.PruebaLaboratorio;
import BLL_Motivos.Motivo;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cita {
    private final int id_cita;
    private List<Actitud> arrayActitud;
    private List<Condicion> arrayCondicion;
    private List<Evaluacion> arrayEvaluacion;
    private List<Motivo> arrayMotivo;
    private List<PruebaLaboratorio> arrayPruebaLaboratorio;
    private String diagnostico;
    private String indicaciones;
    private Date fechaCita;
    private int frecuenciaCardiaca;
    private int frecuenciaRespiratoria;
    private int pulso;
    private int temperatura;

    public Cita(String diagnostico, String indicaciones, Date fechaCita, int frecuenciaCardiaca, int frecuenciaRespiratoria, int impulso, int temperatura) {
        id_cita = 0;
        this.arrayActitud = new ArrayList<>();
        this.arrayCondicion = new ArrayList<>();
        this.arrayEvaluacion = new ArrayList<>();
        this.arrayMotivo = new ArrayList<>();
        this.arrayPruebaLaboratorio = new ArrayList<>();
        this.diagnostico = diagnostico;
        this.indicaciones = indicaciones;
        this.fechaCita = fechaCita;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.pulso = impulso;
        this.temperatura = temperatura;
    }
    
    public Cita(int id_cita, String diagnostico, String indicaciones, Date fechaCita, int frecuenciaCardiaca, int frecuenciaRespiratoria, int impulso, int temperatura) {
        this.id_cita = id_cita;
        this.arrayActitud = new ArrayList<>();
        this.arrayCondicion = new ArrayList<>();
        this.arrayEvaluacion = new ArrayList<>();
        this.arrayMotivo = new ArrayList<>();
        this.arrayPruebaLaboratorio = new ArrayList<>();
        this.diagnostico = diagnostico;
        this.indicaciones = indicaciones;
        this.fechaCita = fechaCita;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.pulso = impulso;
        this.temperatura = temperatura;
    }
    
    public void agregarActitud(Actitud actitud) {
        this.arrayActitud.add(actitud);
    }

    public void agregarCondicion(Condicion condicion) {
        this.arrayCondicion.add(condicion);
    }

    public void agregarEvaluacion(Evaluacion evaluacion) {
        this.arrayEvaluacion.add(evaluacion);
    }

    public void agregarMotivo(Motivo motivo) {
        this.arrayMotivo.add(motivo);
    }

    public void agregarPruebaLaboratorio(PruebaLaboratorio pruebaLaboratorio) {
        this.arrayPruebaLaboratorio.add(pruebaLaboratorio);
    }

    @Override
    public String toString() {
        DateFormat formato = DateFormat.getDateInstance(); 
        StringBuilder sb = new StringBuilder();
        sb.append("Cita");
        if (!arrayActitud.isEmpty()) {
            sb.append("\n");
            for (Actitud actitud : arrayActitud) {
                sb.append(actitud).append("\n");
            }
        }
        if (!arrayCondicion.isEmpty()) {
            sb.append("\n");
            for (Condicion condicion : arrayCondicion) {
                sb.append(condicion).append("\n");
            }
        }
        if (!arrayEvaluacion.isEmpty()) {
            sb.append("\n");
            for (Evaluacion evaluacion : arrayEvaluacion) {
                sb.append(evaluacion.toString()).append("\n");
            }
        }
        if (!arrayMotivo.isEmpty()) {
            sb.append("\n");
            for (Motivo motivo : arrayMotivo) {
                sb.append(motivo).append("\n");
            }
        }
        if (!arrayPruebaLaboratorio.isEmpty()) {
            if (arrayPruebaLaboratorio.size() == 1) {
                sb.append("\nPrueba de laboratorio:\n");
            }else{
                sb.append("\nPruebas de laboratorio:\n");
            }
            sb.append("\n");
            for (PruebaLaboratorio pruebaLaboratorio : arrayPruebaLaboratorio) {
                sb.append(pruebaLaboratorio).append("\n");
            }
        }
        sb.append("\nDiagnostico: ").append(diagnostico);
        sb.append("\nIndicaciones: ").append(indicaciones);
        sb.append("\nFecha de la cita: ").append(formato.format(fechaCita));
        sb.append("\nFrecuencia cardiaca: ").append(frecuenciaCardiaca);
        sb.append("\nFrecuencia respiratoria: ").append(frecuenciaRespiratoria);
        sb.append("\nPulso: ").append(pulso);
        sb.append("\nTemperatura: ").append(temperatura);
        return sb.toString();
    }

    public List<Actitud> getArrayActitud() {
        return arrayActitud;
    }

    public void setArrayActitud(List<Actitud> arrayActitud) {
        this.arrayActitud = arrayActitud;
    }

    public List<Condicion> getArrayCondicion() {
        return arrayCondicion;
    }

    public void setArrayCondicion(List<Condicion> arrayCondicion) {
        this.arrayCondicion = arrayCondicion;
    }

    public List<Evaluacion> getArrayEvaluacion() {
        return arrayEvaluacion;
    }

    public void setArrayEvaluacion(List<Evaluacion> arrayEvaluacion) {
        this.arrayEvaluacion = arrayEvaluacion;
    }

    public List<Motivo> getArrayMotivo() {
        return arrayMotivo;
    }

    public void setArrayMotivo(List<Motivo> arrayMotivo) {
        this.arrayMotivo = arrayMotivo;
    }

    public List<PruebaLaboratorio> getArrayPruebaLaboratorio() {
        return arrayPruebaLaboratorio;
    }

    public void setArrayPruebaLaboratorio(List<PruebaLaboratorio> arrayPruebaLaboratorio) {
        this.arrayPruebaLaboratorio = arrayPruebaLaboratorio;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    public int getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(int frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public int getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    public void setFrecuenciaRespiratoria(int frecuenciaRespiratoria) {
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
    }

    public int getPulso() {
        return pulso;
    }

    public void setPulso(int pulso) {
        this.pulso = pulso;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }
    
    
}
