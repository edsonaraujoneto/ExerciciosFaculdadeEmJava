
public class Pessoa {
    private String nome = "";
    private String sobrenome = "";
    private String cpf = "";
    
    public Pessoa (){}
    
    public Pessoa ( String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }
    
    public String getNomeCompleto(){
        return getNome() + " " + getSobrenome();
    }
    
    @Override
    public String toString() {
        return  getNomeCompleto() +
        "\nCPF: " + getCpf();
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }
    
    
}

