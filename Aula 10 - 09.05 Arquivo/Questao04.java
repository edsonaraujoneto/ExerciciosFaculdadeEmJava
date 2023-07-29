
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.FileReader;
import java.io.BufferedReader;

public class Questao04 {
    public static void main(String[] args) {
        String nome;
        long matricula;
        
        File arquivo = new File("aluno.txt");
        try (FileWriter fw = new FileWriter(arquivo,true)) {
            BufferedWriter bw = new BufferedWriter(fw);
            int op=1;
            while (op !=0){
                nome = JOptionPane.showInputDialog("Digite o nome do aluno");
                matricula = Long.parseLong(JOptionPane.showInputDialog("Digite a matricula do aluno"));
                bw.write (nome);
                bw.write ("\t" + matricula );
                bw.newLine();
                op = Integer.parseInt(JOptionPane.showInputDialog("Deseja cadastrar outro aluno?\n 1 - sim \n0 - não"));
            }
            bw.close();
        } catch (IOException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        } 
        
        try (FileReader fr = new FileReader (arquivo)) {
            BufferedReader br = new BufferedReader (fr);
            String linha ="";
            while (br.ready()) {
                linha += br.readLine() + "\n";
            }
            br.close();
            JOptionPane.showMessageDialog(null,linha);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
  


