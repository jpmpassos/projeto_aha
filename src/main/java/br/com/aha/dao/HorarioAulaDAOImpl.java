/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;

import br.com.aha.base.HorarioAula;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author JP1
 */
public class HorarioAulaDAOImpl implements HorarioAulaDAO {

    private Session session;

    @Override
    public void salvar(HorarioAula horarioAula) {
        this.session.save(horarioAula);
    }

    @Override
    public List<HorarioAula> listar() {
        return this.session.createCriteria(HorarioAula.class).list();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }   
}
