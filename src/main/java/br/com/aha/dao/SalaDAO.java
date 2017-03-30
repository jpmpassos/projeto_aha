/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;

import br.com.aha.base.Sala;
import java.util.List;

/**
 *
 * @author JP1
 */

    
public interface SalaDAO {

    public void salvar(Sala sala);

    public void atualizar(Sala sala);

    public void excluir(Sala sala);

    public Sala carregar(Integer codigo);

    public List<Sala> listar();
}
