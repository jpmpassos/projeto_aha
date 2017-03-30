/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.gerencial;

/**
 *
 * @author JP1
 */
public class HorarioDiaTurma {

    private String descricao;
    private DiaTurma segunda;
    private DiaTurma terca;
    private DiaTurma quarta;
    private DiaTurma quinta;
    private DiaTurma sexta;
    private DiaTurma sabado;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public DiaTurma getSegunda() {
        return segunda;
    }

    public void setSegunda(DiaTurma segunda) {
        this.segunda = segunda;
    }

    public DiaTurma getTerca() {
        return terca;
    }

    public void setTerca(DiaTurma terca) {
        this.terca = terca;
    }

    public DiaTurma getQuarta() {
        return quarta;
    }

    public void setQuarta(DiaTurma quarta) {
        this.quarta = quarta;
    }

    public DiaTurma getQuinta() {
        return quinta;
    }

    public void setQuinta(DiaTurma quinta) {
        this.quinta = quinta;
    }

    public DiaTurma getSexta() {
        return sexta;
    }

    public void setSexta(DiaTurma sexta) {
        this.sexta = sexta;
    }

    public DiaTurma getSabado() {
        return sabado;
    }

    public void setSabado(DiaTurma sabado) {
        this.sabado = sabado;
    }
}
