package Poo25E1;

public class ModeloODS {
	private String nome;
    private String descricao;
    private String meta;
    private Quiz quiz;
    
    
    public ModeloODS(String nome, String descricao, String meta, Quiz quiz) {
        this.nome = nome;
        this.descricao = descricao;
        this.meta = meta;
        this.quiz = quiz;
    }
       
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getMeta() {
        return meta;
    }
    public Quiz getQuiz() {
        return quiz;
    }

}
