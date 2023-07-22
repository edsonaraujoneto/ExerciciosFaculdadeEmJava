
public class Conta {
    private int numero;
    private Cliente cliente;
    private double saldo;
    private static int contConta = 0;
 
    public Conta (Cliente c) {
        this.cliente = c;
        ++contConta;
    }
    
    public Conta (Cliente c, double saldo) {
        this.cliente = c;
        this.saldo = saldo;
        ++contConta;
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
        return cliente.imprimir()
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
        return cliente.getNome();
    } 

    public double getSaldo() {
        return saldo;
    }
    
    public int getContConta() {
        return contConta;
    }

    public void setNumero(int numero) {
        this.numero = numero+1;
    }
   
}