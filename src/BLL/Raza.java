package BLL;

import DAO.RazasDAO;
import java.util.List;

public class Raza{
    private final int id_raza;
    protected String nombreRaza;
    private int codigoEspecie;

    public Raza(String nombreRaza, int codigoEspecie){
        id_raza = 0;
        this.nombreRaza = nombreRaza;
        this.codigoEspecie = codigoEspecie;
    }

    public Raza(int id_raza, String nombreRaza, int codigoEspecie) {
        this.id_raza = id_raza;
        this.nombreRaza = nombreRaza;
        this.codigoEspecie = codigoEspecie;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }   

    public int getCodigoEspecie() {
        return codigoEspecie;
    }

    public int getId_raza() {
        return id_raza;
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
    
    public static boolean eliminarRaza(Raza raza)throws Exception{
        return RazasDAO.eliminarRaza(raza);
    }

    @Override
    public String toString() {
        return nombreRaza;
    }
}
    
    
