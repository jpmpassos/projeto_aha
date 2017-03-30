/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.exceptions;

import br.com.aha.util.FuncoesUtils;
import java.util.Iterator;
import javax.faces.FacesException;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;

/**
 *
 * @author João Paulo
 */
public class JsfExceptionHandler extends ExceptionHandlerWrapper {

    private ExceptionHandler wrapped;

    public JsfExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ExceptionHandler getWrapped() {
        return this.wrapped;
    }

    @Override
    public void handle() throws FacesException {
        Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();
        while (events.hasNext()) {
            ExceptionQueuedEvent event = events.next();
            ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();

            Throwable throwable = context.getException();

            NegocioException negocioException = NegocioException.getNegocioException(throwable);

            Boolean tratado = false;

            try {
                if (throwable instanceof ViewExpiredException) {
                    tratado = true;
                    FuncoesUtils.redirect("/");
                } else if (negocioException != null) {
                    tratado = true;
                    if (negocioException.getTipo() >= 1 && negocioException.getTipo() <= 4) {
                        FuncoesUtils.enviarMensagemTela(negocioException.getMessage(), negocioException.getTipo(), negocioException.getDlg());
                    } else if (negocioException.getTipo() == 5) {
                        FuncoesUtils.redirect("/");
                    } else if (negocioException.getTipo() == 6) {
                        throw new RuntimeException();
                    } else if (negocioException.getTipo() == 7) {
                        FuncoesUtils.redirect("/erros/acessonegado.jsf");                    
                    } else if (negocioException.getTipo() == 8) {
                        FuncoesUtils.redirect("/erros/erronfe.jsf");
                    }
                } else if (throwable instanceof NoClassDefFoundError) {
                    tratado = true;
                    FuncoesUtils.redirect("/erros/filenotfoundexception.jsf");
                } else if (throwable instanceof java.sql.SQLException) {
                    tratado = true;
                    FuncoesUtils.redirect("/erros/sql-exception.jsf");
                } else if (throwable instanceof java.lang.Exception) {
                    tratado = true;
                    FuncoesUtils.redirect("/erros/exception.jsf");
                }
                /*else if (throwable instanceof NumberFormatException) {
                    tratado = true;
                    redirect("/");
                } else if (throwable instanceof java.lang.NullPointerException) {
                    tratado = true;
                    redirect("/");
                } else {
                    tratado = true;
                    redirect("/");
                }*/
            } finally {
                if (tratado) {
                    try {
                        events.remove();
                    } catch (Exception e) {
                        FuncoesUtils.redirect("/erros/exception.jsf");
                    }
                }
            }
            wrapped.handle();
        }
    }

}
