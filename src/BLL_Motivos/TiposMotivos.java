package BLL_Motivos;

public enum TiposMotivos {
    PRECIO_PREESTABLECIDO("Precio preestablecido"),
    PRECIO_NO_PREESTABLECIDO("Precio no preestablecido"),
    CON_VACUNA("Con vacuna");
    
    private String nombre;

    private TiposMotivos(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
