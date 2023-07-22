
/* Vamos projetar uma classe jogador de futebol: O que um jogador conhece? O que um jogador sabe
fazer?
Crie o projeto time e dentro dele defina:
 A classe Jogador
 Uma outra classe para testar a classe Jogador. */

public class TestaJogador {
   public static void main (String[] args) {
       JogadorDeFutebol x = new JogadorDeFutebol();
       System.out.println("O nome do Jogador é: " + x.nome());
       System.out.println("O número de sua camisa é: " + x.camisa());
       System.out.println("Ele como como " + x.posicao());
   } 
}
