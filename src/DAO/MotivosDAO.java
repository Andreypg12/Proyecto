package DAO;

import BLL.Especie;
import BLL.Gato;
import BLL.Perro;
import BLL_Motivos.*;
import java.sql.*;
import static DAO.ConeccionDB.conectarBaseDatos;
import java.util.ArrayList;
import java.util.List;

public class MotivosDAO {

    public static void agregarMotivo(Motivo motivo) throws Exception {
        try {
            String sql = "INSERT INTO Motivo (descripcion, precio, aplica_examen, id_vacuna) VALUES( ?, ?, ?, ?)";

            try (Connection conexion = conectarBaseDatos(); PreparedStatement pstm = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                String descripcion = motivo.getDescripcion();
                double precio = motivo.getPrecio();
                boolean aplica_examen = motivo.isAplicaExamen();

                pstm.setString(1, descripcion);
                pstm.setDouble(2, precio);
                pstm.setBoolean(3, aplica_examen);
                
                if (motivo instanceof Vacunacion) {
                    pstm.setInt(4, ((Vacunacion)motivo).getVacuna().getId_vacuna());
                }
                else{
                    pstm.setNull(4, java.sql.Types.INTEGER);
                }

                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public static List<Motivo> consultarMotivos() throws Exception {
        List<Motivo> arrayMotivos = new ArrayList<>();
        try {
            String sql = "SELECT m.id_motivo, m.descripcion, m.precio AS precio_motivo, m.aplica_examen"
                    + ", v.id_vacuna, v.nombre, v.id_especie, v.precio AS precio_vacuna "
                    + "FROM Motivo m "
                    + "LEFT JOIN Vacuna v ON m.id_vacuna = v.id_vacuna";

            try (PreparedStatement pstm = conectarBaseDatos().prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {
                    int id_motivo = rs.getInt("id_motivo");
                    String descripcion = rs.getString("descripcion");

                    boolean aplica_examen = rs.getBoolean("aplica_examen");
                    int id_vacuna = rs.getInt("id_vacuna");
                    Motivo motivo;

                    if (rs.wasNull()) {
                        double precio = rs.getDouble("precio_motivo");
                        motivo = new Motivo(id_motivo, descripcion, precio, aplica_examen);

                    } else {
                        String nombreVacuna = rs.getString("nombre");
                        double precioVacuna = rs.getDouble("precio_vacuna");
                        int id_especie = rs.getInt("id_especie");
                        
                        Especie especie =(id_especie == 1) ? new Perro() : new Gato();

                        Vacuna vacuna = new Vacuna(nombreVacuna, precioVacuna, id_vacuna, especie);

                        motivo = new Vacunacion(id_motivo, descripcion, vacuna);
                    }
                    arrayMotivos.add(motivo);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arrayMotivos;
    }

    public static void eliminarMotivo(Motivo motivo) throws Exception {
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

    public static boolean mofificarMotivo(Motivo motivoViejo, Motivo motivoNuevo) throws Exception {
        try {
            String sql = "UPDATE Motivo SET descripcion = ?, precio = ?, aplica_examen = ?, id_vacuna = ?  WHERE id_motivo = ?";
            try (Connection conexion = conectarBaseDatos(); PreparedStatement pstm = conexion.prepareStatement(sql)) {

                int id_motivo = motivoViejo.getId_motivo();

                pstm.setString(1, motivoNuevo.getDescripcion());
                pstm.setDouble(2, motivoNuevo.getPrecio());
                pstm.setBoolean(3, motivoNuevo.isAplicaExamen());
                pstm.setInt(5, id_motivo);
                
                if (motivoViejo instanceof Vacunacion) {
                    pstm.setInt(4, ((Vacunacion)motivoNuevo).getVacuna().getId_vacuna());
                }else{
                    pstm.setNull(4, java.sql.Types.INTEGER);
                }

                pstm.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
