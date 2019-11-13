/**
 * Boletín 1 de DS            10/10/2019
 * Exercicio e4
 * 
 * @author  Ángel Álvarez Rey e Brais García Brenlla
 */
package e2_e3;

import java.util.Objects;

public class EuroCoin implements java.lang.Comparable<EuroCoin> {
    private final Valor valor;
    private final Color color;
    private final Pais pais;
    private final String diseño;
    private final int año;

    public EuroCoin(Valor valor, String diseño, int año, Pais pais) {
        this.valor = valor;
        switch (valor.getCentimos()){  //decidese o color en base ao valor da moneda
            case 1: case 2: case 5: this.color=Color.BRONCE;break;
            case 10: case 20: case 50: this.color=Color.ORO;break;
            default:this.color=Color.ORO_PLATA;break;
        }
        this.pais = pais;
        this.diseño = diseño;
        this.año = año;
    }



    public int getValor() {
        return valor.getCentimos();
    }
    
    public int getAño() {
        return año;
    }
    
    public String getPais() {
        return pais.getCode();
    }
    
    public String getDiseño() {
        return diseño;
    }

    @Override
    public int hashCode() {
        return 3 * this.valor.getCentimos();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EuroCoin other = (EuroCoin) obj;
        if (this.valor != other.valor) {
            return false;
        }
        if (!Objects.equals(this.diseño, other.diseño)) {
            return false;
        }
        else
        return this.pais == other.pais;
    }
    
    @Override
    public int compareTo(EuroCoin o){
        if (this.getValor() > o.getValor()) {
           return -1;
        } else
            if (this.getValor() < o.getValor()){
              return 1;
            } else 
                if (this.getPais().compareTo(o.getPais())> 0){
                  return -1;
                } else 
                    if (this.getPais().compareTo(o.getPais())< 0){
                       return 1;
                    } else
                        if (this.getDiseño().compareTo(o.getDiseño()) > 0){
                           return -1;
                        } else 
                            if (this.getDiseño().compareTo(o.getDiseño()) < 0){
                               return 1;
                            } 
        return 0;
        
    }
    
   
}


