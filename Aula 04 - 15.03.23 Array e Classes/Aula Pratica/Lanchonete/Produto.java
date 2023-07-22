public class Produto {
    
    private int codigo;
    private String nome;
    private String descricao;
    private String tipo;
    private double valor;
    private int quantidade;
    private static int numProdutos=0;
   
    public Produto(String nome){
       this.nome=nome;
       codigo = ++numProdutos;
    }
    
    public Produto(String nome, double valor){
       this.nome=nome;
       this.valor=valor;
       codigo = ++numProdutos;
    }
    
    public Produto(String nome, double valor, int quantidade){
       this.nome=nome;
       this.valor=valor;
       this.quantidade=quantidade;
       codigo = ++numProdutos;
    }
    
    public double getPrecoVenda(){
	return valor *2;
    }
    
    public boolean venderProduto(int qtd){
        boolean temProduto=false;
        if (getQuantidade() >= qtd){
            quantidade  = getQuantidade() - qtd;
            temProduto=true;
	}
        return temProduto;
    }
    
    public void comprarProduto(int qtd){
	quantidade  = getQuantidade() + qtd;
    }
    
    public String imprimir (){
        return getCodigo() + " | " + getNome();
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

}
