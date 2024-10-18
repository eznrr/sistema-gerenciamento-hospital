package models;

/**
 * A classe Prontuario representa o registro de saúde de um paciente,
 * contendo o histórico médico e os exames realizados.
 */
public class Prontuario {
    
    // Atributo que armazena o histórico médico do paciente.
    private String historicoMedico;
    
    // Atributo que armazena os exames realizados pelo paciente.
    private String exames;

    /**
     * Construtor da classe Prontuario.
     * Inicializa um novo prontuário com o histórico médico e os exames fornecidos.
     * 
     * @param historicoMedico O histórico médico do paciente.
     * @param exames Os exames realizados pelo paciente.
     */
    public Prontuario(String historicoMedico, String exames) {
        this.historicoMedico = historicoMedico;
        this.exames = exames;
    }

    /**
     * Retorna o histórico médico do paciente.
     * 
     * @return O histórico médico.
     */
    public String getHistoricoMedico() {
        return historicoMedico;
    }

    /**
     * Retorna os exames realizados pelo paciente.
     * 
     * @return Os exames do paciente.
     */
    public String getExames() {
        return exames;
    }

    /**
     * Sobrescreve o método toString() para exibir as informações
     * do prontuário de forma legível.
     * 
     * @return Uma string contendo o histórico médico e os exames do paciente.
     */
    @Override
    public String toString() {
        return "Histórico Médico: " + historicoMedico + ", Exames: " + exames;
    }
}
