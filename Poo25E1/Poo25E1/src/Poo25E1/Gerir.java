package Poo25E1;

import java.util.ArrayList;

public class Gerir {
    private ArrayList<Utilizador> utilizadores;
    private ArrayList<ModuloODS> modulos;
    private ArrayList<FrequenciaRealizada> frequencias;

    public Gerir() {
        this.utilizadores = new ArrayList<>();
        this.modulos = new ArrayList<>();
        this.frequencias = new ArrayList<>();
    }

    public void registarUtilizador(Utilizador utilizador) {
        utilizadores.add(utilizador);
        System.out.println("Utilizador registado com sucesso: " + utilizador.getNome());
    }

    public void adicionarModulo(ModuloODS modulo) {
        modulos.add(modulo);
        System.out.println("Módulo adicionado: " + modulo.getNome());
    }

    public void removerModulo(ModuloODS modulo) {
        if (modulos.remove(modulo)) {
            System.out.println("Módulo removido: " + modulo.getNome());
        } else {
            System.out.println("Módulo não encontrado.");
        }
    }

    public void registarFrequencia(FrequenciaRealizada frequencia) {
        frequencias.add(frequencia);
        Estudante aluno = frequencia.getIDaluno();
        if (aluno != null) {
            aluno.getFrequencias().add(frequencia);
            System.out.println("Frequência registada para o aluno: " + aluno.getNome());
        } else {
            System.out.println("Frequência registada.");
        }
    }

    public float getProgresso(Estudante estudante) {
        return estudante.calcularProgresso();
    }

    public Utilizador buscarUtilizadorPorEmail(String email) {
        for (Utilizador u : utilizadores) {
            if (u.getEmail().equalsIgnoreCase(email)) return u;
        }
        return null;
    }

    public ModuloODS buscarModuloPorNome(String nome) {
        for (ModuloODS m : modulos) {
            if (m.getNome().equalsIgnoreCase(nome)) return m;
        }
        return null;
    }

    public ArrayList<ModuloODS> getModulos() {
        return modulos;
    }
}
