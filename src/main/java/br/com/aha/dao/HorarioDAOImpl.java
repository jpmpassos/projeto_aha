/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;

import br.com.aha.base.Horario;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author JP1
 */
public class HorarioDAOImpl implements HorarioDAO {

    private Session session;

    @Override
    public void salvar(Horario horario) {
        this.session.save(horario);
    }

    @Override
    public void atualizar(Horario horario) {
        this.session.update(horario);
    }

    @Override
    public void excluir(Horario horario) {
        this.session.delete(horario);
    }

    @Override
    public Horario carregar(Integer codigo) {
        return (Horario) this.session.get(Horario.class, codigo);
    }

    @Override
    public List<Horario> listar() {
        return this.session.createCriteria(Horario.class).list();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
