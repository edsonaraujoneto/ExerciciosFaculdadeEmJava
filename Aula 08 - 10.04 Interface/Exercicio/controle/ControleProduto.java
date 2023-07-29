package controle;
import java.util.ArrayList;
import modelo.*;

public class ControleProduto {
    private ArrayList <IProduto> produtos = new ArrayList();
    
    public void cadastrarMotor(String marca, double custo, int codigo){
        produtos.add(new Motor (marca, custo,codigo));
    }
    
    public void cadastrarPneu (String marca,double custo,int codigo) {
        produtos.add(new Pneu(marca,custo,codigo));
    }
    
    public void cadastrarBanco (String marca, double custo,int codigo) {
        produtos.add(new Banco(marca,custo,codigo));
    }
        
    public IProduto pesquisarProduto(int codigo){
        IProduto p=null;
        for (int i=0; i<produtos.size(); i++){
            if (codigo == produtos.get(i).getCodigo()){
                p=produtos.get(i);
                break;
            }
        }
        return p;
    }  
    
    public int getQuantidade () {
        return produtos.size();
    }
    
}
