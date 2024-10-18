package models;

// Classe que representa uma consulta médica
public class Consulta {
    // Contador estático para rastrear o número de consultas criadas
    private static int consultaCounter = 1;
    
    // Número da consulta individual
    private int numeroConsulta;
    
    // Data da consulta
    private String data;
    
    // Paciente envolvido na consulta (associado à classe Paciente)
    private Paciente paciente;
    
    // Médico responsável pela consulta (associado à classe Medico)
    private Medico medico;
    
    // Diagnóstico feito pelo médico durante a consulta
    private String diagnostico;

    // Construtor que inicializa a consulta com seus atributos e gera um número único para cada consulta
    public Consulta(String data, Paciente paciente, Medico medico, String diagnostico) {
        // Atribui o número da consulta e incrementa o contador estático para a próxima consulta
        this.numeroConsulta = consultaCounter++;
        this.data = data;
        this.paciente = paciente;
        this.medico = medico;
        this.diagnostico = diagnostico;
    }

    // Retorna o número da consulta
    public int getNumeroConsulta() {
        return numeroConsulta;
    }

    // Retorna a data da consulta
    public String getData() {
        return data;
    }

    // Retorna o paciente envolvido na consulta
    public Paciente getPaciente() {
        return paciente;
    }

    // Retorna o médico responsável pela consulta
    public Medico getMedico() {
        return medico;
    }

    // Retorna o diagnóstico dado na consulta
    public String getDiagnostico() {
        return diagnostico;
    }

    // Sobrescreve o método toString() para exibir as informações da consulta de forma legível
    @Override
    public String toString() {
        return "Número da Consulta: " + numeroConsulta + ", Data: " + data + 
               ", Paciente: " + paciente.getNome() + " (ID: " + paciente.getId() + 
               "), Médico: " + medico.getNome() + " (ID: " + medico.getId() + 
               "), Diagnóstico: " + diagnostico;
    }
}
