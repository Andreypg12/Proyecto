package BLL;

public class Especie {
    private static int CONTADOR;
    private final int codigoEspecie;
    private String nombreEspecie;

    public Especie(String nombreEspecie) {
        this.codigoEspecie = CONTADOR++;
        this.nombreEspecie = nombreEspecie;
    }

    public String getNombreEspecie() {
        return nombreEspecie;
    }

    public void setNombreEspecie(String nombreEspecie) {
        this.nombreEspecie = nombreEspecie;
    }

    public int getCodigoEspecie() {
        return codigoEspecie;
    }
}
