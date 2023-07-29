package modelo;

public class Banco implements IProduto {
    private int codigo;
    private String marca;
    private double custo;
    private String posicao;
    private String material;
    
    public Banco (String marca, double custo, int codigo) {
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
        return marca;
    }
    @Override
    public double getCusto() {
        return custo;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
