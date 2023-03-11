package br.com.puc.model;

import java.io.Serializable;

public enum Curso implements Serializable {
    ADS("Análise e desenvolvimento de sistemas"),
    ENG("Engenharia da Computação"),
    CIENCIA("Ciências da Computação"),
    OUTROS("Outros");

    private String nomeCurso;
    private Curso(String nomeCurso){
        this.nomeCurso = nomeCurso;
    }
    public String nomeCurso(){
        return this.nomeCurso;
    }
}
