package BLL;

import DAO.CitaDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cita {
    private final int id_cita;
    private List<Actitud> arrayActitud;
    private Condicion condicion;
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
    private Date proximaCita;

    public Cita(String diagnostico, String indicaciones, Date fechaCita, int frecuenciaCardiaca, int frecuenciaRespiratoria, int pulso, int temperatura, Condicion condicion, Date proximaCita) {
        id_cita = 0;
        this.arrayActitud = new ArrayList<>();
        this.condicion = condicion;
        this.arrayEvaluacion = new ArrayList<>();
        this.arrayMotivo = new ArrayList<>();
        this.arrayPruebaLaboratorio = new ArrayList<>();
        this.diagnostico = diagnostico;
        this.indicaciones = indicaciones;
        this.fechaCita = fechaCita;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.pulso = pulso;
        this.temperatura = temperatura;
        this.proximaCita = proximaCita;
    }
    
    public Cita(int id_cita, String diagnostico, String indicaciones, Date fechaCita, int frecuenciaCardiaca, int frecuenciaRespiratoria, int pulso, int temperatura, Condicion condicion, Date proximaCita) {
        this.id_cita = id_cita;
        this.arrayActitud = new ArrayList<>();
        this.condicion = condicion;
        this.arrayEvaluacion = new ArrayList<>();
        this.arrayMotivo = new ArrayList<>();
        this.arrayPruebaLaboratorio = new ArrayList<>();
        this.diagnostico = diagnostico;
        this.indicaciones = indicaciones;
        this.fechaCita = fechaCita;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.frecuenciaRespiratoria = frecuenciaRespiratoria;
        this.pulso = pulso;
        this.temperatura = temperatura;
        this.proximaCita = proximaCita;
    }
    
    public double calcularCostoCita(){
        double costo = 0;
        for (Motivo motivo : arrayMotivo) {
            if (motivo.getDescripcion().trim().equals("Chequeo general")) {
                if (!motivo.isAplicaExamen()) {
                    costo += motivo.getPrecio();
                }
            }
            else{
                costo += motivo.getPrecio();
            }
        }
        for (PruebaLaboratorio prueba : arrayPruebaLaboratorio) {
            costo += prueba.getPrecio();
        }
        
        return costo;
    }
    
    public void agregarActitud(Actitud actitud) {
        this.arrayActitud.add(actitud);
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

    public String toStringInformacion() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

        StringBuilder sb = new StringBuilder();
        sb.append("➤Cita");
        sb.append("\nCondición: ").append(condicion).append("\n");
        if (!arrayActitud.isEmpty()) {
            if (arrayActitud.size() == 1) {
                sb.append("Actitud: ").append(arrayActitud.get(0)).append("\n");
            } else {
                sb.append("Actitudes: ");
                for (Actitud actitud : arrayActitud) {
                    sb.append("•").append(actitud);
                }
            }

        }
        if (!arrayEvaluacion.isEmpty()) {
            sb.append("\n");
            for (Evaluacion evaluacion : arrayEvaluacion) {
                sb.append("•").append(evaluacion.toString()).append("\n");
            }
        }
        if (!arrayMotivo.isEmpty()) {
            if (arrayMotivo.size() == 1) {
                sb.append("El motivo fue: ").append(arrayMotivo.get(0).toStringInformacion());
            } else {
                sb.append("\nLos motivos fueron ( \n");
                for (Motivo motivo : arrayMotivo) {
                    sb.append("➤").append(motivo.toStringInformacion());
                }
                sb.append(")");
            }
        }
        if (!arrayPruebaLaboratorio.isEmpty()) {
            if (arrayPruebaLaboratorio.size() == 1) {
                sb.append("\nPrueba de laboratorio:");
            }else{
                sb.append("\nPruebas de laboratorio:\n");
            }
            sb.append("\n");
            for (PruebaLaboratorio pruebaLaboratorio : arrayPruebaLaboratorio) {
                sb.append("➤").append(pruebaLaboratorio.getNombrePrueba()).append("\n");
                for (SubCategoriaPrueba subCategoria : pruebaLaboratorio.getArraySubCategorias()) {
                    sb.append("▹").append(subCategoria.getNombre()).append("\n");
                }
            }
        }
        
        if (proximaCita == null) {
            sb.append("No hay proxima cita");
        }
        else{
            sb.append("La fecha de la proxima cita es: ").append(sdf.format(proximaCita));
        }
        sb.append("\nEl costo total de la cita fue: ").append(calcularCostoCita());
        sb.append("\nDiagnostico: ").append(diagnostico);
        sb.append("\nIndicaciones: ").append(indicaciones);
        sb.append("\nFecha de la cita: ").append(sdf.format( fechaCita));
        sb.append("\nFrecuencia cardiaca: ").append(frecuenciaCardiaca);
        sb.append("\nFrecuencia respiratoria: ").append(frecuenciaRespiratoria);
        sb.append("\nPulso: ").append(pulso);
        sb.append("\nTemperatura: ").append(temperatura).append("°C\n\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(calcularCostoCita());
        return sb.toString();
    }
    
    public String mostrarPrecio() {
        StringBuilder sb = new StringBuilder();
        sb.append("➤Resumen de servicios");

        if (!arrayMotivo.isEmpty()) {
            if (arrayMotivo.size() == 1) {
                sb.append("El motivo fue: ").append(arrayMotivo.get(0).toStringInformacion());
            } else {
                sb.append("\nLos motivos fueron ( \n");
                for (Motivo motivo : arrayMotivo) {
                    sb.append("➤").append(motivo.toStringInformacion());
                }
                sb.append(")");
            }
        }else{
            sb.append("\nNo hay motivos");
            
        }
        if (!arrayPruebaLaboratorio.isEmpty()) {
            if (arrayPruebaLaboratorio.size() == 1) {
                sb.append("\nPrueba de laboratorio:");
            }else{
                sb.append("\nPruebas de laboratorio:\n");
            }
            sb.append("\n");
            for (PruebaLaboratorio pruebaLaboratorio : arrayPruebaLaboratorio) {
                sb.append("➤").append(pruebaLaboratorio.getNombrePrueba()).append("\n");
                for (SubCategoriaPrueba subCategoria : pruebaLaboratorio.getArraySubCategorias()) {
                    sb.append("▹").append(subCategoria.getNombre()).append(" ").append(subCategoria.getPrecio()).append("₡\n");
                }
            }
        }
        else{
            sb.append("\nNo hay pruebas de laboratorio");
        }
        sb.append("\nEl costo total de la cita fue: ").append(calcularCostoCita()).append("₡");
        return sb.toString();
    }
    
    

    public List<Actitud> getArrayActitud() {
        return arrayActitud;
    }

    public void setArrayActitud(List<Actitud> arrayActitud) {
        this.arrayActitud = arrayActitud;
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

    public int getId_cita() {
        return id_cita;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public Date getProximaCita() {
        return proximaCita;
    }

    public void setProximaCita(Date proximaCita) {
        this.proximaCita = proximaCita;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }
    
    public static void agregarCita(Cita cita, Paciente paciente) throws SQLException{
        new CitaDAO().agregarCita(cita, paciente);
    }
    
//    public static List<Cita> consultarCitasPorPaciente(int id_paciente) throws SQLException{
//        return new CitaDAO().consultarCitasPorPaciente(id_paciente);
//    }
    
    public static List<Paciente> consultarPacientesConCita() throws SQLException{
        return new CitaDAO().consultarPacientesConCita();
    }
    
    public static boolean verificarCitaPorFecha(Date fechaVerificar) throws SQLException{
        return new CitaDAO().verificarFechaCita(fechaVerificar);
    }
}
