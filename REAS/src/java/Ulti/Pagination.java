/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ulti;

import java.util.Collections;
import java.util.List;

/**
 *
 * @author sny12
 */
public class Pagination {
    public static List paging(List list,int pagenum){
        if(list.isEmpty()){
            return Collections.EMPTY_LIST;
        }
        return list.subList((pagenum - 1) * 5, Math.min(pagenum * 5, list.size()));
    }
}
