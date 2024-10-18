package services;

import models.Medico;  // Importa a classe Medico do pacote models
import utils.InputUtils;  // Importa a classe InputUtils do pacote utils

import java.util.ArrayList;  // Importa a classe ArrayList para utilizar uma lista dinâmica
import java.util.Scanner;  // Importa a classe Scanner para ler entradas do usuário

public class GerenciamentoMedicos {
    // Declara uma lista de médicos usando ArrayList
    private ArrayList<Medico> medicos = new ArrayList<>();

    // Método principal para gerenciar médicos
    public void gerenciar(Scanner scanner) {
        int opcao;  // Variável para armazenar a opção escolhida pelo usuário
        do {
            // Exibe a lista de médicos cadastrados
            System.out.println("\n--- Lista de Médicos ---");
            if (medicos.isEmpty()) {
                System.out.println("Nenhum médico cadastrado.");  // Mensagem se não houver médicos
            } else {
                // Itera sobre a lista de médicos e imprime seus detalhes
                for (Medico medico : medicos) {
                    System.out.println(medico);
                }
            }
            // Opções do menu
            System.out.println("\n1. Adicionar Médico");
            System.out.println("2. Excluir Médico");
            System.out.println("3. Voltar ao Menu");
            opcao = InputUtils.lerOpcaoSubMenu(scanner);  // Lê a opção escolhida pelo usuário
            
            // Executa a ação correspondente à opção escolhida
            switch (opcao) {
                case 1:
                    adicionarMedico(scanner);  // Chama o método para adicionar um médico
                    break;
                case 2:
                    excluirMedico(scanner);  // Chama o método para excluir um médico
                    break;
                case 3:
                    System.out.println("Voltando ao menu...");  // Mensagem de retorno ao menu
                    break;
                default:
                    System.out.println("Opção inválida.");  // Mensagem de opção inválida
            }
        } while (opcao != 3);  // Continua até que o usuário escolha voltar ao menu
    }

    // Método para adicionar um médico à lista
    private void adicionarMedico(Scanner scanner) {
        System.out.print("Nome do médico: ");
        String nome = scanner.nextLine();  // Lê o nome do médico
        int idade = InputUtils.lerInteiro(scanner, "Idade");  // Lê a idade do médico
        System.out.print("Gênero: ");
        String genero = scanner.nextLine();  // Lê o gênero do médico
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();  // Lê a especialidade do médico

        // Cria um novo objeto Medico com os dados coletados
        Medico medico = new Medico(nome, idade, genero, especialidade);
        medicos.add(medico);  // Adiciona o médico à lista
        System.out.println("Médico adicionado com sucesso!");  // Mensagem de sucesso
    }

    // Método para excluir um médico da lista
    private void excluirMedico(Scanner scanner) {
        int id = InputUtils.lerInteiro(scanner, "ID do médico a ser excluído");  // Lê o ID do médico a ser excluído
        // Tenta remover o médico com o ID informado
        if (medicos.removeIf(medico -> medico.getId() == id)) {
            System.out.println("Médico excluído com sucesso!");  // Mensagem de sucesso
        } else {
            System.out.println("Médico não encontrado.");  // Mensagem se o médico não for encontrado
        }
    }

    // Método para retornar a lista de médicos
    public ArrayList<Medico> getMedicos() {
        return medicos;  // Retorna a lista de médicos
    }
}
