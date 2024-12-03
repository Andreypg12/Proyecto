package BLL;

import DAO.PruebaLaboratorioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *Clase que junto con sus hijas crean una variedad definida de las pruebas de laboratorio que se pueden realizar en la cita
 * Tiene un identidicador único un nombre de la prueba y un array list de las subcategorías
 * @author Andrey Pérez Gutiérrez
 */
public abstract class PruebaLaboratorio{
    private final int id_prueba;
    protected String nombrePrueba;
    protected double precio;
    protected List<SubCategoriaPrueba> arraySubCategorias;

    /**
     * Constructor donmde se construye el objeto
     * @param nombrePrueba es el nombre con el que se construira el objeto
     * @param numPrueba es el identificador único con el que se construira el objeto
     */
    public PruebaLaboratorio(String nombrePrueba, int numPrueba) {
        this.nombrePrueba = nombrePrueba;
        this.id_prueba = numPrueba;
        this.precio = 0;
        arraySubCategorias = new ArrayList<>();
    }
    
    /**
     * Método que funciona para agregar una subcategoría al array list
     * @param subCategoria Es la subcategoria que se va agregar al array list
     */
    public void agregarSubCategoria(SubCategoriaPrueba subCategoria){
        precio += subCategoria.getPrecio();
        arraySubCategorias.add(subCategoria);
    }
    
    /**
     * Mostrará el nombre de la prueba
     * @return Nombre de la prueba
     */
    public String getNombrePrueba() {
        return nombrePrueba;
    }

    /**
     * Mostrará el precio de la prueba
     * @return Precio de la prueba
     */
    public double getPrecio() {
        return precio;
    }
    
    /**
     * Traerá el arreglo de las subcategorias
     * @return Arreglo de las subcategorias
     */
    public List<SubCategoriaPrueba> getArraySubCategorias() {
        return arraySubCategorias;
    }

    /**
     * Traerá el identificador único de la prueba
     * @return Identificar único de la prueba
     */
    public int getId_prueba() {
        return id_prueba;
    }
    
    /**
     * Método estático que mostrará todas las pruebas de laboratorio guardadas en la base de datos
     * @return Pruebas de laboraatorio almacenadas en la base de datos
     */
    public static List<PruebaLaboratorio> consultarPruebasLaboratorio() throws SQLException{
        return new PruebaLaboratorioDAO().consultarPruebasLaboratorio();
    }

    /**
     * Muestra toda la información sobre la prueba con sus subcategorias y el precio total
     * @return Información sobre la prueba con sus subcategorias y el precio total
     */
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
    
    /**
     * Muestra el nombre de la prueba
     * @return  Nombre de la prueba
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombrePrueba);
        return sb.toString();
    }
}
