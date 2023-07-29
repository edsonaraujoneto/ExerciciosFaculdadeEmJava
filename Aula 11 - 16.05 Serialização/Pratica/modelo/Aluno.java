package modelo;
import java.io.Serializable;

public class Aluno implements Serializable {
    private String nome;
    private String cpf;
    private int codigo;
    
    public Aluno (String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }
    
    public Aluno (String nome, int codigo, String cpf) {
        this.nome = nome;
        this.codigo = codigo;
        this.cpf = cpf;
    }

    public String getCpf () {
        return cpf;
    }
    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String imprimir () {
        return "Nome: " + this.getNome() + "\nCodigo: " + this.getCodigo() + "\nCPF: " + this.getCpf();
    }
    
}
