package modelo;

public class LivroDidatico extends Livro {
    private String disciplina ="";
    
    public LivroDidatico(String nome, double preco,String autor, int paginas, String disciplina) {
        super(nome,preco,autor, paginas);
        this.disciplina = disciplina;
    }
    
    public boolean ehCaro(){
        boolean caro = false;
        if (this.getPreco()>200)
            caro = true;
        return caro;
    }      
    
    @Override
    public String toString () {
        return super.toString() +
        "\nDisciplina: " + getDisciplina();
    }

    public String getDisciplina() {
        return disciplina;
    }
    
}
