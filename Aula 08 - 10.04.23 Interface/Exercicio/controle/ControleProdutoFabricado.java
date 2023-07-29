package controle;
import java.util.ArrayList;
import modelo.*;

public class ControleProdutoFabricado {
    private ArrayList <IProdutoFabricado> produtosFabricados = new ArrayList();
    
    public void cadastrar(String nome, String marca, int ano ){
        produtosFabricados.add(new Carro (nome, marca, ano));
    }
    
    public boolean inserirComponentes (IProduto produto, int codigo) { // inserir componentes no carro
        IProdutoFabricado p = pesquisarProduto(codigo);
        if (p != null) {
            p.setComponentes(produto);   
            return true;
        }
        return false;
    }
        
    public IProdutoFabricado pesquisarProduto(int codigo){
        IProdutoFabricado p=null;
        for (int i=0; i<produtosFabricados.size(); i++){
            if (codigo == produtosFabricados.get(i).getCodigo()){
                p=produtosFabricados.get(i);
                break;
            }
        }
        return p;
    }
    
    public int getQuantidade () {
        return produtosFabricados.size();
    }

}
