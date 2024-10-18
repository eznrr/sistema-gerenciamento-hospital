package models;

public class Prontuario {
    private String historicoMedico;
    private String exames;

    public Prontuario(String historicoMedico, String exames) {
        this.historicoMedico = historicoMedico;
        this.exames = exames;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public String getExames() {
        return exames;
    }

    @Override
    public String toString() {
        return "Histórico Médico: " + historicoMedico + ", Exames: " + exames;
    }
}
