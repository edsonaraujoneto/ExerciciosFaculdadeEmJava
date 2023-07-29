
public class Funcionario extends Pessoa {
    private int matricula; private double salario;

    public Funcionario (String nome, String sobrenome, String cpf, int matricula, double salario) {
        super(nome,sobrenome,cpf);
        this.matricula = matricula;
        if ( salario > 0) {
            this.salario = salario;        
        }
    }
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    @Override
    public String toString () {
        return super.toString() + "\nMatricula: " + matricula + "\nSalario: " + salario;
    }
}
