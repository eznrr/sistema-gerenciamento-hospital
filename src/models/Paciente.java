package models;

// A classe Paciente herda de Pessoa e adiciona informações específicas de um paciente, como o prontuário.
public class Paciente extends Pessoa {
    // Um contador estático para garantir que cada paciente tenha um ID único.
    private static int idCounter = 1;

    // ID exclusivo do paciente.
    private int id;

    // O prontuário contém informações médicas do paciente, como histórico médico e exames.
    private Prontuario prontuario;

    // Construtor da classe Paciente. Inicializa o nome, idade e gênero, 
    // herdados da classe Pessoa, e cria um prontuário para o paciente.
    public Paciente(String nome, int idade, String genero, String historicoMedico, String exames) {
        // Chama o construtor da classe pai (Pessoa) para inicializar esses atributos.
        super(nome, idade, genero);
        // Cria um novo prontuário com o histórico médico e exames.
        this.prontuario = new Prontuario(historicoMedico, exames);
        // Atribui um ID único ao paciente, incrementando o contador estático.
        this.id = idCounter++;
    }

    // Método que retorna o ID do paciente.
    public int getId() {
        return id;
    }

    // Método que retorna o prontuário do paciente.
    public Prontuario getProntuario() {
        return prontuario;
    }

    // Método sobrescrito que retorna uma representação em string do paciente,
    // incluindo o ID, dados da pessoa e dados do prontuário.
    @Override
    public String toString() {
        return "ID: " + id + ", " + super.toString() + ", " + prontuario.toString();
    }
}
