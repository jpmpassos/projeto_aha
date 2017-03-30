/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.logincontrole;

import br.com.aha.util.FuncoesUtils;
import br.com.aha.util.RecuperaObjetoBean;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author João Paulo
 */
@ManagedBean
@SessionScoped
public class LoginControle {

    private String login;
    private String senha;
    private Sessao sessao;
    private Boolean logado;

    public LoginControle() {
        RecuperaObjetoBean.fecharObjectSession("loginControle");
        logado = false;
    }

    public void home() {
        FuncoesUtils.redirect("/");
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    private String getSenhaAdministrador() {
        Date dataCorrente = new Date(System.currentTimeMillis());
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(dataCorrente); //aqui você usa sua variável que chamei de "minhaData"

        String ano = String.valueOf(calendar.get(GregorianCalendar.YEAR));
        String mes = String.valueOf(calendar.get(GregorianCalendar.MONTH) + 1);
        mes = (mes.length() == 1 ? ("0" + mes) : mes);
        String dia = String.valueOf(calendar.get(GregorianCalendar.DAY_OF_MONTH));
        dia = (dia.length() == 1 ? ("0" + dia) : dia);
        String somaDiaAno = String.valueOf(Integer.parseInt(ano.substring(2, 4)) + calendar.get(GregorianCalendar.DAY_OF_MONTH));
        return ano + mes + somaDiaAno;
    }

    public static String md5(String senha) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }

    public Boolean permissao(String perfil) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpSession session = request.getSession();
        sessao = (Sessao) session.getAttribute("logado");
        if (sessao != null) {
            if ("admin".equals(perfil)) {
                return true;
            }
            if ("normal".equals(perfil)) {
                return true;
            }
        }
        return false;
    }

    public void logar() throws IOException {

    }

    public void logarAdmin() throws IOException {
        if (this.senha.equals(getSenhaAdministrador()) && this.login.equals("suporte_facil")) {
            //FacesContext context = FacesContext.getCurrentInstance();
            //HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            //response.sendRedirect("principal.jsf");
            sessao = new Sessao(true);
            sessao.setLogado(true);
            sessao.setSuporteinterno(true);

            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = request.getSession(true);
            session.setAttribute("logado", sessao);
            FacesContext.getCurrentInstance().getExternalContext().redirect("controleAdministrativo.jsf");
            //FacesContext.getCurrentInstance().responseComplete();
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!!!", "Login e Senha inválido!!!"));
        }
    }

    public void validarUsuarioLogado() {
        if (!logado) {
            FuncoesUtils.redirect("/erros/acessonegado.jsf");
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getLogado() {
        return logado;
    }

    public void setLogado(Boolean logado) {
        this.logado = logado;
    }

    public Boolean getTeste() {
        return false;
    }
}
