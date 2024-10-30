package BLL;

import DAO.RazasDAO;
import java.util.List;

public class Especie {
    private final int codigoEspecie;
    private String nombreEspecie;

    public Especie(String nombreEspecie, int codigoEspecie) {
        this.codigoEspecie = codigoEspecie;
        this.nombreEspecie = nombreEspecie;
    }

    public String getNombreEspecie() {
        return nombreEspecie;
    }

    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }

    public int getCodigoEspecie() {
        return codigoEspecie;
    }
    
    public static List<Especie> ConsultarEspecies() throws Exception{
        return RazasDAO.consultarEspecies();
    }

    @Override
    public String toString() {
        return nombreEspecie;
    }
}
