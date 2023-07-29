package modelo;

public class Motor implements IProduto {
    private int potencia;
    private int codigo;
    private String marca=""; 
    private double cilindro;
    private double custo; 
    
    public Motor (String marca,double custo, int codigo) {
        this.custo = custo;
        this.marca = marca;
        this.codigo = codigo;
    }
    public void setPotencia (int potencia) {
        this.potencia = potencia;
    }
    public void setCilindro (double cilindro) {
        this.cilindro = cilindro;
    }
    @Override
    public int getCodigo () {
        return codigo;
    }
    @Override
    public String getNome () {
        return marca; // adaptação *-*
    }
    @Override
    public double getCusto () {
        return custo;
    }
    public int getPotencia() {
        return potencia;
    }
    public double getCilindro() {
        return cilindro;
    }
    
}
