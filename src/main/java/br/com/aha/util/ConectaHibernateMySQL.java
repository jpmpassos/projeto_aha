/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.util;

import java.math.BigDecimal;
import org.hibernate.Session;

/**
 *
 * @author João Paulo
 */
public class ConectaHibernateMySQL {

    public static void main(String[] args) {

        BigDecimal a = new BigDecimal(20);
        BigDecimal b = new BigDecimal(254.58754);

        BigDecimal c = a.add(b);

        System.out.println(c);

//        Session sessao = null;
//        try {
//            sessao = HibernateUtil.getSessionFactory().openSession();
//            System.out.println("Conectou!");
//        } finally {
//            sessao.close();
//        }

        /*      UsuarioCTR usuarioCTR = null;
         int i = usuarioCTR.listar().size();
         System.out.println(i);
         */
    }
}
