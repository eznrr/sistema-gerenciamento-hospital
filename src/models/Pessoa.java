package models;

// Classe Pessoa representa uma entidade com atributos nome, idade e gênero
public class Pessoa {
    
    // Atributos privados da classe
    private String nome;   // Armazena o nome da pessoa
    private int idade;     // Armazena a idade da pessoa
    private String genero; // Armazena o gênero da pessoa

    // Construtor da classe Pessoa
    // Inicializa os atributos da pessoa ao criar um objeto dessa classe
    public Pessoa(String nome, int idade, String genero) {
        this.nome = nome;       // Inicializa o nome
        this.idade = idade;     // Inicializa a idade
        this.genero = genero;   // Inicializa o gênero
    }

    // Métodos de acesso (getters)
    // Retorna o nome da pessoa
    public String getNome() {
        return nome;
    }

    // Retorna a idade da pessoa
    public int getIdade() {
        return idade;
    }

    // Retorna o gênero da pessoa
    public String getGenero() {
        return genero;
    }

    // Sobrescreve o método toString() para retornar uma representação em texto dos atributos da pessoa
    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Gênero: " + genero;
    }
}
