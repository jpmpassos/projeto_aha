/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.filtros;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.FilterChain;

/**
 *
 * @author João Paulo
 */
public class CaracterEncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
