/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.bean;

import br.com.aha.base.Curso;
import br.com.aha.base.Disciplina;
import br.com.aha.base.Turma;
import br.com.aha.ctr.CursoCTR;
import br.com.aha.ctr.DisciplinaCTR;
import br.com.aha.ctr.TurmaCTR;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author JP1
 */
@ManagedBean
@SessionScoped
public class TurmaBean {

    private Turma turma;
    private List<Turma> lista;
    private Curso curso;
    
     public void salvar() {
        TurmaCTR turmaCTR = new TurmaCTR();
        this.turma.setCurso(this.curso);
        turmaCTR.salvar(this.turma);
        prepararTurma();
    }
    
    public void excluir(){
        TurmaCTR turmaCTR = new TurmaCTR();
        turmaCTR.excluir(this.turma);
        this.lista.remove(this.turma);
    }
    public void limpar(){
        this.turma = new Turma();
    }
    
    public void prepararTurma(){
        CursoCTR cursoCTR = new CursoCTR();
        this.lista = cursoCTR.carregar(this.curso.getIdcurso()).getTurmas();
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<Turma> getLista() {
        return lista;
    }

    public void setLista(List<Turma> lista) {
        this.lista = lista;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
