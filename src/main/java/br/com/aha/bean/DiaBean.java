/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.bean;

import br.com.aha.base.Dia;
import br.com.aha.ctr.DiaCTR;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author JP1
 */
@ManagedBean
@SessionScoped
public class DiaBean {

    private boolean domingo;
    private boolean segunda;
    private boolean terça;
    private boolean quarta;
    private boolean quinta;
    private boolean sexta;
    private boolean sabado;
    private Dia dia = new Dia();

    public void prepararDia() {
        this.domingo = this.segunda = this.terça = this.quarta = this.quinta = this.sexta = this.sabado = false;
        DiaCTR diaCTR = new DiaCTR();
        List<Dia> lista = diaCTR.listar();
        if (!lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                if ("domingo".equals(lista.get(i).getDia())) {
                    this.domingo = true;
                }
                if ("sabado".equals(lista.get(i).getDia())) {
                    this.sabado = true;
                }
                if ("segunda".equals(lista.get(i).getDia())) {
                    this.segunda = true;
                }
                if ("terça".equals(lista.get(i).getDia())) {
                    this.terça = true;
                }
                if ("quarta".equals(lista.get(i).getDia())) {
                    this.quarta = true;
                }
                if ("quinta".equals(lista.get(i).getDia())) {
                    this.quinta = true;
                }
                if ("sexta".equals(lista.get(i).getDia())) {
                    this.sexta = true;
                }
            }
        }
    }

    public void salvar() {
        DiaCTR diaCTR = new DiaCTR();
        List<Dia> lista = diaCTR.listar();
        int teste;
        teste = 0;
        if (this.domingo) {
            for (int i = 0; i < lista.size(); i++) {
                if ("domingo".equals(lista.get(i).getDia())) {
                    teste = 1;
                }
            }
            if ((teste == 0) && !lista.isEmpty()) {
                this.dia.setDia("domingo");
                diaCTR.salvar(this.dia);
                diaCTR = new DiaCTR();
                this.dia = new Dia();
            }
            if (lista.isEmpty()) {
                this.dia.setDia("domingo");
                diaCTR.salvar(this.dia);
                diaCTR = new DiaCTR();
                this.dia = new Dia();
            }
        } else {
            for (int i = 0; i < lista.size(); i++) {
                if ("domingo".equals(lista.get(i).getDia())) {
                    this.dia = diaCTR.carregar(lista.get(i).getIddia());
                    diaCTR.excluir(this.dia);
                    diaCTR = new DiaCTR();
                    this.dia = new Dia();
                }
            }
        }
        teste = 0;
        if (this.segunda) {
            for (int i = 0; i < lista.size(); i++) {
                if ("segunda".equals(lista.get(i).getDia())) {
                    teste = 1;
                }
            }
            if (teste == 0 && !lista.isEmpty()) {
                this.dia.setDia("segunda");
                diaCTR.salvar(this.dia);
                diaCTR = new DiaCTR();
                this.dia = new Dia();
            }
            if (lista.isEmpty()) {
                this.dia.setDia("segunda");
                diaCTR.salvar(this.dia);
                diaCTR = new DiaCTR();
                this.dia = new Dia();
            }
        } else {
            for (int i = 0; i < lista.size(); i++) {
                if ("segunda".equals(lista.get(i).getDia())) {
                    this.dia = diaCTR.carregar(lista.get(i).getIddia());
                    diaCTR.excluir(this.dia);
                    diaCTR = new DiaCTR();
                    this.dia = new Dia();
                }
            }
        }
        teste = 0;
        if (this.terça) {
            for (int i = 0; i < lista.size(); i++) {
                if ("terça".equals(lista.get(i).getDia())) {
                    teste = 1;
                }
            }
            if (teste == 0 && !lista.isEmpty()) {
                this.dia.setDia("terça");
                diaCTR.salvar(this.dia);
                diaCTR = new DiaCTR();
                this.dia = new Dia();
            }
            if (lista.isEmpty()) {
                this.dia.setDia("terça");
                diaCTR.salvar(this.dia);
                diaCTR = new DiaCTR();
                this.dia = new Dia();
            }
        } else {
            for (int i = 0; i < lista.size(); i++) {
                if ("terça".equals(lista.get(i).getDia())) {
                    this.dia = diaCTR.carregar(lista.get(i).getIddia());
                    diaCTR.excluir(this.dia);
                    diaCTR = new DiaCTR();
                    this.dia = new Dia();
                }
            }
        }
        teste = 0;
        if (this.quarta) {
            for (int i = 0; i < lista.size(); i++) {
                if ("quarta".equals(lista.get(i).getDia())) {
                    teste = 1;
                }
            }
            if (teste == 0 && !lista.isEmpty()) {
                this.dia.setDia("quarta");
                diaCTR.salvar(this.dia);
                diaCTR = new DiaCTR();
                this.dia = new Dia();
            }
            if (lista.isEmpty()) {
                this.dia.setDia("quarta");
                diaCTR.salvar(this.dia);
                diaCTR = new DiaCTR();
                this.dia = new Dia();
            }
        } else {
            for (int i = 0; i < lista.size(); i++) {
                if ("quarta".equals(lista.get(i).getDia())) {
                    this.dia = diaCTR.carregar(lista.get(i).getIddia());
                    diaCTR.excluir(this.dia);
                    diaCTR = new DiaCTR();
                    this.dia = new Dia();
                }
            }
        }
        teste = 0;
        if (this.quinta) {
            for (int i = 0; i < lista.size(); i++) {
                if ("quinta".equals(lista.get(i).getDia())) {
                    teste = 1;
                }
            }
            if (teste == 0 && !lista.isEmpty()) {
                this.dia.setDia("quinta");
                diaCTR.salvar(this.dia);
                diaCTR = new DiaCTR();
                this.dia = new Dia();
            }
            if (lista.isEmpty()) {
                this.dia.setDia("quinta");
                diaCTR.salvar(this.dia);
                diaCTR = new DiaCTR();
                this.dia = new Dia();
            }
        } else {
            for (int i = 0; i < lista.size(); i++) {
                if ("quinta".equals(lista.get(i).getDia())) {
                    this.dia = diaCTR.carregar(lista.get(i).getIddia());
                    diaCTR.excluir(this.dia);
                    diaCTR = new DiaCTR();
                    this.dia = new Dia();
                }
            }
        }
        teste = 0;
        if (this.sexta) {
            for (int i = 0; i < lista.size(); i++) {
                if ("sexta".equals(lista.get(i).getDia())) {
                    teste = 1;
                }
            }
            if (teste == 0 && !lista.isEmpty()) {
                this.dia.setDia("sexta");
                diaCTR.salvar(this.dia);
                diaCTR = new DiaCTR();
                this.dia = new Dia();
            }
            if (lista.isEmpty()) {
                this.dia.setDia("sexta");
                diaCTR.salvar(this.dia);
                diaCTR = new DiaCTR();
                this.dia = new Dia();
            }
        } else {
            for (int i = 0; i < lista.size(); i++) {
                if ("sexta".equals(lista.get(i).getDia())) {
                    this.dia = diaCTR.carregar(lista.get(i).getIddia());
                    diaCTR.excluir(this.dia);
                    diaCTR = new DiaCTR();
                    this.dia = new Dia();
                }
            }
        }
        teste = 0;
        if (this.sabado) {
            for (int i = 0; i < lista.size(); i++) {
                if ("sabado".equals(lista.get(i).getDia())) {
                    teste = 1;
                }
            }
            if (teste == 0 && !lista.isEmpty()) {
                this.dia.setDia("sabado");
                diaCTR.salvar(this.dia);
                diaCTR = new DiaCTR();
                this.dia = new Dia();
            }
            if (lista.isEmpty()) {
                this.dia.setDia("sabado");
                diaCTR.salvar(this.dia);
                diaCTR = new DiaCTR();
                this.dia = new Dia();
            }
        } else {
            for (int i = 0; i < lista.size(); i++) {
                if ("sabado".equals(lista.get(i).getDia())) {
                    this.dia = diaCTR.carregar(lista.get(i).getIddia());
                    diaCTR.excluir(this.dia);
                    diaCTR = new DiaCTR();
                    this.dia = new Dia();
                }
            }
        }
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public boolean isDomingo() {
        return domingo;
    }

    public void setDomingo(boolean domingo) {
        this.domingo = domingo;
    }

    public boolean isSegunda() {
        return segunda;
    }

    public void setSegunda(boolean segunda) {
        this.segunda = segunda;
    }

    public boolean isTerça() {
        return terça;
    }

    public void setTerça(boolean terça) {
        this.terça = terça;
    }

    public boolean isQuarta() {
        return quarta;
    }

    public void setQuarta(boolean quarta) {
        this.quarta = quarta;
    }

    public boolean isQuinta() {
        return quinta;
    }

    public void setQuinta(boolean quinta) {
        this.quinta = quinta;
    }

    public boolean isSexta() {
        return sexta;
    }

    public void setSexta(boolean sexta) {
        this.sexta = sexta;
    }

    public boolean isSabado() {
        return sabado;
    }

    public void setSabado(boolean sabado) {
        this.sabado = sabado;
    }

    public void setAlreadyAssociated(boolean b) {
    }
}
