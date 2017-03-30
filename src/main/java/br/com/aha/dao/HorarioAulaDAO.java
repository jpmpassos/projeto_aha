/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.dao;


import br.com.aha.base.HorarioAula;
import java.util.List;

/**
 *
 * @author JP1
 */
public  interface HorarioAulaDAO {
    
    public void salvar(HorarioAula horarioAula);
    public List<HorarioAula> listar();
    
}
