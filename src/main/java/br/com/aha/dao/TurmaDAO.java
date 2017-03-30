/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;

import br.com.aha.base.Turma;
import java.util.List;

/**
 *
 * @author JP1
 */
public interface TurmaDAO {

    public void salvar(Turma turma);

    public void atualizar(Turma turma);

    public void excluir(Turma turma);

    public Turma carregar(Integer codigo);

    public List<Turma> listar();
}
