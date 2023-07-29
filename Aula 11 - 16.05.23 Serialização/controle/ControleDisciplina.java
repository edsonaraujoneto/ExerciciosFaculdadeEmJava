package controle;
import dados.DisciplinaDados;
import modelo.Disciplina;
import java.util.ArrayList;

public class ControleDisciplina {
    DisciplinaDados disciplinaDados = new DisciplinaDados ();
    
    public void cadastrarDisciplina (String nome, int codigo, int ch){
        Disciplina disciplina = new Disciplina (nome,codigo,ch);
        disciplinaDados.cadastrarDisciplina(disciplina);
    }
    
    public Disciplina pesquisarDisciplina (int codigo) {
        return disciplinaDados.pesquisarDisciplina(codigo);
    }
    
    public ArrayList<Disciplina> listarDisciplina() {
        return disciplinaDados.listarDisciplinas();
    }
    
    public String imprimir(){
        String res="";
        ArrayList<Disciplina> disc = listarDisciplina();
        for (int i=0; i<disc.size(); i++){
        res += disc.get(i).imprimir() + "\n---------\n";
        }
        return res;
    }
}
