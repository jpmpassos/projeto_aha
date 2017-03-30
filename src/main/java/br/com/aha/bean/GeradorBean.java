/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.bean;

import br.com.aha.base.Dia;
import br.com.aha.base.DisciplinaAula;
import br.com.aha.base.Horario;
import br.com.aha.base.HorarioAula;
import br.com.aha.base.HorarioAulaPK;
import br.com.aha.base.Sala;
import br.com.aha.ctr.DiaCTR;
import br.com.aha.ctr.DisciplinaAulaCTR;
import br.com.aha.ctr.HorarioAulaCTR;
import br.com.aha.hard.RestricaoHard;
import br.com.aha.motor.Motor;
import br.com.aha.util.FuncoesUtils;
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
public class GeradorBean {

    private List<HorarioAula> horarioAulas;
    private List<DisciplinaAula> disciplinaAulas;
    private List<Dia> litaDias;
    private List<Dia> dias;

    public GeradorBean() {
        HorarioAulaCTR horarioAulaCTR = new HorarioAulaCTR();
        DisciplinaAulaCTR disciplinaAulaCTR = new DisciplinaAulaCTR();
        DiaCTR diaCTR = new DiaCTR();
        this.dias = diaCTR.listar();
        this.horarioAulas = horarioAulaCTR.listar();
        this.disciplinaAulas = disciplinaAulaCTR.listar();
        this.litaDias = new ArrayList<Dia>();
    }

    public void gerador() {
        RestricaoHard hard = new RestricaoHard();
        for (int i = 0; i < disciplinaAulas.size(); i++) {
            for (int j = 0; j < horarioAulas.size(); j++) {
                System.out.println(hard.validar(horarioAulas.get(j), disciplinaAulas.get(i)));
            }
        }
        System.out.println("Terminou de passar nos Forms");
    }

    public void escolherHorario() {
        Dia dia;
        Sala sala;
        int i = 0;
//        while (true) {            
//            dia = this.dias.get(i);
//            sala = this.dias.get(i).getHorarioAulas().get(i).getPk().getSala();
//            System.out.println("teste");
//            
//        }

    }

    public void gerarGrade() {
        Motor motor = new Motor();

        motor.gerarHorario(motor.gerarGrade());

        FuncoesUtils.enviarMensagemTela("Grade de Horários gerada com sucesso!", 1, "", "");

    }

