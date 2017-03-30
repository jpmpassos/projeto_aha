/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;

import br.com.aha.base.Professor;
import java.util.List;

/**
 *
 * @author JP1
 */
public interface ProfessorDAO {
    public void salvar(Professor professor);

    public void atualizar(Professor professor);

    public void excluir(Professor professor);

    public Professor carregar(Integer codigo);

    public List<Professor> listar();
}
