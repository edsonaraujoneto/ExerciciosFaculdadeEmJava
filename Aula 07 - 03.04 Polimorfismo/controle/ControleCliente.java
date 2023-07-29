package controle;

import modelo.Cliente;
import java.util.ArrayList;

public class ControleCliente {
    
    private ArrayList <Cliente> clientes = new ArrayList();
    
    public void cadastrarCliente (String nome, long cpf){
        clientes.add(new Cliente(nome, cpf));
    }
    
    public Cliente pesquisarCliente(long cpf){
        Cliente c=null;
        for (Cliente cli : clientes){
            if (cli.getCpf()== cpf){
                c=cli;
                break;
            }
        }
        return c;
    }
    
    public int getNumClientes () {
        return clientes.size();
    }
       
}
