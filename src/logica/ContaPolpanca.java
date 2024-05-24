package logica;

public class ContaPolpanca extends Conta{

    public ContaPolpanca(Cliente cliente) {
        super(cliente);
    }
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Polpanca ===");
        super.imprimirExtrato();
    }
}
