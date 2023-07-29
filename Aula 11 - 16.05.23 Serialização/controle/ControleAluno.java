package controle;
import dados.AlunoDados;
import modelo.Aluno;
import java.util.ArrayList;


public class ControleAluno {
    AlunoDados alunoDados = new AlunoDados();
    
    public void cadastrarAluno (String nome, int codigo, String cpf){
        Aluno aluno = new Aluno (nome,codigo,cpf);
        alunoDados.cadastrarAluno(aluno);
    }
    
    public Aluno pesquisarAluno (int codigo) {
        return alunoDados.pesquisarAluno(codigo);
    }
    
    public ArrayList<Aluno> listarAlunos() {
        return alunoDados.listarAlunos();
    }
    
    public String imprimir(){
        String res="";
        ArrayList<Aluno> disc = listarAlunos();
        for (int i=0; i<disc.size(); i++){
            res += disc.get(i).imprimir() + "\n---------\n";
        }
        return res;
    }
}
