package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;

public class DataPedido {
    String nomeArquivo = "Pedido.ser";
    
    public List<Pedido> getAllPedidos() {
        ArrayList <Pedido> pedidos = new ArrayList();
        FileInputStream fluxo;
        ObjectInputStream lerObj = null;
        try{
            fluxo = new FileInputStream(nomeArquivo);
            lerObj = new ObjectInputStream(fluxo);
            pedidos = (ArrayList<Pedido>)lerObj.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println ("Erro ao listar os pedidos");
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println ("Erro ao listar os pedidos");
        }
        return pedidos;
    }
    
        public void createPedido(Pedido pedido) {
          ArrayList <Pedido> pedidos = (ArrayList<Pedido>) getAllPedidos();
          pedidos.add(pedido);
          try{
             FileOutputStream fluxo = new FileOutputStream(nomeArquivo);
             ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
             escreverObj.writeObject(pedidos);
             escreverObj.close();
          
           } catch (FileNotFoundException ex) {
            System.out.println ("Erro ao cadastrar pedido");
           } catch (IOException ex) {
            System.out.println ("Erro ao cadastrar pedido");
        }
    }
        
    public Pedido readPedido(int numero) {
       ArrayList <Pedido> pedidos = (ArrayList<Pedido>) getAllPedidos();
       Pedido pedido=null;
         for (int i=0; i<pedidos.size(); i++){
             if (numero == pedidos.get(i).getNumero()){
                 pedido=pedidos.get(i);
                 break;
             }
         }
         return pedido;
    }
    
    public void updatePedido(Pedido pedido) {
        ArrayList <Pedido> pedidos = (ArrayList<Pedido>) getAllPedidos();
        boolean achou=false;
        for (int i=0; i<pedidos.size(); i++){
             if (pedido.getNumero()== pedidos.get(i).getNumero()){
                 pedidos.remove(i);
                 pedidos.add(pedido);
                 achou=true;
                 break;
             }
        }
        if (achou){
            atualizarArquivo(pedidos);
        }
    }
    
        public void deletePedido(Pedido pedido) {
        ArrayList <Pedido> pedidos = (ArrayList<Pedido>) getAllPedidos();
        boolean achou=false;
        for (int i=0; i<pedidos.size(); i++){
             if (pedido.getNumero()== pedidos.get(i).getNumero()){
                 pedidos.remove(i);
                 achou=true;
                 break;
             }
         }
        if (achou){
            atualizarArquivo(pedidos);
        } 
    }
    
    private void atualizarArquivo (ArrayList <Pedido> pedidos){
        try{
            FileOutputStream fluxo = new FileOutputStream(nomeArquivo);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(pedidos);
            escreverObj.close();
          
           } catch (FileNotFoundException ex) {
            System.out.println ("Erro ao atualizar pedido");
           } catch (IOException ex) {
            System.out.println ("Erro ao atualizar pedido");
        }
    }
}
