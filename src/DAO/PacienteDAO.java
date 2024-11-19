package DAO;

import BLL.Dueño;
import BLL.Especie;
import BLL.Gato;
import BLL.Paciente;
import BLL.Perro;
import BLL.Raza;
import BLL.Sexo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    
    private Especie perro = new Perro();
    private Especie gato = new Gato();
    
    public void agregar(Paciente paciente) throws SQLException{
        try {
            String sql = "INSERT INTO Paciente (cedula_dueño, nombre, sexo, edad,id_especie, id_raza) VALUES(?, ?, ?, ?, ?, ?)";
            try(PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql)){
                
                String cedula_dueno = paciente.getDueño().getCedula();
                String nombre = paciente.getNombre();
                String sexo = paciente.getSexo().name();
                int edad = paciente.getEdad();
                int id_especie = paciente.getEspecie().getId_especie();
                int id_raza = paciente.getRaza().getId_raza();
                
                pstm.setString(1, cedula_dueno);
                pstm.setString(2, nombre);
                pstm.setString(3, sexo);
                pstm.setInt(4, edad);
                pstm.setInt(5, id_especie);
                pstm.setInt(6, id_raza);
                
                pstm.executeUpdate();
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Paciente> consultarPacientes() throws SQLException {
        List<Paciente> arrayPacientes = new ArrayList<>();
        try {
            String sql = "SELECT p.id_paciente, p.nombre AS nombre_paciente, p.sexo, p.edad"
                    + ", d.cedula, d.nombre AS nombre_dueño, d.direccion, d.numero_telefono"
                    + ", e.id_especie "
                    + ", r.id_raza, r.nombre_raza "
                    + "FROM Paciente p "
                    + "LEFT JOIN Dueño d ON p.cedula_dueño = d.cedula "
                    + "LEFT JOIN Especie e ON p.id_especie = e.id_especie "
                    + "LEFT JOIN Raza r ON p.id_raza = r.id_raza";
            try (PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql); ResultSet rs = pstm.executeQuery()) {

                while (rs.next()) {
                    int id_especie = rs.getInt("id_especie");
                    Especie especie = (id_especie == 1) ? perro : gato;
                    Dueño dueño = new Dueño(rs.getString("cedula").trim(),
                            rs.getString("nombre_dueño").trim(),
                            rs.getString("direccion").trim(),
                            rs.getString("numero_telefono"));
                    Raza raza = new Raza(rs.getInt("id_raza"),
                            rs.getString("nombre_raza").trim(),
                            especie);

                    arrayPacientes.add(new Paciente(rs.getInt("id_paciente"),
                            rs.getString("nombre_paciente"),
                            Sexo.valueOf(rs.getString("sexo").trim()),
                            rs.getInt("edad"),
                            dueño,
                            especie,
                            raza));
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arrayPacientes;
    }
    
    public List<Paciente> consultarPacientesPorDueño(Dueño dueño) throws SQLException {
        List<Paciente> arrayPacientes = new ArrayList<>();
        try {
            String sql = "SELECT p.id_paciente, p.nombre, p.sexo, p.edad, p.id_especie"
                    + ", r.id_raza, r.nombre_raza "
                    + "FROM Paciente p "
                    + "LEFT JOIN Raza r ON p.id_raza = r.id_raza "
                    + "WHERE cedula_dueño = ?";
            try (PreparedStatement pstm = ConeccionDB.conectarBaseDatos().prepareStatement(sql)) {
                pstm.setString(1, dueño.getCedula());

                try (ResultSet rs = pstm.executeQuery()) {

                    while (rs.next()) {
                        int id_especie = rs.getInt("id_especie");
                        Especie especie = (id_especie == 1) ? perro : gato;
                        Raza raza = new Raza(rs.getInt("id_raza"),
                                rs.getString("nombre_raza").trim(),
                                especie);

                        arrayPacientes.add(new Paciente(rs.getInt("id_paciente"),
                                rs.getString("nombre"),
                                Sexo.valueOf(rs.getString("sexo").trim()),
                                rs.getInt("edad"),
                                dueño,
                                especie,
                                raza));
                    }
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return arrayPacientes;
    }
}
