package BLL;

import BLL.Especie;
import DAO.VacunasDAO;
import java.util.List;

public class Vacuna {
    private String nombre;
    private double precio;
    private final int id_vacuna;
    private Especie especieVacuna;

    public Vacuna(String nombre, double precio, Especie especieVacuna) {
        this.nombre = nombre;
        this.precio = precio;
        this.id_vacuna = 0;
        this.especieVacuna = especieVacuna;
    }

    public Vacuna(String nombre, double precio, int id_vacuna, Especie especieVacuna) {
        this.nombre = nombre;
        this.precio = precio;
        this.id_vacuna = id_vacuna;
        this.especieVacuna = especieVacuna;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String tipo_vacuna) {
        this.nombre = tipo_vacuna;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Especie getEspecieVacuna() {
        return especieVacuna;
    }

    public void setEspecieVacuna(Especie especieVacuna) {
        this.especieVacuna = especieVacuna;
    }

    public int getId_vacuna() {
        return id_vacuna;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    public static void agregarVacuna(Vacuna vacuna) throws Exception{
        new VacunasDAO().agregarVacuna(vacuna);
    }
    
    public static List<Vacuna> consultarVacunas() throws Exception{
        return new VacunasDAO().consultarVacunas();
    }
    
    public static void eliminarVacuna(Vacuna vacuna) throws Exception{
        new VacunasDAO().eliminarVacuna(vacuna);
    }
    public static void modificarVacuna(Vacuna vacuna) throws Exception{
        new VacunasDAO().modificarVacuna(vacuna);
    }
}