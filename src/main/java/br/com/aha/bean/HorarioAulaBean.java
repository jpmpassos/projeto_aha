/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.bean;

import br.com.aha.gerencial.DiaTurma;
import br.com.aha.gerencial.HorarioDiaTurma;
import br.com.aha.gerencial.HorarioTurma;
import br.com.aha.base.Dia;
import br.com.aha.base.Horario;
import br.com.aha.base.HorarioAula;
import br.com.aha.base.HorarioAulaPK;
import br.com.aha.base.Sala;
import br.com.aha.base.Turma;
import br.com.aha.ctr.DiaCTR;
import br.com.aha.ctr.HorarioAulaCTR;
import br.com.aha.ctr.HorarioCTR;
import br.com.aha.ctr.SalaCTR;
import br.com.aha.ctr.TurmaCTR;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author JP1
 */
@ManagedBean
@SessionScoped
public class HorarioAulaBean {

    private List<Dia> listaDia;
    private List<Sala> listaSala;
    private List<Horario> listaHorario;
    private HorarioAula horarioAula;
    private List<HorarioAula> lista;
    public List<HorarioTurma> horarioTurmas ;
    
    public void limpar(){
        this.horarioTurmas = null;
    }

    public void gerarHorarioAula() {
        DiaCTR diaCTR = new DiaCTR();
        SalaCTR salaCTR = new SalaCTR();
        HorarioCTR horarioCTR = new HorarioCTR();
        HorarioAulaCTR horarioAulaCTR;
        HorarioAulaPK horarioAulaPK;
        
        this.listaDia = diaCTR.listar();
        this.listaSala = salaCTR.listar();
        this.listaHorario = horarioCTR.listar();

        for (int i = 0; i < this.listaDia.size(); i++) {
            for (int j = 0; j < this.listaSala.size(); j++) {
                for (int t = 0; t < this.listaHorario.size(); t++) {
                    horarioAulaCTR = new HorarioAulaCTR();
                    this.horarioAula = new HorarioAula();
                    horarioAulaPK = new HorarioAulaPK();
                    horarioAulaPK.setDia(listaDia.get(i));
                    horarioAulaPK.setSala(listaSala.get(j));
                    horarioAulaPK.setHorario(listaHorario.get(t));
                    this.horarioAula.setPk(horarioAulaPK);
                    horarioAulaCTR.salvar(this.horarioAula);
                }
            }
        }
    }

    public List<HorarioAula> getLista() {
        if (this.lista == null) {
            HorarioAulaCTR horarioAulaCTR = new HorarioAulaCTR();
            return horarioAulaCTR.listar();
        }
        return lista;
    }

    public void setLista(List<HorarioAula> lista) {
        this.lista = lista;
    }

