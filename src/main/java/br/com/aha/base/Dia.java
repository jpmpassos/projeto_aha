/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.base;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author JP1
 */
@Entity
@Table(name = "dia")
public class Dia implements Serializable {

    private static final long serialVersionUID = -3889521508743669737L;
    @Id
    @GeneratedValue
    private int iddia;
    private String dia;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "pk.dia",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
        org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    private List<HorarioAula> horarioAulas = new LinkedList<HorarioAula>();

    public int getIddia() {
        return iddia;
    }

    public void setIddia(int iddia) {
        this.iddia = iddia;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public List<HorarioAula> getHorarioAulas() {
        return horarioAulas;
    }

    public void setHorarioAulas(List<HorarioAula> horarioAulas) {
        this.horarioAulas = horarioAulas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.iddia;
        hash = 43 * hash + (this.dia != null ? this.dia.hashCode() : 0);
        hash = 43 * hash + (this.horarioAulas != null ? this.horarioAulas.hashCode() : 0);
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
        final Dia other = (Dia) obj;
        if (this.iddia != other.iddia) {
            return false;
        }
        if ((this.dia == null) ? (other.dia != null) : !this.dia.equals(other.dia)) {
            return false;
        }
        if (this.horarioAulas != other.horarioAulas && (this.horarioAulas == null || !this.horarioAulas.equals(other.horarioAulas))) {
            return false;
        }
        return true;
    }
}
