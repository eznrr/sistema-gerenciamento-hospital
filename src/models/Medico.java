package models;

public class Medico extends Pessoa {
    private static int idCounter = 1;
    private int id;
    private String especialidade;

    public Medico(String nome, int idade, String genero, String especialidade) {
        super(nome, idade, genero);
        this.id = idCounter++;
        this.especialidade = especialidade;
    }

    public int getId() {
        return id;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", " + super.toString() + ", Especialidade: " + especialidade;
    }
}
