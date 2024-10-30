package BLL;

import DAO.RazasDAO;
import java.util.List;

public class Raza{
    private final int id_raza;
    protected String nombreRaza;
    private Especie especieAQuePertenece;

    public Raza(String nombreRaza, Especie especieAQuePertenece){
        id_raza = 0;
        this.nombreRaza = nombreRaza;
        this.especieAQuePertenece = especieAQuePertenece;
    }

    public Raza(int id_raza, String nombreRaza, Especie especieAQuePertenece) {
        this.id_raza = id_raza;
        this.nombreRaza = nombreRaza;
        this.especieAQuePertenece = especieAQuePertenece;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    public int getId_raza() {
        return id_raza;
    }

    public Especie getEspecieAQuePertenece() {
        return especieAQuePertenece;
    }

    public void setEspecieAQuePertenece(Especie especieAQuePertenece) {
        this.especieAQuePertenece = especieAQuePertenece;
    }
    
    public static void agregarRaza(Raza raza) throws Exception{
        RazasDAO.agregarRaza(raza);
    }
    
    public static List<Raza> consultarRazas() throws Exception{
        return RazasDAO.consultarRazas();
    }
    
    public static void modificarRaza(String nuevoNombre, int id_raza) throws Exception{
        RazasDAO.modificarRaza(nuevoNombre, id_raza);
    }
    
    public static void eliminarRaza(Raza raza)throws Exception{
        RazasDAO.eliminarRaza(raza);
    }

    @Override
    public String toString() {
        return nombreRaza;
    }
}
    
    
