/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author João Paulo
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    // A SessionFactory is set up once for an application
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable e) {
            System.out.println("Criação inicial do objeto SessionFactory falhou. Erro: " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Boolean rollbackTransaction() {
        try {
            getSessionFactory().getCurrentSession().getTransaction().rollback();
            getSessionFactory().getCurrentSession().getTransaction().begin();
            return true;
        } finally {
            return false;
        }
    }

    public static Boolean commitTransaction() {
        try {
            getSessionFactory().getCurrentSession().getTransaction().commit();
            getSessionFactory().getCurrentSession().getTransaction().begin();
            return true;
        } catch (Exception e) {
            try {
                getSessionFactory().getCurrentSession().getTransaction().rollback();
                getSessionFactory().getCurrentSession().getTransaction().begin();
            } finally {
                return false;
            }
        }
    }

    public static Boolean limparSessao() {
        try {
            getSessionFactory().getCurrentSession().clear();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
