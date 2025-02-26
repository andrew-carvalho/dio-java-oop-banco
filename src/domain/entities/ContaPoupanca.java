package domain.entities;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente, double saldoInicial) {
        super(cliente, saldoInicial);
    }

    @Override
    public void sacar(double valor) {
        if (valor > this.saldo) {
            System.out.println("Saldo insuficiente");
            return;
        }
        this.saldo -= valor;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("==========================");
        System.out.println("Conta poupança: ");
        System.out.println(this);
        System.out.println("==========================");
    }
}
