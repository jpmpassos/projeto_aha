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
@Table(name = "disciplina")
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 4972847172811630496L;
    @Id
    @GeneratedValue
    private int iddisciplina;
    private String disciplina;
    private String periodo;
    private int creditos;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "idcurso")
    private Curso curso;
    @OneToMany(mappedBy = "disciplina")
    private List<DisciplinaAula> disciplinaAulas;

    public int getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(int iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
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
        int hash = 3;
        hash = 59 * hash + this.iddisciplina;
        hash = 59 * hash + (this.disciplina != null ? this.disciplina.hashCode() : 0);
        hash = 59 * hash + (this.periodo != null ? this.periodo.hashCode() : 0);
        hash = 59 * hash + this.creditos;
        hash = 59 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 59 * hash + (this.curso != null ? this.curso.hashCode() : 0);
        hash = 59 * hash + (this.disciplinaAulas != null ? this.disciplinaAulas.hashCode() : 0);
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
        final Disciplina other = (Disciplina) obj;
        if (this.iddisciplina != other.iddisciplina) {
            return false;
        }
        if ((this.disciplina == null) ? (other.disciplina != null) : !this.disciplina.equals(other.disciplina)) {
            return false;
        }
        if ((this.periodo == null) ? (other.periodo != null) : !this.periodo.equals(other.periodo)) {
            return false;
        }
        if (this.creditos != other.creditos) {
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
