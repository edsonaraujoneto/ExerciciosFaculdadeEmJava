
public class Produto {
    
    private String nome;
    private double precoCompra;
    private int quantidade=0;
    
    public Produto () {}
    
    public Produto (String nome) {
        this.nome = nome;
    }
    
    public Produto (String nome, int quantidade ) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public double obterPrecoVenda(){
        return getPrecoCompra() *2;
    }
    
    public void vendaProduto(int qtd){
        if (getQuantidade() >= qtd){
            setQuantidade(getQuantidade() - qtd);
         }
    }
    
    public void compraProduto(int qtd){
        setQuantidade(getQuantidade() + qtd);

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
