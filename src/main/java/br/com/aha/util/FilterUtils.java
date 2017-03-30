/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.aha.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author João Paulo
 */
interface Filter {

    boolean accept(Object obj);
}

public class FilterUtils {

    public static Collection filter(Collection col, Filter filter) {
        Collection result = new ArrayList();
        for (Iterator it = col.iterator(); it.hasNext();) {
            Object obj = it.next();
            if (filter.accept(obj)) {
                result.add(obj);
            }
        }
        return result;
    }
}
