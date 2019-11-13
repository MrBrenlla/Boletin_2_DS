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
public class Iterador implements java.util.Iterator<EuroCoin> {
    private EuroCoin lastCoin;
    private String pais;
    private boolean protect;
    public EuroCoinCollection coleccion;
    

    public static Iterador crearIterador(EuroCoinCollection col){
        Iterador i = new Iterador();
        i.pais = null;
        i.lastCoin = null;
        i.coleccion = col;
        i.protect = true;
        return i;
    }
    
    public void setPais(Pais p){
        this.pais=p.getCode();
    } 
    @Override
    public boolean hasNext() {
        boolean comp = (lastCoin == null);
            for (EuroCoin c: coleccion.coleccion){
                if (comp){
                    if (this.pais == null || c.getPais().equals(this.pais)) {
                        return true;
                    } 
                }
                else if (c.equals(lastCoin)) comp = true;
            }
            return false;             
    }

    @Override
    public EuroCoin next() {
        boolean comp = (lastCoin == null);
        for (EuroCoin c: coleccion.coleccion){
            if (comp){
                if (this.pais == null || c.getPais().equals(this.pais)) { 
                    lastCoin = c;
                    protect = false;
                    if (!this.hasNext()) this.coleccion.finIteracion();
                    return c;
                } 
            }
            else if (c.equals(lastCoin)) comp = true;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        EuroCoin ant = null;
        Object aux = null;
        if (!protect){
            for (EuroCoin c: coleccion.coleccion){
                if (c.equals(lastCoin)) {
                    aux = (Object) lastCoin;
                    lastCoin = ant;
                    protect = true;
                } else ant = c;
            } 
            if (protect){ this.coleccion.coleccion.remove(aux);}
        }
        else throw new IllegalStateException();
    }
    
    
}
