package br.com.puc.Enum;

public enum Area {

    exata("Exata"),
    humanas("humanas"),
    biologicas("biologicas"),
    artes("artes");

    private String nomeArea;

    private Area(String nomeArea){this.nomeArea = nomeArea;}
    public String nomeCurso(){return this.nomeArea;}
}
