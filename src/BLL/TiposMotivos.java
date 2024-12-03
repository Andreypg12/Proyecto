package BLL;

/**
 * Clase que va a definir a que tipo pertenece un motivo
 * Puede tener un precio preestablecido que se le aplicará automatico,
 * Puede no tener un precio y este precio será definido por el veterinario
 * y puede ser con vacuna que el precio será definido por la vacuna que se le vincule al motivo
 * @author Andrey Pérez Gutiérrez
 */
public enum TiposMotivos {
    PRECIO_PREESTABLECIDO("Precio preestablecido"),
    PRECIO_NO_PREESTABLECIDO("Precio no preestablecido"),
    CON_VACUNA("Con vacuna");
    
    private String nombre;

    /**
     * Constructor privado para darle el valor a los tipos de motivos
     * @param nombre Es el nombre representativo del tipo de motivo
     */
    private TiposMotivos(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Mostrará el nombre representativo del tipo de motivo
     * 
     * @return Nombre representativo del tipo de motivo
     */
    @Override
    public String toString() {
        return nombre;
    }
    
}
