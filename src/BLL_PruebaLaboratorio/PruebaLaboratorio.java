package BLL_PruebaLaboratorio;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public abstract class PruebaLaboratorio <T>{
    private static int CONTADOR = 1;
    private final int numPrueba;
    protected double precio;
    protected List<T> arrayCategorias;

    public PruebaLaboratorio() {
        this.arrayCategorias = new ArrayList<>();
        this.numPrueba = CONTADOR++;
        this.precio = 0;
    }
    
    abstract public void definirDescripcion();
    
    public void agregarCategoria(T t){
        arrayCategorias.add(t);
    }
    
    public void calcularPrecio(Class object){
        try {
            Method metodo = object.getMethod("getPrecio");
            for (T categoria : arrayCategorias) {
            precio += (double)metodo.invoke(categoria);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "NOOOOOOOOOOOOOOOOOOOOOOOOO");
        }
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNumero de prueba: ").append(numPrueba);
        sb.append("\nPrecio: ").append(precio);
        sb.append("\n");
        return sb.toString();
    }
}
