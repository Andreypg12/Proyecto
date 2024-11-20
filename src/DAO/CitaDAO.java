package DAO;

import BLL.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CitaDAO {

    public void agregarCita(Cita cita, Paciente paciente) throws SQLException {
        String sqlInsertCita = "INSERT INTO Cita (id_Paciente, diagnostico, indicaciones, fechaCita, "
                + "frecuenciaCardiaca, frecuenciaRespiratoria, pulso, temperatura, id_condicion) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String sqlInsertCitaMotivo = "INSERT INTO Cita_Motivo (id_cita, id_motivo, id_vacuna, precio) VALUES (?, ?, ?, ?)";

        String sqlInsertarCita_PruebaLaboratorio_SubCategoria = "INSERT INTO Cita_PruebaLaboratorio (id_cita, id_pruebaLaboratorio, id_subCategoria) VALUES (?, ?, ?)";

        String sqlInsertarEvaluacion = "INSERT INTO Evaluacion (id_tipo_evaluacion, id_estado) VALUES (?, ?)";

        String sqlInsertarCita_Evaluacion = "INSERT INTO Cita_Evaluacion (id_cita, id_evaluacion) VALUES (?, ?)";

        String sqlInsertarCita_Actitud = "INSERT INTO Cita_Actitud (id_cita, id_actitud) VALUES (?, ?)";

        try (Connection conexion = ConeccionDB.conectarBaseDatos()) {
            conexion.setAutoCommit(false);

            try (PreparedStatement pstmtCita = conexion.prepareStatement(sqlInsertCita, Statement.RETURN_GENERATED_KEYS)) {

                pstmtCita.setInt(1, paciente.getId_paciente());
                pstmtCita.setString(2, cita.getDiagnostico());
                pstmtCita.setString(3, cita.getIndicaciones());
                pstmtCita.setTimestamp(4, new java.sql.Timestamp(cita.getFechaCita().getTime()));
                pstmtCita.setInt(5, cita.getFrecuenciaCardiaca());
                pstmtCita.setInt(6, cita.getFrecuenciaRespiratoria());
                pstmtCita.setInt(7, cita.getPulso());
                pstmtCita.setInt(8, cita.getTemperatura());
                pstmtCita.setInt(9, cita.getCondicion().getId_condicion());

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
                            try (PreparedStatement pstmtEvaluacion = conexion.prepareStatement(sqlInsertarEvaluacion, Statement.RETURN_GENERATED_KEYS); PreparedStatement pstmCita_Evaluacion = conexion.prepareStatement(sqlInsertarCita_Evaluacion)) {

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
                        try (PreparedStatement pstmCita_Actitud = conexion.prepareStatement(sqlInsertarCita_Actitud)) {
                            for (Actitud actitud : cita.getArrayActitud()) {
                                pstmCita_Actitud.setInt(1, id_cita);
                                pstmCita_Actitud.setInt(2, actitud.getId_actitud());
                                pstmCita_Actitud.addBatch();
                            }
                            pstmCita_Actitud.executeBatch();
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
        String sqlConsultarCita = "SELECT c.id_cita, c.diagnostico, c.indicaciones, c.fechaCita, c.frecuenciaCardiaca, c.frecuenciaRespiratoria, c.pulso, c.temperatura"
                + ", co.descripcion "
                + "FROM Cita c "
                + "JOIN Condicion co ON c.id_condicion = co.id_condicion "
                + "WHERE id_Paciente = " + id_paciente;

        try {
            try (Connection conexion = ConeccionDB.conectarBaseDatos(); PreparedStatement pstmConsultarCita = conexion.prepareStatement(sqlConsultarCita); ResultSet rsCitas = pstmConsultarCita.executeQuery()) {

                while (rsCitas.next()) {
                    int id_cita = rsCitas.getInt("id_cita");
                    String disgnostico = rsCitas.getString("diagnostico").trim();
                    String indicaciones = rsCitas.getString("indicaciones").trim();
                    Timestamp fechaCitaTime = rsCitas.getTimestamp("fechaCita");
                    Date fechaCita = new Date(fechaCitaTime.getTime());
                    int frecuenciaCardiaca = rsCitas.getInt("frecuenciaCardiaca");
                    int frecuenciaRespiratoria = rsCitas.getInt("frecuenciaRespiratoria");
                    int pulso = rsCitas.getInt("pulso");
                    int temperatura = rsCitas.getInt("temperatura");
                    Condicion condicion = Condicion.valueOf(rsCitas.getString("descripcion").trim());

                    Cita cita = new Cita(id_cita, disgnostico, indicaciones, fechaCita, frecuenciaCardiaca, frecuenciaRespiratoria, pulso, temperatura, condicion);

                    String sqlConsultaActitudes = "SELECT a.id_actitud, a.descripcion "
                            + "FROM Actitud a "
                            + "INNER JOIN Cita_Actitud ca ON a.id_actitud = ca.id_actitud "
                            + "WHERE ca.id_cita = " + id_cita;
                    List<Actitud> arrayActitudes = new ArrayList<>();

                    try (PreparedStatement pstmConsultarActitudes = conexion.prepareStatement(sqlConsultaActitudes); ResultSet rsActitudes = pstmConsultarActitudes.executeQuery()) {
                        while (rsActitudes.next()) {
                            Actitud actitud = Actitud.valueOf(rsActitudes.getString("descripcion").trim());
                            arrayActitudes.add(actitud);
                        }
                        cita.setArrayActitud(arrayActitudes);
                    }

                    String sqlCunsultaEvaluaciones = "SELECT e.id_evaluacion, te.tipo_evaluacion, es.estado "
                            + "FROM Evaluacion e "
                            + "JOIN Cita_Evaluacion ce ON e.id_evaluacion = ce.id_evaluacion "
                            + "JOIN Tipo_Evaluacion te ON e.id_tipo_evaluacion = te.id_tipo_evaluacion "
                            + "JOIN Estado es ON e.id_estado = es.id_estado "
                            + "WHERE ce.id_cita = " + id_cita;
                    List<Evaluacion> arrayEvaluaciones = new ArrayList<>();

                    try (PreparedStatement pstmConsultarEvaluaciones = conexion.prepareStatement(sqlCunsultaEvaluaciones); ResultSet rsEvaluaciones = pstmConsultarEvaluaciones.executeQuery()) {
                        while (rsEvaluaciones.next()) {
                            TiposEvaluaciones tipoEvaluacion = TiposEvaluaciones.valueOf(rsEvaluaciones.getString("tipo_evaluacion").trim());
                            Estado estado = Estado.valueOf(rsEvaluaciones.getString("estado").trim());

                            Evaluacion evaluacion = new Evaluacion(rsEvaluaciones.getInt("id_evaluacion"), estado, tipoEvaluacion);
                            arrayEvaluaciones.add(evaluacion);
                        }
                        cita.setArrayEvaluacion(arrayEvaluaciones);
                    }

                    String sqlConsultarMotivos = "SELECT m.id_motivo, m.descripcion, m.aplica_examen, m.tiene_vacuna, "
                            + "cm.precio AS precio_cita_motivo, v.id_vacuna, v.id_especie, v.precio AS precio_vacuna, v.nombre "
                            + "FROM Motivo m "
                            + "JOIN Cita_Motivo cm ON m.id_motivo = cm.id_motivo "
                            + "LEFT JOIN Vacuna v ON cm.id_vacuna = v.id_vacuna "
                            + "WHERE cm.id_cita = " + id_cita;

                    List<Motivo> arrayMotivos = new ArrayList<>();

                    try (PreparedStatement pstmConsultarMotivos = conexion.prepareStatement(sqlConsultarMotivos); ResultSet rsMotivos = pstmConsultarMotivos.executeQuery()) {
                        while (rsMotivos.next()) {
                            int id_motivo = rsMotivos.getInt("id_motivo");
                            String descripcion = rsMotivos.getString("descripcion");
                            double precio = rsMotivos.getDouble("precio_cita_motivo");
                            boolean aplica_examen = rsMotivos.getBoolean("aplica_examen");
                            Motivo motivo;

                            if (rsMotivos.getBoolean("tiene_vacuna")) {
                                Especie especie = (rsMotivos.getInt("id_especie") == 1) ? new Perro() : new Gato();
                                int id_vacuna = rsMotivos.getInt("id_vacuna");
                                double precioVacuna = rsMotivos.getDouble("precio_vacuna");
                                String nombreVacuna = rsMotivos.getString("nombre");
                                Vacuna vacuna = new Vacuna(nombreVacuna, precioVacuna, id_vacuna, especie);

                                motivo = new Vacunacion(id_motivo, descripcion, vacuna, vacuna.getPrecio());
                            } else {
                                motivo = new Motivo(id_motivo, descripcion, precio, aplica_examen);
                            }
                            arrayMotivos.add(motivo);
                        }
                        cita.setArrayMotivo(arrayMotivos);
                    }

                    String sqlConsultarPruebas = "SELECT pl.id_prueba, "
                            + "sp.id_subCategoria, sp.nombre AS nombre_subCategoria, sp.precio AS precio_subcategoria "
                            + "FROM PruebaLaboratorio pl "
                            + "JOIN Cita_PruebaLaboratorio cpl ON pl.id_prueba = cpl.id_pruebaLaboratorio "
                            + "JOIN SubCategoriaPrueba sp ON cpl.id_subCategoria = sp.id_subCategoria "
                            + "WHERE cpl.id_cita = " + id_cita;

                    List<PruebaLaboratorio> arrayPruebas = new ArrayList<>();

                    try (PreparedStatement pstmConsultarPruebasLaboratorio = conexion.prepareStatement(sqlConsultarPruebas);
                            ResultSet rsPruebasLaboratorio = pstmConsultarPruebasLaboratorio.executeQuery()) {

                        Map<Integer, PruebaLaboratorio> arrayPruebasHashMap = new HashMap<>();

                        while (rsPruebasLaboratorio.next()) {
                            int id_prueba = rsPruebasLaboratorio.getInt("id_prueba");

                            PruebaLaboratorio prueba = arrayPruebasHashMap.get(id_prueba);

                            if (prueba == null) {
                                prueba = switch (id_prueba) {
                                    case 1 ->
                                        new Sangre();
                                    case 2 ->
                                        new Heces();
                                    case 3 ->
                                        new Orina();
                                    case 4 ->
                                        new Cultivos();
                                    default ->
                                        null;
                                };
                                arrayPruebasHashMap.put(id_prueba, prueba);
                            }

                            int id_subCategoria = rsPruebasLaboratorio.getInt("id_subCategoria");
                            String nombre = rsPruebasLaboratorio.getString("nombre_subCategoria");
                            double precio_subCategoria = rsPruebasLaboratorio.getDouble("precio_subCategoria");

                            SubCategoriaPrueba subCategoria = new SubCategoriaPrueba(nombre, precio_subCategoria, id_prueba, id_subCategoria);

                            prueba.getArraySubCategorias().add(subCategoria);
                        }

                        arrayPruebas.addAll(arrayPruebasHashMap.values());
                        cita.setArrayPruebaLaboratorio(arrayPruebas);
                    }

                    arrayCitas.add(cita);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arrayCitas;
    }
    
    public List<Cita> consultarCitasPorFecha(Date fecha) throws SQLException {
        List<Cita> arrayCitas = new ArrayList<>();
        String sqlConsultarCita = "SELECT c.id_cita, c.diagnostico, c.indicaciones, c.fechaCita, c.frecuenciaCardiaca, c.frecuenciaRespiratoria, c.pulso, c.temperatura"
                + ", co.descripcion "
                + "FROM Cita c "
                + "JOIN Condicion co ON c.id_condicion = co.id_condicion "
                + "WHERE CAST(c.fechaCita AS Date) = ?";

        try (Connection conexion = ConeccionDB.conectarBaseDatos(); PreparedStatement pstmConsultarCita = conexion.prepareStatement(sqlConsultarCita)) {
            pstmConsultarCita.setDate(1, new java.sql.Date(fecha.getTime()));
            try (ResultSet rsCitas = pstmConsultarCita.executeQuery()) {

                while (rsCitas.next()) {
                    int id_cita = rsCitas.getInt("id_cita");
                    String disgnostico = rsCitas.getString("diagnostico").trim();
                    String indicaciones = rsCitas.getString("indicaciones").trim();
                    Timestamp fechaCitaTime = rsCitas.getTimestamp("fechaCita");
                    Date fechaCita = new Date(fechaCitaTime.getTime());
                    int frecuenciaCardiaca = rsCitas.getInt("frecuenciaCardiaca");
                    int frecuenciaRespiratoria = rsCitas.getInt("frecuenciaRespiratoria");
                    int pulso = rsCitas.getInt("pulso");
                    int temperatura = rsCitas.getInt("temperatura");
                    Condicion condicion = Condicion.valueOf(rsCitas.getString("descripcion").trim());

                    Cita cita = new Cita(id_cita, disgnostico, indicaciones, fechaCita, frecuenciaCardiaca, frecuenciaRespiratoria, pulso, temperatura, condicion);

                    String sqlConsultaActitudes = "SELECT a.id_actitud, a.descripcion "
                            + "FROM Actitud a "
                            + "INNER JOIN Cita_Actitud ca ON a.id_actitud = ca.id_actitud "
                            + "WHERE ca.id_cita = " + id_cita;
                    List<Actitud> arrayActitudes = new ArrayList<>();

                    try (PreparedStatement pstmConsultarActitudes = conexion.prepareStatement(sqlConsultaActitudes); ResultSet rsActitudes = pstmConsultarActitudes.executeQuery()) {
                        while (rsActitudes.next()) {
                            Actitud actitud = Actitud.valueOf(rsActitudes.getString("descripcion").trim());
                            arrayActitudes.add(actitud);
                        }
                        cita.setArrayActitud(arrayActitudes);
                    }

                    String sqlCunsultaEvaluaciones = "SELECT e.id_evaluacion, te.tipo_evaluacion, es.estado "
                            + "FROM Evaluacion e "
                            + "JOIN Cita_Evaluacion ce ON e.id_evaluacion = ce.id_evaluacion "
                            + "JOIN Tipo_Evaluacion te ON e.id_tipo_evaluacion = te.id_tipo_evaluacion "
                            + "JOIN Estado es ON e.id_estado = es.id_estado "
                            + "WHERE ce.id_cita = " + id_cita;
                    List<Evaluacion> arrayEvaluaciones = new ArrayList<>();

                    try (PreparedStatement pstmConsultarEvaluaciones = conexion.prepareStatement(sqlCunsultaEvaluaciones); ResultSet rsEvaluaciones = pstmConsultarEvaluaciones.executeQuery()) {
                        while (rsEvaluaciones.next()) {
                            TiposEvaluaciones tipoEvaluacion = TiposEvaluaciones.valueOf(rsEvaluaciones.getString("tipo_evaluacion").trim());
                            Estado estado = Estado.valueOf(rsEvaluaciones.getString("estado").trim());

                            Evaluacion evaluacion = new Evaluacion(rsEvaluaciones.getInt("id_evaluacion"), estado, tipoEvaluacion);
                            arrayEvaluaciones.add(evaluacion);
                        }
                        cita.setArrayEvaluacion(arrayEvaluaciones);
                    }

                    String sqlConsultarMotivos = "SELECT m.id_motivo, m.descripcion, m.aplica_examen, m.tiene_vacuna, "
                            + "cm.precio AS precio_cita_motivo, v.id_vacuna, v.id_especie, v.precio AS precio_vacuna, v.nombre "
                            + "FROM Motivo m "
                            + "JOIN Cita_Motivo cm ON m.id_motivo = cm.id_motivo "
                            + "LEFT JOIN Vacuna v ON cm.id_vacuna = v.id_vacuna "
                            + "WHERE cm.id_cita = " + id_cita;

                    List<Motivo> arrayMotivos = new ArrayList<>();

                    try (PreparedStatement pstmConsultarMotivos = conexion.prepareStatement(sqlConsultarMotivos); ResultSet rsMotivos = pstmConsultarMotivos.executeQuery()) {
                        while (rsMotivos.next()) {
                            int id_motivo = rsMotivos.getInt("id_motivo");
                            String descripcion = rsMotivos.getString("descripcion");
                            double precio = rsMotivos.getDouble("precio_cita_motivo");
                            boolean aplica_examen = rsMotivos.getBoolean("aplica_examen");
                            Motivo motivo;

                            if (rsMotivos.getBoolean("tiene_vacuna")) {
                                Especie especie = (rsMotivos.getInt("id_especie") == 1) ? new Perro() : new Gato();
                                int id_vacuna = rsMotivos.getInt("id_vacuna");
                                double precioVacuna = rsMotivos.getDouble("precio_vacuna");
                                String nombreVacuna = rsMotivos.getString("nombre");
                                Vacuna vacuna = new Vacuna(nombreVacuna, precioVacuna, id_vacuna, especie);

                                motivo = new Vacunacion(id_motivo, descripcion, vacuna, vacuna.getPrecio());
                            } else {
                                motivo = new Motivo(id_motivo, descripcion, precio, aplica_examen);
                            }
                            arrayMotivos.add(motivo);
                        }
                        cita.setArrayMotivo(arrayMotivos);
                    }

                    String sqlConsultarPruebas = "SELECT pl.id_prueba, "
                            + "sp.id_subCategoria, sp.nombre AS nombre_subCategoria, sp.precio AS precio_subcategoria "
                            + "FROM PruebaLaboratorio pl "
                            + "JOIN Cita_PruebaLaboratorio cpl ON pl.id_prueba = cpl.id_pruebaLaboratorio "
                            + "JOIN SubCategoriaPrueba sp ON cpl.id_subCategoria = sp.id_subCategoria "
                            + "WHERE cpl.id_cita = " + id_cita;

                    List<PruebaLaboratorio> arrayPruebas = new ArrayList<>();

                    try (PreparedStatement pstmConsultarPruebasLaboratorio = conexion.prepareStatement(sqlConsultarPruebas); ResultSet rsPruebasLaboratorio = pstmConsultarPruebasLaboratorio.executeQuery()) {

                        Map<Integer, PruebaLaboratorio> arrayPruebasHashMap = new HashMap<>();

                        while (rsPruebasLaboratorio.next()) {
                            int id_prueba = rsPruebasLaboratorio.getInt("id_prueba");

                            PruebaLaboratorio prueba = arrayPruebasHashMap.get(id_prueba);

                            if (prueba == null) {
                                prueba = switch (id_prueba) {
                                    case 1 ->
                                        new Sangre();
                                    case 2 ->
                                        new Heces();
                                    case 3 ->
                                        new Orina();
                                    case 4 ->
                                        new Cultivos();
                                    default ->
                                        null;
                                };
                                arrayPruebasHashMap.put(id_prueba, prueba);
                            }

                            int id_subCategoria = rsPruebasLaboratorio.getInt("id_subCategoria");
                            String nombre = rsPruebasLaboratorio.getString("nombre_subCategoria");
                            double precio_subCategoria = rsPruebasLaboratorio.getDouble("precio_subCategoria");

                            SubCategoriaPrueba subCategoria = new SubCategoriaPrueba(nombre, precio_subCategoria, id_prueba, id_subCategoria);

                            prueba.getArraySubCategorias().add(subCategoria);
                        }

                        arrayPruebas.addAll(arrayPruebasHashMap.values());
                        cita.setArrayPruebaLaboratorio(arrayPruebas);
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
