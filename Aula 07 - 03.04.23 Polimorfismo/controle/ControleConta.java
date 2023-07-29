package controle;

import java.util.ArrayList;
import modelo.*;

public class ControleConta {
    
    ArrayList <Conta> contas = new ArrayList();
    
    public void cadastrarConta (Cliente c, double saldo, double juros) {
        contas.add(new ContaCorrente(c,saldo,juros));
    }
    
    public void cadastrarConta (Cliente c,double rendimento) {
        contas.add(new ContaPoupanca(c,rendimento));
    }
    
    public Conta pesquisarConta(int num){
        Conta c = null;
        for (int i=0; i<contas.size(); i++){
            if (num == contas.get(i).getNumeroConta()){
                c=contas.get(i);
                break;
            }
        }
        return c;
    }
    
    public String mostrarHistorico(int num){
        Conta c = pesquisarConta(num);
        return c.mostrarHistorico();
    }
    
    public String imprimirContas (){
        String resultado="";
        for (int i=0; i<contas.size(); i++){
            resultado += contas.get(i).toString() + "\n--------\n";
        }  
        return resultado;
    }
    
    public void depositar (int num, double valor){
        Conta c = pesquisarConta(num);
        c.depositar(valor);
    }
    
    public boolean sacar (int num, double valor){
        Conta c = pesquisarConta(num);
        return c.sacar(valor);
    }
    
    public double consultarSaldo (int num){
        Conta c = pesquisarConta(num);
        return c.consultarSaldo();
    }    
    
    public int getNumContas () {
        return contas.size();
    }
}
