/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.conversores;


import br.com.aha.base.Turma;
import br.com.aha.ctr.TurmaCTR;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author JP1
 */
@FacesConverter(value = "turmaConverter")
public class TurmaConverter implements Converter{
    
    private TurmaCTR turmaCTR;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        return turmaCTR.carregar(Integer.parseInt(string));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return ((Turma) o).getIdturma().toString();
    }
    
}

