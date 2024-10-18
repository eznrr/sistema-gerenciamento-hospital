package models;

public class Paciente extends Pessoa {
    private static int idCounter = 1;
    private int id;
    private Prontuario prontuario;

    public Paciente(String nome, int idade, String genero, String historicoMedico, String exames) {
        super(nome, idade, genero);
        this.prontuario = new Prontuario(historicoMedico, exames);
        this.id = idCounter++;
    }

    public int getId() {
        return id;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", " + super.toString() + ", " + prontuario.toString();
    }
}
