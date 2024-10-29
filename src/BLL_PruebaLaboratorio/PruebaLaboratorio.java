package BLL_PruebaLaboratorio;

public abstract class PruebaLaboratorio{
    private static int CONTADOR = 1;
    private final int numPrueba;
    protected double precio;

    public PruebaLaboratorio(double precio) {
        this.numPrueba = CONTADOR++;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
