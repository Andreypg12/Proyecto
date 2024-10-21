package BLL;

public class Paciente {
    private static int CONTADOR = 1;
    private final int numeroPaciente;
    private String nombre;
    private Sexo sexo;
    private int edad;
    private Dueño dueño;
    private Especie especie;

    public Paciente(String nombre, Sexo sexo, int edad, Dueño dueño, Especie especie) {
        this.numeroPaciente = CONTADOR++;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.dueño = dueño;
        this.especie = especie;
    }
    
    
    
}
