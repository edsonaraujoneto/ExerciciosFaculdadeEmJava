
public class Pedido {
    private int codigo;
    private String data;
    private Item[] itens;
    private int contItem=0;
    private static int geradorDeCodigo=0;
    
    public Pedido (String data){
        this.data=data;
        this.itens = new Item[10];
        this.codigo= ++geradorDeCodigo;
    }
    
    public void inserirItem(Item i){
        itens[contItem]=i;
        contItem++;
    }
    
    public double calcularTotalPedido(){
        double total=0;
        for (int c = 0; c < contItem; c++){
            total += itens[c].calcularSubTotal();
        }
        return total;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

   /* public String getItens() {
        String it = "Nenhum Pedido Feito";
        for (int c = 0; c < contItem;c++) {
            if (c==0) {
                it = "";
            }
        it +=itens[c].getCodigo() + "  |  "+ itens[c].getNome() + "\n";
        }
        return it;
    }*/
    
    public String imprimir () {
        String saida="\nNenhum Pedido Feito";
        if (contItem > 0) {
            saida = "\nPedido: "+codigo+"  --  "+data + "\n"+
            "\nCod | Nome | Qtd | Vl. Unit | SubtTotal\n";
            for (int cont = 0; cont < contItem; cont++){
                if (itens[cont]!=null) {
                     saida+= itens[cont].getCodigo() + "  |  " + itens[cont].getNome()+ "  |  "+ itens[cont].getQuantidade()+ "  |  " + itens[cont].getPrecoVenda() + "  |  " + itens[cont].calcularSubTotal() +"\n";
                }
            }
            saida+="______________________________________\n"+"Total: "+ calcularTotalPedido();
        }        
        return saida;

    }
}
