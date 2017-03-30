/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;


import br.com.aha.base.Disciplina;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author JP1
 */
public class DisciplinaDAOImpl implements DisciplinaDAO {

    private Session session;

    @Override
    public void salvar(Disciplina disciplina) {
        this.session.save(disciplina);
    }

    @Override
    public void atualizar(Disciplina disciplina) {
        this.session.update(disciplina);
    }

    @Override
    public void excluir(Disciplina disciplina) {
        this.session.delete(disciplina);
    }

    @Override
    public Disciplina carregar(Integer codigo) {
        return (Disciplina) this.session.get(Disciplina.class, codigo);
    }

    @Override
    public List<Disciplina> listar() {
        return this.session.createCriteria(Disciplina.class).list();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }   
}
