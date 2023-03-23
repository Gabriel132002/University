package br.com.puc;

import br.com.puc.dao.AlunoDAO;
import br.com.puc.model.Alunos;

import java.util.Optional;

public class AlunoUpdate {

    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAO();

        Optional<Alunos> alunosOptional = alunoDAO.findById(1547L);
        Alunos alunos = alunosOptional.get();

        alunos.setSexo("M");

        Alunos alunosUpdate = alunoDAO.update(alunos);
        System.err.println("Matricula: "+alunosUpdate.getMatricula());
        System.err.println("Nome: "+alunosUpdate.getNome());
        System.err.println("Sexo: "+alunosUpdate.getSexo());
        System.err.println("Curso: "+alunosUpdate.getCursos());
        System.err.println(alunosUpdate.isMaioridade()?" Adulto":"Adolescente");

    }
}
