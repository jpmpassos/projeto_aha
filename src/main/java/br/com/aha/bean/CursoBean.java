/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.bean;

import br.com.aha.base.Curso;
import br.com.aha.ctr.CursoCTR;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author JP1
 */
@ManagedBean
@SessionScoped
public class CursoBean {

    private Curso curso;
    private List<Curso> lista;
 
    public void salvar() {
        CursoCTR cursoCTR = new CursoCTR();
        cursoCTR.salvar(this.curso);
        this.lista = null;
    }

    public void excluir() {
        CursoCTR cursoCTR = new CursoCTR();
        cursoCTR.excluir(this.curso);
        this.lista = null;

    }

    public void prepararCurso() {
        this.curso = new Curso();
        this.lista = null;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Curso> getLista() {
        if (this.lista == null) {
            CursoCTR cursoCTR = new CursoCTR();
            return cursoCTR.listar();
        }
        return lista;
    }

    public void setLista(List<Curso> lista) {
        this.lista = lista;
    }
}