    public List<HorarioTurma> getHorarioTurmas() {
        if (horarioTurmas == null) {
            horarioTurmas = new ArrayList<HorarioTurma>();
            TurmaCTR turmaCTR = new TurmaCTR();
            List<Turma> turmas = turmaCTR.listar();
            DiaCTR diaCTR = new DiaCTR();
            List<HorarioAula> horarioAulas = pegarHAD();
            List<Dia> dias = diaCTR.listar();
            HorarioDiaTurma horarioDiaTurma;
            HorarioCTR horarioCTR = new HorarioCTR();
            HorarioTurma horarioTurma;
            List<Horario> horarios = horarioCTR.listar();
            for (int i = 0; i < turmas.size(); i++) {
                horarioTurma = new HorarioTurma();
                horarioTurma.setTurma(turmas.get(i));
                for (int x = 0; x < horarios.size(); x++) {
                    horarioDiaTurma = new HorarioDiaTurma();
                    horarioDiaTurma.setDescricao(horarios.get(x).getHorario());
                    DiaTurma diaTurma = new DiaTurma();
                    Boolean teste = true;
                    for (int t = 0; t < horarioAulas.size(); t++) {
                        if (turmas.get(i).equals(horarioAulas.get(t).getDisciplinaAula().getTurma())
                                && horarioAulas.get(t).getPk().getDia().getDia().equals("segunda")
                                && horarioAulas.get(t).getPk().getHorario().equals(horarios.get(x))) {
                            teste = false;
                            diaTurma = new DiaTurma();
                            diaTurma.setDescricao(horarioAulas.get(t).getDisciplinaAula().getDisciplina().getDisciplina());
                            diaTurma.setHorarioAula(horarioAulas.get(t));
                            t = horarioAulas.size();
                        }
                    }
                    if (teste) {
                        diaTurma = new DiaTurma();
                        diaTurma.setDescricao("<< Vago >>");
                    }
                    horarioDiaTurma.setSegunda(diaTurma);
                    teste = true;
                    for (int t = 0; t < horarioAulas.size(); t++) {
                        if (turmas.get(i).equals(horarioAulas.get(t).getDisciplinaAula().getTurma())
                                && horarioAulas.get(t).getPk().getDia().getDia().equals("terça")
                                && horarioAulas.get(t).getPk().getHorario().equals(horarios.get(x))) {
                            teste = false;
                            diaTurma = new DiaTurma();
                            diaTurma.setDescricao(horarioAulas.get(t).getDisciplinaAula().getDisciplina().getDisciplina());
                            diaTurma.setHorarioAula(horarioAulas.get(t));
                            t = horarioAulas.size();
                        }
                    }
                    if (teste) {
                        diaTurma = new DiaTurma();
                        diaTurma.setDescricao("<< Vago >>");
                    }
                    horarioDiaTurma.setTerca(diaTurma);
                    teste = true;
                    for (int t = 0; t < horarioAulas.size(); t++) {
                        if (turmas.get(i).equals(horarioAulas.get(t).getDisciplinaAula().getTurma())
                                && horarioAulas.get(t).getPk().getDia().getDia().equals("quarta")
                                && horarioAulas.get(t).getPk().getHorario().equals(horarios.get(x))) {
                            teste = false;
                            diaTurma = new DiaTurma();
                            diaTurma.setDescricao(horarioAulas.get(t).getDisciplinaAula().getDisciplina().getDisciplina());
                            diaTurma.setHorarioAula(horarioAulas.get(t));
                            t = horarioAulas.size();
                        }
                    }
                    if (teste) {
                        diaTurma = new DiaTurma();
                        diaTurma.setDescricao("<< Vago >>");
                    }
                    horarioDiaTurma.setQuarta(diaTurma);
                    teste = true;
                    for (int t = 0; t < horarioAulas.size(); t++) {
                        if (turmas.get(i).equals(horarioAulas.get(t).getDisciplinaAula().getTurma())
                                && horarioAulas.get(t).getPk().getDia().getDia().equals("quinta")
                                && horarioAulas.get(t).getPk().getHorario().equals(horarios.get(x))) {
                            teste = false;
                            diaTurma = new DiaTurma();
                            diaTurma.setDescricao(horarioAulas.get(t).getDisciplinaAula().getDisciplina().getDisciplina());
                            diaTurma.setHorarioAula(horarioAulas.get(t));
                            t = horarioAulas.size();
                        }
                    }
                    if (teste) {
                        diaTurma = new DiaTurma();
                        diaTurma.setDescricao("<< Vago >>");
                    }
                    horarioDiaTurma.setQuinta(diaTurma);
                    teste = true;
                    for (int t = 0; t < horarioAulas.size(); t++) {
                        if (turmas.get(i).equals(horarioAulas.get(t).getDisciplinaAula().getTurma())
                                && horarioAulas.get(t).getPk().getDia().getDia().equals("sexta")
                                && horarioAulas.get(t).getPk().getHorario().equals(horarios.get(x))) {
                            teste = false;
                            diaTurma = new DiaTurma();
                            diaTurma.setDescricao(horarioAulas.get(t).getDisciplinaAula().getDisciplina().getDisciplina());
                            diaTurma.setHorarioAula(horarioAulas.get(t));
                            t = horarioAulas.size();
                        }
                    }
                    if (teste) {
                        diaTurma = new DiaTurma();
                        diaTurma.setDescricao("<< Vago >>");
                    }
                    horarioDiaTurma.setSexta(diaTurma);
                    horarioTurma.horarioDiaTurmas.add(horarioDiaTurma);
                }
                horarioTurmas.add(horarioTurma);
            }
        }
        return horarioTurmas;
    }

    public List<HorarioAula> pegarHAD() {
        List<HorarioAula> horarioAulas = getLista();
        for (int i = 0; i < horarioAulas.size(); i++) {
            if (horarioAulas.get(i).getDisciplinaAula() == null) {
                horarioAulas.remove(i);
                --i;
            }
        }
        return horarioAulas;
    }

//    public List<HorarioTurma> getHorarioTurmas() {
//        this.horarioTurmas = new ArrayList<HorarioTurma>();
//        TurmaCTR turmaCTR = new TurmaCTR();
//        List<Turma> turmas = turmaCTR.listar();
//        DiaCTR diaCTR = new DiaCTR();
//        List<HorarioAula> horarioAulas = pegarHAD();
//        List<Dia> dias = diaCTR.listar();
//        HorarioTurma horarioTurma;
//        for (int i = 0; i < turmas.size(); i++) {
//            horarioTurma = new HorarioTurma();
//            horarioTurma.setTurma(turmas.get(i));
//            DiaTurma diaTurma;
//            for (int j = 0; j < dias.size(); j++) {
//                diaTurma = new DiaTurma();
//                diaTurma.setDia(dias.get(j));
//                for (int t = 0; t < horarioAulas.size(); t++) {
//                    if (turmas.get(i).equals(horarioAulas.get(t).getDisciplinaAula().getTurma())
//                            && dias.get(j).equals(horarioAulas.get(t).getPk().getDia())) {
//                        diaTurma.horarioAulas.add(horarioAulas.get(t));
//                    }
//                }
//                horarioTurma.diaTurmas.add(diaTurma);
//            }
//            horarioTurmas.add(horarioTurma);
//        }
//        return horarioTurmas;
//    }
//
//    public List<HorarioAula> pegarHAD() {
//        List<HorarioAula> horarioAulas = getLista();
//        for (int i = 0; i < horarioAulas.size(); i++) {
//            if(horarioAulas.get(i).getDisciplinaAula() == null){
//                horarioAulas.remove(i);
//                --i;
//            }
//        }
//        return horarioAulas;
//    }
    public void setHorarioTurmas(List<HorarioTurma> horarioTurmas) {
        this.horarioTurmas = horarioTurmas;
    }
}
