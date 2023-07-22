import javax.swing.JOptionPane;

public class TestaTurmaAluno {
    
    public static String menu(){
        return "Digite:\n" +
        "1 - Cadastrar aluno \n" +
        "2 - Cadastrar turma \n"+
        "3 - Matricular aluno na turma \n"+
        "4 - Listar alunos da turma\n"+
        "5 - Cadastrar disciplina\n"+
        "0 - para sair";
    }
    
    public static void main (String [] args) {
        
        int quantTurmas = 5;
        int contTurmas = 0;
        Turma turmas[] = new Turma [quantTurmas];
        
        int contAlunos = 0;
        Aluno alunos [] = new Aluno [100];
        
        int quantDisciplina = 5;
        int contadorDisciplina = 0;
        Disciplina disciplina[] = new Disciplina [quantDisciplina];
        
        int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu()));

        
        while (opcao != 0) {
            switch (opcao) {
                case 1: { // cadastrar aluno
                    String nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
                    alunos[contAlunos] = new Aluno (nome);
                    JOptionPane.showMessageDialog(null,"Bem vindo! " + alunos[contAlunos].getNome()+ " seu número de matrícula é: " + alunos[contAlunos].getMatricula());
                    ++contAlunos;      
                    break;
                }
                case 2: { // cadastrar turma
                    if (contTurmas <= quantTurmas) { // condição para criar turmas sem passar do limite
                        if (contadorDisciplina != 0) { // condição para analisar se tem disciplina cadastrada
                            String nomesDisciplinas="";
                            for ( int c = 0; c < contadorDisciplina; c++) {
                                nomesDisciplinas += disciplina[c].imprimir()+ "\n" ;
                            }
                            JOptionPane.showMessageDialog(null,"Disciplinas cadastradas: \n" + nomesDisciplinas);
                            
                            String lerDisciplina = JOptionPane.showInputDialog("Digite o código da disciplina escolhida: ");
                            int codigo = Integer.parseInt(lerDisciplina);
                            
                            for (int c = 0; c < contadorDisciplina; c++) { // para percorrer as disciplinas
                                if (codigo == disciplina[c].getCodigo()) { // condição para analisar se o código digitado é o mesmo da disciplina
                                    String pegarNumAlunos = JOptionPane.showInputDialog("Digite o número máximo de alunos: ");
                                    int numAlunos = Integer.parseInt(pegarNumAlunos);
                                    turmas[contTurmas] = new Turma (codigo,disciplina[c],numAlunos);
                                    JOptionPane.showMessageDialog(null,"Turma criada com sucesso! ");
                                    ++contTurmas;
                                    break;
                                }         
                            }    
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null,"Nenhuma disciplina registrada!");
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Número máximo de turmas criadas.");
                        break;
                    }
                }
                case 3: { // matricular aluno na turma
                    if (contAlunos !=0) { // condição para analisar se tem aluno cadastrado
                        if (contTurmas != 0) { // donição para analisar se tem turma criada 
                            String nomeDeAlunos="";
                            for (int c = 0; c < contAlunos;c++) { // estrutura para dar o nome de todos os alunos cadastrados
                                nomeDeAlunos +=  alunos[c].imprimir()+"\n";
                            }
                            JOptionPane.showMessageDialog(null, "Aluno(s) cadastrado(s): \n MATRÍCULA | NOME \n" + nomeDeAlunos);

                            String pedirMatricula = JOptionPane.showInputDialog("Digite o número de matricula do aluno: ");
                            int matricula = Integer.parseInt(pedirMatricula);

                            for ( int c = 0; c < contAlunos; c++) {
                                if (matricula == alunos[c].getMatricula()) { // condição para encontrar o aluno escolhido
                                    String nomeTurmas="";
                                    for (int d = 0 ; d < contTurmas; d++) {
                                        nomeTurmas += turmas[d].getCodigo()+ " | " + turmas[d].getDisciplina().getNome() + "\n";
                                    }
                                    
                                    String escolher = JOptionPane.showInputDialog("Qual código da turma que você quer cadastrar o aluno? \nCÓDIGO | DISCIPLINA \n" + nomeTurmas);
                                    int escolheu = Integer.parseInt(escolher);

                                    for (int e = 0; e < contTurmas ; e++) {
                                        if (escolheu == turmas[e].getCodigo()) {
                                            if (turmas[e].getQtdAluno()+1 <= turmas[e].getNumMaxAluno()){
                                                if (turmas[e].matricular(alunos[c])) {
                                                    JOptionPane.showMessageDialog(null,"Aluno matriculado com sucesso!");
                                                    break;
                                                } else {
                                                    JOptionPane.showMessageDialog(null,"O aluno já está matriculado!");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null,"A turma está cheia!");
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }    
                            }
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null,"Nenhuma turma criada!");
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Nenhum aluno cadastrado.");
                        break;
                    }  
                }
                case 4: { // listar alunos da turma
                    if (contTurmas != 0 ) {
                        String nomeTurmas="";
                        for (int d = 0 ; d < contTurmas; d++) {
                            nomeTurmas += turmas[d].getCodigo()+ " | " + turmas[d].getDisciplina().getNome() + "\n";
                        }                   

                        String escolher = JOptionPane.showInputDialog("Qual código da turma que você quer ver a lista dos alunos? \n CÓDIGO | DISCIPLINA \n" + nomeTurmas);
                        int escolheu = Integer.parseInt(escolher);           

                        for (int e = 0; e < contTurmas ; e++) {
                            if (escolheu == turmas[e].getCodigo()) {
                                JOptionPane.showMessageDialog(null,turmas[e].imprimir());
                                break;
                            }
                        }
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null,"Nenhum turma criada!");
                        break;
                    }
                }
                case 5: { // cadastrar disciplina
                    if ( contadorDisciplina <= quantDisciplina) {
                        String nomeDisciplina = JOptionPane.showInputDialog("Digite o nome da disciplina: ");
                        String lerCodigoDisciplina = JOptionPane.showInputDialog("Digite o código da disciplina! ");
                        int codigoDisciplina = Integer.parseInt(lerCodigoDisciplina);

                        disciplina[contadorDisciplina] = new Disciplina (nomeDisciplina,codigoDisciplina);
                        JOptionPane.showMessageDialog(null,"Disciplina criada com sucesso!");
                        ++contadorDisciplina;
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "número máximo de disciplinas cadastradas!");
                    }
                }
            }
        opcao = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        }
    }
}
 