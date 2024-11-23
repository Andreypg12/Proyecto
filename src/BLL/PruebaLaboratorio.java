package BLL;

import DAO.PruebaLaboratorioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class PruebaLaboratorio{
    private final int id_prueba;
    protected String nombrePrueba;
    protected double precio;
    protected List<SubCategoriaPrueba> arraySubCategorias;

    public PruebaLaboratorio(String nombrePrueba, int numPrueba) {
        this.nombrePrueba = nombrePrueba;
        this.id_prueba = numPrueba;
        this.precio = 0;
        arraySubCategorias = new ArrayList<>();
    }
    
    public void agregarSubCategoria(SubCategoriaPrueba subCategoria){
        precio += subCategoria.getPrecio();
        arraySubCategorias.add(subCategoria);
    }

    public String getNombrePrueba() {
        return nombrePrueba;
    }

    public void setNombrePrueba(String nombrePrueba) {
        this.nombrePrueba = nombrePrueba;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<SubCategoriaPrueba> getArraySubCategorias() {
        return arraySubCategorias;
    }

    public int getId_prueba() {
        return id_prueba;
    }
    
    public static List<PruebaLaboratorio> consultarPruebasLaboratorio() throws SQLException{
        return new PruebaLaboratorioDAO().consultarPruebasLaboratorio();
    }

    public String informacion() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombrePrueba).append(" --");
        for (SubCategoriaPrueba subCategoria : arraySubCategorias) {
            sb.append(subCategoria.getNombre()).append(", ");
        }
        sb.append("Precio total: ");
        sb.append(precio);
        return sb.toString();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombrePrueba);
        return sb.toString();
    }
}
