package br.com.puc;

import br.com.puc.dao.AlunoDAO;
import br.com.puc.model.Alunos;
import br.com.puc.model.Curso;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args){

        AlunoDAO alunoDAO = new AlunoDAO();

//        Alunos alunos = new Alunos();
//        alunos.setNome("Yusuke");
//        alunos.setSexo("M");
//        alunos.setCursos(Curso.ADS);
//        alunos.setMaioridade(true);
//
//        alunoDAO.create(alunos);

//        List<Alunos> lista = alunoDAO.findAll();
//        for(Alunos a : lista){
//            System.out.println("Matricula "+a.getMatricula());
//            System.out.println("Nome "+a.getNome());
//            System.out.println("Sexo "+a.getSexo());
//            System.out.println("Curso "+a.getCursos().nomeCurso());
//            System.out.println(a.isMaioridade()?" Adulto":"Adolescente");
//            System.out.println("=======================================");
//        }

        Optional<Alunos> alunos = alunoDAO.findById(1l);
        alunos.ifPresent(a -> {
            System.err.println("matricula: "+a.getMatricula());
            System.err.println("nome: "+a.getNome());
            System.err.println("sexo: "+a.getSexo());
            System.err.println("curso: "+a.getCursos().nomeCurso());
            System.err.println(a.isMaioridade()?" Adulto":" Adolescente");
        });

    }
}
