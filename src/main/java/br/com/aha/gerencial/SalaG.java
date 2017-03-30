/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.gerencial;


import br.com.aha.base.HorarioAula;
import br.com.aha.base.Sala;
import java.util.List;

/**
 *
 * @author JP1
 */
public class SalaG {

    private Sala sala;
    private DiaG diaG;
    public List<HorarioAula> horarioAulas;
    private int hv;

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public DiaG getDiaG() {
        return diaG;
    }

    public void setDiaG(DiaG diaG) {
        this.diaG = diaG;
    }

    public List<HorarioAula> getHorarioAulas() {
        return horarioAulas;
    }

    public void setHorarioAulas(List<HorarioAula> horarioAulas) {
        this.horarioAulas = horarioAulas;
    }

    public int getHv() {
        return hv;
    }

    public void setHv(int hv) {
        this.hv = hv;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.sala != null ? this.sala.hashCode() : 0);
        hash = 97 * hash + (this.diaG != null ? this.diaG.hashCode() : 0);
        hash = 97 * hash + (this.horarioAulas != null ? this.horarioAulas.hashCode() : 0);
        hash = 97 * hash + this.hv;
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
        final SalaG other = (SalaG) obj;
        if (this.sala != other.sala && (this.sala == null || !this.sala.equals(other.sala))) {
            return false;
        }
        if (this.diaG != other.diaG && (this.diaG == null || !this.diaG.equals(other.diaG))) {
            return false;
        }
        if (this.horarioAulas != other.horarioAulas && (this.horarioAulas == null || !this.horarioAulas.equals(other.horarioAulas))) {
            return false;
        }
        if (this.hv != other.hv) {
            return false;
        }
        return true;
    }
}
