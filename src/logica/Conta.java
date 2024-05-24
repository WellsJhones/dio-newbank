package logica;

import javax.sound.midi.Sequence;
import java.lang.ref.Cleaner;

public class Conta {
    //atributes
    protected static int AGENGIA_PADRAO = 1;
    protected static int SEQUENCIAL = 1;

    private double saldo;
    private  int agencia;
    private int numero;
    private Cliente cliente;

      public Conta(Cliente cliente) {
            this.cliente = cliente;
            this.agencia =AGENGIA_PADRAO;
            this.numero = SEQUENCIAL++;
    }

    public void deposita(double valor) {
        this.saldo += valor;
    }

    public boolean saca(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean transfere(double valor, Conta destino) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            destino.deposita(valor);
            return true;
        } else {
            return false;
        }
    }

    public double getSaldo() {
        return this.saldo;
    }
    public void imprimirExtrato() {
        System.out.println("Titular: " + this.cliente.getNome());
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Numero: " + this.numero);
        System.out.println("Saldo: " + this.saldo);
    }
}
