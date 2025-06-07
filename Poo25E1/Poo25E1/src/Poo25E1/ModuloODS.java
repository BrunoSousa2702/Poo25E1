package Poo25E1;

import java.util.ArrayList;

public class ModuloODS {
    private int ODS; // Número do ODS (1-17)
    private String nome;
    private String descricao;
    private String meta;
    private ArrayList<Pergunta> perguntas; // Contém as perguntas (quiz) do módulo

    public ModuloODS(int ODS, String nome, String descricao, String meta) {
        this.ODS = ODS;
        this.nome = nome;
        this.descricao = descricao;
        this.meta = meta;
        this.perguntas = new ArrayList<>();
    }

    // Getters e setters
    public int getODS() { return ODS; }
    public void setODS(int ODS) { this.ODS = ODS; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getMeta() { return meta; }
    public void setMeta(String meta) { this.meta = meta; }

    public ArrayList<Pergunta> getPerguntas() { return perguntas; }

    public void adicionarPergunta(Pergunta pergunta) {
        perguntas.add(pergunta);
    }

    public void removerPergunta(Pergunta pergunta) {
        perguntas.remove(pergunta);
    }
}
