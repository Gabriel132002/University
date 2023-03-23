package br.com.puc;

import br.com.puc.dao.AlunoDAO;
import br.com.puc.dao.CursoDAO;
import br.com.puc.model.Alunos;
import br.com.puc.model.Curso;
import br.com.puc.Enum.Area;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args){

        AlunoDAO alunoDAO = new AlunoDAO();
//
//        Alunos alunos = new Alunos();
//        alunos.setNome("teste");
//        alunos.setSexo("F");
//        alunos.setCursos(Curso.ADS);
//        alunos.setMaioridade(true);
//
//        alunoDAO.create(alunos);

        //CURSO

        //Create
        Curso curso = new Curso();
        CursoDAO cursoDAO = new CursoDAO();


//        curso.setNome("Português");
//        curso.setArea(Area.humanas);
//        curso.setSigla("PT");
//        cursoDAO.create(curso);

//        curso.setNome("ANALISE E DESENVOLVIMENTO DE SISTEMAS");
//        curso.setSigla("ADS");
//        curso.setCodigo(1L);
//        curso.setArea(Area.exata);
//
//        Curso cursoUpdated = cursoDAO.update(curso);
//
//        System.err.println(cursoUpdated.getNome());


//        cursoDAO.delete(4L);



//        List<Curso> cursosList = cursoDAO.findAll();
//
//        for(Curso c : cursosList) {
//            System.out.println(c.getCodigo());
//            System.out.println(c.getNome());
//            System.out.println(c.getSigla());
//            System.out.println(c.getArea());
//        }

//        Optional<Curso> cursoTesteId = cursoDAO.findById(1L);
//
//        cursoTesteId.ifPresent(c -> {
//            System.err.println(c.getNome());
//        });


//        List<Curso> c = cursoDAO.findByArea(Area.exata);
//        for(Curso c1 : c) {
//            System.out.println(c1.getCodigo());
//            System.out.println(c1.getNome());
//            System.out.println(c1.getSigla());
//            System.out.println(c1.getArea());
//        }

        List<Curso> c = cursoDAO.findBySigla("ADS");
        for(Curso c1 : c) {
            System.out.println(c1.getCodigo());
            System.out.println(c1.getNome());
            System.out.println(c1.getSigla());
            System.out.println(c1.getArea());
        }




    }
}
