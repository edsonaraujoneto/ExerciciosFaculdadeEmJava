package modelo;

public class Item {
    private int quantidade=0;
    private Produto produto;
    
    public Item (Produto c) {
        this.produto = c;
    }
    
    public Item (Produto c, int quantidade) {
        this.produto = c;
        this.quantidade = quantidade;
        c.venderProduto(quantidade);
    }
    
    public double calcularSubTotal(){
        return quantidade*produto.getPrecoVenda();
    }
    
    public void setQuantidade (int quantidade) {
        this.quantidade = quantidade;
    }
    
    public int getQuantidade () {
        return this.quantidade;
    }
    
    public Produto getProduto(){
        return produto;
    }
    
    public int getCodigo () {
        return produto.getCodigo();
    }
    
    public String getNome () {
        return produto.getNome();
    }
    
    public double getPrecoVenda () {
        return produto.getPrecoVenda();
    }
    
    public String imprimir () {
        String retornar= this.getNome() + " | " + this.getQuantidade() + " | " + this.calcularSubTotal();
        return retornar;
    }
}
