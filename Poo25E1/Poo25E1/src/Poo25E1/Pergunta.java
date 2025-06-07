package Poo25E1;

public class Pergunta {
    private String texto;
    private String resposta; // Resposta correta
    private int peso;

    public Pergunta(String texto, String resposta, int peso) {
        this.texto = texto;
        this.resposta = resposta;
        this.peso = peso;
    }

    public String getTexto() { 
        return texto; 
    }
    
    public void setTexto(String texto) { 
        this.texto = texto; 
    }

    public String getResposta() {
        return resposta; 
    }
    
    public void setResposta(String resposta) { 
        this.resposta = resposta; 
    }

    public int getPeso() { 
        return peso; 
    }
    
    public void setPeso(int peso) { 
        this.peso = peso; 
    }
}
