package dados;
import modelo.Disciplina;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.DataInputStream;

public class DisciplinaDados {
    
    public void cadastrarDisciplina (Disciplina disciplina) {
        File arquivoDisciplina = new File ("disciplina.ser");
        FileOutputStream fos;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream (arquivoDisciplina,true);
            dos = new DataOutputStream (fos);
            dos.writeUTF(disciplina.getNome());
            dos.writeInt(disciplina.getCodigo());
            dos.writeInt(disciplina.getCargaHoraria());
            dos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();;
        }
        catch (IOException a) {
            a.printStackTrace();
        } 
    }
    
    public ArrayList<Disciplina> listarDisciplinas () {
        ArrayList<Disciplina> disciplinas = new ArrayList();
        File arquivoDisciplina = new File ("disciplina.ser");
        FileInputStream fis;
        DataInputStream dis = null;
        try {
            fis = new FileInputStream (arquivoDisciplina);
            dis = new DataInputStream (fis);
            while (dis.available()>0) {
                String nome = dis.readUTF();
                int codigo = dis.readInt();
                int cargaHoraria = dis.readInt();
                disciplinas.add(new Disciplina(nome,codigo,cargaHoraria));
            }
            dis.close();    
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException a) {
            a.printStackTrace();
        }
        return disciplinas;
    }
    
    public Disciplina pesquisarDisciplina (int codigo) {
        ArrayList <Disciplina> disciplinas = this.listarDisciplinas();
        Disciplina pesquisa = null;
        for (int c = 0; c < disciplinas.size();c++) {
            if (codigo == disciplinas.get(c).getCodigo()) {
                pesquisa = disciplinas.get(c);
                break;
            }
        }
        return pesquisa;
    }
}
