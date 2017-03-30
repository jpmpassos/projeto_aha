/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;

import br.com.aha.base.Sala;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author JP1
 */
public class SalaDAOImpl implements SalaDAO {

    private Session session;

    @Override
    public void salvar(Sala sala) {
        this.session.save(sala);
    }

    @Override
    public void atualizar(Sala sala) {
        this.session.update(sala);
    }

    @Override
    public void excluir(Sala sala) {
        this.session.delete(sala);
    }

    @Override
    public Sala carregar(Integer codigo) {
        return (Sala) this.session.get(Sala.class, codigo);
    }

    @Override
    public List<Sala> listar() {
        return this.session.createCriteria(Sala.class).list();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
