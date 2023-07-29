package dados;
import modelo.Aluno;
import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.DataInputStream;

public class AlunoDados {
    
    public void cadastrarAluno (Aluno aluno) {
        File arquivoAluno = new File ("aluno.ser");
        FileOutputStream fos;
        DataOutputStream dos = null;
        try {
            fos = new FileOutputStream (arquivoAluno,true);
            dos = new DataOutputStream (fos);
            dos.writeUTF(aluno.getNome());
            dos.writeInt(aluno.getCodigo());
            dos.writeUTF(aluno.getCpf());
            dos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();;
        }
        catch (IOException a) {
            a.printStackTrace();
        } 
    }
    
    public ArrayList<Aluno> listarAlunos () {
        ArrayList<Aluno> alunos = new ArrayList();
        File arquivoAluno = new File ("aluno.ser");
        FileInputStream fis;
        DataInputStream dis = null;
        try {
            fis = new FileInputStream (arquivoAluno);
            dis = new DataInputStream (fis);
            while (dis.available()>0) {
                String nome = dis.readUTF();
                int codigo = dis.readInt();
                String cpf = dis.readUTF();
                alunos.add(new Aluno(nome,codigo,cpf));
            }
            dis.close();    
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException a) {
            a.printStackTrace();
        }
        return alunos;
    }
    
    public Aluno pesquisarAluno (int codigo) {
        ArrayList <Aluno> alunos = this.listarAlunos();
        Aluno pesquisa = null;
        for (int c = 0; c < alunos.size();c++) {
            if (codigo == alunos.get(c).getCodigo()) {
                pesquisa = alunos.get(c);
                break;
            }
        }
        return pesquisa;
    }
    
}
