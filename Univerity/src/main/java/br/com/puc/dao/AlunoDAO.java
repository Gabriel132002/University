package br.com.puc.dao;

import br.com.puc.model.Alunos;
import br.com.puc.model.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import br.com.puc.config.ConnectionFactory2;

public class AlunoDAO implements IAlunoDAO{

    @Override
    public Alunos create(Alunos aluno) {
        try(Connection connection = ConnectionFactory2.getConnection() ){
            String query = "INSERT INTO alunos"+
                    "(NOME, MAIORIDADE, CURSO, SEXO)"+
                    "VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, aluno.getNome());
            statement.setBoolean(2, aluno.isMaioridade());
            statement.setString(3, aluno.getCursos().toString());
            statement.setString(4, aluno.getSexo());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long matriculaGerada = resultSet.getLong(1);
            aluno.setMatricula(matriculaGerada);
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
        String query = "SELECT * FROM Alunos";
        List<Alunos> lista = new ArrayList<>();
        try(Connection connection =
                    ConnectionFactory2.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Alunos aluno = new Alunos();
                aluno.setMatricula(rs.getLong("matricula"));
                aluno.setNome(rs.getString("nome"));
                aluno.setSexo(rs.getString("sexo"));
                aluno.setCursos(Curso.valueOf(rs.getString("curso")));
                aluno.setMaioridade(rs.getBoolean("maioridade"));
                lista.add(aluno);
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return lista;
    }

    @Override
    public Optional<Alunos> findById(Long matricula) {
        String query = "SELECT * FROM alunos WHERE matricula = ?";
        Alunos alunos;
        try(Connection connection =
                ConnectionFactory2.getConnection()){
            PreparedStatement statement =
                    connection.prepareStatement(query);
            statement.setLong(1,matricula);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            rs.next();

            alunos = new Alunos(
              rs.getLong("matricula"),
              rs.getString("nome"),
              rs.getString("sexo"),
              Curso.valueOf(rs.getString("curso")),
              rs.getBoolean("maioridade")
            );

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(alunos);
    }

    @Override
    public List<Alunos> findByCurso(Curso curso) {
//        String query = "SELECT * FROM alunos WHERE curso = ?";
//        Alunos alunos;
//
//        try(Connection connection =
//                ConnectionFactory2.getConnection()){
//            PreparedStatement statement = connection.prepareStatement(query);
//
//        }catch (SQLException e){
//            throw new RuntimeException(e);
//        }
        return null;
    }
}
