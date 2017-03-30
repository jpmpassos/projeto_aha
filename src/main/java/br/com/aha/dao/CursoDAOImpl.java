/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;

import br.com.aha.base.Curso;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author JP1
 */
public class CursoDAOImpl implements CursoDAO {

    private Session session;

    @Override
    public void salvar(Curso curso) {
        this.session.save(curso);
    }

    @Override
    public void atualizar(Curso curso) {
        this.session.update(curso);
    }

    @Override
    public void excluir(Curso curso) {
        this.session.delete(curso);
    }

    @Override
    public Curso carregar(Integer codigo) {
        return (Curso) this.session.get(Curso.class, codigo);
    }

    @Override
    public List<Curso> listar() {
        return this.session.createCriteria(Curso.class).list();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
}
