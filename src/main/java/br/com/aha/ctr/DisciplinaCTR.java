/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.ctr;


import br.com.aha.base.Disciplina;
import br.com.aha.dao.DisciplinaDAO;
import br.com.aha.util.DAOFactory;
import java.util.List;

/**
 *
 * @author JP1
 */
public class DisciplinaCTR {
    private DisciplinaDAO disciplinaDAO;

    public DisciplinaCTR() {
        this.disciplinaDAO = DAOFactory.criardisciplinaDAO();
    }
    
    public void salvar(Disciplina disciplina){
        this.disciplinaDAO.salvar(disciplina);
    }
    
    public void atualizar(Disciplina disciplina){
        this.disciplinaDAO.atualizar(disciplina);
    }
    
    public void excluir(Disciplina disciplina){
        this.disciplinaDAO.excluir(disciplina);
    }
    
    public Disciplina carregar(Integer codigo){
        return this.disciplinaDAO.carregar(codigo);
    }
    
    public List<Disciplina> listar(){
        return this.disciplinaDAO.listar();
    }
}
