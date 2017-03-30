/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.bean;

import br.com.aha.base.Horario;
import br.com.aha.ctr.HorarioCTR;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author JP1
 */
@ManagedBean
@SessionScoped
public class HorarioBean {

    private Horario horario;
    private List<Horario> lista;
    
    public void prepararHorario(){
        this.horario = new Horario();
        this.lista = null;
    }

    public void salvar() {
        HorarioCTR horarioCTR = new HorarioCTR();
        horarioCTR.salvar(this.horario);
        this.lista = null;
    }

    public void excluir() {
        HorarioCTR horarioCTR = new HorarioCTR();
        horarioCTR.excluir(this.horario);
        this.lista = null;

    }

    public void limpar() {
        this.lista = null;
        this.horario = new Horario();
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public List<Horario> getLista() {
        if (this.lista == null) {
            HorarioCTR horarioCTR = new HorarioCTR();
            this.lista = horarioCTR.listar();
        }
        return this.lista;
    }

    public void setLista(List<Horario> lista) {
        this.lista = lista;
    }
}
