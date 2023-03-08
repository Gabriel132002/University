package br.com.puc;

import br.com.puc.dao.AlunoDAO;
import br.com.puc.model.Alunos;
import br.com.puc.model.Curso;

public class Main {
    public static void main(String[] args){

        AlunoDAO alunoDAO = new AlunoDAO();

        Alunos alunos = new Alunos();
        alunos.setNome("Vegeta");
        alunos.setSexo("M");
        alunos.setCursos(Curso.ADS);
        alunos.setMaioridade(true);

        alunoDAO.create(alunos);

    }
}
