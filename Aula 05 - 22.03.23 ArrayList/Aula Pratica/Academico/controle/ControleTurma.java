package controle;

import modelo.*;
import java.util.ArrayList;

public class ControleTurma {
    ArrayList <Turma> turmas = new ArrayList();

    public void cadastrarTurma (int codigo, String disciplina, int maximoAlunos) {
        Turma a = new Turma (codigo,disciplina,maximoAlunos);
        turmas.add(a);
    }
    
    public Turma pesquisarTurma (int codigo) {
        Turma a = null;
        for ( int c = 0; c < turmas.size(); c++) {
            if (codigo == turmas.get(c).getCodigo()) {
                a = turmas.get(c);
                break;
            }
        }
        return a;
    }

    public void matricularAluno (Aluno aluno, int codigo) {
        for ( int c = 0 ; c < turmas.size(); c++)
            if (turmas.get(c).getCodigo() == codigo) {
                turmas.get(c).matricular(aluno);
                break;
            }
    }

    public String listarAlunos (int codigo) { // recebe código como parametro
        for ( int c = 0 ; c < turmas.size(); c++) { // percorre toda a turma
            if (turmas.get(c).getCodigo()== codigo) { // condição para achar a turma escolhida pelo codigo passado
                String listaAlunos="";
                for ( int d = 0 ; d < turmas.get(c).getQtdAluno(); d++) { // estrutura de repetição para listar todos os alunos
                    Aluno a = turmas.get(c).getAlunos(d); // Um objeto aluno é criado pegando o aluno da turma;
                    listaAlunos += a.getNome() +  " | " + a.getMatricula() +  "\n"; // o aluno é adicionado a lista
                }
                return "Nome | Matricula \n " + listaAlunos;
            }
        }
        return "Nenhuma sala encontrada";
    }
    
    public int getQtdTurma () {
        return turmas.size();
    }
    
    public String imprimirTurmas() {
        String nomeTurmas = "";
        for (int c = 0; c < turmas.size() ;c++) {
            Turma a = turmas.get(c);
            nomeTurmas += "Código: " + a.getCodigo() + " | Disciplina: " + a.getDisciplina()+ "\n";
        }
        return nomeTurmas;
    }
      
}
