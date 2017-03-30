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
@Table(name = "turma")
public class Turma implements Serializable {

    private static final long serialVersionUID = 2013133293603459084L;
    @Id
    @GeneratedValue
    private Integer idturma;
    private String turma;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "idcurso")
    private Curso curso;
    @OneToMany(mappedBy = "turma")
    private List<DisciplinaAula> disciplinaAulas;

    public Integer getIdturma() {
        return idturma;
    }

    public void setIdturma(Integer idturma) {
        this.idturma = idturma;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<DisciplinaAula> getDisciplinaAulas() {
        return disciplinaAulas;
    }

    public void setDisciplinaAulas(List<DisciplinaAula> disciplinaAulas) {
        this.disciplinaAulas = disciplinaAulas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idturma;
        hash = 67 * hash + (this.turma != null ? this.turma.hashCode() : 0);
        hash = 67 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 67 * hash + (this.curso != null ? this.curso.hashCode() : 0);
        hash = 67 * hash + (this.disciplinaAulas != null ? this.disciplinaAulas.hashCode() : 0);
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
        final Turma other = (Turma) obj;
        if (this.idturma != other.idturma) {
            return false;
        }
        if ((this.turma == null) ? (other.turma != null) : !this.turma.equals(other.turma)) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (this.curso != other.curso && (this.curso == null || !this.curso.equals(other.curso))) {
            return false;
        }
        if (this.disciplinaAulas != other.disciplinaAulas && (this.disciplinaAulas == null || !this.disciplinaAulas.equals(other.disciplinaAulas))) {
            return false;
        }
        return true;
    }
}
