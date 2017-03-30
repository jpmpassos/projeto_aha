/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.motor;

import br.com.aha.gerencial.DiaG;
import br.com.aha.gerencial.HorarioG;
import br.com.aha.gerencial.HorarioP;
import br.com.aha.gerencial.SalaG;
import br.com.aha.base.Dia;
import br.com.aha.base.DisciplinaAula;
import br.com.aha.base.Horario;
import br.com.aha.base.HorarioAula;
import br.com.aha.base.Sala;
import br.com.aha.base.Turma;
import br.com.aha.ctr.DiaCTR;
import br.com.aha.ctr.DisciplinaAulaCTR;
import br.com.aha.ctr.HorarioCTR;
import br.com.aha.ctr.SalaCTR;
import br.com.aha.ctr.TurmaCTR;
import br.com.aha.hard.RestricaoHard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author JP1
 */
public class Motor {

    private List<Dia> dias;
    private List<Sala> salas;
    private RestricaoHard restricaoHard = new RestricaoHard();

    public Motor() {
        DiaCTR diaCTR = new DiaCTR();
        this.dias = diaCTR.listar();
        SalaCTR salaCTR = new SalaCTR();
        this.salas = salaCTR.listar();
    }

    public void gerarHorario(List<DiaG> diaGs) {
        TurmaCTR turmaCTR = new TurmaCTR();
        List<Turma> turmas = turmaCTR.listar();
        Random r = new Random();
        boolean sair = true;
        int contD = 0;
        int contDS = 0;
        int contS = 0;
        int contPara = 0;
        while (sair) {
            try {
                for (int i = 0; i < diaGs.size(); i++) {
                    for (int j = 0; j < turmas.size(); j++) {
                        DisciplinaAula disciplinaAula = buscarDisciplina(turmas.get(j), diaGs.get(i).getDia(), diaGs);
                        if (disciplinaAula != null) {
                            procurarVaga(diaGs.get(i).getDia(), diaGs, disciplinaAula);
                        } else {
                            System.out.println("Terminou de gerar o horario");
                            //sair = false;
                        }
                    }
                }
                contD++;
                contPara++;
                if (contD == 5) {
                    DisciplinaAulaCTR cTR = new DisciplinaAulaCTR();
                    List<DisciplinaAula> testeDisciplinaVazia = cTR.listar();
                    sair = false;
                    for (int x = 0; x < testeDisciplinaVazia.size(); x++) {
                        if (testeDisciplinaVazia.get(x).getCreditosrestantes() > 0) {
                            sair = true;
                        }
                    }
                    contD = 0;
                }
                if (contPara == 5) {
                    sair = false;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public DisciplinaAula buscarDisciplina(Turma turma, Dia dia, List<DiaG> diasG) {
        Random gerador = new Random();
        int cont = 0;
        List<DisciplinaAula> lista = turma.getDisciplinaAulas();

        Collections.sort(lista);
//            for (int i = 0; i < lista.size(); i++) {
//                System.out.println(lista.get(i).getDisciplina().getDisciplina());
//                System.out.println(lista.get(i).getDisciplina().getCreditos());
//            }

        while (true) {
            if (cont != lista.size()) {
                if (lista.get(cont).getCreditosrestantes() != 0) {
                    return turma.getDisciplinaAulas().get(cont);
                }
                cont++;
            } else {
                return null;
            }


//            if (!lista.isEmpty()) {
//                int numero = gerador.nextInt(255) % lista.size();
//                if (lista.get(numero).getCreditosrestantes() != 0) {
//                    return turma.getDisciplinaAulas().get(numero);
//                } else {
//                    lista.remove(numero);
//                }
//            } else {
//                return null;
//            }

        }
    }

    public String procurarVaga(Dia dia, List<DiaG> diasG, DisciplinaAula disciplinaAula) {
        try {
            int credito = disciplinaNumVagas(disciplinaAula);
            for (int i = 0; i < diasG.size(); i++) {
                if (diasG.get(i).getDia().equals(dia)) {
                    if (diasG.get(i).getHv() < credito) {
                        return "DiaSemHorarioSuficiente";
                    }
                    for (int horP = 0; horP < diasG.get(i).horarios.size(); horP++) {
                        for (int horG = 0; horG < diasG.get(i).horarios.get(horP).horarios.size(); horG++) {
                            if (diasG.get(i).horarios.get(horP).horarios.get(horG).getSalaG().getHv() >= credito
                                    && diasG.get(i).horarios.get(horP).horarios.get(horG).getHorarioAula().getDisciplinaAula() == null) {
                                SalaG sg = diasG.get(i).horarios.get(horP).horarios.get(horG).getSalaG(); //só para facilitar o acesso 

                                for (int haVal = 0; haVal < sg.horarioAulas.size(); haVal++) {
                                    if (sg.horarioAulas.get(haVal).equals(diasG.get(i).horarios.get(horP).horarios.get(horG).getHorarioAula())) {
                                        int haTrue = haVal;
                                        if (haVal + credito <= sg.horarioAulas.size()) {
                                            for (int haVal2 = haVal; haVal2 < haVal + credito; haVal2++) {
                                                if (!this.restricaoHard.validar(sg.horarioAulas.get(haVal2), disciplinaAula)) {
                                                    haTrue = -1;
                                                }
                                            }

                                            if (haTrue != -1) {
                                                for (int haVal2 = haTrue; haVal2 < haTrue + credito; haVal2++) {
                                                    sg.getHorarioAulas().get(haVal2).setDisciplinaAula(disciplinaAula);
                                                    int prov = sg.getHv();
                                                    --prov;
                                                    sg.setHv(prov);
                                                    prov = diasG.get(i).getHv();
                                                    --prov;
                                                    diasG.get(i).setHv(prov);
                                                    prov = disciplinaAula.getCreditosrestantes();
                                                    --prov;
                                                    disciplinaAula.setCreditosrestantes(prov);
                                                }
                                                return "AlocadoComSucesso";
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int disciplinaNumVagas(DisciplinaAula disciplinaAula) {
        int i;
        if (disciplinaAula.getDisciplina().getCreditos() > 3) {
            if (disciplinaAula.getCreditosrestantes() < disciplinaAula.getDisciplina().getCreditos()) {
                return disciplinaAula.getCreditosrestantes();
            }
            return (disciplinaAula.getDisciplina().getCreditos() / 2);
        }
        return (disciplinaAula.getDisciplina().getCreditos());
    }

    public List<DiaG> gerarGrade() {
        List<DiaG> listaDiaG;
        listaDiaG = new ArrayList<DiaG>();
        for (int i = 0; i < this.dias.size(); i++) {
            DiaG diaG = new DiaG();
            diaG.setDia(this.dias.get(i));
            diaG.setHv(this.dias.get(i).getHorarioAulas().size());
            diaG.salas = new ArrayList<SalaG>();
            for (int j = 0; j < this.salas.size(); j++) {
                SalaG salaG = new SalaG();
                salaG.setSala(this.salas.get(j));
                salaG.setDiaG(diaG);
                salaG.horarioAulas = new ArrayList<HorarioAula>();
                for (int t = 0; t < this.salas.get(j).getHorarioAulas().size(); t++) {
                    if (this.salas.get(j).getHorarioAulas().get(t).getPk().getDia().getIddia() == this.dias.get(i).getIddia()) {
                        salaG.horarioAulas.add(this.salas.get(j).getHorarioAulas().get(t));
                    }
                }
                salaG.setHv(salaG.horarioAulas.size());
                diaG.salas.add(salaG);
            }
            listaDiaG.add(diaG);
        }
        for (int i = 0; i < listaDiaG.size(); i++) {
            HorarioCTR horarioCTR = new HorarioCTR();
            List<Horario> h = horarioCTR.listar();
            for (int j = 0; j < h.size(); j++) {
                HorarioP horarioP = new HorarioP();
                horarioP.setHorario(h.get(j));
                listaDiaG.get(i).horarios.add(horarioP);
            }
        }
        for (int i = 0; i < listaDiaG.size(); i++) {
            for (int j = 0; j < listaDiaG.get(i).salas.size(); j++) {

                for (int t = 0; t < listaDiaG.get(i).salas.get(j).getHorarioAulas().size(); t++) {
                    for (int y = 0; y < listaDiaG.get(i).horarios.size(); y++) {
                        if (listaDiaG.get(i).salas.get(j).getHorarioAulas().get(t).getPk().getHorario().equals(
                                listaDiaG.get(i).horarios.get(y).getHorario())) {
                            HorarioG horarioG = new HorarioG();
                            horarioG.setHorarioAula(listaDiaG.get(i).salas.get(j).getHorarioAulas().get(t));
                            horarioG.setSalaG(listaDiaG.get(i).salas.get(j));
                            listaDiaG.get(i).horarios.get(y).horarios.add(horarioG);
                        }
                    }
                }
            }
        }
        return listaDiaG;
    }
}
