/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.exceptions;

/**
 *
 * @author João Paulo
 */
public class NegocioException extends RuntimeException {

    private Integer tipo;
    private String dlg;

    public NegocioException(String message, Integer tipo, String dlg) {
        super(message);
        this.tipo = tipo;
        this.dlg = dlg;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getDlg() {
        return dlg;
    }

    public void setDlg(String dlg) {
        this.dlg = dlg;
    }

    public static NegocioException getNegocioException(Throwable throwable) {
        if (throwable instanceof NegocioException) {
            return (NegocioException) throwable;
        } else if (throwable.getCause() != null) {
            return getNegocioException(throwable.getCause());
        }
        return null;
    }

}
