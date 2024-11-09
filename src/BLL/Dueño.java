package BLL;

import DAO.DueñosDAO;
import java.util.List;

public class Dueño {
    private final String cedula;
    private String direccion;
    private String nombre;
    private String telefono;

    public Dueño(String cedula, String nombre, String direccion, String telefono) {
        this.cedula = cedula;
        this.direccion = direccion;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }
    
    public static void agregar(Dueño dueno) throws Exception{
        new DueñosDAO().agregar(dueno);
    }
    
    public static List<Dueño> cosultarDueños() throws Exception{
        return new DueñosDAO().consultarDuenos();
    }

    @Override
    public String toString() {
        return nombre + " - cédula: " + cedula;
    }
}
