/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.base;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author JP1
 */
@Entity
@Table(name = "curso")
public class Curso implements Serializable {

    private static final long serialVersionUID = -3986348829986765381L;
    @Id
    @GeneratedValue
    private int idcurso;
    private String curso;
    private String descricao;
    @OneToMany(mappedBy = "curso")
    private List<Turma> turmas;
    @OneToMany(mappedBy = "curso")
    private List<Disciplina> disciplinas;

    public int getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(int idcurso) {
        this.idcurso = idcurso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.idcurso;
        hash = 11 * hash + (this.curso != null ? this.curso.hashCode() : 0);
        hash = 11 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 11 * hash + (this.turmas != null ? this.turmas.hashCode() : 0);
        hash = 11 * hash + (this.disciplinas != null ? this.disciplinas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (this.idcurso != other.idcurso) {
            return false;
        }
        if ((this.curso == null) ? (other.curso != null) : !this.curso.equals(other.curso)) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (this.turmas != other.turmas && (this.turmas == null || !this.turmas.equals(other.turmas))) {
            return false;
        }
        if (this.disciplinas != other.disciplinas && (this.disciplinas == null || !this.disciplinas.equals(other.disciplinas))) {
            return false;
        }
        return true;
    }
}
