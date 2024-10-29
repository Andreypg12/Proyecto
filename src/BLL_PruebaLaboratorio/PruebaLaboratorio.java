package BLL_PruebaLaboratorio;

public abstract class PruebaLaboratorio{
    private final int numPrueba;
    protected double precio;

    public PruebaLaboratorio(double precio) {
        this.numPrueba = 0;
        this.precio = precio;
    }

    public PruebaLaboratorio(int numPrueba, double precio) {
        this.numPrueba = numPrueba;
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
