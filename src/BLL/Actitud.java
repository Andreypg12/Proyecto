package BLL;

public enum Actitud {
    EXCITADO("Excitado", 1),
    DEPRIMIDO("Deprimido", 2),
    POSTRADO("Postrado", 3);

    private final int id_actitud;
    private final String actitud;

    Actitud(String actitud, int id_actitud) {
        this.id_actitud = id_actitud;
        this.actitud = actitud;
    }

    public int getId_actitud() {
        return id_actitud;
    }

    @Override
    public String toString() {
        return actitud;
    }
}
