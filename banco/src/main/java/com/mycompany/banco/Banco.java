/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.banco;
/**
 *
 * @author Florêncio
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Banco {
    private Map<String, Conta> contas = new HashMap<>();

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Cadastro de conta\n2. Login\n3. Sair");
            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    criarConta(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    System.out.println("====================");
                    System.out.println("Obrigado por usar nosso banco!");
                    System.out.println("====================");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    private void criarConta(Scanner scanner) {
        System.out.println("Digite o CPF:");
        String cpf = scanner.next();
        System.out.println("Digite a senha:");
        String senha = scanner.next();
        System.out.print("Digite seu nome: ");
        String nome = scanner.next();
        System.out.print("Digite seu sobrenome: ");
        String sobrenome = scanner.next();
        contas.put(cpf, new Conta(cpf, senha, nome, sobrenome));
        System.out.println("Conta criada com sucesso!");
    }
    private void login(Scanner scanner) {
        System.out.println("Digite o CPF:");
        String cpf = scanner.next();
        System.out.println("Digite a senha:");
        String senha = scanner.next();
        Conta conta = contas.get(cpf);
        if (conta != null && conta.getSenha().equals(senha)) {
            System.out.println("Login realizado com sucesso!");
            conta.menu(scanner);
        } else {
            System.out.println("CPF ou senha inválidos!");
        }
    }
    public static void main(String[] args) {
        new Banco().iniciar();
    }
}