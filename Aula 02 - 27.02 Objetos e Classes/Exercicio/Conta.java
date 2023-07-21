
public class Conta {
    String nome ="", agencia ="",abertura="", deposito="", saque="";
    int numero;
    double saldo;
    
    public boolean sacar (double x) {
        if ( saldo >= x) {
            saldo -= x;
            saque += "\nSaque: " + x;
            return true;
        }
        else {
            return false;
        }
    }

    public void depositar (double y) {
        saldo += y;
        deposito += "\nDepósito: " + y;
    }

    public double calcularRendimento () {
        return saldo * 0.1;
    }

    public String imprime () {
        return "Conta número: " + numero
        + "\nTitular: " + nome
        + "\nSaldo: " + saldo
        +"\nData de abertura: " + abertura;
    }

    public String extrato () {
        return deposito
        + saque
        + "\n_________"
        + "\nSaldo: " + saldo;
    }
}
