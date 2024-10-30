package DAO;

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
                else {
                    pstm.setInt(4, -1);
                }

                pstm.executeUpdate();
//                try (ResultSet keyGenerada = pstm.getGeneratedKeys()) {
//                    if (keyGenerada.next() & motivo instanceof Vacunacion) {
//                        int id_motivo = keyGenerada.getInt(1);
//                        String tipo_vacuna = ((Vacunacion) motivo).getVacuna().name();
//                        insertarVacuna(id_motivo, tipo_vacuna, conexion);
//                    }
//                }
            }
        } catch (SQLException e) {
            throw e;
        }
    }

//    public static void insertarVacuna(int id_motivo, String tipo_vacuna, Connection conexion) throws Exception {
//        try {
//            String sql = "insert into Vacuna (id_motivo, tipo_vacuna) values(?, ?)";
//            try (PreparedStatement pstm = conexion.prepareStatement(sql)) {
//                pstm.setInt(1, id_motivo);
//                pstm.setString(2, tipo_vacuna);
//                pstm.executeUpdate();
//            }
//        } catch (SQLException e) {
//            throw e;
//        }
//    }

    public static List<Motivo> consultarMotivos() throws Exception {
        List<Motivo> arrayMotivos = new ArrayList<>();
        try {
            String sql = "SELECT id_motivo, descripcion, precio, aplica_examen, id_vacuna FROM Motivo";

            try (PreparedStatement pstm = conectarBaseDatos().prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {
                    int id_motivo = rs.getInt(1);
                    String descripcion = rs.getString(2);
                    
                    boolean aplica_examen = rs.getBoolean(4);
                    int id_vacuna = rs.getInt(5);
                    Motivo motivo;

                    if (id_vacuna == -1) {
                        double precio = rs.getInt(3);
                        motivo = new Motivo(id_motivo, descripcion, precio, aplica_examen);
                        
                    } else {
                        Vacuna vacuna = Vacuna.consultarVacuna(id_vacuna);
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

                if (motivo instanceof Vacunacion) {
                    try (PreparedStatement pstmVacuna = conexion.prepareStatement("delete from Vacuna where id_motivo = ?")) {
                        pstmVacuna.setInt(1, id_motivo);
                        pstmVacuna.executeUpdate();
                    }
                }
                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public static boolean mofificarMotivo(Motivo motivoViejo, Motivo motivoNuevo) throws Exception {
        try {
            String sql = "UPDATE Motivo SET descripcion = ?, precio = ?, aplica_examen = ?, id_vacuna  WHERE id_motivo = ?";
            try (Connection conexion = conectarBaseDatos(); PreparedStatement pstm = conexion.prepareStatement(sql)) {

                int id_motivo = motivoViejo.getId_motivo();

                pstm.setString(1, motivoNuevo.getDescripcion());
                pstm.setDouble(2, motivoNuevo.getPrecio());
                pstm.setBoolean(3, motivoNuevo.isAplicaExamen());
                pstm.setInt(5, id_motivo);
                
                if (motivoViejo instanceof Vacunacion) {
                    pstm.setInt(4, ((Vacunacion)motivoNuevo).getVacuna().getId_vacuna());
                }

                pstm.executeUpdate();
                return true;
            }
        } catch (SQLException e) {
            return false;
        }
    }
}
