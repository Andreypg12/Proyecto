package BLL;

public enum Condicion {
    BAJO_PESO("Bajo Peso", 1),
    SOBRE_PESO("Sobrepeso", 2),
    NORMAL("Normal", 3);

    private final int id_condicion;
    private final String estado;

    Condicion(String estado, int id_condicion) {
        this.id_condicion = id_condicion;
        this.estado = estado;
    }

    public int getId_condicion() {
        return id_condicion;
    }
    
    @Override
    public String toString() {
        return estado;
    }
}
