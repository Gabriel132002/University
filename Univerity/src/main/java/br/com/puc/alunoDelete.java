package br.com.puc;

import br.com.puc.dao.AlunoDAO;
import br.com.puc.model.Alunos;

public class alunoDelete {
    public static void main(String[] args) {

        AlunoDAO alunoDAO = new AlunoDAO();
        alunoDAO.delete(1551L);
        System.out.println("Aluno deletado");
    }
}
