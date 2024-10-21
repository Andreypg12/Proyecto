package BLL;

public enum Estado {
    NORMAL("Normal"),
    ANORMAL("Anormal");
    
    private final String estado;

    private Estado(String estado) {
        this.estado = estado;
    }
}
