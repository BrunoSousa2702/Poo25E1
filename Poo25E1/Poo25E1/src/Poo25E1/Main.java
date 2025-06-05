package Poo25E1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estudante> estudantes = new ArrayList<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Estudante");
            System.out.println("2. Adicionar Módulo ao Estudante");
            System.out.println("3. Adicionar Frequência");
            System.out.println("4. Mostrar Estudantes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcao) {
                case 1:
                    System.out.print("Número do Aluno: ");
                    int numeroAluno = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Universidade: ");
                    String universidade = scanner.nextLine();

                    Estudante estudante = new Estudante(numeroAluno, universidade);
                    estudantes.add(estudante);
                    System.out.println("Estudante adicionado com sucesso!");
                    break;

                case 2:
                    System.out.print("Número do Aluno do Estudante: ");
                    int numeroEstudante = scanner.nextInt();
                    scanner.nextLine(); 

                    Estudante est = encontrarEstudante(estudantes, numeroEstudante);
                    if (est != null) {
                        System.out.print("Nome do Módulo: ");
                        String nomeModulo = scanner.nextLine();
                        System.out.print("Descrição do Módulo: ");
                        String descricaoModulo = scanner.nextLine();
                        System.out.print("Meta do Módulo: ");
                        String metaModulo = scanner.nextLine();

                      
                        ModeloODS modulo = new ModeloODS(nomeModulo, descricaoModulo, metaModulo, null);
                        est.getModulos().add(modulo);
                        System.out.println("Módulo adicionado ao Estudante!");
                    } else {
                        System.out.println("Estudante não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("Número do Aluno do Estudante: ");
                    numeroEstudante = scanner.nextInt();
                    scanner.nextLine(); 

                    est = encontrarEstudante(estudantes, numeroEstudante);
                    if (est != null) {
                        ArrayList<ModeloODS> modulos = est.getModulos();
                        if (modulos.isEmpty()) {
                            System.out.println("Este estudante não tem módulos.");
                            break;
                        }

                        System.out.println("Selecione um módulo:");
                        for (int i = 0; i < modulos.size(); i++) {
                            System.out.println(i + ". " + modulos.get(i).getNome());
                        }

                        int indiceModulo = scanner.nextInt();
                        scanner.nextLine(); 
                        if (indiceModulo < 0 || indiceModulo >= modulos.size()) {
                            System.out.println("Índice de módulo inválido.");
                            break;
                        }

                        ModeloODS modulo = modulos.get(indiceModulo);

                        System.out.print("Nota da Frequência: ");
                        int nota = scanner.nextInt();
                        scanner.nextLine(); 

                        System.out.print("Data da Frequência (AAAA-MM-DD): ");
                        String dataInput = scanner.nextLine();

                        Date data;
                        try {
                            data = new SimpleDateFormat("yyyy-MM-dd").parse(dataInput);
                        } catch (Exception e) {
                            System.out.println("Data inválida.");
                            break;
                        }

                        FrequenciaRealizada frequencia = new FrequenciaRealizada(modulo, nota, data);
                        est.getFrequencias().add(frequencia);
                        System.out.println("Frequência adicionada!");
                    } else {
                        System.out.println("Estudante não encontrado.");
                    }
                    break;

                case 4:
                    for (Estudante e : estudantes) {
                        System.out.println("Estudante Nº " + e.getNumeroAluno() + " - " + e.getUniversidade());
                        System.out.println("Módulos: ");
                        for (ModeloODS m : e.getModulos()) {
                            System.out.println("  - " + m.getNome());
                        }
                    }
                    break;

                case 0:
                    System.out.println("A sair");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida, tenta novamente.");
                    break;
            }
        }
    }

    private static Estudante encontrarEstudante(ArrayList<Estudante> estudantes, int numeroAluno) {
        for (Estudante est : estudantes) {
            if (est.getNumeroAluno() == numeroAluno) {
                return est;
            }
        }
        return null;
    }
}
