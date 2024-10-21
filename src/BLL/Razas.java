package BLL;

import java.io.Serializable;
import DAO.RazasDAO;
import java.util.List;
public class Razas implements Serializable{
    protected String nombreRaza;

    public Razas(String nombreRaza){
        this.nombreRaza = nombreRaza;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }   
    
    public static void agregar(Razas raza) throws Exception{
        RazasDAO.getInstance().agregar(raza);
    }
    
    public static List<Razas> listaRazas() throws Exception{
        return RazasDAO.getInstance().listado();
    }
    
    public static Razas consultar(String nombre) throws Exception{
        return RazasDAO.getInstance().consultar(nombre);
    }

}
    
    
