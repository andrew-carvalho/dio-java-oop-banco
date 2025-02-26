package domain.entities;

public class ContaCorrente extends Conta {
    private final double limite;

    public ContaCorrente(Cliente cliente, double limiteComValorPositivo, double saldoInicial) {
        super(cliente, saldoInicial);
        this.limite = limiteComValorPositivo * -1;
    }

    @Override
    public void sacar(double valor) {
        if(this.saldo - valor < limite) {
            System.out.println("Limite excedido!");
            return;
        }
        this.saldo -= valor;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("==========================");
        System.out.println("Conta corrente: ");
        System.out.println(this);
        System.out.println("==========================");
    }
}
