package BLL;

import DAO.PacienteDAO;
import java.sql.SQLException;
import java.util.List;

public class Paciente {
    private final int id_paciente;
    private String nombre;
    private Sexo sexo;
    private int edad;
    private Dueño dueño;
    private Especie especie;
    private Raza raza;

    public Paciente(String nombre, Sexo sexo, int edad, Dueño dueño, Especie especie, Raza raza) {
        this.id_paciente = 0;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.dueño = dueño;
        this.especie = especie;
        this.raza = raza;
    }

    public Paciente(int id_paciente, String nombre, Sexo sexo, int edad, Dueño dueño, Especie especie, Raza raza) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.dueño = dueño;
        this.especie = especie;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Dueño getDueño() {
        return dueño;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }
     
    public static void agregar(Paciente paciente) throws SQLException{
        new PacienteDAO().agregar(paciente);
    }
    
    public static List<Paciente> consultarPacientes() throws SQLException{
        return new PacienteDAO().consultarPacientes();
    }
    
    public static List<Paciente> consultarPacientesPorDueño(Dueño dueño) throws SQLException{
        return new PacienteDAO().consultarPacientesPorDueño(dueño);
    }

    @Override
    public String toString() {
        return nombre + ", " + especie.getNombreEspecie() + " " + raza.getNombreRaza() + ", "  + sexo;
    }
}
