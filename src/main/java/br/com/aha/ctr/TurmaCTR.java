/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.ctr;

import br.com.aha.base.Turma;
import br.com.aha.dao.TurmaDAO;
import br.com.aha.util.DAOFactory;
import java.util.List;

/**
 *
 * @author JP1
 */
public class TurmaCTR {
    private TurmaDAO turmaDAO;

    public TurmaCTR() {
        this.turmaDAO = DAOFactory.criarturmaDAO();
    }
    
    public void salvar(Turma turma){
        this.turmaDAO.salvar(turma);
    }
    
    public void atualizar(Turma turma){
        this.turmaDAO.atualizar(turma);
    }
    
    public void excluir(Turma turma){
        this.turmaDAO.excluir(turma);
    }
    
    public Turma carregar(Integer codigo){
        return this.turmaDAO.carregar(codigo);
    }
    
    public List<Turma> listar(){
        return this.turmaDAO.listar();
    }
}
