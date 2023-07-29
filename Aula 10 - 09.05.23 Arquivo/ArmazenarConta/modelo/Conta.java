package modelo;


public class Conta {
    private int numero;
    private String cliente;
    private double saldo;
    
    //Construtores
    public Conta (int numero, String nome, double saldo){
        this.cliente=nome;
        this.numero=numero;
        this.saldo=saldo;
    }
    
    //Métodos
    public double getSaldo(){
        return saldo;
    }

    public boolean sacar(double valor){
        boolean ok=false;
        if (saldo >= valor){
            saldo = saldo - valor;
            ok=true;
        }
        return ok;
    }

    public void depositar(double valor){
        if ( valor>0 )
            saldo +=valor;
    }
        
    public void transferir (double valor, Conta c){
        if (valor <=this.saldo){
            this.sacar(valor);
            c.depositar(valor);
        }
    }
        
    public void setCliente (String nome){
        cliente = nome;
    }
    
   public String getCliente(){
        return cliente;
    }
        
    public int getNumero(){
        return numero;
    }
    
    @Override
    public String toString(){
        return "\nConta: " + numero +
        "\nCliente: " + cliente+
        "\nSaldo: " + saldo + "\n";
    }   
}
