package DAO;

import BLL.Actitud;
import BLL.Cita;
import BLL.Condicion;
import BLL.Evaluacion;
import BLL_Motivos.*;
import BLL.Paciente;
import BLL_PruebaLaboratorio.*;
import DAO.ConeccionDB;
import  java.sql.*;

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
        
        String sqlInsertarCita_Condicion = "INSERT INTO Cita_Cnodicion (id_cita, id_condicion) VALUES (?, ?)";

        try (Connection conexion = ConeccionDB.conectarBaseDatos()) {
            conexion.setAutoCommit(false); // Iniciar la transacción

            try (PreparedStatement pstmtCita = conexion.prepareStatement(sqlInsertCita, Statement.RETURN_GENERATED_KEYS)) {
                // Insertar la cita
                pstmtCita.setInt(1, paciente.getId_paciente());
                pstmtCita.setString(2, cita.getDiagnostico());
                pstmtCita.setString(3, cita.getIndicaciones());
                pstmtCita.setDate(4, new java.sql.Date(cita.getFechaCita().getTime()));
                pstmtCita.setInt(5, cita.getFrecuenciaCardiaca());
                pstmtCita.setInt(6, cita.getFrecuenciaRespiratoria());
                pstmtCita.setInt(7, cita.getPulso());
                pstmtCita.setInt(8, cita.getTemperatura());

                pstmtCita.executeUpdate();

                // Obtener el ID de la cita insertada
                try (ResultSet generatedKeys = pstmtCita.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id_cita = generatedKeys.getInt(1);

                        // Insertar en la tabla Cita_Motivo
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
                                    pstmtCitaMotivo.addBatch(); // Agregar al batch
                                }

                                pstmtCitaMotivo.executeBatch(); // Ejecutar todos los inserts de una vez
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
                                pstmCita_Evaluacion.executeBatch(); // Ejecutar los inserts en Cita_Evaluacion
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
                System.out.println("La cita y los motivos fueron insertados exitosamente.");
            } catch (SQLException e) {
                conexion.rollback();
                throw e;
            } finally {
                conexion.setAutoCommit(true);
            }
        }
    }
}
