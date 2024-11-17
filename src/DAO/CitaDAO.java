package DAO;

import BLL.Cita;
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

        String sqlInsertarCitaPruebaLaboratorio = "INSERT INTO Cita_PruebaLaboratorio (id_cita, id_pruebaLaboratoio) VALUES (?, ?)";
        String sqlInsertarPruebaLaboratorio_SubCategoria = "INSERT INTO PruebaLaboratorio_SubCategoria (id_PruebaLaboratorio, id_SubCategoria) VALUES (?, ?)";

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
                        if (!cita.getArrayPruebaLaboratorio().isEmpty()) {

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

                            try (PreparedStatement pstmtCitaPruebaLaboratorio = conexion.prepareStatement(sqlInsertarCitaPruebaLaboratorio)) {
                                if (true) {

                                }
                                for (PruebaLaboratorio pruebaLaboratorio : cita.getArrayPruebaLaboratorio()) {
                                    pstmtCitaPruebaLaboratorio.setInt(1, id_cita);
                                    pstmtCitaPruebaLaboratorio.setInt(2, pruebaLaboratorio.getId_prueba());
                                    try(PreparedStatement pstmtPruebaLaboratorio_SubCategoria = conexion.prepareStatement(sqlInsertarPruebaLaboratorio_SubCategoria)){
                                        for (SubCategoriaPrueba subCategoria : pruebaLaboratorio.getArraySubCategorias()) {
                                            pstmtPruebaLaboratorio_SubCategoria.setInt(1, pruebaLaboratorio.getId_prueba());
                                            pstmtPruebaLaboratorio_SubCategoria.setInt(2, subCategoria.getId_subCategoria());
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                conexion.commit(); // Confirmar la transacción
                System.out.println("La cita y los motivos fueron insertados exitosamente.");
            } catch (SQLException e) {
                conexion.rollback(); // Deshacer la transacción en caso de error
                throw e;
            }
        }
    }
}
