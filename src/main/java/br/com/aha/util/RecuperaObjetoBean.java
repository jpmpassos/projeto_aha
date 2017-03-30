/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.util;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author João Paulo
 */
public class RecuperaObjetoBean {

    public static <T> Object getObjectSession(String attribute) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession(true);
        return session.getAttribute(attribute);
    }

    public static Boolean fecharObjectSession(String attribute) {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession(true);
            session.invalidate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
