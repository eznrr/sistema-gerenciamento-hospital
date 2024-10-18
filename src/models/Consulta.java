package models;

public class Consulta {
    private static int consultaCounter = 1;
    private int numeroConsulta;
    private String data;
    private Paciente paciente;
    private Medico medico;
    private String diagnostico;

    public Consulta(String data, Paciente paciente, Medico medico, String diagnostico) {
        this.numeroConsulta = consultaCounter++;
        this.data = data;
        this.paciente = paciente;
        this.medico = medico;
        this.diagnostico = diagnostico;
    }

    public int getNumeroConsulta() {
        return numeroConsulta;
    }

    public String getData() {
        return data;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    @Override
    public String toString() {
        return "Número da Consulta: " + numeroConsulta + ", Data: " + data + 
               ", Paciente: " + paciente.getNome() + " (ID: " + paciente.getId() + 
               "), Médico: " + medico.getNome() + " (ID: " + medico.getId() + 
               "), Diagnóstico: " + diagnostico;
    }
}
