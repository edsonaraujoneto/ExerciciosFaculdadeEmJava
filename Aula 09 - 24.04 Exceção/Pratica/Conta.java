
public class Conta {
    private static int numero=0;
    private double saldo;
    
    public Conta (){
        ++numero;
        this.saldo=0;
    }

    public Conta (int numero, double saldo){
        this.numero=numero;
        this.saldo=saldo;
    }
    
    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor <= saldo){
            saldo -= valor;
        } 
        else {
            throw new SaldoInsuficienteException("Sem Saldo disponivel!");
        }
    }
    
    public void depositar(double valor){
        if (valor >0){
            saldo += valor;
        }
        else {
            throw new IllegalArgumentException("Valor de depósito inválido");
        }
    }    
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }
}