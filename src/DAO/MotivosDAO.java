package DAO;

import BLL.Motivo;
import BLL.Vacunacion;
import java.sql.*;
import static DAO.ConeccionDB.conectarBaseDatos;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase MotivosDAO que gestiona las operaciones relacionadas con la tabla Motivo en la base de datos.
 * 
 * @author Andrey Pérez Gutiérrez
 */
public class MotivosDAO {

    /**
     * Agrega un nuevo motivo a la base de datos.
     *
     * @param motivo el objeto Motivo a insertar en la base de datos.
     *               Si el motivo es de tipo Vacunacion, se marcará como que tiene vacuna.
     * @throws Exception si ocurre un error durante la operación de base de datos.
     */
    public void agregarMotivo(Motivo motivo) throws Exception {
        try {
            String sql = "INSERT INTO Motivo (descripcion, precio, aplica_examen, tiene_vacuna) VALUES( ?, ?, ?, ?)";

            try (Connection conexion = conectarBaseDatos(); PreparedStatement pstm = conexion.prepareStatement(sql)) {

                String descripcion = motivo.getDescripcion();
                double precio = motivo.getPrecio();
                boolean aplica_examen = motivo.isAplicaExamen();

                pstm.setString(1, descripcion);
                if (precio == 0) {
                    pstm.setNull(2, java.sql.Types.INTEGER);
                } else {
                    pstm.setDouble(2, precio);
                }
                pstm.setBoolean(3, aplica_examen);

                if (motivo instanceof Vacunacion) {
                    pstm.setBoolean(4, true);
                }else{
                    pstm.setBoolean(4, false);
                }
                
                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Consulta y recupera todos los motivos de la base de datos.
     *
     * @return una lista de objetos Motivo con la información recuperada. 
     *         Los motivos con vacunas se devuelven como instancias de Vacunacion.
     * @throws Exception si ocurre un error durante la operación de base de datos.
     */
    public List<Motivo> consultarMotivos() throws Exception {
        List<Motivo> arrayMotivos = new ArrayList<>();
        try {
            String sql = "SELECT * from Motivo";

            try (PreparedStatement pstm = conectarBaseDatos().prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {
                    int id_motivo = rs.getInt("id_motivo");
                    String descripcion = rs.getString("descripcion");

                    boolean aplica_examen = rs.getBoolean("aplica_examen");
                    boolean tiene_vacuna = rs.getBoolean("tiene_vacuna");

                    Motivo motivo;

                    if (tiene_vacuna) {
                        motivo = new Vacunacion(id_motivo, descripcion, null);
                    } else {
                        double precio = rs.getDouble("precio");
                        if (rs.wasNull()) {
                            motivo = new Motivo(id_motivo, descripcion, aplica_examen);
                        } else {
                            motivo = new Motivo(id_motivo, descripcion, precio, aplica_examen);
                        }
                    }
                    arrayMotivos.add(motivo);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arrayMotivos;
    }

    /**
     * Elimina un motivo específico de la base de datos.
     *
     * @param motivo el objeto Motivo que se desea eliminar.
     * @throws Exception si ocurre un error durante la operación de base de datos.
     */
    public void eliminarMotivo(Motivo motivo) throws Exception {
        try {
            String sql = "delete from Motivo where id_motivo = ?";
            try (Connection conexion = conectarBaseDatos(); PreparedStatement pstm = conexion.prepareStatement(sql)) {

                int id_motivo = motivo.getId_motivo();

                pstm.setInt(1, id_motivo);
                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Modifica los datos de un motivo existente en la base de datos.
     *
     * @param motivo el objeto Motivo con los nuevos datos a actualizar.
     *               Si el motivo es de tipo Vacunacion, se marcará como que tiene vacuna.
     * @throws Exception si ocurre un error durante la operación de base de datos.
     */
    public void mofificarMotivo(Motivo motivo) throws Exception {
        try {
            String sql = "UPDATE Motivo SET descripcion = ?, precio = ?, aplica_examen = ?, tiene_vacuna = ?  WHERE id_motivo = ?";
            try (PreparedStatement pstm = conectarBaseDatos().prepareStatement(sql)) {

                int id_motivo = motivo.getId_motivo();

                pstm.setString(1, motivo.getDescripcion());
                pstm.setDouble(2, motivo.getPrecio());
                pstm.setBoolean(3, motivo.isAplicaExamen());

                if (motivo instanceof Vacunacion) {
                    pstm.setBoolean(4, true);
                } else {
                    pstm.setBoolean(4, false);
                }

                pstm.setInt(5, id_motivo);

                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
}
