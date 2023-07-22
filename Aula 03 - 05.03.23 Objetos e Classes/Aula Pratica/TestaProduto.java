
/*
1.Criar a classe Produto
2. Definir construtores para a classe Produtos (pelo menos dois construtores)
3. Definir os métodos getters e setters necessários a classe Produto
4. Crie uma classe principal para testar a sua classe Produto
*/
public class TestaProduto {
    public static void main (String[] args) {
        
        Produto p1;
        p1 = new Produto ();
        Produto p2 = new Produto ();
        
        p1.compraProduto(50);
        System.out.println(p1.getQuantidade());
        
        p2.setNome("coxinha");
        p2.compraProduto(100);
        p2.vendaProduto(2);
        System.out.println(p2.getQuantidade());
    }   
}
