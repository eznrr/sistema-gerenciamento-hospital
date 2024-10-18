package utils;

import java.util.InputMismatchException; // Importa a exceção para tratamento de entradas inválidas
import java.util.Scanner; // Importa a classe Scanner para leitura de entradas

public class InputUtils {

    // Método para ler a opção do menu principal
    public static int lerOpcaoMenuPrincipal(Scanner scanner) {
        int opcao = -1; // Inicializa a opção como -1 (não válida)
        boolean valido = false; // Controle para verificar se a entrada é válida

        // Loop até que uma opção válida seja fornecida
        while (!valido) {
            try {
                System.out.print("Selecione uma opção: "); // Solicita ao usuário que selecione uma opção
                opcao = scanner.nextInt(); // Lê a opção do usuário
                // Verifica se a opção está dentro do intervalo permitido
                if (opcao >= 1 && opcao <= 4) {
                    valido = true; // Marca como válido se estiver dentro do intervalo
                } else {
                    System.out.println("Opção inválida. Tente novamente."); // Mensagem de erro para opções fora do intervalo
                }
            } catch (InputMismatchException e) { // Captura exceção para entradas inválidas
                System.out.println("Entrada inválida. Digite um número."); // Mensagem de erro para entradas não numéricas
                scanner.nextLine(); // Limpa a entrada inválida
            }
        }
        return opcao; // Retorna a opção válida
    }

    // Método para ler a opção de um submenu
    public static int lerOpcaoSubMenu(Scanner scanner) {
        int opcao = -1; // Inicializa a opção como -1 (não válida)
        boolean valido = false; // Controle para verificar se a entrada é válida

        // Loop até que uma opção válida seja fornecida
        while (!valido) {
            try {
                System.out.print("Selecione uma opção: "); // Solicita ao usuário que selecione uma opção
                opcao = scanner.nextInt(); // Lê a opção do usuário
                scanner.nextLine(); // Consome a nova linha deixada pelo nextInt()
                // Verifica se a opção está dentro do intervalo permitido
                if (opcao >= 1 && opcao <= 3) {
                    valido = true; // Marca como válido se estiver dentro do intervalo
                } else {
                    System.out.println("Opção inválida. Tente novamente."); // Mensagem de erro para opções fora do intervalo
                }
            } catch (InputMismatchException e) { // Captura exceção para entradas inválidas
                System.out.println("Entrada inválida. Digite um número."); // Mensagem de erro para entradas não numéricas
                scanner.nextLine(); // Limpa a entrada inválida
            }
        }
        return opcao; // Retorna a opção válida
    }

    // Método para ler um número inteiro genérico
    public static int lerInteiro(Scanner scanner, String campo) {
        int numero = -1; // Inicializa o número como -1 (não válido)
        boolean valido = false; // Controle para verificar se a entrada é válida

        // Loop até que um número válido seja fornecido
        while (!valido) {
            try {
                System.out.print(campo + ": "); // Solicita ao usuário que insira um valor para o campo especificado
                numero = scanner.nextInt(); // Lê o número do usuário
                scanner.nextLine(); // Consome a nova linha deixada pelo nextInt()
                valido = true; // Marca como válido após a leitura
            } catch (InputMismatchException e) { // Captura exceção para entradas inválidas
                System.out.println("Entrada inválida. Digite apenas números."); // Mensagem de erro para entradas não numéricas
                scanner.nextLine(); // Limpa a entrada inválida
            }
        }
        return numero; // Retorna o número válido
    }
}
