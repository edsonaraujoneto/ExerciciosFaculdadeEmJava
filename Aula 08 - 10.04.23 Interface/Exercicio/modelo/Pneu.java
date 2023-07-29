package modelo;

public class Pneu implements IProduto {
    private int codigo;
    private String especificacao;
    private double custo;
    private String marca;
    
    public Pneu (String marca, double custo, int codigo) {
        this.marca = marca;
        this.custo = custo;
        this.codigo = codigo;
    }
    
    @Override
    public int getCodigo() {
        return codigo;
    }
    @Override
    public String getNome(){
        return marca; // aconteceu uma adaptação aqui, já que provavelmente o nome do pneu é a marca
    }
    @Override
    public double getCusto() {
        return custo;
    }

    public String getEspecificacao() {
        return especificacao;
    }

    public void setEspecificacao(String especificacao) {
        this.especificacao = especificacao;
    }

}
