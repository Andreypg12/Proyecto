package BLL;

import DAO.RazasDAO;
import java.util.List;

public class Especie {
    private final int id_especie;
    private String nombreEspecie;
    private Raza raza;

    public Especie(String nombreEspecie, int id_especie) {
        this.id_especie = id_especie;
        this.nombreEspecie = nombreEspecie;
    }

    public Especie(int id_especie, String nombreEspecie, Raza raza) {
        this.id_especie = id_especie;
        this.nombreEspecie = nombreEspecie;
        this.raza = raza;
    }

    public String getNombreEspecie() {
        return nombreEspecie;
    }

    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }

    public int getId_especie() {
        return id_especie;
    }
    
    public static List<Especie> consultarEspecies() throws Exception{
        return new RazasDAO().consultarEspecies();
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return nombreEspecie;
    }
}
