package BLL;

public class Gato extends Especie{
    private RazasGato raza;

    public Gato(RazasGato raza) {
        super("Gato");
        this.raza = raza;
    }
}
