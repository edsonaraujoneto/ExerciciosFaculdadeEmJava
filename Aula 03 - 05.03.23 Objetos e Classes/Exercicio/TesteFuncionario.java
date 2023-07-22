import javax.swing.JOptionPane;

public class TesteFuncionario {
    public static String menu () {
        return "Bem vindo a empresa! "+
        "\n1. Trabalhar"+
        "\n2. Receber"+
        "\n3. Sair";
    }
    
    public static void main (String [] args) {
        Funcionario f1 = new Funcionario("Jonas","Engenheiro","105.555.550-05");
        Funcionario f2 = new Funcionario("Edson","Promotor","100.000.000-05","21.12.2021");
        f1.setDataAdmissao("01.02.2020");
        
        JOptionPane.showMessageDialog(null,"CURIOSIDADE! \nO primeiro funcionário da empresa foi " + f1.getNome() +", ele entrou na empresa no dia " + f1.getDataAdmissao());
        JOptionPane.showMessageDialog(null,"Nós pagamos " + f2.getValorHora() + " reais por hora! ");
        
        String opc = JOptionPane.showInputDialog(menu());
        int opcao = Integer.parseInt(opc);
        
        while (opcao != 3 && opcao <=2) { 
            switch (opcao) {
                case 1: 
                    String horas = JOptionPane.showInputDialog("Quantas horas você quer trabalhar? ");
                    double h = Double.parseDouble(horas);
                    f2.trabalhar(h);
                    break;
                case 2: 
                    if (f2.horasTrabalhadas()>0) {
                        JOptionPane.showMessageDialog(null, "Obrigado pelos serviços prestados. Tome seu salário: " + f2.receberPagamento());
                    } else {
                        JOptionPane.showMessageDialog(null,"Você ainda não trabalhou hoje!");
                    }
                    break;
                 }
            opc = JOptionPane.showInputDialog(menu());
            opcao = Integer.parseInt(opc);  
        }   
    }
}
