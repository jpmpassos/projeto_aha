/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.filtros;

import br.com.aha.util.HibernateUtil;
import java.io.IOException;
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
public class ConexaoHibernateFilter implements Filter {

    private SessionFactory sf;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.sf = HibernateUtil.getSessionFactory();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {
            this.sf.getCurrentSession().beginTransaction();
            chain.doFilter(request, response);
            this.sf.getCurrentSession().getTransaction().commit();
            this.sf.getCurrentSession().close();
        } catch (Throwable ex) {
            try {
                if (this.sf.getCurrentSession().getTransaction().isActive()) {
                    this.sf.getCurrentSession().getTransaction().rollback();
                }
            } catch (Throwable t) {
            }
            throw new ServletException(ex);
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
