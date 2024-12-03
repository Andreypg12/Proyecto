package BLL;

import DAO.CitaDAO;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase que representa una cita médica para un paciente, incluyendo sus detalles, actitudes, evaluaciones, motivos y pruebas de laboratorio.
 * Proporciona métodos para calcular el costo de la cita, gestionar sus elementos y generar resúmenes informativos y también la facturación.
 * 
 * @author Andrey Pérez Gutiérrez
 */

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

    /**
     * Constructor para crear una nueva cita con un identificador generado automáticamente.
     * 
     * @param diagnostico          Diagnóstico de la cita.
     * @param indicaciones         Indicaciones de la cita.
     * @param fechaCita            Fecha de la cita.
     * @param frecuenciaCardiaca   Frecuencia cardíaca registrada.
     * @param frecuenciaRespiratoria Frecuencia respiratoria registrada.
     * @param pulso                Pulso registrado.
     * @param temperatura          Temperatura registrada.
     * @param condicion            Condición del paciente.
     * @param proximaCita          Fecha de la próxima cita.
     */
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
    
    /**
     * Constructor para crear una nueva cita con un identificador específico.
     * 
     * @param id_cita              Identificador de la cita.
     * @param diagnostico          Diagnóstico de la cita.
     * @param indicaciones         Indicaciones de la cita.
     * @param fechaCita            Fecha de la cita.
     * @param frecuenciaCardiaca   Frecuencia cardíaca registrada.
     * @param frecuenciaRespiratoria Frecuencia respiratoria registrada.
     * @param pulso                Pulso registrado.
     * @param temperatura          Temperatura registrada.
     * @param condicion            Condición del paciente.
     * @param proximaCita          Fecha de la próxima cita.
     */
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
    
    /**
     * Calcula el costo total de la cita sumando los costos de los motivos y las pruebas de laboratorio.
     * Si Aplica el examen en el Chequeo general no se cobrará
     * @return El costo total de la cita.
     */
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
    
    /**
     * Permite agregar actitudes al arreglo de actitudes
     * 
     * @param actitud Es el onjeto que se va agregar
     */
    public void agregarActitud(Actitud actitud) {
        this.arrayActitud.add(actitud);
    }

    /**
     * Permite agregar evaluaciones al arreglo de evaluaciones
     * 
     * @param evaluacion Es el onjeto que se va agregar
     */
    public void agregarEvaluacion(Evaluacion evaluacion) {
        this.arrayEvaluacion.add(evaluacion);
    }

    /**
     * Permite agregar motivos al arreglo de motivos
     * 
     * @param motivo Es el onjeto que se va agregar
     */
    public void agregarMotivo(Motivo motivo) {
        this.arrayMotivo.add(motivo);
    }

    /**
     * Permite agregar Pruebas al arreglo de Pruebas de laboratorio
     * 
     * @param pruebaLaboratorio Es el onjeto que se va agregar
     */
    public void agregarPruebaLaboratorio(PruebaLaboratorio pruebaLaboratorio) {
        this.arrayPruebaLaboratorio.add(pruebaLaboratorio);
    }

    /**
     * Muestra toda la información de la cita
     * 
     * @return Toda la información de la cita
     */
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

    /**
     * Muestra el monto total a pagar por la cita
     * 
     * @return Monto total a pagar por la cita
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(calcularCostoCita());
        return sb.toString();
    }
    
    /**
     * Muestra El resumen de los servicios a pagar por la cita
     * 
     * @return Los servicios a pagar por la cita
     */
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
    
    /**
     * @return Array de actitudes
     */
    public List<Actitud> getArrayActitud() {
        return arrayActitud;
    }

    /**
     * @param arrayActitud Setea todo el array de actitudes
     */
    public void setArrayActitud(List<Actitud> arrayActitud) {
        this.arrayActitud = arrayActitud;
    }

    /**
     * @return Array de evaluaciones
     */
    public List<Evaluacion> getArrayEvaluacion() {
        return arrayEvaluacion;
    }

    /**
     * @param arrayEvaluacion Setea todo el array de evaluaciones
     */
    public void setArrayEvaluacion(List<Evaluacion> arrayEvaluacion) {
        this.arrayEvaluacion = arrayEvaluacion;
    }

    /**
     * @return Array de motivos
     */
    public List<Motivo> getArrayMotivo() {
        return arrayMotivo;
    }

    /**
     * @param arrayMotivo Setea todo el array de motivos
     */
    public void setArrayMotivo(List<Motivo> arrayMotivo) {
        this.arrayMotivo = arrayMotivo;
    }

    /**
     * @return Array de pruebas de laboratorio
     */
    public List<PruebaLaboratorio> getArrayPruebaLaboratorio() {
        return arrayPruebaLaboratorio;
    }

    /**
     * @param arrayPruebaLaboratorio Setea todo el array de pruebas de laboratorio
     */
    public void setArrayPruebaLaboratorio(List<PruebaLaboratorio> arrayPruebaLaboratorio) {
        this.arrayPruebaLaboratorio = arrayPruebaLaboratorio;
    }

    /**
     * @return El diagnostico realizado en la cita
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * @return Las indicaciones que se hicieron en la cita
     */
    public String getIndicaciones() {
        return indicaciones;
    }

    /**
     * @return Fecha en que se realizó la cita
     */
    public Date getFechaCita() {
        return fechaCita;
    }

    /**
     * @return Frecuencia cardiaca del paciente
     */
    public int getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    /**
     * @return Frecuencia respiratoria del paciente
     */
    public int getFrecuenciaRespiratoria() {
        return frecuenciaRespiratoria;
    }

    /**
     * @return Pulso del paciente
     */
    public int getPulso() {
        return pulso;
    }

    /**
     * @return Temperatura del paciente
     */
    public int getTemperatura() {
        return temperatura;
    }

    /**
     * @return Identificador de la cita del paciente
     */
    public int getId_cita() {
        return id_cita;
    }

    /**
     * @return Condicion de peso del paciente
     */
    public Condicion getCondicion() {
        return condicion;
    }

    /**
     *  Puede no haber una fecha para la próxima cita
     * @return Fecha de la próxima cita programada
     */
    public Date getProximaCita() {
        return proximaCita;
    }
    
    /**
     *  Agrega la cita a la base de datos
     * @param cita Es la cita que se va a guardar
     * @param paciente Es el paciente a la que se le realizó la cita
     */
    public static void agregarCita(Cita cita, Paciente paciente) throws SQLException{
        new CitaDAO().agregarCita(cita, paciente);
    }
    
    /**
     *  Consulta todos los pacientes de la base de datos con sus respectivas citas
     */
    public static List<Paciente> consultarPacientesConCita() throws SQLException{
        return new CitaDAO().consultarPacientesConCita();
    }
    
    /**
     *  Verifica si la fecha de la cita está ligada a otra cita en un rango de una hora
     * @return Falso si no hay ninguna cita ligada a esa fecha y verdadero si ya hay una cita ligada
     */
    public static boolean verificarCitaPorFecha(Date fechaVerificar) throws SQLException{
        return new CitaDAO().verificarFechaCita(fechaVerificar);
    }
}
