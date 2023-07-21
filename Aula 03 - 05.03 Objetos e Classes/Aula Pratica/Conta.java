
public class Conta {
    private int numero;
    private String cliente;
    private double saldo;
 
    public Conta (String nome) {
        this.cliente = nome;
    }
    
    public Conta (String nome, double saldo) {
        this.cliente = nome;
        this.saldo = saldo;
    }
    
    boolean sacar(double valor){
        boolean sacou=false;
        if (getSaldo() >= valor){
            saldo = getSaldo() - valor;
            sacou=true;
        }
        return sacou;
    }

    void depositar(double valor){
        if ( valor>0 )
            saldo +=valor;
    } 
        
    String imprimir () {
        return "Nome: " + cliente
        + "\nNúmero: " + numero+1
        + "\nSaldo: " + saldo;
    } 
    
    boolean transferir(double valor, Conta outra) {
        if (valor<=saldo) {
            this.sacar(valor);
            outra.depositar(valor);
            return true;
        } else {
            return false;
        }
    }
    
    boolean comparar (Conta outra){
        if (this.saldo == outra.getSaldo()) {
            return true;
        } else {
            return false;
        }
    }

    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }
}