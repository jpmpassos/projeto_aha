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
public class DiaTurma {

    private String descricao;
    private HorarioAula horarioAula;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public HorarioAula getHorarioAula() {
        return horarioAula;
    }

    public void setHorarioAula(HorarioAula horarioAula) {
        this.horarioAula = horarioAula;
    }
}
