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
public class Comparator implements java.util.Comparator<EuroCoin>{

    
    @Override
    public int compare(EuroCoin o1, EuroCoin o2){
        
        if (o1.getPais().compareTo(o2.getPais())< 0){
                  return -1;
        } else 
            if (o1.getPais().compareTo(o2.getPais())> 0){
               return 1;
            } else
                if (o1.getValor() < o2.getValor()) {
                    return -1;
                } else
                    if (o1.getValor() > o2.getValor()){
                       return 1;
                    } else 
                        if (o1.getAño() < o2.getAño()) {
                            return -1;
                        } else
                            if (o1.getAño() > o2.getAño()){
                              return 1;
                            } else 
        return 0;
    }

}
