package br.com.puc.dao;

import br.com.puc.model.Alunos;
import br.com.puc.model.Curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import br.com.puc.config.ConnectionFactory2;

public class AlunoDAO implements IAlunoDAO{

    @Override
    public Alunos create(Alunos aluno) {
        try(Connection connection = ConnectionFactory2.getConnection() ){
            String query = "INSERT INTO Alunos"+
                    "(NOME, MAIORIDADE, CURSO, SEXO)"+
                    "VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, aluno.getNome());
            statement.setBoolean(2, aluno.isMaioridade());
            statement.setString(3, aluno.getCursos().toString());
            statement.setString(4, aluno.getSexo());
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return aluno;
    }

    @Override
    public Alunos update(Alunos aluno) {
        return null;
    }

    @Override
    public void delete(Long matricula) {

    }

    @Override
    public List<Alunos> findAll() {
        return null;
    }

    @Override
    public Optional<Alunos> findById(Long matricula) {
        return Optional.empty();
    }

    @Override
    public List<Alunos> findByCurso(Curso curso) {
        return null;
    }
}
