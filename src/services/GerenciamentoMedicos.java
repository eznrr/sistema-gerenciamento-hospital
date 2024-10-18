package services;

import models.Medico;
import utils.InputUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciamentoMedicos {
    private ArrayList<Medico> medicos = new ArrayList<>();

    public void gerenciar(Scanner scanner) {
        int opcao;
        do {
            System.out.println("\n--- Lista de Médicos ---");
            if (medicos.isEmpty()) {
                System.out.println("Nenhum médico cadastrado.");
            } else {
                for (Medico medico : medicos) {
                    System.out.println(medico);
                }
            }
            System.out.println("\n1. Adicionar Médico");
            System.out.println("2. Excluir Médico");
            System.out.println("3. Voltar ao Menu");
            opcao = InputUtils.lerOpcaoSubMenu(scanner);
            switch (opcao) {
                case 1:
                    adicionarMedico(scanner);
                    break;
                case 2:
                    excluirMedico(scanner);
                    break;
                case 3:
                    System.out.println("Voltando ao menu...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);
    }

    private void adicionarMedico(Scanner scanner) {
        System.out.print("Nome do médico: ");
        String nome = scanner.nextLine();
        int idade = InputUtils.lerInteiro(scanner, "Idade");
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        Medico medico = new Medico(nome, idade, genero, especialidade);
        medicos.add(medico);
        System.out.println("Médico adicionado com sucesso!");
    }

    private void excluirMedico(Scanner scanner) {
        int id = InputUtils.lerInteiro(scanner, "ID do médico a ser excluído");
        if (medicos.removeIf(medico -> medico.getId() == id)) {
            System.out.println("Médico excluído com sucesso!");
        } else {
            System.out.println("Médico não encontrado.");
        }
    }

    // Adicionar o método getMedicos para retornar a lista de médicos
    public ArrayList<Medico> getMedicos() {
        return medicos;
    }
}
