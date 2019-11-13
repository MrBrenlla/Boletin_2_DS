/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1;

/**
 *
 * @author Brais
 */
public enum Turno {
    MANAN , TARDE , NOITE;
    
    @Override
    public String toString(){
        switch(this){
            case MANAN: return "manan ";
            case TARDE: return "tarde ";
            default: return "noite ";
        }
    }
}
