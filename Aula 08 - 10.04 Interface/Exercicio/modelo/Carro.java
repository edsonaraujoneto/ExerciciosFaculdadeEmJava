package modelo;
import java.util.ArrayList;

public class Carro implements IProdutoFabricado {
    
    ArrayList <IProduto> produtos = new ArrayList ();
    private int numeroComponentes=0,ano;
    private static int codigo = 0; 
    private String nome,marca, modelo;
    
    public Carro (String nome,String marca, int ano) {
        this.nome = nome;
        this.marca = marca;
        this.ano = ano;
        ++codigo;
    }
    
    @Override
    public void setComponentes (IProduto c) {
        produtos.add(c);
        ++numeroComponentes;
    }
    
    @Override
    public int getNumeroComponentes () {
        return numeroComponentes;
    }
    
    @Override
    public IProduto getComponentes(int index){
        return produtos.get(index);
    }
    
    @Override
    public int getCodigo () {
        return codigo;
    }
    
    @Override
    public String getNome () {
        return nome;
    }
    
    @Override
    public double getCusto () {
        double total=0;
        for (int c = 0; c < produtos.size(); c++) {
            total += produtos.get(c).getCusto();
        }
        return total;
    }

    public int getAno() {
        return ano;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
