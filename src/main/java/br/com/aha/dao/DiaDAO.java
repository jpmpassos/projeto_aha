/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;


import br.com.aha.base.Dia;
import java.util.List;

/**
 *
 * @author JP1
 */
public interface DiaDAO {

    public void salvar(Dia dia);

    public void atualizar(Dia dia);

    public void excluir(Dia dia);

    public Dia carregar(Integer codigo);

    public List<Dia> listar();
}
