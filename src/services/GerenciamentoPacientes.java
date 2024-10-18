package services;

import models.Paciente; // Importa a classe Paciente do pacote models
import utils.InputUtils; // Importa a classe InputUtils para auxiliar na leitura de entradas do usuário

import java.util.ArrayList; // Importa a classe ArrayList para armazenar os pacientes
import java.util.Scanner; // Importa a classe Scanner para leitura de entradas do usuário

public class GerenciamentoPacientes {
    // Lista para armazenar os pacientes cadastrados
    private ArrayList<Paciente> pacientes = new ArrayList<>();

    // Método principal para gerenciar pacientes
    public void gerenciar(Scanner scanner) {
        int opcao; // Variável para armazenar a opção escolhida pelo usuário
        do {
            System.out.println("\n--- Lista de Pacientes ---");
            // Verifica se a lista de pacientes está vazia
            if (pacientes.isEmpty()) {
                System.out.println("Nenhum paciente cadastrado.");
            } else {
                // Exibe todos os pacientes cadastrados
                for (Paciente paciente : pacientes) {
                    System.out.println(paciente);
                }
            }
            // Menu de opções
            System.out.println("\n1. Adicionar Paciente");
            System.out.println("2. Excluir Paciente");
            System.out.println("3. Voltar ao Menu");
            // Lê a opção escolhida pelo usuário
            opcao = InputUtils.lerOpcaoSubMenu(scanner);
            // Processa a opção escolhida
            switch (opcao) {
                case 1:
                    adicionarPaciente(scanner); // Chama o método para adicionar um paciente
                    break;
                case 2:
                    excluirPaciente(scanner); // Chama o método para excluir um paciente
                    break;
                case 3:
                    System.out.println("Voltando ao menu..."); // Mensagem ao voltar ao menu
                    break;
                default:
                    System.out.println("Opção inválida."); // Mensagem para opção inválida
            }
        } while (opcao != 3); // Continua até que o usuário escolha voltar ao menu
    }

    // Método para adicionar um paciente
    private void adicionarPaciente(Scanner scanner) {
        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine(); // Lê o nome do paciente
        int idade = InputUtils.lerInteiro(scanner, "Idade"); // Lê a idade do paciente
        System.out.print("Gênero: ");
        String genero = scanner.nextLine(); // Lê o gênero do paciente
        System.out.print("Histórico Médico: ");
        String historicoMedico = scanner.nextLine(); // Lê o histórico médico do paciente
        System.out.print("Exames: ");
        String exames = scanner.nextLine(); // Lê os exames do paciente

        // Cria um novo objeto Paciente com os dados informados
        Paciente paciente = new Paciente(nome, idade, genero, historicoMedico, exames);
        // Adiciona o paciente à lista
        pacientes.add(paciente);
        System.out.println("Paciente adicionado com sucesso!"); // Mensagem de sucesso
    }

    // Método para excluir um paciente
    private void excluirPaciente(Scanner scanner) {
        int id = InputUtils.lerInteiro(scanner, "ID do paciente a ser excluído"); // Lê o ID do paciente a ser excluído
        // Tenta remover o paciente da lista baseado no ID
        if (pacientes.removeIf(paciente -> paciente.getId() == id)) {
            System.out.println("Paciente excluído com sucesso!"); // Mensagem de sucesso
        } else {
            System.out.println("Paciente não encontrado."); // Mensagem caso o paciente não seja encontrado
        }
    }

    // Método para retornar a lista de pacientes
    public ArrayList<Paciente> getPacientes() {
        return pacientes; // Retorna a lista de pacientes
    }
}
