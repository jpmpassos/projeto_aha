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
@Table(name = "preferencia")
@AssociationOverrides({
    @AssociationOverride(name = "pk.professor", joinColumns =
            @JoinColumn(name = "idprofessor")),
    @AssociationOverride(name = "pk.dia", joinColumns =
            @JoinColumn(name = "iddia"))})
public class Preferencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private PreferenciaPK pk = new PreferenciaPK();
    private String descricao;

    public PreferenciaPK getPk() {
        return pk;
    }

    public void setPk(PreferenciaPK pk) {
        this.pk = pk;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (this.pk != null ? this.pk.hashCode() : 0);
        hash = 59 * hash + (this.descricao != null ? this.descricao.hashCode() : 0);
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
        final Preferencia other = (Preferencia) obj;
        if (this.pk != other.pk && (this.pk == null || !this.pk.equals(other.pk))) {
            return false;
        }
        if ((this.descricao == null) ? (other.descricao != null) : !this.descricao.equals(other.descricao)) {
            return false;
        }
        return true;
    }
}
