package controle;

import modelo.*;
import java.util.ArrayList;

public class ControleProduto {

    private ArrayList <Produto> produtos = new ArrayList();
    
    public void cadastrarProduto(String nome, double preco){
        produtos.add(new Produto (nome, preco));
    }
    
    public void cadastrarProduto(String nome,double preco,String autor, int paginas){
        produtos.add(new Livro (nome, preco, autor, paginas));
    }
    
    public void cadastrarProduto (String nome, double preco,String autor, int paginas, String disciplina) {
        produtos.add(new LivroDidatico(nome,preco,autor,paginas,disciplina));
    }
    
    public Produto pesquisarProduto(int codigo){
        Produto p =null;
        for (int i=0; i<produtos.size(); i++){
            if (codigo == produtos.get(i).getCodigo()){
                p=produtos.get(i);
                break;
            }
        }
        return p;
    }
    
    public String imprimirProduto(int codigo){
        Produto p = pesquisarProduto(codigo);
        if (p!= null){
            return p.toString();
        }
        else
            return "Código inválido";
    }
            
    public boolean produtoEhCaro (int codigo){
        Produto p = pesquisarProduto(codigo);
        return p.ehCaro();
    }  
    
    public int quantidade () {
        return produtos.size();
    }
    
    public String getInformacao (int codigo) {
        Produto p = pesquisarProduto(codigo);
        if (p != null) {
            return "Nome: " + p.getNome() + " | Código: " + p.getCodigo();
        }
        else
            return "Código invalido";
    }
}
