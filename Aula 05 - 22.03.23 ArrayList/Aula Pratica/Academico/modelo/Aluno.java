package modelo;

public class Aluno {
    
    private String nome;
    private int matricula;
    private static int cont=0;
    
    public Aluno (String nome){
        this.nome=nome;
        matricula = ++cont;
    }
    
    public Aluno (String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public long getMatricula() {
        return matricula;
    }
    
    public String imprimir (){
        return this.getMatricula() + " | " + this.getNome();
    }
}
