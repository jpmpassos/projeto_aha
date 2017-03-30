/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;


import br.com.aha.base.DisciplinaAula;
import java.util.List;

/**
 *
 * @author JP1
 */
public interface DisciplinaAulaDAO {

    public void salvar(DisciplinaAula disciplinaAula);
    
    public void atualizar(DisciplinaAula disciplinaAula);

    public List<DisciplinaAula> listar();
}
