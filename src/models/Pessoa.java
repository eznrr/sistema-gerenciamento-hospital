package models;

public class Pessoa {
    private String nome;
    private int idade;
    private String genero;

    public Pessoa(String nome, int idade, String genero) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Idade: " + idade + ", Gênero: " + genero;
    }
}
