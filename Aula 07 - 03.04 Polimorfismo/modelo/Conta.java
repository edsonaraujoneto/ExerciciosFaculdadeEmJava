package modelo;

import java.util.ArrayList;

public abstract class Conta {
    private int numeroConta;
    private Cliente cliente;
    private double saldo;
    protected ArrayList <String> historico;
    private static int identificador;
    
    //Construtores
    public Conta (){
       numeroConta = ++identificador;
       historico = new ArrayList();
    }
    
    public Conta(Cliente cliente){
        numeroConta = ++identificador;
        this.cliente=cliente;
        saldo = 0.0;
        historico = new ArrayList();
    }
    public Conta (Cliente c, double saldo){
        numeroConta=++identificador; 
        this.cliente = c;
        this.saldo = saldo;   
        historico = new ArrayList();
    }
    
    // métodos
   
    public int getNumeroConta() {
        return numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void depositar (double valor){
        if (valor > 0){
            setSaldo(getSaldo() + valor);
            historico.add("Depositou R$ "+valor);
        }
    }
    public boolean sacar(double valor) {
        if (getSaldo() >= valor && valor > 0){
            setSaldo(getSaldo() - valor);
            historico.add("Sacou R$ "+valor);
            return true;
        }
        return false;
    }
    public double consultarSaldo() {
        return getSaldo();
    }
    
    public void setCliente(Cliente c){
        this.cliente = c;
    }
    
    public String mostrarHistorico(){
        String s = "";
        for(int i=0; i < historico.size(); i++)
            s = s + historico.get(i) + "\n";
        return s;
    }   
    
    @Override
    public String toString(){
        return "Numero: " + getNumeroConta() + 
                "\nSaldo: " + getSaldo()+
                "\nTipo de Conta: " + getTipo();
    }
    
    public abstract String getTipo();

}
