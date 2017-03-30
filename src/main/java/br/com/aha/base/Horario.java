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
@Table(name = "horario")
public class Horario implements Serializable {

    private static final long serialVersionUID = -5067797458907869301L;
    @Id
    @GeneratedValue
    private int idhorario;
    private String horario;
    private String descricao;
    private String turno;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "pk.horario",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
        org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    private List<HorarioAula> horarioAulas = new LinkedList<HorarioAula>();

    public int getIdhorario() {
        return idhorario;
    }

    public void setIdhorario(int idhorario) {
        this.idhorario = idhorario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public List<HorarioAula> getHorarioAulas() {
        return horarioAulas;
    }

    public void setHorarioAulas(List<HorarioAula> horarioAulas) {
        this.horarioAulas = horarioAulas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.idhorario;
        hash = 59 * hash + (this.horario != null ? this.horario.hashCode() : 0);
        hash = 59 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 59 * hash + (this.turno != null ? this.turno.hashCode() : 0);
        hash = 59 * hash + (this.horarioAulas != null ? this.horarioAulas.hashCode() : 0);
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
        final Horario other = (Horario) obj;
        if (this.idhorario != other.idhorario) {
            return false;
        }
        if ((this.horario == null) ? (other.horario != null) : !this.horario.equals(other.horario)) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if ((this.turno == null) ? (other.turno != null) : !this.turno.equals(other.turno)) {
            return false;
        }
        if (this.horarioAulas != other.horarioAulas && (this.horarioAulas == null || !this.horarioAulas.equals(other.horarioAulas))) {
            return false;
        }
        return true;
    }
}
