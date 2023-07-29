package model;

import java.io.Serializable;

public class Item implements Serializable {
    IProduto produto;
    private int quantidade;
    private double subTotal;
        
    public Item(IProduto a, int quant) {
        produto = a;
        quantidade = quant;
        subTotal = a.getPreco()*quant;
    }
    
    public Item(IProduto a) {
        produto = a;
        quantidade = 1;
        subTotal = a.getPreco();
    }
    
    public double getSubTotal() {
        return subTotal;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade( int quant) {
        this.quantidade = quant;
    }
    
    public IProduto getProduto() {
        return produto;
    }
}
