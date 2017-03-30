/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.hard;

import br.com.aha.base.DisciplinaAula;
import br.com.aha.base.HorarioAula;



/**
 *
 * @author JP1
 */
public class RestricaoHard {

    public Boolean validar(HorarioAula horarioAula, DisciplinaAula disciplinaAula) {



        //Testa se o professor ja tem aula no mesmo horario no mesmo dia... 
        for (int i = 0; i < horarioAula.getPk().getDia().getHorarioAulas().size(); i++) {

            //Testa se ja tem aula da mesma disciplina no mesmo dia...
            if (horarioAula.getPk().getDia().getHorarioAulas().get(i).getDisciplinaAula() != null) {
                if (horarioAula.getPk().getDia().getHorarioAulas().get(i).getDisciplinaAula().equals(disciplinaAula)) {
                    return false;
                }
            }

            if (horarioAula.getPk().getDia().getHorarioAulas().get(i).getPk().getHorario().equals(horarioAula.getPk().getHorario()) //Testa se o o dia e o horario das são os mesmos (pois pode ter salas diferente)
                    && !horarioAula.getPk().getDia().getHorarioAulas().get(i).equals(horarioAula) //Teste se o horarioAula não é o mesmo passado por parametro.
                    && horarioAula.getPk().getDia().getHorarioAulas().get(i).getDisciplinaAula() != null) { //Testa se tem disciplinas alocada.
                if (horarioAula.getPk().getDia().getHorarioAulas().get(i).getDisciplinaAula().getProfessor().equals(disciplinaAula.getProfessor())
                        || horarioAula.getPk().getDia().getHorarioAulas().get(i).getDisciplinaAula().getTurma().equals(disciplinaAula.getTurma())) { //Testa se o professor da disciplina é o mesmo da passada por parametro
                    return false; //Se for o mesmo professor retorna false.
                }
            }
            
            //Backp antes da inclusão de turmas como estrição...
//            if (horarioAula.getPk().getDia().getHorarioAulas().get(i).getPk().getHorario().equals(horarioAula.getPk().getHorario()) //Testa se o o dia e o horario das são os mesmos (pois pode ter salas diferente)
//                    && !horarioAula.getPk().getDia().getHorarioAulas().get(i).equals(horarioAula) //Teste se o horarioAula não é o mesmo passado por parametro.
//                    && horarioAula.getPk().getDia().getHorarioAulas().get(i).getDisciplinaAula() != null) { //Testa se tem disciplinas alocada.
//                if (horarioAula.getPk().getDia().getHorarioAulas().get(i).getDisciplinaAula().getProfessor().equals(disciplinaAula.getProfessor())) { //Testa se o professor da disciplina é o mesmo da passada por parametro
//                    return false; //Se for o mesmo professor retorna false.
//                }
//            }
        }
        return true;
    }
}
