/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.ctr;

import br.com.aha.base.Horario;
import br.com.aha.dao.HorarioDAO;
import br.com.aha.util.DAOFactory;
import java.util.List;

/**
 *
 * @author JP1
 */
public class HorarioCTR {

    private HorarioDAO horarioDAO;

    public HorarioCTR() {
        this.horarioDAO = DAOFactory.criarhorarioDAO();
    }

    public void salvar(Horario horario) {
        this.horarioDAO.salvar(horario);
    }

    public void atualizar(Horario horario) {
        this.horarioDAO.atualizar(horario);
    }

    public void excluir(Horario horario) {
        this.horarioDAO.excluir(horario);
    }

    public Horario carregar(Integer codigo) {
        return this.carregar(codigo);
    }

    public List<Horario> listar() {
        return this.horarioDAO.listar();
    }
}
