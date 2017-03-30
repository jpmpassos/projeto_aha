/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;

import br.com.aha.base.Turma;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author JP1
 */
public class TurmaDAOImpl implements TurmaDAO {

    private Session session;

    @Override
    public void salvar(Turma turma) {
        this.session.save(turma);
    }

    @Override
    public void atualizar(Turma turma) {
        this.session.update(turma);
    }

    @Override
    public void excluir(Turma turma) {
        this.session.delete(turma);
    }

    @Override
    public Turma carregar(Integer codigo) {
        return (Turma) this.session.get(Turma.class, codigo);
    }

    @Override
    public List<Turma> listar() {
        return this.session.createCriteria(Turma.class).list();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
