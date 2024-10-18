package models;

/**
 * Classe Medico herda de Pessoa e representa um médico com uma especialidade específica.
 */
public class Medico extends Pessoa {
    // Variável estática para gerar IDs únicos para cada médico.
    private static int idCounter = 1;
    // ID único para cada médico.
    private int id;
    // Especialidade do médico (ex: cardiologia, dermatologia, etc.).
    private String especialidade;

    /**
     * Construtor para inicializar um objeto Medico.
     * 
     * @param nome Nome do médico.
     * @param idade Idade do médico.
     * @param genero Gênero do médico.
     * @param especialidade Especialidade médica do profissional.
     */
    public Medico(String nome, int idade, String genero, String especialidade) {
        // Chama o construtor da classe pai (Pessoa) para inicializar nome, idade e gênero.
        super(nome, idade, genero);
        // Atribui um ID único ao médico e incrementa o contador.
        this.id = idCounter++;
        // Define a especialidade do médico.
        this.especialidade = especialidade;
    }

    /**
     * Retorna o ID único do médico.
     * 
     * @return ID do médico.
     */
    public int getId() {
        return id;
    }

    /**
     * Retorna a especialidade do médico.
     * 
     * @return Especialidade do médico.
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * Sobrescreve o método toString para fornecer uma representação em texto 
     * do objeto Medico, incluindo o ID, dados da pessoa e a especialidade.
     * 
     * @return String representando o médico.
     */
    @Override
    public String toString() {
        return "ID: " + id + ", " + super.toString() + ", Especialidade: " + especialidade;
    }
}
