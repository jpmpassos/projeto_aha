/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;

import br.com.aha.base.Disciplina;
import java.util.List;

/**
 *
 * @author JP1
 */
public interface DisciplinaDAO {

    public void salvar(Disciplina disciplina);

    public void atualizar(Disciplina disciplina);

    public void excluir(Disciplina disciplina);

    public Disciplina carregar(Integer codigo);

    public List<Disciplina> listar();
}
