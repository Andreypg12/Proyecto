package BLL;

public enum Estado {
    NORMAL("Normal", 1),
    ANORMAL("Anormal", 2);
    
    private final int id_estado;
    private final String estado;

    private Estado(String estado, int id_estado) {
        this.id_estado = id_estado;
        this.estado = estado;
    }

    public int getId_estado() {
        return id_estado;
    }

    @Override
    public String toString() {
        return estado;
    }
}
