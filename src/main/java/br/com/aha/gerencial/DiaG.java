/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.gerencial;


import br.com.aha.base.Dia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JP1
 */
public class DiaG {

    private Dia dia;
    public List<SalaG> salas;
    public List<HorarioP> horarios = new ArrayList<HorarioP>();
    private int hv;

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public List<SalaG> getSalas() {
        return salas;
    }

    public void setSalas(List<SalaG> salas) {
        this.salas = salas;
    }

    public int getHv() {
        return hv;
    }

    public void setHv(int hv) {
        this.hv = hv;
    }

    public List<HorarioP> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<HorarioP> horarios) {
        this.horarios = horarios;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.dia != null ? this.dia.hashCode() : 0);
        hash = 17 * hash + (this.salas != null ? this.salas.hashCode() : 0);
        hash = 17 * hash + this.hv;
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
        final DiaG other = (DiaG) obj;
        if (this.dia != other.dia && (this.dia == null || !this.dia.equals(other.dia))) {
            return false;
        }
        if (this.salas != other.salas && (this.salas == null || !this.salas.equals(other.salas))) {
            return false;
        }
        if (this.hv != other.hv) {
            return false;
        }
        return true;
    }
}
