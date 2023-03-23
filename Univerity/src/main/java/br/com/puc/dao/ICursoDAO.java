package br.com.puc.dao;

import br.com.puc.Enum.Area;
import br.com.puc.Enum.Cursos;
import br.com.puc.model.Curso;

import java.util.List;
import java.util.Optional;

public interface ICursoDAO {

    Curso create(Curso curso);
    Curso update(Curso curso);
    void delete(Long codigo);
    List<Curso> findAll();
    Optional<Curso> findById(Long idCurso);

    List<Curso> findByArea(Area area);

    List<Curso> findBySigla(String sigla);
}
