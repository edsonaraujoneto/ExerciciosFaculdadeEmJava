package controle;

import java.util.ArrayList;
import modelo.*;


public class ControlePedido {
    ArrayList <Pedido> pedidos = new ArrayList();
    
    public void cadastrarPedido (int numero, String data) {
        pedidos.add(new Pedido(data,numero));
    }
    
    public boolean adicionarItem (int numeroPedido, Produto p, int quantidade) { // eu alterei pra boolean pra no main manipular ;)
        for (int c = 0; c < pedidos.size();c++) {
            if (numeroPedido == pedidos.get(c).getCodigo()) {
                pedidos.get(c).inserirItem(new Item (p,quantidade));
                return true;
            }
        }
        return false;
    }
    
    public Pedido pesquisarPedido (int numero) {
        for (int c = 0; c < pedidos.size();c++) {
            if (numero == pedidos.get(c).getCodigo()) {
                return pedidos.get(c);
            }
        }
        return null;       
    }
    
    public boolean removerPedido (int numero) { // eu alterei pra boolean pra no main manipular ;)
        for (int c = 0; c < pedidos.size();c++) {
            if (numero == pedidos.get(c).getCodigo()) {
                pedidos.remove(c);
                return true;
            }
        }  
        return false;
    }
    
    public String imprimirPedido (int numero) {
        for (int c = 0; c < pedidos.size();c++) {
            if (numero == pedidos.get(c).getCodigo()) {
                return pedidos.get(c).imprimir();
            }
        }
        return "Nenhum pedido encontrado!";            
    }
    
    public int getQuantidade () {
        return pedidos.size();
    }
}
