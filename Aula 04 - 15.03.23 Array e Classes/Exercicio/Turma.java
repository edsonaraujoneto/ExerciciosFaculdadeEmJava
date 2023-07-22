public class Turma {
    
    private int codigo;
    private Disciplina disciplina = new Disciplina();
    private Aluno alunos[] = new Aluno [1000];
    private int numeroMaximoAluno;
    private int contAlunos;
    
    public Turma (int codigo, Disciplina disciplina){
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.contAlunos = 0;
    }
    
    public Turma (int codigo, Disciplina disciplina, int numeroMaximoAluno){
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.numeroMaximoAluno = numeroMaximoAluno;
        this.contAlunos = 0;
    }
    
    public String imprimir(){
    return getCodigo()+ " - " + getDisciplina().getNome() + "\nAlunos matriculados: " + getQtdAluno();
    }
    
    public int getQtdAluno(){ //retorna o número de alunos (contAlunos) já matriculados na turma
        return this.contAlunos;
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
    
    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    public Aluno[] getAlunos() {
        return alunos;
    }
    
    public boolean matricular(Aluno aluno){    //inserir o aluno na lista de alunos da turma
        for (int c = 0; c < contAlunos; c++) {
            if (alunos[c].getNome().equals(aluno.getNome())) {
                return false;
            }
        }
        alunos[contAlunos] = aluno;
        ++contAlunos;
        return true;
    }
}

