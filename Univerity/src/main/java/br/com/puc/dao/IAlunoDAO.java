package br.com.puc.dao;

import br.com.puc.model.Alunos;
import br.com.puc.Enum.Cursos;

import java.util.List;
import java.util.Optional;

public interface IAlunoDAO {

    Alunos create(Alunos aluno);
    Alunos update(Alunos aluno);
    void delete(Long matricula);
    List<Alunos> findAll();
    Optional<Alunos> findById(Long matricula);

    List<Alunos> findByCurso(Cursos curso);

}
