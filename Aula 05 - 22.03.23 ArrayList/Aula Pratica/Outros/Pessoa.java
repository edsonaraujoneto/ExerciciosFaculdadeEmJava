
public class Pessoa {
    private String nome;
    private int idade;
    
    public Pessoa(String nome, int idade) {
        this.nome = nome; this.idade = idade;
    }
    
    public String imprimir() {
        return nome + ", " + idade + " ano(s)";
    }
}
