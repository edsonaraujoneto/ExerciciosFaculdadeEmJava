import javax.swing.JOptionPane;

/*
2 - Escreva uma classe Data cuja instância (objeto) represente uma data. Esta classe deverá dispor
dos seguintes métodos:
 Construtor - define a data que determinado objeto (através de parâmetro), este método
verifica se a data está correta, caso não esteja a data é configurada como 01/01/0001
 Compara - recebe como parâmetro um outro objeto da Classe data, compare com a data
corrente e retorne:
 0 se as datas forem iguais;
 1 se a data corrente for maior que a do parâmetro;
 -1 se a data do parâmetro for maior que a corrente.
 getDia - retorna o dia da data
 getMes - retorna o mês da data
 getMesExtenso - retorna o mês da data corrente por extenso
 getAno - retorna o ano da data
 isBissexto - retorna verdadeiro se o ano da data corrente for bissexto e falso caso contrário
 clone - o objeto clona a si próprio, para isto, ele cria um novo objeto da classe Data com os
mesmos valores de atributos e retorna sua referência
*/

public class TestaData {

    public static void main (String [] args){
        Data hoje = new Data("10","03","2023");
        Data qualquer = new Data("32","05","2000");
    
        JOptionPane.showMessageDialog(null, "Hoje é o dia " + hoje.getDia() + " do mês de " + hoje.getMesExtenso() + " do ano de " + hoje.getAno());
        JOptionPane.showMessageDialog(null, "Após ser criada um objeto data com a seguinte data: 32/05/2000, foi atribuida a ela a seguinte data: " + qualquer.getDia()+"/"+qualquer.getMes()+"/"+qualquer.getAno());
        JOptionPane.showMessageDialog(null,"Se datas iguais = 0\nSe a data corrente for maior = 1 \nSe a data corrente for menor = -1");
        JOptionPane.showMessageDialog (null,"Comparando ambas datas, a resposta é: " + hoje.comparar(qualquer));
    
        Data igual = hoje.clonar();
                
        JOptionPane.showMessageDialog (null,"Após criar um clone da data de hoje, a resposta é: " + hoje.comparar(igual));
        
        Data bissexto = new Data ("10","10","2000");
        JOptionPane.showMessageDialog (null,"Todo mundo sabe que o ano "+bissexto.getAno()+" é bissexto, será mesmo?\nDEIXA QUE O PC RESPONDE");
        
        if(bissexto.isBissexto()) {
            JOptionPane.showMessageDialog(null,"SIM, é bissexto!");
        }
        else {
            JOptionPane.showMessageDialog(null,"NÃO,  não é bissexto!"); 
        }
        
    }
}
