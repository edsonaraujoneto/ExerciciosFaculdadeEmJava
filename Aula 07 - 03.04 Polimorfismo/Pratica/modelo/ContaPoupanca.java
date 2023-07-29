package modelo;

public class ContaPoupanca extends Conta {
    double rendimento;
    
    public ContaPoupanca(Cliente cliente,double rendimento) {
        super(cliente);
        this.rendimento = rendimento;
    }

    public double calcularRendimento () { 
        super.setSaldo((super.getSaldo()*rendimento)+super.getSaldo());
        return rendimento;
    }
    
    @Override
    public String getTipo() {
        return "Conta Poupança";
    } 
}
