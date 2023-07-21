/* 
1 - Crie uma classe que representa os funcionários de uma empresa. Um funcionário deve saber seu
nome, cpf, horas trabalhadas, valor da hora trabalhada, cargo e data de admissão. Além disso, um
funcionário sabe fazer o cálculo do seu salário com base nas horas trabalhadas e o valor da hora.
 Encapsule o estado dos objetos;
 Defina construtores;
 Defina métodos setters e getters necessários;
 Escreva um programa principal para testar a classe funcionário.
*/
public class Funcionario {
    private String nome,cargo, dataAdmissao, cpf;
    private double horasTrabalhadas, valorHora=10.50;
    
   
    public Funcionario (String nome, String cargo, String cpf) {
        this.nome = nome;
        this.cargo = cargo;
        this.cpf = cpf; 
    }
    
    public Funcionario (String nome, String cargo, String cpf, String dataAdmissao) {
        this.nome = nome;
        this.cargo = cargo;
        this.dataAdmissao = dataAdmissao;
        this.cpf = cpf; 
    }
    
    public double receberPagamento () {
        double salario = horasTrabalhadas*valorHora;
        horasTrabalhadas = 0;
        return salario;
    }
    
    public void trabalhar (double horas) {
        horasTrabalhadas += horas;
    }
    
    public double horasTrabalhadas () {
        return this.horasTrabalhadas;
    }
    
    public double getValorHora () {
        return this.valorHora;
    }
    
    public String getNome () {
        return this.nome;
    }
    
    public String getCargo () {
        return this.cargo;
    }
    
    public String getDataAdmissao () {
        return this.dataAdmissao;
    }
    
    public String getCpf () {
        return this.cpf;
    }
    
    public void setDataAdmissao (String data) {
        this.dataAdmissao = data;
    }
    
}
