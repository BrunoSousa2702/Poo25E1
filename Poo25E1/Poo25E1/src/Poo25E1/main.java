package Poo25E1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gerir gerir = new Gerir();

        System.out.println("=== Plataforma E-learning Sustentabilidade ===");

        while (true) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Registar Utilizador");
            System.out.println("2. Adicionar Módulo ODS (Admin)");
            System.out.println("3. Remover Módulo ODS (Admin)");
            System.out.println("4. Adicionar Perguntas a um Módulo (Admin)");
            System.out.println("5. Fazer Quiz (Estudante)");
            System.out.println("6. Consultar Progresso (Estudante)");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = -1;
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println("Por favor, insira um número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    
                    System.out.println("=== Registar Utilizador ===");
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Password: ");
                    String password = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Tipo (Estudante/Admin): ");
                    String tipo = scanner.nextLine();

                    if (tipo.equalsIgnoreCase("Estudante")) {
                        System.out.print("Número do aluno: ");
                        int numAluno = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Universidade: ");
                        String universidade = scanner.nextLine();

                        Estudante est = new Estudante(nome, password, email, tipo, numAluno, universidade);
                        gerir.registarUtilizador(est);
                    } else if (tipo.equalsIgnoreCase("Admin")) {
                        Utilizador admin = new Utilizador(nome, password, email, tipo);
                        gerir.registarUtilizador(admin);
                    } else {
                        System.out.println("Tipo inválido, tente novamente.");
                    }
                    break;

                case 2:
                    
                    System.out.println("=== Adicionar Módulo ODS ===");
                    System.out.print("Email do utilizador que está a adicionar (deve ser admin): ");
                    String emailAdminCriar = scanner.nextLine();
                    Utilizador adminCriar = gerir.buscarUtilizadorPorEmail(emailAdminCriar);

                    if (adminCriar == null || !adminCriar.getTipo().equalsIgnoreCase("Admin")) {
                        System.out.println("Apenas admins podem adicionar módulos.");
                        break;
                    }

                    System.out.print("Número do ODS (1-17): ");
                    int odsNum = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome do ODS: ");
                    String odsNome = scanner.nextLine();
                    System.out.print("Descrição do ODS: ");
                    String odsDescricao = scanner.nextLine();
                    System.out.print("Meta do ODS: ");
                    String odsMeta = scanner.nextLine();

                    ModuloODS modulo = new ModuloODS(odsNum, odsNome, odsDescricao, odsMeta);
                    gerir.adicionarModulo(modulo);
                    break;

                case 3:
                   
                    System.out.println("=== Remover Módulo ODS ===");
                    System.out.print("Email do Admin que está a remover: ");
                    String emailAdminRemover = scanner.nextLine();
                    Utilizador adminRemover = gerir.buscarUtilizadorPorEmail(emailAdminRemover);

                    if (adminRemover == null || !adminRemover.getTipo().equalsIgnoreCase("Admin")) {
                        System.out.println("Apenas admins podem remover módulos.");
                        break;
                    }

                    System.out.print("Nome do Módulo a remover: ");
                    String nomeRemover = scanner.nextLine();
                    ModuloODS modRem = gerir.buscarModuloPorNome(nomeRemover);
                    if (modRem != null) {
                        gerir.removerModulo(modRem);
                    } else {
                        System.out.println("Módulo não encontrado.");
                    }
                    break;

                case 4:
                    
                    System.out.println("=== Adicionar Perguntas ===");
                    System.out.print("Email do Admin que está a adicionar perguntas: ");
                    String emailAdminPerguntas = scanner.nextLine();
                    Utilizador adminPerguntas = gerir.buscarUtilizadorPorEmail(emailAdminPerguntas);

                    if (adminPerguntas == null || !adminPerguntas.getTipo().equalsIgnoreCase("Admin")) {
                        System.out.println("Apenas admins podem adicionar perguntas.");
                        break;
                    }

                    System.out.print("Nome do Módulo onde adicionar perguntas: ");
                    String nomeModuloPergunta = scanner.nextLine();
                    ModuloODS moduloPergunta = gerir.buscarModuloPorNome(nomeModuloPergunta);

                    if (moduloPergunta == null) {
                        System.out.println("Módulo não encontrado.");
                        break;
                    }

                    System.out.print("Quantas perguntas quer adicionar? ");
                    int qtdPerguntas = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < qtdPerguntas; i++) {
                        System.out.println("Pergunta " + (i + 1) + ": ");
                        String textoPergunta = scanner.nextLine();
                        System.out.print("Resposta correta: ");
                        String resposta = scanner.nextLine();
                        System.out.print("Peso da pergunta (ex: 1): ");
                        int peso = scanner.nextInt();
                        scanner.nextLine();

                        Pergunta p = new Pergunta(textoPergunta, resposta, peso);
                        moduloPergunta.adicionarPergunta(p);
                    }
                    System.out.println("Perguntas adicionadas ao módulo " + moduloPergunta.getNome());
                    break;

                case 5:
                    
                    System.out.println("=== Fazer Quiz ===");
                    System.out.print("Email do estudante: ");
                    String emailEstudante = scanner.nextLine();
                    Utilizador uEst = gerir.buscarUtilizadorPorEmail(emailEstudante);

                    if (uEst == null || !(uEst instanceof Estudante)) {
                        System.out.println("Estudante não encontrado.");
                        break;
                    }
                    Estudante estudante = (Estudante) uEst;

                    if (gerir.getModulos().isEmpty()) {
                        System.out.println("Não existem módulos cadastrados.");
                        break;
                    }

                    System.out.println("Módulos disponíveis para quiz:");
                    ArrayList<ModuloODS> modulosDisp = gerir.getModulos();
                    for (int i = 0; i < modulosDisp.size(); i++) {
                        System.out.println((i + 1) + ". " + modulosDisp.get(i).getNome());
                    }
                    System.out.print("Escolha o módulo para fazer o quiz: ");

                    int moduloEscolhido = scanner.nextInt() - 1;
                    scanner.nextLine();

                    if (moduloEscolhido < 0 || moduloEscolhido >= modulosDisp.size()) {
                        System.out.println("Opção inválida.");
                        break;
                    }

                    ModuloODS modQuiz = modulosDisp.get(moduloEscolhido);
                    if (modQuiz.getPerguntas().size() == 0) {
                        System.out.println("Esse módulo não tem perguntas registadas ainda.");
                        break;
                    }

                    int notaQuiz = estudante.fazerQuiz(modQuiz);

                    
                    FrequenciaRealizada fr = new FrequenciaRealizada(modQuiz, notaQuiz, new Date(), estudante, null);
                    gerir.registarFrequencia(fr);

                    System.out.println("Frequência registada com sucesso! Nota: " + notaQuiz);
                    break;

                case 6:
                   
                    System.out.println("=== Consultar Progresso ===");
                    System.out.print("Email do estudante: ");
                    String emailProg = scanner.nextLine();
                    Utilizador uProg = gerir.buscarUtilizadorPorEmail(emailProg);

                    if (uProg == null || !(uProg instanceof Estudante)) {
                        System.out.println("Estudante não encontrado.");
                        break;
                    }
                    Estudante estProg = (Estudante) uProg;

                    float progresso = estProg.calcularProgresso();
                    System.out.printf("Progresso do estudante %s: %.2f%%%n", estProg.getNome(), progresso * 100);
                    break;

                case 7:
                    System.out.println("A sair...!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }
}
