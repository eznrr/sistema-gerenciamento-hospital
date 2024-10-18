package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {

    public static int lerOpcaoMenuPrincipal(Scanner scanner) {
        int opcao = -1;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Selecione uma opção: ");
                opcao = scanner.nextInt();
                if (opcao >= 1 && opcao <= 4) {
                    valido = true;
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
            }
        }
        return opcao;
    }

    public static int lerOpcaoSubMenu(Scanner scanner) {
        int opcao = -1;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print("Selecione uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();
                if (opcao >= 1 && opcao <= 3) {
                    valido = true;
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
            }
        }
        return opcao;
    }

    public static int lerInteiro(Scanner scanner, String campo) {
        int numero = -1;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(campo + ": ");
                numero = scanner.nextInt();
                scanner.nextLine();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
                scanner.nextLine();
            }
        }
        return numero;
    }
}
