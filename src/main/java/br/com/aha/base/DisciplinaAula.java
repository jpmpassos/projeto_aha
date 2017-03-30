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
@Table(name = "disciplinaaula")
public class DisciplinaAula implements Serializable, Comparable<DisciplinaAula> {

    private static final long serialVersionUID = 537095593376403309L;
    @Id
    @GeneratedValue
    private int iddisciplinaaula;
    private int creditosrestantes;
    @ManyToOne
    @JoinColumn(name = "idturma")
    private Turma turma;
    @ManyToOne
    @JoinColumn(name = "iddisciplina")
    private Disciplina disciplina;
    @ManyToOne
    @JoinColumn(name = "idprofessor")
    private Professor professor;
    @OneToMany(mappedBy = "disciplinaAula")
    private List<HorarioAula> horarioAulas;

    public List<HorarioAula> getHorarioAulas() {
        return horarioAulas;
    }

    public void setHorarioAulas(List<HorarioAula> horarioAulas) {
        this.horarioAulas = horarioAulas;
    }

    public int getIddisciplinaaula() {
        return iddisciplinaaula;
    }

    public void setIddisciplinaaula(int iddisciplinaaula) {
        this.iddisciplinaaula = iddisciplinaaula;
    }

    public int getCreditosrestantes() {
        return creditosrestantes;
    }

    public void setCreditosrestantes(int creditosrestantes) {
        this.creditosrestantes = creditosrestantes;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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
        hash = 97 * hash + this.iddisciplinaaula;
        hash = 97 * hash + this.creditosrestantes;
        hash = 97 * hash + (this.turma != null ? this.turma.hashCode() : 0);
        hash = 97 * hash + (this.disciplina != null ? this.disciplina.hashCode() : 0);
        hash = 97 * hash + (this.professor != null ? this.professor.hashCode() : 0);
        hash = 97 * hash + (this.horarioAulas != null ? this.horarioAulas.hashCode() : 0);
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
        final DisciplinaAula other = (DisciplinaAula) obj;
        if (this.iddisciplinaaula != other.iddisciplinaaula) {
            return false;
        }
        if (this.creditosrestantes != other.creditosrestantes) {
            return false;
        }
        if (this.turma != other.turma && (this.turma == null || !this.turma.equals(other.turma))) {
            return false;
        }
        if (this.disciplina != other.disciplina && (this.disciplina == null || !this.disciplina.equals(other.disciplina))) {
            return false;
        }
        if (this.professor != other.professor && (this.professor == null || !this.professor.equals(other.professor))) {
            return false;
        }
        if (this.horarioAulas != other.horarioAulas && (this.horarioAulas == null || !this.horarioAulas.equals(other.horarioAulas))) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(DisciplinaAula o) {
        if (this.disciplina.getCreditos() < o.getDisciplina().getCreditos()) {
            return - 1;
        } else {
            return 1;
        }
        
//        if (this.professor.getNome().compareTo(o.getProfessor().getNome()) < 0) {
//            return - 1;
//        } else {
//            return 1;
//        }
        
    }
}
