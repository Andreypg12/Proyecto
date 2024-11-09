package BLL;

public class Paciente {
    private final int numeroPaciente;
    private String nombre;
    private Sexo sexo;
    private int edad;
    private Dueño dueño;
    private Especie especie;

    public Paciente(String nombre, Sexo sexo, int edad, Dueño dueño, Especie especie) {
        this.numeroPaciente = 0;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.dueño = dueño;
        this.especie = especie;
    }

    public Paciente(int numeroPaciente, String nombre, Sexo sexo, int edad, Dueño dueño, Especie especie) {
        this.numeroPaciente = numeroPaciente;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.dueño = dueño;
        this.especie = especie;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Dueño getDueño() {
        return dueño;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public int getNumeroPaciente() {
        return numeroPaciente;
    }
    
    
    
}
