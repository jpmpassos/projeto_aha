/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.base;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author JP1
 */
@Embeddable
public class HorarioAulaPK implements Serializable {
    private static final long serialVersionUID = -6818377887543909789L;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Dia dia;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Sala sala;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Horario horario;

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.dia != null ? this.dia.hashCode() : 0);
        hash = 37 * hash + (this.sala != null ? this.sala.hashCode() : 0);
        hash = 37 * hash + (this.horario != null ? this.horario.hashCode() : 0);
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
        final HorarioAulaPK other = (HorarioAulaPK) obj;
        if (this.dia != other.dia && (this.dia == null || !this.dia.equals(other.dia))) {
            return false;
        }
        if (this.sala != other.sala && (this.sala == null || !this.sala.equals(other.sala))) {
            return false;
        }
        if (this.horario != other.horario && (this.horario == null || !this.horario.equals(other.horario))) {
            return false;
        }
        return true;
    }
}
