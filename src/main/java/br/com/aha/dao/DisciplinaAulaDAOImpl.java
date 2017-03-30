/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;


import br.com.aha.base.DisciplinaAula;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author JP1
 */
public class DisciplinaAulaDAOImpl implements DisciplinaAulaDAO {

    private Session session;

    @Override
    public void salvar(DisciplinaAula disciplinaAula) {
        this.session.save(disciplinaAula);
    }

    @Override
    public void atualizar(DisciplinaAula disciplinaAula) {
        this.session.update(disciplinaAula);
    }

    @Override
    public List<DisciplinaAula> listar() {
        return this.session.createCriteria(DisciplinaAula.class).list();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
