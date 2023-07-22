import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {
    Scanner teclado = new Scanner (System.in);
    
    ArrayList impares = new ArrayList();
    impares.add(1); impares.add(3); impares.add(5); impares.add(13);
    impares.add ("casa");
    
    ArrayList pares = new ArrayList();
    pares.add(2); pares.add(4); pares.add(6);
    pares.add(new Date());
    
    int resposta;
    
    do {        
    System.out.println("Digite um número inteiro: ");
    int n1 = teclado.nextInt();
    
    if (n1%2 == 0) {
        pares.add(n1);
    } else {
        impares.add(n1);
    }
    
    System.out.println("Adicionar número? 1. SIM 2. NÃO");
    resposta = teclado.nextInt();
    } while (resposta == 1); // repetir o processo de adicionar até o usuário digitar 2
    
    System.out.println("Impares: ");
    for (int i = 0; i < impares.size(); i++) {
        if (impares.get(i).equals("casa")) {
            impares.remove(i); // como a questão pede pra usar remove sem especificar, 
        }                           // usei neste exemplo, retirando "casa" dos impares
        System.out.println(impares.get(i));
    }
    
    System.out.println("Pares:");
    for (int i = 0; i < pares.size(); i++) 
        System.out.println(pares.get(i));
    }
}
