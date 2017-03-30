/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;

import br.com.aha.base.Curso;
import java.util.List;

/**
 *
 * @author JP1
 */

public interface CursoDAO {

    public void salvar(Curso curso);

    public void atualizar(Curso curso);

    public void excluir(Curso curso);

    public Curso carregar(Integer codigo);

    public List<Curso> listar();
}
