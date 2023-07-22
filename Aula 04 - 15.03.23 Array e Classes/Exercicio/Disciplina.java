public class Disciplina {
    
    private String nome;
    private int codigo;
    
    public Disciplina () {}
    
    public Disciplina (String nome, int codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public String imprimir () {
        return "Nome: " + nome + " | Código: " + codigo; 
    }
}
