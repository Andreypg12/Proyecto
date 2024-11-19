package DAO;

import BLL.Actitud;
import BLL.Cita;
import BLL.Condicion;
import BLL.Evaluacion;
import BLL_Motivos.*;
import BLL.Paciente;
import BLL.Sexo;
import BLL_PruebaLaboratorio.*;
import DAO.ConeccionDB;
import  java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {
    
    public void agregarCita(Cita cita, Paciente paciente) throws SQLException {
        String sqlInsertCita = "INSERT INTO Cita (id_Paciente, diagnostico, indicaciones, fechaCita, "
                + "frecuenciaCardiaca, frecuenciaRespiratoria, pulso, temperatura) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        String sqlInsertCitaMotivo = "INSERT INTO Cita_Motivo (id_cita, id_motivo, id_vacuna, precio) VALUES (?, ?, ?, ?)";

        String sqlInsertarCita_PruebaLaboratorio_SubCategoria = "INSERT INTO Cita_PruebaLaboratorio (id_cita, id_pruebaLaboratoio, id_subCategoria) VALUES (?, ?, ?)";

        String sqlInsertarEvaluacion = "INSERT INTO Evaluacion (id_tipo_evaluacion, id_estado) VALUES (?, ?)";

        String sqlInsertarCita_Evaluacion = "INSERT INTO Cita_Evaluacion (id_cita, id_evaluacion) VALUES (?, ?)";
        
        String sqlInsertarCita_Actitud = "INSERT INTO Cita_Actitud (id_cita, id_actitud) VALUES (?, ?)";
        
        String sqlInsertarCita_Condicion = "INSERT INTO Cita_Condicion (id_cita, id_condicion) VALUES (?, ?)";

        try (Connection conexion = ConeccionDB.conectarBaseDatos()) {
            conexion.setAutoCommit(false);

            try (PreparedStatement pstmtCita = conexion.prepareStatement(sqlInsertCita, Statement.RETURN_GENERATED_KEYS)) {

                pstmtCita.setInt(1, paciente.getId_paciente());
                pstmtCita.setString(2, cita.getDiagnostico());
                pstmtCita.setString(3, cita.getIndicaciones());
                pstmtCita.setDate(4, new java.sql.Date(cita.getFechaCita().getTime()));
                pstmtCita.setInt(5, cita.getFrecuenciaCardiaca());
                pstmtCita.setInt(6, cita.getFrecuenciaRespiratoria());
                pstmtCita.setInt(7, cita.getPulso());
                pstmtCita.setInt(8, cita.getTemperatura());

                pstmtCita.executeUpdate();

                try (ResultSet generatedKeys = pstmtCita.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id_cita = generatedKeys.getInt(1);

                        if (!cita.getArrayMotivo().isEmpty()) {

                            try (PreparedStatement pstmtCitaMotivo = conexion.prepareStatement(sqlInsertCitaMotivo)) {
                                for (Motivo motivo : cita.getArrayMotivo()) {
                                    pstmtCitaMotivo.setInt(1, id_cita);
                                    pstmtCitaMotivo.setInt(2, motivo.getId_motivo());
                                    pstmtCitaMotivo.setDouble(4, motivo.getPrecio());
                                    if (motivo instanceof Vacunacion) {
                                        pstmtCitaMotivo.setInt(3, ((Vacunacion) motivo).getVacuna().getId_vacuna());
                                    } else {
                                        pstmtCitaMotivo.setNull(3, java.sql.Types.INTEGER);
                                    }
                                    pstmtCitaMotivo.addBatch();
                                }

                                pstmtCitaMotivo.executeBatch();
                            }
                        }
                        if (!cita.getArrayPruebaLaboratorio().isEmpty()) {
                            try (PreparedStatement pstmtCitaPruebaLaboratorio = conexion.prepareStatement(sqlInsertarCita_PruebaLaboratorio_SubCategoria)) {
                                for (PruebaLaboratorio pruebaLaboratorio : cita.getArrayPruebaLaboratorio()) {
                                    for (SubCategoriaPrueba subCategoria : pruebaLaboratorio.getArraySubCategorias()) {
                                        pstmtCitaPruebaLaboratorio.setInt(1, id_cita);
                                        pstmtCitaPruebaLaboratorio.setInt(2, pruebaLaboratorio.getId_prueba());
                                        pstmtCitaPruebaLaboratorio.setInt(3, subCategoria.getId_subCategoria());
                                        pstmtCitaPruebaLaboratorio.addBatch();
                                    }
                                }
                                pstmtCitaPruebaLaboratorio.executeBatch();
                            }
                        }
                        if (!cita.getArrayEvaluacion().isEmpty()) {
                            try (PreparedStatement pstmtEvaluacion = conexion.prepareStatement(sqlInsertarEvaluacion, Statement.RETURN_GENERATED_KEYS);
                                    PreparedStatement pstmCita_Evaluacion = conexion.prepareStatement(sqlInsertarCita_Evaluacion)) {

                                for (Evaluacion evaluacion : cita.getArrayEvaluacion()) {
                                    pstmtEvaluacion.setInt(1, evaluacion.getTipoEvaluacion().getId_tipo_evaluacion());
                                    pstmtEvaluacion.setInt(2, evaluacion.getEstado().getId_estado());
                                    pstmtEvaluacion.executeUpdate();
                                    
                                    try (ResultSet rsEvaluacion = pstmtEvaluacion.getGeneratedKeys()) {
                                        if (rsEvaluacion.next()) {
                                            int id_evaluacion = rsEvaluacion.getInt(1);
                                            pstmCita_Evaluacion.setInt(1, id_cita);
                                            pstmCita_Evaluacion.setInt(2, id_evaluacion);
                                            pstmCita_Evaluacion.addBatch();
                                        }
                                    }
                                }
                                pstmCita_Evaluacion.executeBatch();
                            }
                        }
                        try(PreparedStatement pstmCita_Actitud = conexion.prepareStatement(sqlInsertarCita_Actitud)){
                            for (Actitud actitud : cita.getArrayActitud()) {
                                pstmCita_Actitud.setInt(1, id_cita);
                                pstmCita_Actitud.setInt(2, actitud.getId_actitud());
                                pstmCita_Actitud.addBatch();
                            }
                            pstmCita_Actitud.executeBatch();
                        }
                        
                        try(PreparedStatement pstmCita_Condicion = conexion.prepareStatement(sqlInsertarCita_Condicion)){
                            for (Condicion condicion : cita.getArrayCondicion()) {
                                pstmCita_Condicion.setInt(1, id_cita);
                                pstmCita_Condicion.setInt(2, condicion.getId_condicion());
                                pstmCita_Condicion.addBatch();
                            }
                            pstmCita_Condicion.executeBatch();
                        }
                    }
                }
                conexion.commit();
                System.out.println("La cita fue insertada exitosamente.");
            } catch (SQLException e) {
                conexion.rollback();
                throw e;
            } finally {
                conexion.setAutoCommit(true);
            }
        }
    }
    
    public List<Cita> consultarCitasPorPaciente(int id_paciente) throws SQLException {
        List<Cita> arrayCitas = new ArrayList<>();
        String sqlConsultarCita = "SELECT id_cita, diagnostico, indicaciones, fechaCita, frecuenciaCardiaca, frecuenciaRespiratoria, pulso, temperatura from Cita where id_Paciente = " + id_paciente;

        try {
            try (Connection conexion = ConeccionDB.conectarBaseDatos();
                    PreparedStatement pstmConsultarCita = conexion.prepareStatement(sqlConsultarCita);
                    ResultSet rsCitas = pstmConsultarCita.executeQuery()) {
                
                while (rsCitas.next()) {
                    int id_cita = rsCitas.getInt("id_cita");
                    String disgnostico = rsCitas.getString("diagnostico").trim();
                    String indicaciones = rsCitas.getString("indicaciones").trim();
                    Date fechaCita = rsCitas.getDate("fechaCita");
                    int frecuenciaCardiaca = rsCitas.getInt("frecuenciaCardiaca");
                    int frecuenciaRespiratoria = rsCitas.getInt("frecuenciaRespiratoria");
                    int pulso = rsCitas.getInt("pulso");
                    int temperatura = rsCitas.getInt("temperatura");

                    Cita cita = new Cita(id_cita, disgnostico, indicaciones, fechaCita, frecuenciaCardiaca, frecuenciaRespiratoria, pulso, temperatura);

                    List<Actitud> arrayActitudes = new ArrayList<>();
                    
                    String sqlConsultaActitudes = "SELECT a.id_actitud, a.descripcion "
                            + "FROM Actitud a "
                            + "INNER JOIN Cita_Actitud ca ON a.id_actitud = ca.id_actitud "
                            + "WHERE ca.id_cita = " + id_cita;

                    try (PreparedStatement pstmConsultarActitudes = conexion.prepareStatement(sqlConsultaActitudes);
                            ResultSet rsActitudes = pstmConsultarActitudes.executeQuery()) {
                        while (rsActitudes.next()) {
                            Actitud actitud = Actitud.valueOf(rsActitudes.getString("descripcion").trim());
                            arrayActitudes.add(actitud);
                        }
                        cita.setArrayActitud(arrayActitudes);
                    }
                    
                    List<Condicion> arrayCondiciones = new ArrayList<>();
                    
                    String sqlConsultaCondiciones = "SELECT co.id_condicion, co.descripcion "
                            + "FROM Condicion co "
                            + "INNER JOIN Cita_Condicion cc ON co.id_condicion = cc.id_condicion "
                            + "WHERE cc.id_cita = " + id_cita;
                    
                    try (PreparedStatement pstmConsultarActitudes = conexion.prepareStatement(sqlConsultaCondiciones);
                            ResultSet rsCondiciones = pstmConsultarActitudes.executeQuery()) {
                        while (rsCondiciones.next()) {
                            Condicion condicion = Condicion.valueOf(rsCondiciones.getString("descripcion").trim());
                            arrayCondiciones.add(condicion);
                        }
                        cita.setArrayCondicion(arrayCondiciones);
                    }
                    arrayCitas.add(cita);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arrayCitas;
    }
}
