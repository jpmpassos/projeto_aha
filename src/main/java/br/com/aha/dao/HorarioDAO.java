/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;

import br.com.aha.base.Horario;
import java.util.List;

/**
 *
 * @author JP1
 */

public interface HorarioDAO {

    public void salvar(Horario horario);

    public void atualizar(Horario horario);

    public void excluir(Horario horario);

    public Horario carregar(Integer codigo);

    public List<Horario> listar();
}
