/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.util;

import java.util.Iterator;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

/**
 *
 * @author João Paulo
 */
public final class MbUtil {

    public static void resetComponentTree(final FacesContext context, final String componentId) {
        final UIComponent form = findComponent(context.getViewRoot(), componentId);
        if (form != null) {
            resetComponent(form);
        }
    }

    private static UIComponent findComponent(final UIComponent c, final String id) {
        if (id.equals(c.getId())) {
            return c;
        }
        final Iterator<UIComponent> kids = c.getFacetsAndChildren();
        while (kids.hasNext()) {
            final UIComponent found = findComponent(kids.next(), id);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    private static void resetComponent(final UIComponent c) {
        if (c instanceof UIInput) {
            final UIInput uiInput = (UIInput) c;
            uiInput.setValue(null);
            uiInput.setSubmittedValue(null);
            uiInput.setValid(true);
        }

        Iterator<UIComponent> children = c.getFacetsAndChildren();
        while (children.hasNext()) {
            resetComponent(children.next());
        }
    }
}
