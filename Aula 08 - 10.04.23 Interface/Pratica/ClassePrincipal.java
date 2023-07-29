
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ClassePrincipal {
    public static void main (String args []) {
        ArrayList <Tributavel> tributos = new ArrayList();
        tributos.add(new Consultoria("Consultorio",1500));
        tributos.add(new Imovel (100000,20, "Avenida Jequitibara"));
        tributos.add(new ProfissionalAutonomo("Jonas Esticado","1053004012020","Avenida Edmundo Silveira Flores",1600));
        
        for ( int c = 0; c < tributos.size() ; c++) {
                JOptionPane.showMessageDialog(null,"Tipo de Imposto: " + tributos.get(c).getTipo() + "\nAliquota: " +tributos.get(c).getAliquota()+ "\nValor do Imposto: " + tributos.get(c).getValorImposto());  
        }

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    } /// main
} // classe principal
