package br.com.puc.Enum;

import java.io.Serializable;

public enum Cursos implements Serializable {
    ADS("Análise e desenvolvimento de sistemas"),
    ENG("Engenharia da Computação"),
    CIENCIA("Ciências da Computação"),
    OUTROS("Outros");

    private String nomeCurso;
    private Cursos(String nomeCurso){
        this.nomeCurso = nomeCurso;
    }
    public String nomeCurso(){
        return this.nomeCurso;
    }

}
