package BLL_Motivos;

public enum Vacunas {
    TRIPLE("Triple", 4650),
    PARVOVIRUS("Parvovirus", 6500),
    RABIA_PERRO("Rabia perruna", 8765),
    TRIVALENTE("Trivalente", 5500),
    RABIA_GATO("Rabia gatuna", 9000),
    LEUCEMIA_FELINA("Leucemia Felina", 4567);

    private final String nombreVacuna;
    private final int precio;

    Vacunas(String nombre, int precio) {
        this.nombreVacuna = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombreVacuna).append("\n");
        return sb.toString();
    }

    public int getPrecio() {
        return precio;
    }
}
