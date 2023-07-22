import java.util.Scanner;

/* Escreva um programa que calcula a média das notas de um aluno. 
O programa deve solicitar o nome do aluno e as três notas, calcular a média e mostrar o nome do aluno e a média. */

public class Questao7 {
    public static void main(String[] args) {
	Scanner input = new Scanner (System.in);

	String nome;
	float n1 = 0;
			
        System.out.print("Digite seu nome: ");
        nome = input.nextLine();

        System.out.print("Digite as suas três notas: ");
        n1 = input.nextFloat();
        n1 += input.nextFloat();
        n1 += input.nextFloat();

        System.out.print("A média do aluno " + nome + " é: " + n1/3);
    }
}