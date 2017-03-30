/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.bean;

import br.com.aha.gerencial.PeriodoTurma;
import br.com.aha.base.Disciplina;
import br.com.aha.base.DisciplinaAula;
import br.com.aha.base.Professor;
import br.com.aha.base.Turma;
import br.com.aha.ctr.DisciplinaAulaCTR;
import br.com.aha.ctr.DisciplinaCTR;
import br.com.aha.ctr.ProfessorCTR;
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
public class DisciplinaAulaBean {

    private List<PeriodoTurma> periodoTurmas;
    private PeriodoTurma periodoTurma;
    private List<Turma> turmas;
    private Turma turma;
    private Integer idturma;
    private String periodo;
    private List<DisciplinaAula> listaDiscAulas;
    private DisciplinaAula disciplinaAula;
    private List<Professor> professores;
    private Integer idProf;

    public DisciplinaAulaBean() {
        TurmaCTR turmaCTR = new TurmaCTR();
        this.turmas = turmaCTR.listar();
        this.turma = new Turma();

        this.periodoTurmas = new ArrayList<>();
        this.periodoTurma = new PeriodoTurma();
    }

    public void prepararListaDiscAula() {
        this.listaDiscAulas = null;
        disciplinaAula = new DisciplinaAula();
    }

    public void prepararAulaBean() {
        TurmaCTR turmaCTR = new TurmaCTR();
        this.turmas = turmaCTR.listar();
        this.turma = new Turma();

        this.periodoTurmas = new ArrayList<PeriodoTurma>();
        this.periodoTurma = new PeriodoTurma();
    }

    public void addPeriodoTurmas() {
        this.periodoTurma = new PeriodoTurma();
        this.periodoTurma.setPeriodo(this.periodo);
        TurmaCTR turmaCTR = new TurmaCTR();
        Turma t = turmaCTR.carregar(this.idturma);
        this.periodoTurma.setTurma(t);
        this.periodoTurmas.add(this.periodoTurma);
        for (int i = 0; i < this.turmas.size(); i++) {
            if (this.turmas.get(i).getIdturma().equals(this.idturma)) {
                this.turmas.remove(i);
            }
        }
    }

    public void gerarDA() {
        if (this.turmas.isEmpty()) {
            TurmaCTR turmaCTR;
            DisciplinaCTR disciplinaCTR;
            DisciplinaAulaCTR disciplinaAulaCTR;
            DisciplinaAula da;
            Turma t;
            Disciplina d;
            for (int i = 0; i < this.periodoTurmas.size(); i++) {
                turmaCTR = new TurmaCTR();
                t = turmaCTR.carregar(this.periodoTurmas.get(i).getTurma().getIdturma());
                for (int j = 0; j < t.getCurso().getDisciplinas().size(); j++) {
                    if (t.getCurso().getDisciplinas().get(j).getPeriodo().equals(this.periodoTurmas.get(i).getPeriodo())) {
                        disciplinaAulaCTR = new DisciplinaAulaCTR();
                        disciplinaCTR = new DisciplinaCTR();
                        DisciplinaAula disciplinaAula = new DisciplinaAula();
                        d = disciplinaCTR.carregar(t.getCurso().getDisciplinas().get(j).getIddisciplina());
                        disciplinaAula.setTurma(t);
                        disciplinaAula.setDisciplina(d);
                        disciplinaAula.setCreditosrestantes(d.getCreditos());
                        disciplinaAulaCTR.salvar(disciplinaAula);
                    }
                }
            }
        } else {
            ;
        }
    }

    public void excluirPT() {
        this.turmas.add(this.periodoTurma.getTurma());
        this.periodoTurmas.remove(this.periodoTurma);
    }

    public void alocarProf() {
        ProfessorCTR professorCTR = new ProfessorCTR();
        DisciplinaAulaCTR disciplinaAulaCTR = new DisciplinaAulaCTR();
        Professor professor = professorCTR.carregar(this.idProf);
        this.disciplinaAula.setProfessor(professor);
        disciplinaAulaCTR.atualizar(this.disciplinaAula);
        this.listaDiscAulas = null;
        this.professores = null;
    }

    public void prepararAlocacaoProf() {
        this.listaDiscAulas = null;
        this.professores = null;
    }

    public Integer getIdProf() {
        return idProf;
    }

    public void setIdProf(Integer idProf) {
        this.idProf = idProf;
    }

    public List<Professor> getProfessores() {
        if (this.professores == null) {
            ProfessorCTR professorCTR = new ProfessorCTR();
            return professorCTR.listar();
        }
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
    }

    public List<DisciplinaAula> getListaDiscAulas() {
        if (this.listaDiscAulas == null) {
            DisciplinaAulaCTR disciplinaAulaCTR = new DisciplinaAulaCTR();
            List<DisciplinaAula> l = disciplinaAulaCTR.listar();           
            for (int i = 0; i < l.size(); i++) {
                if (l.get(i).getProfessor() != null) {
                    l.remove(i);
                    i--;
                }
            }
            return l;
        }
        return listaDiscAulas;
    }
 

    public DisciplinaAula getDisciplinaAula() {
        return disciplinaAula;
    }

    public void setDisciplinaAula(DisciplinaAula disciplinaAula) {
        this.disciplinaAula = disciplinaAula;
    }

    public void setListaDiscAulas(List<DisciplinaAula> listaDiscAulas) {
        this.listaDiscAulas = listaDiscAulas;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Integer getIdturma() {
        return idturma;
    }

    public void setIdturma(Integer idturma) {
        this.idturma = idturma;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public List<PeriodoTurma> getPeriodoTurmas() {
        return periodoTurmas;
    }

    public void setPeriodoTurmas(List<PeriodoTurma> periodoTurmas) {
        this.periodoTurmas = periodoTurmas;
    }

    public PeriodoTurma getPeriodoTurma() {
        return periodoTurma;
    }

    public void setPeriodoTurma(PeriodoTurma periodoTurma) {
        this.periodoTurma = periodoTurma;
    }
}
