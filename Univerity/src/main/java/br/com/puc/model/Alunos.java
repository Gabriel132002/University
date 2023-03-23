package br.com.puc.model;

import br.com.puc.Enum.Cursos;

public class Alunos {
    private Long matricula;
    private String nome;
    boolean maioridade;
    Cursos cursos;
    String sexo;

    public Alunos(){}

    public Alunos(Long matricula, String nome, String sexo , Cursos cursos, boolean maioridade) {
        this.matricula = matricula;
        this.nome = nome;
        this.maioridade = maioridade;
        this.cursos = cursos;
        this.sexo = sexo;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isMaioridade() {
        return maioridade;
    }

    public void setMaioridade(boolean maioridade) {
        this.maioridade = maioridade;
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}
