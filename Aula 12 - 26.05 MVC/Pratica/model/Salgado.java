package model;

import java.io.Serializable;

public class Salgado implements IProduto, Serializable{
    private double preco;
    private String descricao;
    private int estoque;
    
    public Salgado (String descricao, double preco){
        this.preco=preco;
        this.descricao=descricao;
    }
    
    public Salgado (String descricao, double preco, int estoque){
        this.preco=preco;
        this.descricao=descricao;
        this.estoque=estoque;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    @Override
    public String toString (){
        return this.descricao +" - "+ this.preco;
    }
}