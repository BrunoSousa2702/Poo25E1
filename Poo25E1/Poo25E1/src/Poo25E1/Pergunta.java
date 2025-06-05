package Poo25E1;

public class Pergunta {
	private String texto;
    private String resposta;
    private int peso;
    
    
    public Pergunta(String texto, String resposta, int peso) {
        this.texto = texto;
        this.resposta = resposta;
        this.peso = peso;
    }
 
    public String getTexto() {
        return texto;
    }
    public String getResposta() {
        return resposta;
    }
    public int getPeso() {
        return peso;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }
    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }

}
