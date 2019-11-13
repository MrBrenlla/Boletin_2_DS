/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e2_e3;

import java.util.*;


/**
 *
 * @author lorudarkuh
 */
public class Iterador extends EuroCoinCollection implements java.util.Iterator<EuroCoin> {
    private EuroCoin lastCoin;
    private String pais;
    private boolean protect;
    
    public void crearIterador(Pais pais){
        this.pais = pais.getCode();
        this.lastCoin = null;
    }
    
    @Override
    public boolean hasNext() {
        boolean comp = (lastCoin == null);
            for (EuroCoin c: coleccion){
                if (comp){
                    if (this.pais == null || c.getPais().equals(this.pais)) {
                        return true;
                    } 
                    if (c.equals(lastCoin)) comp = true;
                }
            }
            return false;             
    }

    @Override
    public EuroCoin next() {
        boolean comp = (lastCoin == null);
            for (EuroCoin c: coleccion){
                if (comp){
                    if (this.pais == null || c.getPais().equals(this.pais)) {
                        lastCoin = c;
                        protect = false;
                        //return c;
                    } 
                    if (c.equals(lastCoin)) comp = true;
                }
            }
        iterando -=1;
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        EuroCoin ant = null;
        if ((!coleccion.isEmpty()) && (!protect)){
            for (EuroCoin c: coleccion){
                if (c.equals(lastCoin)) {
                    coleccion.remove(lastCoin);
                    lastCoin = ant;
                    protect = true;
                } else lastCoin = c;
            } 
        } else throw new IllegalStateException();
    }
    
    
}
