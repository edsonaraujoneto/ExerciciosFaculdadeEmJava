package modelo;

import java.util.ArrayList;

public class Pedido {
    private int codigo;
    private String status;
    private String data;
    private ArrayList <Item> itens = new ArrayList();
    private static int geradorDeCodigo=0;
    
    public Pedido (String data, int numero) {
        this.data = data;
        this.codigo = numero;
    }
    
    public Pedido (String data){
        this.data=data;
        this.codigo= ++geradorDeCodigo;
    }
    
    public void inserirItem(Item i){
        itens.add(i);
    }
    
    public double calcularTotalPedido(){
        double total=0;
        for (int c = 0; c < itens.size(); c++){
            total += itens.get(c).calcularSubTotal();
        }
        return total;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    
    public String imprimir () {
        String saida="\nNenhum Pedido Feito";
        if (itens.size() > 0) {
            saida = "\nPedido: "+codigo+"  --  "+data + "\n"+
            "\nCod | Nome | Qtd | Vl. Unit | SubtTotal\n";
            for (int cont = 0; cont < itens.size(); cont++){
                if (itens.get(cont)!=null) {
                    saida+= itens.get(cont).getCodigo() + "  |  " + itens.get(cont).getNome()+ "  |  "+ itens.get(cont).getQuantidade()+ "  |  " + itens.get(cont).getPrecoVenda() + "  |  " + itens.get(cont).calcularSubTotal() +"\n";
                }
            }
            saida+="______________________________________\n"+"Total: "+ calcularTotalPedido();
        }        
        return saida;
    }
}
