package modelo;
import java.util.ArrayList;

public class Turma {
    
    private int codigo;
    private String disciplina;
    private ArrayList <Aluno> alunos = new ArrayList<Aluno>();
    private int numeroMaximoAluno;// número máximo de alunos que pode matricular
    
    public Turma (int codigo, String disciplina){
        this.codigo = codigo;
        this.disciplina = disciplina;
    }
    
    public Turma (int codigo, String disciplina, int numeroMaximoAluno){
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.numeroMaximoAluno = numeroMaximoAluno;
    }
    
    public String imprimirTurma(){
        return getCodigo()+ " - " + disciplina + "\nAlunos matriculados: " + alunos.size();
    }
    
    
    public int getNumMaxAluno(){
        return this.numeroMaximoAluno;
    }
    
    public void setNumMaxAluno(int numeroMaximoAluno){
        this.numeroMaximoAluno = numeroMaximoAluno;
    }
    
    public int getCodigo() {
        return this.codigo;
    }
    
    public String getDisciplina() {
        return disciplina;
    }
    
    public Aluno getAlunos(int c) {
        return alunos.get(c);
    }
    
    public int getQtdAluno () {
        return alunos.size();
    }
    
    public boolean matricular(Aluno aluno){    //inserir o aluno na lista de alunos da turma      
        for ( int c = 0; c < alunos.size(); c++) {
            if (alunos.get(c) == aluno) {
                return false;
            }
        }
        alunos.add(aluno);
        return true;
    }
}

