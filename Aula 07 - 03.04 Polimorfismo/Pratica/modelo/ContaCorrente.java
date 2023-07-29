package modelo;

public class ContaCorrente extends Conta {
    double juros;
    
    public ContaCorrente (Cliente cliente,double saldo,double juros) {
        super(cliente,saldo);
        this.juros = juros;
    }
    
    @Override
    public boolean sacar(double valor) { 
        if (super.getSaldo() >= valor && valor > 0) {
            super.setSaldo(super.getSaldo() - valor - 0.10); // é retirado 10 centavos de cada saque
            super.historico.add("Sacou R$ "+valor);
            return true;
        } else {
            return false;
        }            
    }    
    
    @Override
    public String getTipo() {
        return "Conta Corrente";
    } 
    
}
