package com.mycompany.conta;

public class Conta {
    public String nome = "", agencia = "", abertura = "";
    public int numero;
    public double saldo;
    
    public boolean sacar (double valor) {
        if (valor <= saldo) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public double depositar (double valor) {
        return saldo + valor;
    }
}
