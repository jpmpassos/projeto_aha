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
@Table(name = "professor")
public class Professor implements Serializable {

    private static final long serialVersionUID = -7882751556706319780L;
    @Id
    @GeneratedValue
    private int idprofessor;
    private String nome;
    private String matricula;
    private String descricao;
    @OneToMany(mappedBy = "professor")
    private List<DisciplinaAula> disciplinaAulas;

    public int getIdprofessor() {
        return idprofessor;
    }

    public void setIdprofessor(int idprofessor) {
        this.idprofessor = idprofessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        hash = 59 * hash + this.idprofessor;
        hash = 59 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        hash = 59 * hash + (this.matricula != null ? this.matricula.hashCode() : 0);
        hash = 59 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
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
        final Professor other = (Professor) obj;
        if (this.idprofessor != other.idprofessor) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        if ((this.matricula == null) ? (other.matricula != null) : !this.matricula.equals(other.matricula)) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (this.disciplinaAulas != other.disciplinaAulas && (this.disciplinaAulas == null || !this.disciplinaAulas.equals(other.disciplinaAulas))) {
            return false;
        }
        return true;
    }
}
