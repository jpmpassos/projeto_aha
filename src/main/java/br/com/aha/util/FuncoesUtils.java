/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.util;

import br.com.aha.logincontrole.LoginControle;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.context.RequestContext;

/**
 *
 * @author João Paulo
 */
public class FuncoesUtils {

    private static final int[] pesoCPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
    private static final int[] pesoCNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    public static void resetDataTable(String dataStr) {
        try {
            DataTable dataTable = (DataTable) FacesContext.getCurrentInstance().getViewRoot().findComponent(dataStr);
            if (!dataTable.getFilters().isEmpty()) {

                dataTable.getFilters().clear();// not working
                dataTable.getFilteredValue().clear();// not working
                dataTable.setFilteredValue(null);// not working
                dataTable.setFilters(null);// not working
                dataTable.setFilterMetadata(null);// not working 

                dataTable.resetValue();// working 
                dataTable.reset();// working 

                RequestContext requestContext = RequestContext.getCurrentInstance();
                requestContext.update(dataStr);
            }
        } catch (Exception e) {
        }
    }

    private static int calcularDigito(String str, int[] peso) {
        int soma = 0;
        for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
            digito = Integer.parseInt(str.substring(indice, indice + 1));
            soma += digito * peso[peso.length - str.length() + indice];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }

    public static boolean isValidCPF(String cpf) {
        if ((cpf == null) || (cpf.length() != 11)) {
            return false;
        }

        Integer digito1 = calcularDigito(cpf.substring(0, 9), pesoCPF);
        Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, pesoCPF);
        return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
    }

    public static boolean isValidCNPJ(String cnpj) {
        if ((cnpj == null) || (cnpj.length() != 14)) {
            return false;
        }

        Integer digito1 = calcularDigito(cnpj.substring(0, 12), pesoCNPJ);
        Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, pesoCNPJ);
        return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
    }

    public static String subString(String str, Integer inicio, Integer fim) {
        if (!str.isEmpty()) {
            if ((str.length() - inicio) > fim) {
                return str.substring(inicio, fim);
            }
            if ((str.length() - inicio) < fim) {
                return str.substring(inicio, str.length());
            }
            if (str.length() > inicio) {
                return str.substring(inicio, str.length());
            }
        }
        return "";
    }

    public static boolean equalsBigDecimal(BigDecimal a, BigDecimal b) {
        return ((a == b) || (a != null && b != null && a.doubleValue() == b.doubleValue())) || (a == null && b != null && b.doubleValue() == 0) || (b == null && a != null && a.doubleValue() == 0);
    }

    public static boolean compararSeNull(Object object1, Object object2) {
        if (object1 == null && object2 == null) {
            return true;
        }
        if (object1 != null && object2 != null) {
            return false;
        }
        return false;
    }

    public static double truncate(Double valor, int precisao) {
        BigDecimal bd = BigDecimal.valueOf(valor);
        bd = bd.setScale(precisao, BigDecimal.ROUND_DOWN);
        return bd.doubleValue();
    }

    public static double calcularAlturaGrafico(Double valorMaximo, Integer valorParametro, Integer tamanhaoIntervalo) {
        int i = 1;
        while (valorMaximo > valorParametro * i) {
            i++;
        }

        Integer n = (i * valorParametro);
        Double d = Double.parseDouble(n.toString()) / tamanhaoIntervalo;

        return Math.floor(d) * tamanhaoIntervalo;
    }

    public static void redirect(String pag) {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            String contextPath = externalContext.getRequestContextPath();

            externalContext.redirect(contextPath + pag);
            facesContext.responseComplete();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    public static void enviarMensagemTela(String msg, Integer tipo, String dlg) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        if (null != tipo) {
            switch (tipo) {
                case 1:
                    //Sucesso
                    message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", msg);
                    break;
                case 2:
                    message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Cuidado!", msg);
                    break;
                case 3:
                    message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", msg);
                    break;
                case 4:
                    message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro Grave!", msg);
                    break;
                default:
                    break;
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("tipo", tipo);
        context.addCallbackParam("dlg", dlg);
    }

    public static void enviarMensagemTela(String msg, Integer tipo, String fecharJanela, String abrirJanela) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        if (tipo == 1) { //Sucesso            
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", msg);
        } else if (tipo == 2) {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Cuidado!", msg);
        } else if (tipo == 3) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", msg);
        } else if (tipo == 4) {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro Grave!", msg);
        } else if (tipo == 5) {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro!", msg);
            tipo = 1;
        }

        FacesContext.getCurrentInstance().addMessage(null, message);

        context.addCallbackParam("tipo", tipo);
        context.addCallbackParam("fecharJanela", fecharJanela);
        context.addCallbackParam("abrirJanela", abrirJanela);
    }

    public static void enviarMensagemTela(String msg, Integer tipo) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        if (tipo == 1) { //Sucesso            
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", msg);
        } else if (tipo == 2) {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Cuidado!", msg);
        } else if (tipo == 3) {
            message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", msg);
        } else if (tipo == 4) {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro Grave!", msg);
        } else if (tipo == 5) {
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro!", msg);
            tipo = 1;
        }
    }

    public static void enviarMensagemTela(String fecharJanela, String abrirJanela) {
        RequestContext context = RequestContext.getCurrentInstance();
        context.addCallbackParam("tipo", 1);
        context.addCallbackParam("fecharJanela", fecharJanela);
        context.addCallbackParam("abrirJanela", abrirJanela);
    }

    public static String onlyNumbers(String str) {
        if (str != null) {
            return str.replaceAll("[^0123456789]", "");
        } else {
            return "";
        }
    }

    public static String formataCurrency(Double valor) {
        DecimalFormat df = new DecimalFormat("0.00");
        return "R$ " + df.format(valor).replace(".", ",");
    }
    
    public static String formataNumber(Double valor) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(valor).replace(".", ",");
    }

    public static String formataFone(String fone) {
        try {
            fone = (fone.length() == 10 ? ("(" + fone.substring(0, 2) + ") " + fone.substring(2, 6) + "-" + fone.substring(6, 10))
                    : (fone.length() == 11 ? ("(" + fone.substring(0, 2) + ") " + fone.substring(2, 7) + "-" + fone.substring(7, 11))
                            : (fone.length() == 8 ? (fone.substring(0, 4) + "-" + fone.substring(4, 8))
                                    : (fone.length() == 9 ? (fone.substring(0, 5) + "-" + fone.substring(5, 9))
                                            : fone))));
        } catch (Exception e) {
            return "";
        }
        return fone;
    }

    public static String formataCPFCNPJ(String cpf, Boolean juridica) {
        try {
            cpf = (juridica
                    ? (cpf.substring(0, 2) + "." + cpf.substring(2, 5) + "." + cpf.substring(5, 8) + "/" + cpf.substring(8, 12) + "-" + cpf.substring(12, 14))
                    : (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11)));
        } catch (Exception e) {
            return "";
        }
        return cpf;
    }

}
