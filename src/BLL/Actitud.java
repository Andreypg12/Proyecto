package BLL;

public enum Actitud {
    EXCITADO("Excitado"),
    DEPRIMIDO("Deprimido"),
    POSTRADO("Postrado");

    private final String estado;

    Actitud(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Actitud: " + estado;
    }
}
