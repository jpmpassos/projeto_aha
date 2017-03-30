/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.ctr;

import br.com.aha.base.Sala;
import br.com.aha.dao.SalaDAO;
import br.com.aha.util.DAOFactory;
import java.util.List;

/**
 *
 * @author JP1
 */
public class SalaCTR {

    private SalaDAO salaDAO;

    public SalaCTR() {
        this.salaDAO = DAOFactory.criarsalaDAO();
    }

    public void salvar(Sala sala) {
        this.salaDAO.salvar(sala);
    }

    public void excluir(Sala sala) {
        this.salaDAO.excluir(sala);
    }

    public void atualizar(Sala sala) {
        this.salaDAO.atualizar(sala);
    }

    public Sala carregar(Integer codigo) {
        return this.carregar(codigo);
    }

    public List<Sala> listar() {
        return this.salaDAO.listar();
    }
}
