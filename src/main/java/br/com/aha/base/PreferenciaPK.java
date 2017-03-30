/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.base;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

/**
 *
 * @author JP1
 */
@Embeddable
public class PreferenciaPK implements Serializable {

    private static final long serialVersionUID = 8551994990999352159L;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Dia dia;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Professor professor;

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (this.dia != null ? this.dia.hashCode() : 0);
        hash = 17 * hash + (this.professor != null ? this.professor.hashCode() : 0);
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
        final PreferenciaPK other = (PreferenciaPK) obj;
        if (this.dia != other.dia && (this.dia == null || !this.dia.equals(other.dia))) {
            return false;
        }
        if (this.professor != other.professor && (this.professor == null || !this.professor.equals(other.professor))) {
            return false;
        }
        return true;
    }
}
