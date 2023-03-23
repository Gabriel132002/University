package br.com.puc.dao;

import br.com.puc.model.Alunos;
import br.com.puc.Enum.Cursos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import br.com.puc.config.ConnectionFactory2;

public class AlunoDAO implements IAlunoDAO{

    @Override
    public Alunos create(Alunos alunos) {
        try(Connection connection = ConnectionFactory2.getConnection() ){
            String query = "INSERT INTO alunos"+
                    "(NOME, MAIORIDADE, CURSO, SEXO)"+
                    "VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, alunos.getNome());
            statement.setBoolean(2, alunos.isMaioridade());
            statement.setString(3, alunos.getCursos());
            statement.setString(4, alunos.getSexo());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long matriculaGerada = resultSet.getLong(1);
            alunos.setMatricula(matriculaGerada);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return alunos;
    }

    @Override
    public Alunos update(Alunos aluno) {
        try(Connection connection =
                ConnectionFactory2.getConnection()){
            String query = "UPDATE alunos SET "+
                    "nome = ?, sexo = ?, curso = ?, maioridade = ? "+
                    "WHERE matricula = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getSexo());
            statement.setString(3,aluno.getCursos().toString());
            statement.setBoolean(4, aluno.isMaioridade());
            statement.setLong(5, aluno.getMatricula());
            statement.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return aluno;
    }

    @Override
    public void delete(Long matricula) {
        try(Connection connection =
                ConnectionFactory2.getConnection()){
            String query = "DELETE FROM alunos WHERE matricula = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1, matricula);
            statement.executeUpdate();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
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
                aluno.setCursos(rs.getString("curso"));
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

            alunos = new Alunos();
            alunos.setNome(rs.getString("nome"));
            alunos.setSexo(rs.getString("sexo"));
            alunos.setCursos(rs.getString("sigla"));
            alunos.setMaioridade(rs.getBoolean("maioridade"));


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(alunos);
    }

    @Override
    public List<Alunos> findByCurso(Cursos curso) {
        String query = "SELECT * FROM alunos WHERE curso = ?";
        Alunos alunos;

        try(Connection connection =
                ConnectionFactory2.getConnection()){
            PreparedStatement statement = connection.prepareStatement(query);


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
    }
}
