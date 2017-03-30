/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.gerencial;

import br.com.aha.base.Horario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JP1
 */
public class HorarioP {

    private Horario horario;
    public List<HorarioG> horarios = new ArrayList<HorarioG>();

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public List<HorarioG> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioG> horarios) {
        this.horarios = horarios;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + (this.horario != null ? this.horario.hashCode() : 0);
        hash = 73 * hash + (this.horarios != null ? this.horarios.hashCode() : 0);
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
        final HorarioP other = (HorarioP) obj;
        if (this.horario != other.horario && (this.horario == null || !this.horario.equals(other.horario))) {
            return false;
        }
        if (this.horarios != other.horarios && (this.horarios == null || !this.horarios.equals(other.horarios))) {
            return false;
        }
        return true;
    }
}
