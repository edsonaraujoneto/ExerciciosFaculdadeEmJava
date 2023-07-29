
public class Professor extends Funcionario {
    private String disciplina =""; 
    
    public Professor (String nome, String sobrenome, String cpf, int matricula, double salario, String disciplina) {
        super(nome,sobrenome,cpf,matricula,salario+(salario*10)/100);
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
    
    @Override
    public String toString () {
        return super.toString() + 
        "\nDisciplina: " + getDisciplina();
    }
}
