package controle;

import java.util.ArrayList;
import modelo.Produto;

public class ControleProduto {
    ArrayList <Produto> produtos = new ArrayList();
    
    public void cadastrarProduto (String nome, double valor, int quantidade) {
        produtos.add(new Produto(nome,valor,quantidade));
    }
    
    public Produto pesquisarProduto (String nome) {
         for (int c = 0; c < produtos.size();c++) {
            if (nome.equals(produtos.get(c).getNome())) {
                return produtos.get(c);
            }
        }
        return null;       
    }
    
    public Produto pesquisarProduto (int codigo) {
        for (int c = 0; c < produtos.size();c++) {
            if (codigo == produtos.get(c).getCodigo()) {
                return produtos.get(c);
            }
        }
        return null;
    }
    
    public boolean comprarProduto (int codigo,int quantidade) {
        for (int c = 0; c < produtos.size();c++) {
            if (codigo == produtos.get(c).getCodigo()) {
                produtos.get(c).comprarProduto(quantidade);
                return true;
            }
        }
        return false;
    }
    
    public int getQuantidade () {
        return produtos.size();
    }
    
    public String imprimir (int c) {
        return produtos.get(c).imprimir();
    }
}
