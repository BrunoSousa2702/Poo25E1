package Poo25E1;
import java.util.Date;

public class Certificado {
	
	private String nome;
    private Date data;
    private String texto;
    
    public Certificado(String nome, Date data, String texto) {
        this.nome = nome;
        this.data = data;
        this.texto = texto;
    }
      
    public String getNome() {
        return nome;
    }
    public Date getData() {
        return data;
    }
    public String getTexto() {
        return texto;
    }
}


