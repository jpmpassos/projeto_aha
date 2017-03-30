/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.util;

import br.com.aha.dao.CursoDAO;
import br.com.aha.dao.CursoDAOImpl;
import br.com.aha.dao.DiaDAO;
import br.com.aha.dao.DiaDAOImpl;
import br.com.aha.dao.DisciplinaAulaDAO;
import br.com.aha.dao.DisciplinaAulaDAOImpl;
import br.com.aha.dao.DisciplinaDAO;
import br.com.aha.dao.DisciplinaDAOImpl;
import br.com.aha.dao.HorarioAulaDAO;
import br.com.aha.dao.HorarioAulaDAOImpl;
import br.com.aha.dao.HorarioDAO;
import br.com.aha.dao.HorarioDAOImpl;
import br.com.aha.dao.ProfessorDAO;
import br.com.aha.dao.ProfessorDAOImpl;
import br.com.aha.dao.SalaDAO;
import br.com.aha.dao.SalaDAOImpl;
import br.com.aha.dao.TurmaDAO;
import br.com.aha.dao.TurmaDAOImpl;

/**
 *
 * @author João Paulo
 */
public class DAOFactory {

    public static DisciplinaDAO criardisciplinaDAO() {
        DisciplinaDAOImpl disciplinaDAOImpl = new DisciplinaDAOImpl();
        disciplinaDAOImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return disciplinaDAOImpl;
    }

//    
//    public static VisitaDAO criarVisitaDAO() {
//        VisitaDAOImpl visitaDAOImpl = new VisitaDAOImpl();        
//        visitaDAOImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());        
//        return visitaDAOImpl;
//    }
    public static CursoDAO criarcursoDAO() {
        CursoDAOImpl cursoDAOImpl = new CursoDAOImpl();
        cursoDAOImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return cursoDAOImpl;
    }

    public static DiaDAO criarDiaDAO() {
        DiaDAOImpl diaDAOImpl = new DiaDAOImpl();
        diaDAOImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return diaDAOImpl;
    }

    public static DisciplinaAulaDAO criardisciplinaaualaDAO() {
        DisciplinaAulaDAOImpl disciplinaAulaDAOImpl = new DisciplinaAulaDAOImpl();
        disciplinaAulaDAOImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return disciplinaAulaDAOImpl;
    }

    public static HorarioAulaDAO criarhorarioaulaDAO() {
        HorarioAulaDAOImpl horarioAulaDAOImpl = new HorarioAulaDAOImpl();
        horarioAulaDAOImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return horarioAulaDAOImpl;
    }

    public static HorarioDAO criarhorarioDAO() {
        HorarioDAOImpl horarioDAOImpl = new HorarioDAOImpl();
        horarioDAOImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return horarioDAOImpl;
    }

    public static ProfessorDAO criarprofessorDAO() {
        ProfessorDAOImpl professorDAOImpl = new ProfessorDAOImpl();
        professorDAOImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return professorDAOImpl;
    }

    public static SalaDAO criarsalaDAO() {
        SalaDAOImpl salaDAOImpl = new SalaDAOImpl();
        salaDAOImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return salaDAOImpl;
    }

    public static TurmaDAO criarturmaDAO() {
        TurmaDAOImpl turmaDAOImpl = new TurmaDAOImpl();
        turmaDAOImpl.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return turmaDAOImpl;
    }
}
