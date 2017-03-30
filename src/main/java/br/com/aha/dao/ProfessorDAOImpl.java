/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;

import br.com.aha.base.Professor;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author JP1
 */
public class ProfessorDAOImpl implements ProfessorDAO {

    private Session session;

    @Override
    public void salvar(Professor professor) {
        this.session.save(professor);
    }

    @Override
    public void atualizar(Professor professor) {
        this.session.update(professor);
    }

    @Override
    public void excluir(Professor professor) {
        this.session.delete(professor);
    }

    @Override
    public Professor carregar(Integer codigo) {
        return (Professor) this.session.get(Professor.class, codigo);
    }

    @Override
    public List<Professor> listar() {
        return this.session.createCriteria(Professor.class).list();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
