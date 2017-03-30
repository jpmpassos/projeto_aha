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
@Entity
@Table(name = "horarioaula")
@AssociationOverrides({
    @AssociationOverride(name = "pk.sala", joinColumns =
            @JoinColumn(name = "idsala")),
    @AssociationOverride(name = "pk.horario", joinColumns =
            @JoinColumn(name = "idhorario")),
    @AssociationOverride(name = "pk.dia", joinColumns =
            @JoinColumn(name = "iddia"))})
public class HorarioAula implements Serializable {

    private static final long serialVersionUID = -4218301455694340187L;
    @EmbeddedId
    private HorarioAulaPK pk = new HorarioAulaPK();
    @ManyToOne
    @JoinColumn(name = "iddisciplinaaula")
    private DisciplinaAula disciplinaAula;

    public HorarioAulaPK getPk() {
        return pk;
    }

    public void setPk(HorarioAulaPK pk) {
        this.pk = pk;
    }

    public DisciplinaAula getDisciplinaAula() {
        return disciplinaAula;
    }

    public void setDisciplinaAula(DisciplinaAula disciplinaAula) {
        this.disciplinaAula = disciplinaAula;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.pk != null ? this.pk.hashCode() : 0);
        hash = 29 * hash + (this.disciplinaAula != null ? this.disciplinaAula.hashCode() : 0);
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
        final HorarioAula other = (HorarioAula) obj;
        if (this.pk != other.pk && (this.pk == null || !this.pk.equals(other.pk))) {
            return false;
        }
        if (this.disciplinaAula != other.disciplinaAula && (this.disciplinaAula == null || !this.disciplinaAula.equals(other.disciplinaAula))) {
            return false;
        }
        return true;
    }
}
