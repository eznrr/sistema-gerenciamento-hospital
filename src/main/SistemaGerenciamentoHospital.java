package main;

// Importa as classes de serviços para gerenciamento de médicos, pacientes e consultas
import services.GerenciamentoMedicos;
import services.GerenciamentoPacientes;
import services.GerenciamentoConsultas;
// Importa a utilidade para capturar entrada de dados
import utils.InputUtils;
import java.util.Scanner;

public class SistemaGerenciamentoHospital {
    
    // Instancia os gerenciadores de médicos e pacientes
    private static GerenciamentoMedicos gerMedicos = new GerenciamentoMedicos();
    private static GerenciamentoPacientes gerPacientes = new GerenciamentoPacientes();
    
    // Instancia o gerenciador de consultas, passando as listas de pacientes e médicos
    // Isso permite ao GerenciamentoConsultas manipular e acessar as listas já gerenciadas
    private static GerenciamentoConsultas gerConsultas = new GerenciamentoConsultas(gerPacientes.getPacientes(), gerMedicos.getMedicos());
    
    // Cria um Scanner para capturar entrada do usuário
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao; // Variável que vai armazenar a opção escolhida pelo usuário
        
        // Laço que exibe o menu principal até que o usuário escolha a opção de sair (opção 4)
        do {
            // Exibe o menu principal para o usuário
            System.out.println("\n--- Sistema de Gerenciamento Hospitalar ---");
            System.out.println("1. Médicos");
            System.out.println("2. Pacientes");
            System.out.println("3. Consultas");
            System.out.println("4. Sair");
            
            // Lê a opção do usuário com uma função utilitária (InputUtils)
            opcao = InputUtils.lerOpcaoMenuPrincipal(scanner);
            
            // Verifica a opção escolhida e executa a ação correspondente
            switch (opcao) {
                case 1:
                    // Chama o método de gerenciamento de médicos
                    gerMedicos.gerenciar(scanner);
                    break;
                case 2:
                    // Chama o método de gerenciamento de pacientes
                    gerPacientes.gerenciar(scanner);
                    break;
                case 3:
                    // Chama o método de gerenciamento de consultas
                    gerConsultas.gerenciar(scanner);
                    break;
                case 4:
                    // Encerra o programa
                    System.out.println("Saindo...");
                    break;
                default:
                    // Exibe uma mensagem de erro se a opção for inválida
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4); // Continua repetindo até o usuário escolher a opção 4
    }
}
