package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

public class Pedido implements Serializable{
    private static int numero = 0;
    private Date date;
    private double valorTotal;
    private ArrayList<Item> itens = new ArrayList();
    
    public Pedido(Item d) {
        Calendar c  = Calendar.getInstance();
        this.date = c.getTime();
        itens.add(d);
        ++numero;
    }
    
    public Pedido(ArrayList<Item> item) {
        Calendar c  = Calendar.getInstance();
        this.date = c.getTime();
        for(int cont = 0; cont < item.size(); cont++){
            itens.add(item.get(cont));
        }
        ++numero;
    }
    
    public Pedido (Date date, Item d) {
        this.date = date;
        itens.add(d);
        ++numero;
    }
    
    public double calcularValorTotal(){
        for(int cont = 0; cont < itens.size(); cont++) {
            valorTotal += itens.get(cont).getSubTotal();
        }
        return valorTotal;
    }
    
    public void addItem (Item c){
        itens.add(c);
    }
    
    public int getNumero(){
        return numero;
    }
}
