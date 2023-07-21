package com.mycompany.conta;

import java.util.Scanner;

/* a) Crie o projeto Banco e defina a classe Conta com os atributos descritos acima e os seguintes métodos:
 sacar que recebe um valor como parâmetro e retira esse valor do saldo da conta
 depositar que recebe um valor como parâmetro e adiciona esse valor ao saldo da conta
b) Crie uma classe principal para testar a classe Conta;
c) Não deve ser permitido deixar o saldo da conta negativo. Alterar o método sacar para retornar
verdadeiro se o saque for realizado e falso caso contrário. Altere o main para informar ao cliente se o
saque foi ou não realizado. */

public class TestaConta {
    public static void main (String [] args) {
        
        Conta c1 = new Conta();
        
        c1.nome = "Danilo";
        c1.saldo = 100;
        
        Scanner input = new Scanner(System.in);
        System.out.println("Quanto você quer depositar?");
        double n1 = input.nextDouble();
        
        System.out.println("Agora seu saldo é: " + c1.depositar(n1));
        System.out.println("O nome da conta é: " + c1.nome);
        
        System.out.println("Quanto você quer sacar?");
        double n2 = input.nextDouble();
        
        if (c1.sacar(n2)) {
            System.out.println("Saque realizado com sucesso!");
        }
        else {
            System.out.println("Saldo insuficiente.");
        }
        
    } 
}

