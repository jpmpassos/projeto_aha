package br.com.aha.bean;

///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.aha.bean;
//
//import com.aha.aha.PeriodoTurma;
//import com.aha.base.Turma;
//import com.aha.ctr.TurmaCTR;
//import java.util.ArrayList;
//import java.util.List;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import org.primefaces.event.TransferEvent;
//import org.primefaces.model.DualListModel;
//
///**
// *
// * @author JP1
// */
//@ManagedBean
//@SessionScoped
//public class DisciplinaAulaBean_picklist {
//
//    private DualListModel<Turma> turmas;
//    private Turma turma;
//    private int periodo;
//    private List<PeriodoTurma> periodoTurmas = new ArrayList<PeriodoTurma>();
//    private PeriodoTurma periodoTurma = new PeriodoTurma();
//
//    public DisciplinaAulaBean_picklist() {
//        TurmaCTR turmaCTR = new TurmaCTR();
//        List<Turma> source = turmaCTR.listar();
//        List<Turma> target = new ArrayList<Turma>();
//        turmas = new DualListModel<Turma>(source, target);
//    }
//
//    public void limpar(){
//        this.periodoTurma = new PeriodoTurma();
//        this.periodoTurmas = new ArrayList<PeriodoTurma>();
//    }
//    
//    public void onTransfer(TransferEvent event){
//        this.periodoTurma.setTurma((Turma) event.getItems());
//        
//    }
//    public void testar(){
//        System.out.println(periodoTurma.getTurma().getTurma());
//        System.out.println(periodoTurma.getPeriodo());
//        System.out.println("********************");
//    }
//    
//    public void addTurmaP() {
//        System.out.println("********************");
//        this.periodoTurma.setPeriodo(this.periodo);
//        System.out.println(periodoTurma.getPeriodo());
//    }
//
//    public int getPeriodo() {
//        return periodo;
//    }
//
//    public void setPeriodo(int periodo) {
//        this.periodo = periodo;
//    }
//
//    public Turma getTurma() {
//        return turma;
//    }
//
//    public void setTurma(Turma turma) {
//        this.turma = turma;
//    }
//
//    public DualListModel<Turma> getTurmas() {
//        return turmas;
//    }
//
//    public void setTurmas(DualListModel<Turma> turmas) {
//        this.turmas = turmas;
//    }
//}
