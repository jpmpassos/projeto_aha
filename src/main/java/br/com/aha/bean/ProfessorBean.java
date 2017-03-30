/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.bean;

import br.com.aha.base.Professor;
import br.com.aha.ctr.ProfessorCTR;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author JP1
 */
@ManagedBean
@SessionScoped
public class ProfessorBean {

    private Professor professor;
    private List<Professor> lista;
    
    public void salvar(){
        ProfessorCTR professorCTR = new ProfessorCTR();
        professorCTR.salvar(this.professor);
        this.lista = null;
    }
    
    public void excluir(){
        ProfessorCTR professorCTR = new ProfessorCTR();
        professorCTR.excluir(this.professor);
        this.lista = null;
    }
    
    public void prepararProf(){
        this.lista = null;
        this.professor = new Professor();
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Professor> getLista() {
        if(this.lista == null){
            ProfessorCTR professorCTR = new ProfessorCTR();
            return professorCTR.listar();
        }
        return lista;
    }

    public void setLista(List<Professor> lista) {
        this.lista = lista;
    }
}
