/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;

import br.com.aha.base.Dia;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author JP1
 */
public class DiaDAOImpl implements DiaDAO{

    private Session session;
    
    @Override
    public void salvar(Dia dia) {
        this.session.save(dia);
    }

    @Override
    public void atualizar(Dia dia) {
        this.session.update(dia);
    }

    @Override
    public void excluir(Dia dia) {
        this.session.delete(dia);
    }

    @Override
    public Dia carregar(Integer codigo) {
        return (Dia) this.session.get(Dia.class, codigo);
    }

    @Override
    public List<Dia> listar() {
        return this.session.createCriteria(Dia.class).list();
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }         
}
