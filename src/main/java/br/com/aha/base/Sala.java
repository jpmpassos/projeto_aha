/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.base;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author JP1
 */
@Entity
@Table(name = "sala")
public class Sala implements Serializable {

    private static final long serialVersionUID = -5714129866094169879L;
    @Id
    @GeneratedValue
    private int idsala;
    private String sala;
    private String descricao;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "pk.sala",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE,
        org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
    private List<HorarioAula> horarioAulas = new LinkedList<HorarioAula>();

    public int getIdsala() {
        return idsala;
    }

    public void setIdsala(int idsala) {
        this.idsala = idsala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<HorarioAula> getHorarioAulas() {
        return horarioAulas;
    }

    public void setHorarioAulas(List<HorarioAula> horarioAulas) {
        this.horarioAulas = horarioAulas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.idsala;
        hash = 53 * hash + (this.sala != null ? this.sala.hashCode() : 0);
        hash = 53 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
        hash = 53 * hash + (this.horarioAulas != null ? this.horarioAulas.hashCode() : 0);
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
        final Sala other = (Sala) obj;
        if (this.idsala != other.idsala) {
            return false;
        }
        if ((this.sala == null) ? (other.sala != null) : !this.sala.equals(other.sala)) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        if (this.horarioAulas != other.horarioAulas && (this.horarioAulas == null || !this.horarioAulas.equals(other.horarioAulas))) {
            return false;
        }
        return true;
    }
}
