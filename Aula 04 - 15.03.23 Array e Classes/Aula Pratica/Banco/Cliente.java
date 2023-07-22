
public class Cliente {
       private long cpf;
       private String nome;
       private String endereco;
       
       public Cliente () {}
       
       public Cliente (String nome, long cpf) {
           this.nome = nome;
           this.cpf = cpf;
       }
       
       public Cliente (String nome, long cpf, String endereco) {
           this.nome  = nome;
           this.cpf = cpf;
           this.endereco = endereco;
       }

        public long getCpf() {
            return cpf;
        }

        public String getNome() {
            return nome;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }
        
        public String imprimir () {
            return "\nNome: " + nome+
            "\nCPF: " + cpf+
            "\nEndereço: " + endereco;          
        }
           
}
