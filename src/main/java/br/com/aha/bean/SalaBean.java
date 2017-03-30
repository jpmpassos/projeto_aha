/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.bean;

import br.com.aha.base.Horario;
import br.com.aha.base.Sala;
import br.com.aha.ctr.HorarioCTR;
import br.com.aha.ctr.SalaCTR;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author JP1
 */
@ManagedBean
@SessionScoped
public class SalaBean {

    private Sala sala;
    private List<Sala> lista;

    
    public void salvar() {
        SalaCTR salaCTR = new SalaCTR();
        salaCTR.salvar(this.sala);
        this.lista = null;
    }

    public void excluir() {
        SalaCTR salaCTR = new SalaCTR();
        salaCTR.excluir(this.sala);
        this.lista = null;

    }

    public void limpar() {
        this.lista = null;
        this.sala = new Sala();
    }
    
    public void prepararSala() {
        this.lista = null;
        this.sala = new Sala();
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public List<Sala> getLista() {
        if (this.lista == null) {
            SalaCTR salaCTR = new SalaCTR();
            return salaCTR.listar();
        }
        return lista;
    }

    public void setLista(List<Sala> lista) {
        this.lista = lista;
    }
}
