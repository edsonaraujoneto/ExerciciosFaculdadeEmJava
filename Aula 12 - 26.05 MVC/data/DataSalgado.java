package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import model.Salgado;


public class DataSalgado {
    String nomeArquivo = "salgados.ser";

    public List<Salgado> getAllSalgados() {
        ArrayList <Salgado> salgados = new ArrayList();
        FileInputStream fluxo;
        ObjectInputStream lerObj = null;
        try{
            fluxo = new FileInputStream(nomeArquivo);
            lerObj = new ObjectInputStream(fluxo);
            salgados = (ArrayList<Salgado>)lerObj.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println ("Erro ao listar os salgados");
        } catch (ClassNotFoundException | IOException ex) {
            System.out.println ("Erro ao listar os salgados");
        }
        return salgados;
    }
    
    public void createSalgado(Salgado salgado) {
          ArrayList <Salgado> salgados = (ArrayList<Salgado>) getAllSalgados();
          salgados.add(salgado);
          try{
             FileOutputStream fluxo = new FileOutputStream(nomeArquivo);
             ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
             escreverObj.writeObject(salgados);
             escreverObj.close();
          
           } catch (FileNotFoundException ex) {
            System.out.println ("Erro ao cadastrar salgado");
           } catch (IOException ex) {
            System.out.println ("Erro ao cadastrar salgado");
        }
    }
    
    public Salgado readSalgado(String descricao) {
       ArrayList <Salgado> salgados = (ArrayList<Salgado>) getAllSalgados();
       Salgado salgado=null;
         for (int i=0; i<salgados.size(); i++){
             if (descricao.equals(salgados.get(i).getDescricao())){
                 salgado=salgados.get(i);
                 break;
             }
         }
         return salgado;
    }

    public void updateSalgado(Salgado salgado) {
        ArrayList <Salgado> salgados = (ArrayList<Salgado>) getAllSalgados();
        boolean achou=false;
        for (int i=0; i<salgados.size(); i++){
             if (salgado.getDescricao().equals(salgados.get(i).getDescricao())){
                 salgados.remove(i);
                 salgados.add(salgado);
                 achou=true;
                 break;
             }
        }
        if (achou){
            atualizarArquivo(salgados);
        }
    }

    public void deleteSalgado(Salgado salgado) {
        ArrayList <Salgado> salgados = (ArrayList<Salgado>) getAllSalgados();
        boolean achou=false;
        for (int i=0; i<salgados.size(); i++){
             if (salgado.getDescricao().equals(salgados.get(i).getDescricao())){
                 salgados.remove(i);
                 achou=true;
                 break;
             }
         }
        if (achou){
            atualizarArquivo(salgados);
        } 
    }
    
    private void atualizarArquivo (ArrayList <Salgado> salgados){
        try{
            FileOutputStream fluxo = new FileOutputStream(nomeArquivo);
            ObjectOutputStream escreverObj = new ObjectOutputStream(fluxo);
            escreverObj.writeObject(salgados);
            escreverObj.close();
          
           } catch (FileNotFoundException ex) {
            System.out.println ("Erro ao atualizar salgado");
           } catch (IOException ex) {
            System.out.println ("Erro ao atualizar salgado");
        }
    }
    
}