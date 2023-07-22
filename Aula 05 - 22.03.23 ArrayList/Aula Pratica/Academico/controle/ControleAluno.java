package controle;
import java.util.ArrayList;
import modelo.Aluno;

public class ControleAluno {
    private ArrayList <Aluno> alunos = new ArrayList();
    
    public void cadastrarAluno (String nome, int matricula){
        Aluno a = new Aluno(nome, matricula);
        alunos.add(a);
    }

    public Aluno pesquisarAluno(int mat){
        Aluno a = null;
        for (int i = 0; i < alunos.size(); i++){
            if (mat == alunos.get(i).getMatricula()){
                a=alunos.get(i);
                break;
            }
        }
        return a;
    }
    
    public int getQtdAluno () {
        return alunos.size();
    }
    
    public String imprimirAlunos() { // imprimir nome de todos os alunos
        String nomeAlunos = "";
        for (int c = 0; c < alunos.size() ;c++) {
            Aluno a = alunos.get(c);
            nomeAlunos += a.imprimir() + "\n";
        }
        return nomeAlunos;
    }

}
