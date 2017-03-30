/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.gerencial;

import br.com.aha.base.Turma;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JP1
 */
public class HorarioTurma {

    private Turma turma;
    public List<HorarioDiaTurma> horarioDiaTurmas = new ArrayList<HorarioDiaTurma>();

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<HorarioDiaTurma> getHorarioDiaTurmas() {
        return horarioDiaTurmas;
    }

    public void setHorarioDiaTurmas(List<HorarioDiaTurma> horarioDiaTurmas) {
        this.horarioDiaTurmas = horarioDiaTurmas;
    }
}
