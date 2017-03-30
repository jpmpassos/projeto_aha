/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.ctr;

import br.com.aha.base.Dia;
import br.com.aha.dao.DiaDAO;
import br.com.aha.util.DAOFactory;
import java.util.List;

/**
 *
 * @author JP1
 */
public class DiaCTR {

    private DiaDAO diaDAO;

    public DiaCTR() {
        this.diaDAO = DAOFactory.criarDiaDAO();
    }

    public void salvar(Dia dia) {
        this.diaDAO.salvar(dia);
    }

    public void excluir(Dia dia) {
        this.diaDAO.excluir(dia);
    }

    public void atualizar(Dia dia) {
        this.diaDAO.atualizar(dia);
    }

    public Dia carregar(Integer codigo) {
        return this.diaDAO.carregar(codigo);
    }

    public List<Dia> listar() {
        return this.diaDAO.listar();
    }
}
