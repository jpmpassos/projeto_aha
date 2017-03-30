/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.ctr;

import br.com.aha.base.DisciplinaAula;
import br.com.aha.dao.DisciplinaAulaDAO;
import br.com.aha.util.DAOFactory;
import java.util.List;

/**
 *
 * @author JP1
 */
public class DisciplinaAulaCTR {

    private DisciplinaAulaDAO disciplinaAulaDAO;

    public DisciplinaAulaCTR() {
        this.disciplinaAulaDAO = DAOFactory.criardisciplinaaualaDAO();
    }

    public void salvar(DisciplinaAula disciplinaAula) {
        this.disciplinaAulaDAO.salvar(disciplinaAula);
    }
    
    public void atualizar(DisciplinaAula disciplinaAula) {
        this.disciplinaAulaDAO.atualizar(disciplinaAula);
    }

    public List<DisciplinaAula> listar() {
        return this.disciplinaAulaDAO.listar();
    }
}
