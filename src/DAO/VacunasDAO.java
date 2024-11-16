package DAO;

import BLL.Especie;
import BLL.Gato;
import BLL.Perro;
import BLL_Motivos.Vacuna;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacunasDAO {
    
    public void agregarVacuna(Vacuna vacuna) throws Exception{
        try {
            String sql = "INSERT INTO Vacuna (id_especie,precio, nombre) VALUES (?, ?, ?)";
            
            try(PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql)){
                
                int id_especie = vacuna.getEspecieVacuna().getId_especie();
                double precio = vacuna.getPrecio();
                String tipo_vacuna = vacuna.getNombre();
                
                pstm.setInt(1, id_especie);
                pstm.setDouble(2, precio);
                pstm.setString(3, tipo_vacuna);
                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public void modificarVacuna(Vacuna vacuna) throws Exception{
        try {
            String sql = "UPDATE Vacuna SET id_especie = ?, precio = ?, nombre = ? WHERE id_vacuna = ?";
            
            try(PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql)){
                
                int id_especie = vacuna.getEspecieVacuna().getId_especie();
                double precio = vacuna.getPrecio();
                String tipo_vacuna = vacuna.getNombre();
                
                pstm.setInt(1, id_especie);
                pstm.setDouble(2, precio);
                pstm.setString(3, tipo_vacuna);
                pstm.setInt(4, vacuna.getId_vacuna());
                
                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public void eliminarVacuna(Vacuna vacuna) throws Exception{
        try {
            String sql = "DELETE FROM Vacuna WHERE id_vacuna = ?";
            
            try(PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql)){

                int id_vacuna = vacuna.getId_vacuna();

                pstm.setInt(1, id_vacuna);
                
                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public List<Vacuna> consultarVacunas() throws Exception {
        List<Vacuna> arrayVacunas = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Vacuna";

            try (PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {

                    int id_vacuna = rs.getInt("id_vacuna");
                    int id_especie = rs.getInt("id_especie");
                    double precio = rs.getDouble("precio");
                    String tipo_vacuna = rs.getString("nombre");
                    Especie especie;

                    if (id_especie == 1) {
                        especie = new Perro();
                    } else {
                        especie = new Gato();
                    }

                    arrayVacunas.add(new Vacuna(tipo_vacuna, precio, id_vacuna, especie));
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arrayVacunas;
    }
}
