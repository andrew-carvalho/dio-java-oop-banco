package application;

import domain.entities.*;
import domain.enums.TipoConta;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite seu nome: ");
        String nomeCliente = scanner.nextLine();

        Cliente cliente = new Cliente(nomeCliente);

        System.out.println("Que tipo de conta deseja abrir? ");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        char resposta;
        do {
            resposta = scanner.next().charAt(0);
        } while (resposta != '1' && resposta != '2');

        System.out.println("Digite o saldo inicial da conta: ");
        double saldoInicial = scanner.nextDouble();

        Conta conta;
        if (resposta == '1') {
            System.out.println("Digite o limite da conta:");
            double limiteChequeEspecial = scanner.nextDouble();
            conta = new ContaCorrente(cliente, limiteChequeEspecial, saldoInicial);
        } else {
            conta = new ContaPoupanca(cliente, saldoInicial);
        }


        System.out.println("Digite o valor que deseja sacar? ");
        double valor = scanner.nextDouble();
        conta.sacar(valor);


        System.out.println("Digite o valor que deseja depositar? ");
        valor = scanner.nextDouble();
        conta.depositar(valor);

        conta.imprimirExtrato();

        System.out.println();

        Banco banco = new Banco("Itaú");
        banco.adicionaConta(conta);
        System.out.println(banco);
    }
}