    //Gera uma lista de horarioaulas a partir do dia, e pode ir filtrando a parti da lista dos objetos horarioaulas
//    public void gerarLiataDia() {
//        for (int i = 0; i < this.dias.size(); i++) {
//            Dia d = new Dia();
//            d.setDia(this.dias.get(i).getDia());
//            d.setIddia(this.dias.get(i).getIddia());
//            //
//            List<HorarioAula> lD = new ArrayList<HorarioAula>();
//            //
//            for (int j = 0; j < this.horarioAulas.size(); j++) {
//                if (this.horarioAulas.get(j).getPk().getDia().getIddia() == this.dias.get(i).getIddia()) {
//                    HorarioAulaPK pkD = new HorarioAulaPK();
//                    HorarioAula haD = new HorarioAula();
//                    pkD.setDia(d);
//                    Sala s = new Sala();
//                    s.setDescricao(this.horarioAulas.get(j).getPk().getSala().getDescricao());
//                    s.setIdsala(this.horarioAulas.get(j).getPk().getSala().getIdsala());
//                    s.setSala(this.horarioAulas.get(j).getPk().getSala().getSala());
//                    //
//                    List<HorarioAula> lS = new ArrayList<HorarioAula>();
//                    //
//                    for (int t = 0; t < this.horarioAulas.size(); t++) { //aloca horario
//                        if (this.horarioAulas.get(t).getPk().getDia().getIddia() == this.dias.get(i).getIddia()
//                                && this.horarioAulas.get(t).getPk().getSala().getIdsala() == s.getIdsala()) {
//                            HorarioAulaPK pkS = new HorarioAulaPK();
//                            HorarioAula haS = new HorarioAula();
//                            pkS.setDia(d);
//                            pkS.setSala(s);
//                            Horario h = new Horario();
////                            h.setDescricao(this.horarioAulas.get(t).getPk().getHorario().getDescricao());
////                            h.setHorario(this.horarioAulas.get(t).getPk().getHorario().getHorario());
////                            h.setIdhorario(this.horarioAulas.get(t).getPk().getHorario().getIdhorario());
////                            h.setTurno(this.horarioAulas.get(t).getPk().getHorario().getTurno());
//                            pkS.setHorario(this.horarioAulas.get(t).getPk().getHorario());
//                            haS.setPk(pkS);
//                            //
//                            lS.add(haS);
//                        }
//                    }
//                    s.setHorarioAulas(lS);
//                    pkD.setSala(s);
//                    //
//                    //
//                    //                    
//                    Horario h = new Horario();
//                    h.setDescricao(this.horarioAulas.get(i).getPk().getHorario().getDescricao());
//                    h.setHorario(this.horarioAulas.get(i).getPk().getHorario().getHorario());
//                    h.setIdhorario(this.horarioAulas.get(i).getPk().getHorario().getIdhorario());
//                    h.setTurno(this.horarioAulas.get(i).getPk().getHorario().getTurno());
//                    //
//                    List<HorarioAula> lH = new ArrayList<HorarioAula>();
//                    //
//                    for (int t = 0; t < this.horarioAulas.size(); t++) { //aloca horario
//                        if (this.horarioAulas.get(t).getPk().getDia().getIddia() == this.dias.get(i).getIddia()
//                                && this.horarioAulas.get(t).getPk().getHorario().getIdhorario() == h.getIdhorario()) {
//                            HorarioAulaPK pkH = new HorarioAulaPK();
//                            HorarioAula haH = new HorarioAula();
//                            pkH.setDia(d);
//                            pkH.setHorario(h);
//                            Sala s2 = new Sala();
////                            s2.setDescricao(this.horarioAulas.get(t).getPk().getSala().getDescricao());
////                            s2.setIdsala(this.horarioAulas.get(t).getPk().getSala().getIdsala());
////                            s2.setSala(this.horarioAulas.get(t).getPk().getSala().getSala());
//
//                            pkH.setSala(this.horarioAulas.get(t).getPk().getSala());
//                            haH.setPk(pkH);
//                            
//                            lH.add(haH);
//                        }
//                    }
//                    h.setHorarioAulas(lH);
//                    pkD.setHorario(h);
//
//                    haD.setPk(pkD);
//                    lD.add(haD);
//                }
//            }
//
//            d.setHorarioAulas(lD);
//            this.litaDias.add(d);
//        }
//        System.out.println("Teminou de adicionar a lista");
//
//    }
//    //Gera uma lista de horarioaulas a partir do dia, e pode ir filtrando a parti da lista dos objetos horarioaulas
//    public void gerarLiataDia() {
//        for (int i = 0; i < this.dias.size(); i++) {
//            Dia d = new Dia();
//            d.setDia(this.dias.get(i).getDia());
//            d.setIddia(this.dias.get(i).getIddia());
//            //
//            List<HorarioAula> lD = new ArrayList<HorarioAula>();
//            //
//            for (int j = 0; j < this.horarioAulas.size(); j++) {
//                if (this.horarioAulas.get(j).getPk().getDia().getIddia() == this.dias.get(i).getIddia()) {
//                    HorarioAulaPK pkD = new HorarioAulaPK();
//                    HorarioAula haD = new HorarioAula();
//                    pkD.setDia(d);
//                    Sala s = new Sala();
//                    s.setDescricao(this.horarioAulas.get(j).getPk().getSala().getDescricao());
//                    s.setIdsala(this.horarioAulas.get(j).getPk().getSala().getIdsala());
//                    s.setSala(this.horarioAulas.get(j).getPk().getSala().getSala());
//                    //
//                    List<HorarioAula> lS = new ArrayList<HorarioAula>();
//                    //
//                    for (int t = 0; t < this.horarioAulas.size(); t++) { //aloca horario
//                        if (this.horarioAulas.get(t).getPk().getDia().getIddia() == this.dias.get(i).getIddia()
//                                && this.horarioAulas.get(t).getPk().getSala().getIdsala() == s.getIdsala()) {
//                            HorarioAulaPK pkS = new HorarioAulaPK();
//                            HorarioAula haS = new HorarioAula();
//                            pkS.setDia(d);
//                            pkS.setSala(s);
//                            Horario h = new Horario();
//                            h.setDescricao(this.horarioAulas.get(t).getPk().getHorario().getDescricao());
//                            h.setHorario(this.horarioAulas.get(t).getPk().getHorario().getHorario());
//                            h.setIdhorario(this.horarioAulas.get(t).getPk().getHorario().getIdhorario());
//                            h.setTurno(this.horarioAulas.get(t).getPk().getHorario().getTurno());
//                            pkS.setHorario(h);
//                            haS.setPk(pkS);
//                            //
//                            lS.add(haS);
//                        }
//                    }
//                    s.setHorarioAulas(lS);
//                    pkD.setSala(s);
//                    //
//                    //
//                    //                    
//                    Horario h = new Horario();
//                    h.setDescricao(this.horarioAulas.get(i).getPk().getHorario().getDescricao());
//                    h.setHorario(this.horarioAulas.get(i).getPk().getHorario().getHorario());
//                    h.setIdhorario(this.horarioAulas.get(i).getPk().getHorario().getIdhorario());
//                    h.setTurno(this.horarioAulas.get(i).getPk().getHorario().getTurno());
//                    //
//                    List<HorarioAula> lH = new ArrayList<HorarioAula>();
//                    //
//                    for (int t = 0; t < this.horarioAulas.size(); t++) { //aloca horario
//                        if (this.horarioAulas.get(t).getPk().getDia().getIddia() == this.dias.get(i).getIddia()
//                                && this.horarioAulas.get(t).getPk().getHorario().getIdhorario() == h.getIdhorario()) {
//                            HorarioAulaPK pkH = new HorarioAulaPK();
//                            HorarioAula haH = new HorarioAula();
//                            pkH.setDia(d);
//                            pkH.setHorario(h);
//                            Sala s2 = new Sala();
//                            s2.setDescricao(this.horarioAulas.get(t).getPk().getSala().getDescricao());
//                            s2.setIdsala(this.horarioAulas.get(t).getPk().getSala().getIdsala());
//                            s2.setSala(this.horarioAulas.get(t).getPk().getSala().getSala());
//
//                            pkH.setSala(s2);
//                            haH.setPk(pkH);
//                            //
//                            lH.add(haH);
//                        }
//                    }
//                    h.setHorarioAulas(lH);
//                    pkD.setHorario(h);
//
//                    haD.setPk(pkD);
//                    lD.add(haD);
//                }
//            }
//
//            d.setHorarioAulas(lD);
//            this.litaDias.add(d);
//        }
//        System.out.println("Teminou de adicionar a lista");
//
//    }
}
