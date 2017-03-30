/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.ctr;

import br.com.aha.base.HorarioAula;
import br.com.aha.dao.HorarioAulaDAO;
import br.com.aha.util.DAOFactory;
import java.util.List;

/**
 *
 * @author JP1
 */
public class HorarioAulaCTR {

    private HorarioAulaDAO horarioAulaDAO;

    public HorarioAulaCTR() {
        this.horarioAulaDAO = DAOFactory.criarhorarioaulaDAO();
    }

    public void salvar(HorarioAula horarioAula) {
        this.horarioAulaDAO.salvar(horarioAula);
    }

    public List<HorarioAula> listar() {
        return this.horarioAulaDAO.listar();
    }
}
