/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.bean;

import br.com.aha.base.Curso;
import br.com.aha.base.Disciplina;
import br.com.aha.ctr.CursoCTR;
import br.com.aha.ctr.DisciplinaCTR;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author JP1
 */
@ManagedBean
@SessionScoped
public class DisciplinaBean {

    private Curso curso;
    private Disciplina disciplina;
    private List<Disciplina> lista;

    public void salvar() {
        DisciplinaCTR disciplinaCTR = new DisciplinaCTR();
        this.disciplina.setCurso(this.curso);
        disciplinaCTR.salvar(this.disciplina);
        prepararDisc();
    }
    
    public void excluir(){
        DisciplinaCTR disciplinaCTR = new DisciplinaCTR();
        disciplinaCTR.excluir(this.disciplina);
        this.lista.remove(this.disciplina);
    }
    public void limpar(){
        this.disciplina = new Disciplina();
    }

    public void prepararDisc() {
        CursoCTR cursoCTR = new CursoCTR();
        this.lista = cursoCTR.carregar(this.curso.getIdcurso()).getDisciplinas();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public List<Disciplina> getLista() {
        return this.lista;
    }

    public void setLista(List<Disciplina> lista) {
        this.lista = lista;
    }
}
