package BLL;

public class Gato extends Especie{
    private Raza raza;

    public Gato() {
        super("Gato", 2);
        this.raza = null;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }
}
