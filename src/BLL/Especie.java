package BLL;

import DAO.RazasDAO;
import java.util.List;

public class Especie {
    private final int id_especie;
    private String nombreEspecie;

    public Especie(String nombreEspecie, int id_especie) {
        this.id_especie = id_especie;
        this.nombreEspecie = nombreEspecie;
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

    @Override
    public String toString() {
        return nombreEspecie;
    }
}
