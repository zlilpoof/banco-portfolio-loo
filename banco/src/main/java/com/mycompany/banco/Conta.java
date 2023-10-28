/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banco;
/**
 *
 * @author Florêncio
 */
import java.util.Scanner;

class Conta {
    private String cpf;
    private String senha;
    private String nome;
    private String sobrenome;
    private double saldo;

    public Conta(String cpf, String senha, String nome, String sobrenome) {
        this.cpf = cpf;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getSenha() {
        return senha;
    }

    public void menu(Scanner scanner) {
        while (true) {
            System.out.println("Olá, " + nome + " " + sobrenome + "!");
            System.out.println("====================");
            System.out.println("1. Depósito\n2. Saque\n3. Saldo\n4. Sair");
            System.out.print("Digite a opção desejada: ");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    depositar(scanner);
                    System.out.println("====================");
                    break;
                case 2:
                    sacar(scanner);
                    System.out.println("====================");
                    break;
                case 3:
                    System.out.println("Saldo: " + saldo);
                    System.out.println("====================");
                    break;
                case 4:
                    System.out.println("Logout realizado com sucesso!");
                    System.out.println("====================");
                    return;
                default:
                    System.out.println("Opção inválida!");
                    System.out.println("====================");
            }
        }
    }

    private void depositar(Scanner scanner) {
        System.out.println("Digite o valor do depósito:");
        double valor = scanner.nextDouble();
        saldo += valor;
        System.out.println("Depósito realizado com sucesso!");
    }

    private void sacar(Scanner scanner) {
    System.out.println("Digite o valor do saque:");
    double valor = scanner.nextDouble();
    if (valor < 0) {
        System.out.println("Valor de saque inválido!");
    } else if (valor <= saldo) {
        saldo -= valor;
        System.out.println("Saque realizado com sucesso!");
    } else {
        System.out.println("Saldo insuficiente!");
        }
    }
}