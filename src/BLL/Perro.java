package BLL;

public class Perro extends Especie{
    private Raza raza;

    public Perro() {
        super("Perro", 1);
        this.raza = null;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }
}