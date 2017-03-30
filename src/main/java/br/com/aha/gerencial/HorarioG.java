/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.gerencial;

import br.com.aha.base.HorarioAula;


/**
 *
 * @author JP1
 */
public class HorarioG {    

    private HorarioAula horarioAula;
    private SalaG salaG;

    public HorarioAula getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(HorarioAula horarioAula) {
        this.horarioAula = horarioAula;
    }

    public SalaG getSalaG() {
        return salaG;
    }

    public void setSalaG(SalaG salaG) {
        this.salaG = salaG;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.horarioAula != null ? this.horarioAula.hashCode() : 0);
        hash = 97 * hash + (this.salaG != null ? this.salaG.hashCode() : 0);
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
        final HorarioG other = (HorarioG) obj;
        if (this.horarioAula != other.horarioAula && (this.horarioAula == null || !this.horarioAula.equals(other.horarioAula))) {
            return false;
        }
        if (this.salaG != other.salaG && (this.salaG == null || !this.salaG.equals(other.salaG))) {
            return false;
        }
        return true;
    }
}
