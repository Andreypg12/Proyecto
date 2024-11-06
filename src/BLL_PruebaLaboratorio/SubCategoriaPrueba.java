package BLL_PruebaLaboratorio;

import DAO.PruebaLaboratorioDAO;
import java.sql.SQLException;
import java.util.List;

public class SubCategoriaPrueba {
    private final int id_subCategoria;
    private int id_prueba;
    private String nombre;
    private double precio;

    public SubCategoriaPrueba(String nombre, double precio, int id_prueba) {
        id_subCategoria = 0;
        this.nombre = nombre;
        this.precio = precio;
        this.id_prueba = id_prueba;
    }

    public SubCategoriaPrueba(String nombre, double precio, int id_prueba, int id_subCategoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.id_prueba = id_prueba;
        this.id_subCategoria = id_subCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_prueba() {
        return id_prueba;
    }

    public void setId_prueba(int id_prueba) {
        this.id_prueba = id_prueba;
    }

    public int getId_subCategoria() {
        return id_subCategoria;
    }
    
    public static void agregarSubCategoria(SubCategoriaPrueba subCategoria) throws SQLException{
        new PruebaLaboratorioDAO().agregarSubCategoria(subCategoria);
    }
    
    public static void modificarSubCategoria(SubCategoriaPrueba subCategoria) throws SQLException{
        new PruebaLaboratorioDAO().modificarSubCategoria(subCategoria);
    }
    
    public static List<SubCategoriaPrueba> consultarSubCategorias() throws SQLException{
        return new PruebaLaboratorioDAO().consultarSubCategorias();
    }

    @Override
    public String toString() {
        return nombre;
    }
}
