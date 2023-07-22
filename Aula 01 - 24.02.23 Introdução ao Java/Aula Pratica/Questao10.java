import javax.swing.JOptionPane;

/* Escreva um programa que calcula a média das notas de um aluno. 
O programa deve solicitar o nome do aluno e as três notas, calcular a média e mostrar o nome do aluno e a média. */

public class Questao10 {		
    public static void main(String[] args){
        String nome="", nomeMaior="", nomeMenor="", nota="";
        float n1 = 0, mediatotal = 0, maior=-9999, menor=9999;

        for (int cont = 0; cont < 10; cont++){
            nome = JOptionPane.showInputDialog("Digite seu nome: ");
            n1 = Float.parseFloat(JOptionPane.showInputDialog("Digite sua nota: "));

            if (n1>maior){
                maior = n1;
                nomeMaior = nome;
            } else if(n1<menor){
                menor = n1;
                nomeMenor = nome;
            }
            mediatotal += n1;
        }

        JOptionPane.showMessageDialog(null, "A média dos alunos é " + (mediatotal/10));
        JOptionPane.showMessageDialog(null, "O aluno " + nomeMaior + " teve a maior nota: " + maior);
        JOptionPane.showMessageDialog(null, "O aluno " + nomeMenor + " teve a menor nota: " + menor);
    }	
}