package controle;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Conta;


public class ControleConta {
    
    public void cadastrarConta(int numero, String nome, double saldo){
        Conta conta = new Conta (numero, nome, saldo);
        armazenarConta(conta);
    }
    
    public void armazenarConta(Conta c){
        File arquivoConta = new File ("contas.dat");
        FileOutputStream fos;
        DataOutputStream dos=null;
        try {
            fos = new FileOutputStream (arquivoConta,true);
            dos = new DataOutputStream (fos);
            dos.writeInt(c.getNumero());
            dos.writeUTF(c.getCliente());
            dos.writeDouble(c.getSaldo());
            
            dos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();;
        }
        catch (IOException a) {
            a.printStackTrace();
        }     
    }
    
    public ArrayList<Conta> listarConta (){
      ArrayList <Conta> contas=new ArrayList();
      File arquivoConta = new File ("contas.dat");
      FileInputStream fis;
      DataInputStream dis=null;
        try {
            fis = new FileInputStream (arquivoConta);
            dis = new DataInputStream (fis);
            while (dis.available()>0){
                int numero = dis.readInt();
                String cliente = dis.readUTF();
                double saldo = dis.readDouble();
                contas.add(new Conta (numero, cliente, saldo));
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
                if (dis!=null)
                    try {
                        dis.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
        }
      return contas;
    }
    
    public Conta pesquisarConta(int numero){
        ArrayList <Conta> contas = listarConta();
        Conta conta = null;
        for (int i=0; i<contas.size(); i++){
            if (numero == contas.get(i).getNumero()){
                conta = contas.get(i);
                break;
            }
        }
        return conta;
    }    
}
