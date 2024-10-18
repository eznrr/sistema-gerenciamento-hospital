package main;

import services.GerenciamentoMedicos;
import services.GerenciamentoPacientes;
import services.GerenciamentoConsultas;
import utils.InputUtils;
import java.util.Scanner;

public class SistemaGerenciamentoHospital {
    private static GerenciamentoMedicos gerMedicos = new GerenciamentoMedicos();
    private static GerenciamentoPacientes gerPacientes = new GerenciamentoPacientes();
    private static GerenciamentoConsultas gerConsultas = new GerenciamentoConsultas(gerPacientes.getPacientes(), gerMedicos.getMedicos());  // Passa as listas para GerenciamentoConsultas
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- Sistema de Gerenciamento Hospitalar ---");
            System.out.println("1. Médicos");
            System.out.println("2. Pacientes");
            System.out.println("3. Consultas");
            System.out.println("4. Sair");
            opcao = InputUtils.lerOpcaoMenuPrincipal(scanner);
            switch (opcao) {
                case 1:
                    gerMedicos.gerenciar(scanner);
                    break;
                case 2:
                    gerPacientes.gerenciar(scanner);
                    break;
                case 3:
                    gerConsultas.gerenciar(scanner);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }
}
