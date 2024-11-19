package BLL;

public enum Sexo {
    MACHO("Macho"),
    HEMBRA("Hembra");
    
    private final String nombreSexo;

    private Sexo(String nombreSexo) {
        this.nombreSexo = nombreSexo;
    }

    public String getNombreSexo() {
        return nombreSexo;
    }

    @Override
    public String toString() {
        return nombreSexo;
    }
    
    
}
