package controller;

import data.DataSalgado;
import java.util.ArrayList;
import model.Salgado;

public class ControllerSalgado {
    private DataSalgado dataSalgado= new DataSalgado();
    
    public void cadastrarSalgado (String descricao, double preco){
        Salgado salgado = new Salgado (descricao, preco);
        dataSalgado.createSalgado(salgado); 
    }
    
    public Salgado pesquisarSalgado (String descricao) {
        return dataSalgado.readSalgado(descricao) ;
    }
    
    public ArrayList<Salgado> listarSalgados() {
        return (ArrayList <Salgado>)dataSalgado.getAllSalgados();
    }
    
    public void removerSalgado (Salgado salgado) {
        dataSalgado.deleteSalgado(salgado);
    }
    
    public void atualizarSalgado (Salgado salgado){
        dataSalgado.updateSalgado(salgado);
    }
    
    public String imprimir (){
        ArrayList<Salgado> salgados = listarSalgados();
        String resultado = "";
        for (int i=0; i< salgados.size(); i++){
            resultado += salgados.get(i).toString()+"\n";
        }
        return resultado;
    }
}