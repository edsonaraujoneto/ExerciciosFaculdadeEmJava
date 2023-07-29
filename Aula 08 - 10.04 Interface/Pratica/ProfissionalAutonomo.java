
public class ProfissionalAutonomo implements Tributavel {
    private String nome;
    private String cpf;
    private String endereco;
    private double remuneracao;
    private double salarioContribuicao;
    
    public ProfissionalAutonomo (String nome, String cpf, String endereco, double remuneracao) {
        this.nome = nome;
        this.cpf=cpf;
        this.endereco = endereco;
        this.remuneracao=remuneracao;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getRemuneracao() {
        return remuneracao;
    }
    
    public double getSalarioContribuicao() {
        return salarioContribuicao;
    }

    @Override
    public String getTipo() {
        return "INSS";
    }
    
    @Override
    public double getAliquota() {
        return 0.11;
    }
    
    @Override
    public double getValorImposto() {
        if (getSalarioContribuicao() <= 7507.49 ) {
            salarioContribuicao += getRemuneracao()*getAliquota();
            return getRemuneracao()*getAliquota();
        }
        else 
            return 0;
          
    }
    
    
}
