package BLL;

public enum Condicion {
    BAJO_DE_PESO("Bajo de Peso"),
    SOBREPESO("Sobrepeso"),
    NORMAL("Normal");

    private final String estado;

    Condicion(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "Condición: " + estado;
    }
}
