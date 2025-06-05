package Poo25E1;
import java.util.ArrayList;

public class Quiz {
	private ArrayList<Pergunta> perguntas = new ArrayList<>();
    public ArrayList<Pergunta> getPerguntas() {
        return perguntas;
    }
    
    public Quiz() {
        this.perguntas = new ArrayList<>();
    }
    
    public void adicionarPergunta(Pergunta p) {
        perguntas.add(p);
    }
    public void removerPergunta(Pergunta p) {
        perguntas.remove(p);
    }

}
