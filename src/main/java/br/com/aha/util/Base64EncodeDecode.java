/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.commons.io.IOUtils;

import org.apache.tomcat.util.codec.binary.Base64;

/**
 *
 * @author João Paulo
 */
public class Base64EncodeDecode {

    public static String encode(String in) throws UnsupportedEncodingException, IOException {
        ByteArrayOutputStream rstBao = new ByteArrayOutputStream();
        GZIPOutputStream zos = new GZIPOutputStream(rstBao);
        zos.write(in.getBytes("ISO-8859-1"));
        IOUtils.closeQuietly(zos);

        byte[] bytes = rstBao.toByteArray();

        String saida = Base64.encodeBase64String(bytes);

        return saida;
    }

    public static String decode(String in) throws UnsupportedEncodingException, IOException {
        String result = null;

        byte[] bytes = Base64.decodeBase64(in);
        GZIPInputStream zi = null;
        try {
            zi = new GZIPInputStream(new ByteArrayInputStream(bytes));
            result = IOUtils.toString(zi, "ISO-8859-1");
        } finally {
            IOUtils.closeQuietly(zi);
        }

        return result;
    }

}
