package BLL;

public enum Sexo {
    MACHO("Macho"),
    HEMBRA("Hembra");
    
    private String nombreSexo;

    private Sexo(String nombreSexo) {
        this.nombreSexo = nombreSexo;
    }

    @Override
    public String toString() {
        return nombreSexo;
    }
    
    
}
