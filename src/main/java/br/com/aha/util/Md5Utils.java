/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Facil-Sistemas
 */
public class Md5Utils {

    /**
     * 
     * @param xml xml aser assinado pelo md5
     * @return xml assinado
     */
    public static String GeraHashMD5(String xml) {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(xml.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < thedigest.length; i++) {
                sb.append(Integer.toHexString((thedigest[i] & 0xFF) | 0x100).substring(1, 3));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
            return ex.toString();
        }
    }
}
