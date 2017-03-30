/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.filtros;

import br.com.aha.logincontrole.LoginControle;
import br.com.aha.util.HibernateUtil;
import br.com.aha.util.RecuperaObjetoBean;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.hibernate.SessionFactory;

/**
 *
 * @author João Paulo
 */
public class VerificarSessaoFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {
            LoginControle loginControle = (LoginControle) RecuperaObjetoBean.getObjectSession("loginControle");
            if (loginControle != null) {
                chain.doFilter(request, response);
            } else {
                FacesContext ctx = FacesContext.getCurrentInstance();
                ctx.getExternalContext().redirect(ctx.getExternalContext().getRequestContextPath() + "/../index.jsf");
            }
        } catch (Throwable ex) {
           chain.doFilter(request, response);
        }
    }
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        try {
//            try {
//                this.sf.getCurrentSession().beginTransaction();
//                chain.doFilter(request, response);
//                this.sf.getCurrentSession().getTransaction().commit();
//                this.sf.getCurrentSession().close();
//            } catch (Throwable ex) {
//                try {
//                    if (this.sf.getCurrentSession().getTransaction().isActive()) {
//                        this.sf.getCurrentSession().getTransaction().rollback();
//                    }
//                } catch (Throwable t) {
//                }
//                throw new ServletException(ex);
//            }
//        } catch (Exception e) {
//            try {
//                this.sf.getCurrentSession().close();
//                this.sf.getCurrentSession().beginTransaction();
//                chain.doFilter(request, response);
//                this.sf.getCurrentSession().getTransaction().commit();
//                this.sf.getCurrentSession().close();
//            } finally {
//                FacesContext.getCurrentInstance().getExternalContext().redirect("/erros/erro.jsf");
//            }
//        }
//    }

    @Override
    public void destroy() {
    }
}
