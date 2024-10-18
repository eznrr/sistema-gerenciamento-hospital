package services;

import models.Consulta;
import models.Medico;
import models.Paciente;
import utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoConsultas {
    // Listas que armazenam consultas, pacientes e médicos
    private ArrayList<Consulta> consultas = new ArrayList<>();
    private ArrayList<Paciente> pacientes;
    private ArrayList<Medico> medicos;

    // Construtor que inicializa as listas de pacientes e médicos
    public GerenciamentoConsultas(ArrayList<Paciente> pacientes, ArrayList<Medico> medicos) {
        this.pacientes = pacientes;
        this.medicos = medicos;
    }

    // Método principal para gerenciar consultas (menu)
    public void gerenciar(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Lista de Consultas ---");

            // Exibe todas as consultas cadastradas
            if (consultas.isEmpty()) {
                System.out.println("Nenhuma consulta cadastrada.");
            } else {
                for (Consulta consulta : consultas) {
                    System.out.println(consulta); // Exibe cada consulta
                }
            }

            // Exibe as opções de gerenciamento
            System.out.println("\n1. Agendar Consulta");
            System.out.println("2. Excluir Consulta");
            System.out.println("3. Voltar ao Menu");

            // Lê a opção do usuário
            opcao = InputUtils.lerOpcaoSubMenu(scanner);

            // Realiza a operação com base na escolha do usuário
            switch (opcao) {
                case 1:
                    agendarConsulta(scanner); // Agendar nova consulta
                    break;
                case 2:
                    excluirConsulta(scanner); // Excluir uma consulta
                    break;
                case 3:
                    System.out.println("Voltando ao menu...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3); // Continua até o usuário escolher voltar
    }

    // Método para agendar uma nova consulta
    private void agendarConsulta(Scanner scanner) {
        System.out.print("Data da consulta (dd/mm/aaaa): ");
        String data = scanner.nextLine(); // Lê a data da consulta

        // Exibe a lista de pacientes disponíveis
        System.out.println("\n--- Seleção de Pacientes ---");
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        } else {
            for (Paciente paciente : pacientes) {
                System.out.println("ID: " + paciente.getId() + ", Nome: " + paciente.getNome());
            }
        }

        // Lê o ID do paciente escolhido
        int idPaciente = InputUtils.lerInteiro(scanner, "ID do Paciente");
        Paciente paciente = buscarPacientePorId(idPaciente); // Busca o paciente pelo ID
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        // Exibe a lista de médicos disponíveis
        System.out.println("\n--- Seleção de Médicos ---");
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
            return;
        } else {
            for (Medico medico : medicos) {
                System.out.println("ID: " + medico.getId() + ", Nome: " + medico.getNome() + ", Especialidade: " + medico.getEspecialidade());
            }
        }

        // Lê o ID do médico escolhido
        int idMedico = InputUtils.lerInteiro(scanner, "ID do Médico");
        Medico medico = buscarMedicoPorId(idMedico); // Busca o médico pelo ID
        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        System.out.print("Diagnóstico: ");
        String diagnostico = scanner.nextLine(); // Lê o diagnóstico informado

        // Cria e adiciona uma nova consulta à lista
        consultas.add(new Consulta(data, paciente, medico, diagnostico));
        System.out.println("Consulta agendada com sucesso!");
    }

    // Método para buscar um paciente pelo ID
    private Paciente buscarPacientePorId(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) { // Compara o ID
                return paciente; // Retorna o paciente se encontrado
            }
        }
        return null; // Retorna null se não encontrado
    }

    // Método para buscar um médico pelo ID
    private Medico buscarMedicoPorId(int id) {
        for (Medico medico : medicos) {
            if (medico.getId() == id) { // Compara o ID
                return medico; // Retorna o médico se encontrado
            }
        }
        return null; // Retorna null se não encontrado
    }

    // Método para excluir uma consulta
    private void excluirConsulta(Scanner scanner) {
        int numeroConsulta = InputUtils.lerInteiro(scanner, "Número da consulta"); // Lê o número da consulta a ser excluída
        if (consultas.removeIf(consulta -> consulta.getNumeroConsulta() == numeroConsulta)) { // Remove se encontrar a consulta
            System.out.println("Consulta excluída com sucesso!");
        } else {
            System.out.println("Consulta não encontrada."); // Exibe mensagem se não encontrada
        }
    }
}
