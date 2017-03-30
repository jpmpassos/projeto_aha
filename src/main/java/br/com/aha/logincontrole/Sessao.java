/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.logincontrole;


import java.io.Serializable;

/**
 *
 * @author João Paulo
 */
public class Sessao implements Serializable {

    private static final long serialVersionUID = -1778117781146621900L;

    private Boolean administrador;
    private Boolean suporteinterno;
    private Boolean logado;
   

    public Sessao(Boolean administrador) {
        this.administrador = administrador;
    }

    public Sessao() {
        this.administrador = false;

    }

    public Boolean getLogado() {
        return logado;
    }

    public void setLogado(Boolean logado) {
        this.logado = logado;
    }


    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }
    
    public Boolean getSuporteinterno() {
        return suporteinterno;
    }

    public void setSuporteinterno(Boolean suporteinterno) {
        this.suporteinterno = suporteinterno;
    }


}
