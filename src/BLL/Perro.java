package BLL;

public class Perro extends Especie{
    private RazasPerro raza;

    public Perro(RazasPerro raza) {
        super("Perro");
        this.raza = raza;
    }
}