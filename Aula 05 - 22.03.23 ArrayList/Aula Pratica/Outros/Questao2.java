
import java.util.ArrayList;

public class Questao2 {
    public static void main(String[] args) {
        ArrayList<Pessoa> pessoas = new ArrayList();
        pessoas.add(new Pessoa("Fulano", 20));
        pessoas.add(new Pessoa("Beltrano", 18));
        pessoas.add(new Pessoa("Ciclano", 23));

        for (int i = 0; i < pessoas.size(); i++)
            System.out.println(pessoas.get(i).imprimir());
    }
}
