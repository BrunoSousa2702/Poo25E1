package Poo25E1;

import java.util.ArrayList;
import java.util.Scanner;

public class Estudante extends Utilizador {
    private int numeroAluno;
    private String universidade;
    private ArrayList<ModuloODS> modulos;
    private ArrayList<FrequenciaRealizada> frequencias;

    
    public Estudante(String nome, String password, String email, String tipo, int numeroAluno, String universidade) {
        super(nome, password, email, tipo);
        this.numeroAluno = numeroAluno;
        this.universidade = universidade;
        this.modulos = new ArrayList<>();
        this.frequencias = new ArrayList<>();
    }

  
    public int getNumeroAluno() { 
    	return numeroAluno; }
    
    public String getUniversidade() { 
    	return universidade; }
    
    public ArrayList<ModuloODS> getModulos() { 
    	return modulos; }
    
    public ArrayList<FrequenciaRealizada> getFrequencias() { 
    	return frequencias; }


    
    public int fazerQuiz(ModuloODS modulo) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pergunta> perguntas = modulo.getPerguntas();
        int notaTotal = 0;
        int pesoTotal = 0;
        System.out.println("A iniciar o quiz do módulo: " + modulo.getNome());
        for (Pergunta pergunta : perguntas) {
            System.out.println(pergunta.getTexto());
            System.out.print("Sua resposta: ");
            String respostaAluno = scanner.nextLine().trim();
            if (respostaAluno.equalsIgnoreCase(pergunta.getResposta())) {
                notaTotal += pergunta.getPeso();
            }
            pesoTotal += pergunta.getPeso();
        }
        System.out.println("Quiz finalizado. Nota obtida: " + notaTotal + " / " + pesoTotal);
        return notaTotal;
    }
    

    public float calcularProgresso() {
        int somaNotas = 0;
        int somaPesos = 0;

        for (FrequenciaRealizada freq : frequencias) {
            ModuloODS modulo = freq.getModulo();
            int notaFreq = freq.getNota();

            
            somaNotas += notaFreq;

            int pesoTotalModulo = 0;
            for (Pergunta p : modulo.getPerguntas()) {
                pesoTotalModulo += p.getPeso();
            }
            somaPesos += pesoTotalModulo;
        }

        if (somaPesos == 0) return 0.0f;

        return (float) somaNotas / somaPesos;
    }

    
}
