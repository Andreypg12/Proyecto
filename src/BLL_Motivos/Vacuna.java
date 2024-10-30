package BLL_Motivos;

import BLL.Especie;
import DAO.VacunasDAO;
import java.util.List;

public class Vacuna {
    private String tipo_vacuna;
    private double precio;
    private final int id_vacuna;
    private Especie especieVacuna;

    public Vacuna(String tipo_vacuna, double precio, Especie especieVacuna) {
        this.tipo_vacuna = tipo_vacuna;
        this.precio = precio;
        this.id_vacuna = 0;
        this.especieVacuna = especieVacuna;
    }

    public Vacuna(String tipo_vacuna, double precio, int id_vacuna, Especie especieVacuna) {
        this.tipo_vacuna = tipo_vacuna;
        this.precio = precio;
        this.id_vacuna = id_vacuna;
        this.especieVacuna = especieVacuna;
    }

    public String getTipo_vacuna() {
        return tipo_vacuna;
    }

    public void setTipo_vacuna(String tipo_vacuna) {
        this.tipo_vacuna = tipo_vacuna;
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
        return tipo_vacuna;
    }
    
    public static void agregarVacuna(Vacuna vacuna) throws Exception{
        VacunasDAO.agregarVacuna(vacuna);
    }
    
    public static List<Vacuna> consultarVacunas() throws Exception{
        return VacunasDAO.consultarVacunas();
    }
    
    public static void eliminarVacuna(Vacuna vacuna) throws Exception{
        VacunasDAO.eliminarVacuna(vacuna);
    }
    public static void modificarVacuna(Vacuna vacuna) throws Exception{
        VacunasDAO.modificarVacuna(vacuna);
    }
}
