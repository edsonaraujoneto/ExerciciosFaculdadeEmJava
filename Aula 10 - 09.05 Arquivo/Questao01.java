
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Questao01 {
    public static void main(String[] args) {
        // ESCREVER
        File arquivo = new File("teste.txt"); //cria o arquivo no disco com o nome texte.txt
        try{
            FileWriter fw = new FileWriter(arquivo);// abre o arquivo para escrita
            fw.write("antes de existir computador existia tevê\nantes de existir tevê existia luz elétrica\nantes de existir luz elétrica existia bicicleta\n"+"antes de existir bicicleta existia enciclopédia\nantes de existir enciclopédia existia alfabeto\nantes de existir alfabeto existia a voz\nantes de existir a voz existia o silêncio"); // inseri texto no arquivo
            fw.close(); // fecha o arquivo
        }catch(IOException ex){
            ex.printStackTrace();
        }
        //LER
        try (FileReader fr = new FileReader (arquivo)) {
            BufferedReader br = new BufferedReader(fr);
            while (br.ready()){
                String linha = br.readLine();
                System.out.println(linha);
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }  
    } // main
} // questao 1
