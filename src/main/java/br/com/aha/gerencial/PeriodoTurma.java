/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.gerencial;


import br.com.aha.base.Turma;
import java.io.Serializable;

/**
 *
 * @author JP1
 */
public class PeriodoTurma implements Serializable {

    private static final long serialVersionUID = 2599822300559355413L;
    private String periodo;
    private Turma turma;

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
