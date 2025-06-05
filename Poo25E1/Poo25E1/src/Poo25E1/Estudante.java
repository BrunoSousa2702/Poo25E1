package Poo25E1;
import java.util.ArrayList;

public class Estudante {
	    private int numeroAluno;
	    private String universidade;
	    private ArrayList<ModeloODS> modulos = new ArrayList<>();
	    private ArrayList<FrequenciaRealizada> frequencias = new ArrayList<>();
	    private ArrayList<Certificado> certificados = new ArrayList<>();
	    
	    
	    public Estudante(int numeroAluno, String universidade) {
	         this.numeroAluno = numeroAluno;
	         this.universidade = universidade;
	         this.modulos = new ArrayList<>();
	         this.frequencias = new ArrayList<>();
	         this.certificados = new ArrayList<>();
	     }
	     
	public int getNumeroAluno() {
        return numeroAluno;
    }
    public String getUniversidade() {
        return universidade;
    }
    public ArrayList<ModeloODS> getModulos() {
        return modulos;
    }
    public ArrayList<FrequenciaRealizada> getFrequencias() {
        return frequencias;
    }
    public ArrayList<Certificado> getCertificados() {
        return certificados;
    }
}

