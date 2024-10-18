package services;

import models.Paciente;
import utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoPacientes {
    private ArrayList<Paciente> pacientes = new ArrayList<>();

    public void gerenciar(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Lista de Pacientes ---");
            if (pacientes.isEmpty()) {
                System.out.println("Nenhum paciente cadastrado.");
            } else {
                for (Paciente paciente : pacientes) {
                    System.out.println(paciente);
                }
            }
            System.out.println("\n1. Adicionar Paciente");
            System.out.println("2. Excluir Paciente");
            System.out.println("3. Voltar ao Menu");
            opcao = InputUtils.lerOpcaoSubMenu(scanner);
            switch (opcao) {
                case 1:
                    adicionarPaciente(scanner);
                    break;
                case 2:
                    excluirPaciente(scanner);
                    break;
                case 3:
                    System.out.println("Voltando ao menu...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);
    }

    private void adicionarPaciente(Scanner scanner) {
        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();
        int idade = InputUtils.lerInteiro(scanner, "Idade");
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Histórico Médico: ");
        String historicoMedico = scanner.nextLine();
        System.out.print("Exames: ");
        String exames = scanner.nextLine();
        Paciente paciente = new Paciente(nome, idade, genero, historicoMedico, exames);
        pacientes.add(paciente);
        System.out.println("Paciente adicionado com sucesso!");
    }

    private void excluirPaciente(Scanner scanner) {
        int id = InputUtils.lerInteiro(scanner, "ID do paciente a ser excluído");
        if (pacientes.removeIf(paciente -> paciente.getId() == id)) {
            System.out.println("Paciente excluído com sucesso!");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    // Adicionar o método getPacientes para retornar a lista de pacientes
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
}
