package services;

import models.Consulta;
import models.Medico;
import models.Paciente;
import utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoConsultas {
    private ArrayList<Consulta> consultas = new ArrayList<>();
    private ArrayList<Paciente> pacientes;
    private ArrayList<Medico> medicos;

    // Constructor recebe listas de pacientes e médicos
    public GerenciamentoConsultas(ArrayList<Paciente> pacientes, ArrayList<Medico> medicos) {
        this.pacientes = pacientes;
        this.medicos = medicos;
    }

    public void gerenciar(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Lista de Consultas ---");
            if (consultas.isEmpty()) {
                System.out.println("Nenhuma consulta cadastrada.");
            } else {
                for (Consulta consulta : consultas) {
                    System.out.println(consulta);
                }
            }
            System.out.println("\n1. Agendar Consulta");
            System.out.println("2. Excluir Consulta");
            System.out.println("3. Voltar ao Menu");
            opcao = InputUtils.lerOpcaoSubMenu(scanner);
            switch (opcao) {
                case 1:
                    agendarConsulta(scanner);
                    break;
                case 2:
                    excluirConsulta(scanner);
                    break;
                case 3:
                    System.out.println("Voltando ao menu...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);
    }

    private void agendarConsulta(Scanner scanner) {
        System.out.print("Data da consulta (dd/mm/aaaa): ");
        String data = scanner.nextLine();

        // Exibir lista de pacientes
        System.out.println("\n--- Seleção de Pacientes ---");
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        } else {
            for (Paciente paciente : pacientes) {
                System.out.println("ID: " + paciente.getId() + ", Nome: " + paciente.getNome());
            }
        }

        int idPaciente = InputUtils.lerInteiro(scanner, "ID do Paciente");
        Paciente paciente = buscarPacientePorId(idPaciente);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        // Exibir lista de médicos
        System.out.println("\n--- Seleção de Médicos ---");
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
            return;
        } else {
            for (Medico medico : medicos) {
                System.out.println("ID: " + medico.getId() + ", Nome: " + medico.getNome() + ", Especialidade: " + medico.getEspecialidade());
            }
        }

        int idMedico = InputUtils.lerInteiro(scanner, "ID do Médico");
        Medico medico = buscarMedicoPorId(idMedico);
        if (medico == null) {
            System.out.println("Médico não encontrado.");
            return;
        }

        System.out.print("Diagnóstico: ");
        String diagnostico = scanner.nextLine();

        // Criar e adicionar consulta
        consultas.add(new Consulta(data, paciente, medico, diagnostico));
        System.out.println("Consulta agendada com sucesso!");
    }

    private Paciente buscarPacientePorId(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    private Medico buscarMedicoPorId(int id) {
        for (Medico medico : medicos) {
            if (medico.getId() == id) {
                return medico;
            }
        }
        return null;
    }

    private void excluirConsulta(Scanner scanner) {
        int numeroConsulta = InputUtils.lerInteiro(scanner, "Número da consulta");
        if (consultas.removeIf(consulta -> consulta.getNumeroConsulta() == numeroConsulta)) {
            System.out.println("Consulta excluída com sucesso!");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }
}
