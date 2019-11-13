/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2_e3;


/**
 *
 * @author lorudarkuh
 */
public abstract class e2 implements java.util.Comparator<EuroCoin> {
    
    @Override
    public int compare(EuroCoin o1, EuroCoin o2){
       return o1.compareTo(o2);
    }

}   
