/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.ctr;

import br.com.aha.base.Professor;
import br.com.aha.dao.ProfessorDAO;
import br.com.aha.util.DAOFactory;
import java.util.List;

/**
 *
 * @author JP1
 */
public class ProfessorCTR {

    private ProfessorDAO professorDAO;

    public ProfessorCTR() {
        this.professorDAO = DAOFactory.criarprofessorDAO();
    }

    public void salvar(Professor professor) {
        this.professorDAO.salvar(professor);
    }

    public void atualizar(Professor professor) {
        this.professorDAO.atualizar(professor);
    }

    public void excluir(Professor professor) {
        this.professorDAO.excluir(professor);
    }

    public Professor carregar(Integer codigo) {
        return this.professorDAO.carregar(codigo);
    }

    public List<Professor> listar() {
        return this.professorDAO.listar();
    }
}
