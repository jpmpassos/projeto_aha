/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.ctr;


import br.com.aha.base.Curso;
import br.com.aha.dao.CursoDAO;
import br.com.aha.util.DAOFactory;
import java.util.List;

/**
 *
 * @author JP1
 */
public class CursoCTR {

    private CursoDAO cursoDAO;

    public CursoCTR() {
        this.cursoDAO = DAOFactory.criarcursoDAO();
    }

    public void salvar(Curso curso) {
        this.cursoDAO.salvar(curso);
    }

    public void atualizar(Curso curso) {
        this.atualizar(curso);
    }

    public void excluir(Curso curso) {
        this.cursoDAO.excluir(curso);
    }

    public Curso carregar(Integer codigo) {
        return this.cursoDAO.carregar(codigo);
    }

    public List<Curso> listar() {
        return this.cursoDAO.listar();
    }
}
